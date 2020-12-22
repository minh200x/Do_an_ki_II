/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IUser;
import bkap.mapper.UserMapper;
import bkap.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class UserDAO extends AbstractDAO<User> implements IUser {
    
    @Override
    public void add(User u) {
        String sql = "{call user_insert(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            insert(sql, u.getUsername(), u.getPassword(), u.getFullname(), u.getLevelId(), u.getPhone(), u.getAddress(),
                    u.getImage(), u.isGender(), u.getBirthday(), u.getDescript(), u.getStartDate(), u.getEndDate(), u.getStatus());
//        try {
//            
//            Connection conn = getConnect();
//            CallableStatement cs = conn.prepareCall(sql);
//            cs.setString(1, u.getUsername());
//            cs.setString(2, u.getPassword());
//            cs.setString(3, u.getFullname());
//            cs.setInt(4, u.getLevelId());
//            cs.setString(5, u.getPhone());
//            cs.setString(6, u.getAddress());
//            cs.setString(7, u.getImage());
//            cs.setBoolean(8, u.isGender());
//            cs.setNull(9, Types.DATE);
//            cs.setNull(10, Types.NVARCHAR);
//            java.sql.Date date = new java.sql.Date(u.getStartDate().getTime());
//            cs.setDate(11, date);
//            cs.setNull(12, Types.DATE);
//            cs.setInt(13, u.getStatus());
//            cs.executeUpdate();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    @Override
    public void delete(int id) {
        String sql = "{call user_delete(?)}";
        update(sql, id);
    }
    
    @Override
    public void edit(User u) {
        String sql = "{call user_update(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        update(sql, u.getId(), u.getUsername(), u.getPassword(), u.getFullname(), 
                u.getLevelId(), u.getPhone(), u.getAddress(), u.getImage(), u.isGender(), u.getBirthday(),
                u.getDescript(), u.getStartDate(), u.getEndDate(), u.getStatus());
    }
    
    @Override
    public List<User> findAll() {
        String sql = "{call user_findAll()}";
        return query(sql, new UserMapper());
    }
    
    @Override
    public List<User> findByUsername(String username) {
        String sql = "{call user_findByUsername(?)}";
        return query(sql, new UserMapper(), username);
    }
    
    @Override
    public List<User> findByFullname(String fullname) {
        String sql = "{call user_findByFullname(?)}";
        return query(sql, new UserMapper(), fullname);
    }
    
    @Override
    public List<User> findByPhone(String phone) {
        String sql = "{call user_findByPhone(?)}";
        return query(sql, new UserMapper(), phone);
    }

    @Override
    public User login(String username, String password) {
        String sql = "{call login(?,?)}";
        List<User> list = query(sql, new UserMapper(),username, password);
        return list.isEmpty() ? null : list.get(0);
    }
    
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        Date date = new Date();
        User u = new User();
        u.setFullname("demo");
        u.setUsername("demo 1");
        u.setPassword("123456");
        u.setBirthday(date);
        u.setLevelId(1);
        u.setDescript(null);
        u.setGender(true);
        u.setPhone("131");
        u.setStartDate(date);
        u.setEndDate(null);
        dao.add(u);
    }
}

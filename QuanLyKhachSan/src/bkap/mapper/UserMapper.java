/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class UserMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs) {
        try {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setFullname(rs.getString("fullname"));
                u.setPassword(rs.getString("password"));
                u.setLevelId(rs.getInt("levelId"));
                u.setPhone(rs.getString("phone"));
                u.setAddress(rs.getString("address"));
                u.setImage(rs.getString("image"));
                u.setGender(rs.getBoolean("gender"));
                u.setBirthday(rs.getDate("birthday"));
                u.setDescript(rs.getString("descript"));
                u.setStartDate(rs.getDate("startDate"));
                u.setEndDate(rs.getDate("endDate"));
                u.setStatus(rs.getInt("status"));
                
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
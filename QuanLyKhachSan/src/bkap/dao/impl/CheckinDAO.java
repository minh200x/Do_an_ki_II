/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckin;
import bkap.mapper.CheckinMapper;
import bkap.model.Checkin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckinDAO extends AbstractDAO<Checkin> implements ICheckin{

    @Override
    public void delete(int id) {
        String sql = "{call checkin_delete(?)}";
        update(sql, id);
    }

    @Override
    public List<Checkin> findAll() {
        String sql = "{call checkin_findAll()}";
        return query(sql, new CheckinMapper());
    }

    @Override
    public Integer add(Checkin c) {
//        String sql = "INSERT INTO tblCheckin(cusPhone, totalPeople, cuponId, totalMoney, totalServicePrice, descript) VALUES(?,?,?,?,?,?)";
//        return insertReturnId(sql, c.getCusPhone(), c.getTotalPeople(), c.getCuponId(), c.getTotalMoney(), c.getTotalServicePrice(), c.getDescript());

        String sql = "INSERT INTO tblCheckin(cusPhone, totalPeople, cuponId, totalMoney, totalServicePrice, descript)\n" +
"	VALUES(?,?,?,?,?,?)";
        ResultSet resultSet = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Integer id = null;
            conn = getConnect();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql);
            statement.setString(1, c.getCusPhone());
            statement.setInt(2, c.getTotalPeople());
            statement.setInt(3, c.getCuponId());
            statement.setFloat(4, c.getTotalMoney());
            statement.setFloat(5, c.getTotalServicePrice());
            statement.setString(6, c.getDescript());
            
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                
                id = resultSet.getInt(1);
            }
            conn.commit();
            return id;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    statement.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return null;
    }
    
}

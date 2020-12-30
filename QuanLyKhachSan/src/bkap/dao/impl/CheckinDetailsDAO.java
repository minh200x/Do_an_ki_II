/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckinDetails;
import bkap.mapper.CheckinDetailsMapper;
import bkap.model.CheckinDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CheckinDetailsDAO extends AbstractDAO<CheckinDetails> implements ICheckinDetails {

    @Override
    public Integer add(CheckinDetails c) {
//        String sql = "INSERT INTO tblCheckinDetails(detailId, checkinId, roomId, totalServicePrice, price, startDate, endDate, status) VALUES(?,?,?,?,?,?,?,?)";
//        return insertReturnId(sql, c.getDetailId(), c.getCheckinId(), c.getRoomId(), c.getTotalServicePrice(), c.getPrice(), c.getStartDate(), c.getEndDate(), c.getStatus());
        
        Integer id = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO tblRoom(detailId, checkinId, roomId, totalServicePrice, price, startDate, endDate, status) VALUES(?,?,?,?,?,?,?,?)";
        try {
            conn = getConnect();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, c.getDetailId());
            ps.setInt(2, c.getCheckinId());
            ps.setInt(3, c.getRoomId());
            ps.setFloat(4, c.getTotalServicePrice());
            ps.setFloat(5, c.getPrice());
            java.sql.Date startDate = new java.sql.Date(c.getStartDate().getTime());
            java.sql.Date endDate = new java.sql.Date(c.getEndDate().getTime());
            ps.setDate(6, startDate);
            ps.setDate(7, endDate);
            ps.setInt(8, c.getStatus());

            ps.executeUpdate();            
            rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                id = rs.getInt(1);
            }
            conn.commit();
            return id;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    
    }

    @Override
    public void delete(int detailId) {
        String sql = "{call checkinDetails_delete(?)}";
        update(sql, detailId);
    }

    @Override
    public List<CheckinDetails> findByDetailId(int detailId) {
        String sql = "{call checkinDetails_findByDetailId(?)}";
        return query(sql, new CheckinDetailsMapper(), detailId);
    }

}

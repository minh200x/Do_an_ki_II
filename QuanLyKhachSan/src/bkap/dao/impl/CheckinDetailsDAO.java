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
        String sql = "INSERT INTO tblCheckinDetails(detailId, checkinId, roomId, totalServicePrice, price, startDate, endDate, status) VALUES(?,?,?,?,?,?,?,?)";
        return insertReturnId(sql, c.getDetailId(), c.getCheckinId(), c.getRoomId(), c.getTotalServicePrice(), c.getPrice(), c.getStartDate(), c.getEndDate(), c.getStatus());
        
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

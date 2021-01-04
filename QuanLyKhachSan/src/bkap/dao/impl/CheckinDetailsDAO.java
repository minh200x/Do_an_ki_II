/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckinDetails;
import bkap.mapper.CheckinDetailsMapper;
import bkap.model.CheckinDetails;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckinDetailsDAO extends AbstractDAO<CheckinDetails> implements ICheckinDetails {

    @Override
    public Integer add(CheckinDetails c) {
        String sql = "INSERT INTO tblCheckinDetails(checkinId, roomId, totalServicePrice, price, startDate, endDate, status) VALUES(?,?,?,?,?,?,?)";
        return insertReturnId(sql, c.getCheckinId(), c.getRoomId(), c.getTotalServicePrice(), c.getPrice(), c.getStartDate(), c.getEndDate(), c.getStatus());
        
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

    public static void main(String[] args) {

            CheckinDetailsDAO dao = new CheckinDetailsDAO();
            CheckinDetails c = new CheckinDetails();
            c.setCheckinId(27);
            
            c.setRoomId(6);
            c.setPrice(22);
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat();
            c.setStartDate(d);
            c.setEndDate(d);
            
            c.setTotalServicePrice(234);
            c.setStatus(0);
            
            
            System.out.println("id checkinDetail: "+dao.add(c));
    }
}

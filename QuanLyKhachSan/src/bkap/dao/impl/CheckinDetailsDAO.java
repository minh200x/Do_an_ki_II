/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckinDetails;
import bkap.mapper.CheckinDetailsMapper;
import bkap.model.CheckinDetails;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckinDetailsDAO extends AbstractDAO<CheckinDetails> implements ICheckinDetails {

    @Override
    public void add(CheckinDetails c) {
        String sql = "{call checkinDetails_insert(?,?,?,?,?,?,?,?)}";
        insert(sql, c.getDetailId(), c.getCheckinId(), c.getRoomId(), c.getTotalServicePrice(), c.getPrice(), c.getStartDate(), c.getEndDate(), c.getStatus());
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

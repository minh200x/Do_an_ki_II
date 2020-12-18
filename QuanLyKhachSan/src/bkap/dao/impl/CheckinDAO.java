/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckin;
import bkap.mapper.CheckinMapper;
import bkap.model.Checkin;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckinDAO extends AbstractDAO<Checkin> implements ICheckin{

    @Override
    public void add(Checkin c) {
        String sql = "{call checkin_insert(?,?,?,?,?,?)}";
        insert(sql, c.getId(), c.getCusPhone(), c.getTotalPeople(), c.getCuponId(), c.getTotalMoney(), c.getTotalServicePrice(), c.getDescript());
    }

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
    
}

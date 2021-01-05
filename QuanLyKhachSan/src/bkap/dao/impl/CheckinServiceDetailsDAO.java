/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckinServiceDetails;
import bkap.mapper.CheckinServiceDetailsMapper;
import bkap.model.CheckinServiceDetails;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckinServiceDetailsDAO extends AbstractDAO<CheckinServiceDetails> implements ICheckinServiceDetails {
    
    @Override
    public void add(CheckinServiceDetails c) {
        String sql = "{call checkinServiceDetail_insert(?,?,?,?)}";
        insert(sql, c.getIdService(), c.getIdCheckinDetails(), c.getQuantity(), c.getPrice());
    }
    
    @Override
    public void delete(int idService) {
        String sql = "{call checkinServiceDetail_delete(?)}";
        update(sql, idService);
    }
    
    @Override
    public void edit(CheckinServiceDetails c) {
        String sql = "{call checkinServiceDetail_update(?,?)}";
        update(sql, c.getIdService(), c.getQuantity());
    }
    
    @Override
    public List<CheckinServiceDetails> findAll() {
        String sql = "{call checkinServiceDetail_findAll()";
        return query(sql, new CheckinServiceDetailsMapper());
    }
//    public static void main(String[] args) {
//        CheckinServiceDetails c = new CheckinServiceDetails();
//        CheckinServiceDetailsDAO dao  = new CheckinServiceDetailsDAO();
//        c.setIdCheckinDetails(8);
//        c.setIdService(6);
//        c.setPrice(345);
//        c.setQuantity(1);
//        dao.add(c);
//    }
    
}

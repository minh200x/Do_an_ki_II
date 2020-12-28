/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICupon;
import bkap.mapper.CuponMapper;
import bkap.model.Cupon;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CuponDAO extends AbstractDAO<Cupon> implements ICupon{

    @Override
    public void add(Cupon c) {
        String sql = "{call cupon_insert(?,?,?,?,?,?,?,?)}";
        insert(sql, c.getName(), c.getDiscount(), c.getMaxQuantity(), c.getStatus(), c.getStartDate(), c.getEndDate(), c.getCreatedAt(), c.getUpdatedAt());
    }

    @Override
    public void delete(int id) {
        String sql = "{call cupon_delete(?)}";
        update(sql, id);
    }

    @Override
    public void edit(Cupon c) {
        String sql = "{call cupon_update(?,?,?,?,?,?,?,?,?)}";
        update(sql, c.getId(), c.getName(), c.getDiscount(), c.getMaxQuantity(), c.getStatus(), c.getStartDate(), c.getEndDate(), c.getCreatedAt(), c.getUpdatedAt());
    }

    @Override
    public List<Cupon> findAll() {
        String sql = "{call cupon_findAll()}";
        return query(sql, new CuponMapper());
    }

    @Override
    public List<Cupon> findByName(String name) {
        String sql = "{call cupon_findByName(?)}";
        return query(sql, new CuponMapper(), name);
    }

    @Override
    public List<Cupon> findByStatus(int status) {
        String sql = "{call cupon_findByStatus(?)}";
        return query(sql, new CuponMapper(), status);
    }

    @Override
    public List<Cupon> findByNameAndStatus(String name, int status) {
        String sql = "{call cupon_findByNameAndStatus(?,?)}";
        return query(sql, new CuponMapper(), name, status);
    }
    
}

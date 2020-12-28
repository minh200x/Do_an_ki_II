/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICustomer;
import bkap.mapper.CustomerMapper;
import bkap.model.Customer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CustomerDAO extends AbstractDAO<Customer> implements ICustomer {
    
    @Override
    public void add(Customer c) {
        String sql = "{call customer_insert(?,?,?,?,?,?,?,?,?)}";
        insert(sql, c.getPhone(), c.getFullname(), c.getEmail(), c.getAddress(), c.isGender(), c.getNumIdentityCard(), c.getDescript(), c.getCreatedAt(), c.getUpdatedAt());
    }
    
    @Override
    public void edit(Customer c) {
        String sql = "{call customer_update(?,?,?,?,?,?,?,?,?)}";
        update(sql, c.getPhone(), c.getFullname(), c.getEmail(), c.getAddress(), c.isGender(), c.getNumIdentityCard(), c.getDescript(), c.getCreatedAt(), c.getUpdatedAt());
    }
    
    @Override
    public void delete(String phone) {
        String sql = "{call customer_delete(?)}";
        update(sql, phone);
    }
    
    @Override
    public List<Customer> findAll() {
        String sql = "{call customer_findAll()}";
        return query(sql, new CustomerMapper());
    }
    
    @Override
    public List<Customer> findByPhone(String phone) {
        String sql = "{call customer_findByPhone(?)}";
        return query(sql, new CustomerMapper(), phone);
    }

    @Override
    public List<Customer> findByNumIdentityCard(String numIdentityCard) {
        String sql = "{call customer_findByNumIdentityCard(?)}";
        return query(sql, new CustomerMapper(), numIdentityCard);
    }
}

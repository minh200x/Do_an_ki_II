/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICategoryService;
import bkap.mapper.CategoryServiceMapper;
import bkap.model.CategoryService;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CategoryServiceDAO extends AbstractDAO implements ICategoryService {

    @Override
    public void add(CategoryService c) {
        List<CategoryService> list = new ArrayList<>();

        CallableStatement cs = null;
        Connection conn = null;

        try {
            String sql = "{call categoryService_insert(?)}";
            conn = getConnect();
            conn.setAutoCommit(false);
            cs = conn.prepareCall(sql);
            cs.setString(1, c.getName());
            cs.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(CategoryServiceDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } finally {
            try {
                conn.close();
                cs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CategoryService c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoryService> findAll() {
        String sql = "{call categoryService_findAll()}";     
        return query(sql, new CategoryServiceMapper());
    }

    public static void main(String[] args) {
        CategoryServiceDAO c = new CategoryServiceDAO();
        List<CategoryService> list = c.findAll();
        System.out.println(list.size());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ILevel;
import bkap.mapper.LevelMapper;
import bkap.model.Level;
import java.util.List;

/**
 *
 * @author THUY
 */
public class LevelDAO extends AbstractDAO<Level> implements ILevel{

    @Override
    public List<Level> findAll() {
        String sql = "{call level_findAll()}";
        return query(sql, new LevelMapper());
    }
    
}

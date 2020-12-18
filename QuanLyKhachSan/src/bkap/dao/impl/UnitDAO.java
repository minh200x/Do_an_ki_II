/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IUnit;
import bkap.mapper.UnitMapper;
import bkap.model.Unit;
import java.util.List;

/**
 *
 * @author THUY
 */
public class UnitDAO extends AbstractDAO<Unit> implements IUnit {

    @Override
    public List<Unit> findAll() {
        String sql = "{call unit_findAll()}";
        return query(sql, new UnitMapper());
    }

}

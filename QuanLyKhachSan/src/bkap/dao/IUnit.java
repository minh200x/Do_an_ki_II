/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Unit;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface IUnit extends GenericDAO<Unit>{
    List<Unit> findAll();
}

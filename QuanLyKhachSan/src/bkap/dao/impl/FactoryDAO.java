/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.GenericDAO;
import bkap.dao.IUser;

/**
 *
 * @author THUY
 */
public class FactoryDAO {
    public static GenericDAO getFactory(String type) {
        if (type == "user") {
             return new UserDAO();
        }
        return null;
    }
}

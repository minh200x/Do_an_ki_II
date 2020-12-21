/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.utils;

import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THUY
 */
public class Utils {
    
    public static Date getCurrentTime() {
        Date currentTime = new Date();
        return currentTime;
    }

    public static <T> void setDataTable(DefaultTableModel model, List<T> list, Object... parameters) {
        model.setRowCount(0);
        
        int indexRow = 0;
        int indexColumn = 0;
        
        for (T t : list) {            
            for (Object param : parameters) {
                model.setValueAt(param, indexRow, indexColumn);
                indexColumn++;
            }
            indexRow++;
        }
    }
}

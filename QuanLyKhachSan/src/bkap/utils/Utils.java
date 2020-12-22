/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.utils;

import java.awt.Color;
import java.awt.Image;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

    public static void setImage(JLabel lbContainImg, String pathImg) {
        ImageIcon imgIcon = new ImageIcon(pathImg);
        Image img = imgIcon.getImage();
        Image newImage = img.getScaledInstance(lbContainImg.getWidth(), lbContainImg.getHeight(), Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(newImage);

        lbContainImg.setIcon(imgIcon);
    }

    public static void setMessageInformation(JLabel label, String msg, Boolean status) {
        if (status == false) {
            label.setForeground(Color.RED);
            label.setText(msg);
        } else {
            label.setForeground(Color.BLUE);
            label.setText(msg);
        }
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

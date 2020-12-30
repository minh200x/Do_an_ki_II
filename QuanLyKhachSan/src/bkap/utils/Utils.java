/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author THUY
 */
public class Utils {

    public static Date getCurrentTime() {
        Date currentTime = new Date();
        return currentTime;
    }

    public static String formatPrice(Float price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        String formated = vn.format(price);
        return formated;
    }

    public static void setImage(JLabel lbContainImg, String pathImg) {
        ImageIcon imgIcon = new ImageIcon(pathImg);
        Image img = imgIcon.getImage();
        Image newImage = img.getScaledInstance(lbContainImg.getWidth(), lbContainImg.getHeight(), Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(newImage);

        lbContainImg.setIcon(imgIcon);
    }

    public static void setMessageInformation(JLabel label, String msg, Boolean status) {
        Font font = new Font("Tahoma", Font.ITALIC, 13);
        label.setFont(font);
        if (status == false) {
            label.setForeground(Color.RED);
            label.setText(msg);
        } else {
            label.setForeground(Color.BLUE);
            label.setText(msg);
        }
    }   
   

}

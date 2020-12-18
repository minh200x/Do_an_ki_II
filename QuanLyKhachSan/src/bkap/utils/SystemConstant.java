/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.utils;

/**
 *
 * @author THUY
 */
public class SystemConstant {
    public final static String host = "localhost";
    public final static String port = "1433";
    public final static String databasename = "QuanLyKhachHang";
    public final static String username = "sa";
    public final static String password = "1234$";
    
    public final static boolean GENDER_FEMALE = true;
    public final static boolean GENDER_MALE = false;
    
    public final static int STATUS_ROOM_EMPTY = 0;
    public final static int STATUS_ROOM_USING = 1;
    public final static int STATUS_ROOM_REPAIRING = 2;
    
    public final static int STATUS_ON = 0;
    public final static int STATUS_OFF = 1;
    
    public final static int STATUS_PRODUCT_NORMAL = 0;
    public final static int STATUS_PRODUCT_ABNORMAl = 1;
    
    public final static String MSG_SUCCESSFUL_UPDATE = "Cập nhật dữ liệu thành công";
    public final static String MSG_SUCCESSFUL_LOGIN = "Đăng nhập liệu thành công";
    
    public final static String MSG_ERROR_UPDATE = "Cập nhật dữ liệu thất bại";
    public final static String MSG_ERROR_LOGIN = "Đăng nhập thất bại";
}

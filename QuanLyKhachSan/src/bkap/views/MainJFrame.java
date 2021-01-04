/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views;

import bkap.dao.impl.UserDAO;
import bkap.utils.Helper;
import bkap.utils.SystemConstant;
import bkap.views.internalFrame.AccountDetailsIF;
import bkap.views.internalFrame.BookRoomIF;
import bkap.views.internalFrame.CategoryRoomIF;
import bkap.views.internalFrame.CategoryServiceIF;
import bkap.views.internalFrame.CuponIF;
import bkap.views.internalFrame.CustomerIF;
import bkap.views.internalFrame.LevelIF;
import bkap.views.internalFrame.ProductIF;
import bkap.views.internalFrame.RoomIF;
import bkap.views.internalFrame.ServiceIF;
import bkap.views.internalFrame.StatisticsIF;
import bkap.views.internalFrame.UnitIF;
import bkap.views.internalFrame.UserIF;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hongb
 */
public class MainJFrame extends javax.swing.JFrame {

    private UserDAO userDao = new UserDAO();
//    private ImageIcon imgLogo;
    private BufferedImage backgroundImage;
    private RoomIF room;
    private String userName;
    private LoginDialog loginForm = new LoginDialog(this, true);

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        setCss();
        showLogin();
        
        if (LoginDialog.levelUser == SystemConstant.LEVEL_ADMIN) {

        } else if (LoginDialog.levelUser == SystemConstant.LEVEL_USER) {
            mnUnit.setEnabled(false);
            mnLevel.setEnabled(false);
            mnEmployee.setEnabled(false);
            mnCatService.setEnabled(false);
            mnCatProduct.setEnabled(false);
        }
        setNameMenu();
    }

    private void showLogin() {
        this.setVisible(false);
        loginForm.setVisible(true);
        loginForm.validate();
        if (loginForm.isIsLogin() == true) {
            userName = loginForm.getUserName();
            userDao.isLogin(true, userName);
            initComponents();
        }
    }

    private boolean checkOnly(JInternalFrame innerFrame) {
        JInternalFrame[] arrFrame = dkpMain.getAllFrames();
        for (JInternalFrame frame : arrFrame) {
            if (frame.getClass().getName() == innerFrame.getClass().getName()) {
                return true;
            }
        }
        return false;
    }

    public void setCss() {
        ImageIcon imgLogo = null;
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("bkap/images/logo.png")); // load the image to a imageIcon 
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imgLogo = new ImageIcon(newimg);
        setIconImage(imgLogo.getImage());
        setTitle("HOTEL - Quản lý khách sạn");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLanguage = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        dkpMain = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnHome = new javax.swing.JMenu();
        mnCheckin_Checkout = new javax.swing.JMenu();
        mnBookRoom = new javax.swing.JMenu();
        mnManageSystem = new javax.swing.JMenu();
        mnRoom = new javax.swing.JMenuItem();
        mnService = new javax.swing.JMenuItem();
        mnCategoryRoom = new javax.swing.JMenuItem();
        mnCatService = new javax.swing.JMenuItem();
        mnUnit = new javax.swing.JMenuItem();
        mnCupon = new javax.swing.JMenuItem();
        mnLevel = new javax.swing.JMenuItem();
        mnEmployee = new javax.swing.JMenuItem();
        mnCatProduct = new javax.swing.JMenuItem();
        mnAccount = new javax.swing.JMenuItem();
        mnCustomer = new javax.swing.JMenu();
        mnAddCustomer = new javax.swing.JMenuItem();
        mnStatistic = new javax.swing.JMenu();
        btnLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icons8_calendar_plus_20px.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout dkpMainLayout = new javax.swing.GroupLayout(dkpMain);
        dkpMain.setLayout(dkpMainLayout);
        dkpMainLayout.setHorizontalGroup(
            dkpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1564, Short.MAX_VALUE)
        );
        dkpMainLayout.setVerticalGroup(
            dkpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );

        mnHome.setText("Trang chủ");
        jMenuBar1.add(mnHome);

        mnCheckin_Checkout.setText("Thuê - Trả phòng");
        jMenuBar1.add(mnCheckin_Checkout);

        mnBookRoom.setText("Đặt phòng");
        mnBookRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnBookRoomMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnBookRoom);

        mnManageSystem.setText("Quản lý hệ thống");

        mnRoom.setText("Phòng");
        mnRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRoomActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnRoom);

        mnService.setText("Menu / Dịch vụ");
        mnService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnServiceActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnService);

        mnCategoryRoom.setText("Loại phòng");
        mnCategoryRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCategoryRoomActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnCategoryRoom);

        mnCatService.setText("Loại dịch vụ");
        mnCatService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCatServiceActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnCatService);

        mnUnit.setText("Đơn vị");
        mnUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUnitActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnUnit);

        mnCupon.setText("Mã giảm giá");
        mnCupon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCuponActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnCupon);

        mnLevel.setText("Chức vụ");
        mnLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLevelActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnLevel);

        mnEmployee.setText("Nhân viên");
        mnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEmployeeActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnEmployee);

        mnCatProduct.setText("Danh mục thiết bị");
        mnCatProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCatProductActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnCatProduct);

        mnAccount.setText("Tài khoản");
        mnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAccountActionPerformed(evt);
            }
        });
        mnManageSystem.add(mnAccount);

        jMenuBar1.add(mnManageSystem);

        mnCustomer.setText("Khách hàng");

        mnAddCustomer.setText("Thêm khách hàng");
        mnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAddCustomerActionPerformed(evt);
            }
        });
        mnCustomer.add(mnAddCustomer);

        jMenuBar1.add(mnCustomer);

        mnStatistic.setText("Thống kê");
        mnStatistic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStatisticMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnStatistic);

        btnLogout.setText("Đăng xuất");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dkpMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dkpMain))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRoomActionPerformed
        // TODO add your handling code here:
        room = new RoomIF();
        dkpMain.add(room);
        room.setVisible(true);
        room.validate();
    }//GEN-LAST:event_mnRoomActionPerformed

    private void mnServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnServiceActionPerformed
        // TODO add your handling code here:
        ServiceIF service = new ServiceIF();
        dkpMain.add(service);
        service.setVisible(true);
        service.validate();
    }//GEN-LAST:event_mnServiceActionPerformed

    private void mnCategoryRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCategoryRoomActionPerformed
        // TODO add your handling code here:
        CategoryRoomIF categoryRoom = new CategoryRoomIF();
        dkpMain.add(categoryRoom);
        categoryRoom.setVisible(true);
        categoryRoom.validate();
    }//GEN-LAST:event_mnCategoryRoomActionPerformed

    private void mnCatServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCatServiceActionPerformed
        // TODO add your handling code here:
        CategoryServiceIF categoryService = new CategoryServiceIF();
        dkpMain.add(categoryService);
        categoryService.setVisible(true);
        categoryService.validate();
    }//GEN-LAST:event_mnCatServiceActionPerformed

    private void mnUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUnitActionPerformed
        // TODO add your handling code here:
        UnitIF unit = new UnitIF();
        dkpMain.add(unit);
        unit.setVisible(true);
        unit.validate();
    }//GEN-LAST:event_mnUnitActionPerformed

    private void mnCuponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCuponActionPerformed
        // TODO add your handling code here:
        CuponIF cupon = new CuponIF();
        dkpMain.add(cupon);
        cupon.setVisible(true);
        cupon.validate();
    }//GEN-LAST:event_mnCuponActionPerformed

    private void mnLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLevelActionPerformed
        // TODO add your handling code here:
        LevelIF level = new LevelIF();
        dkpMain.add(level);
        level.setVisible(true);
        level.validate();
    }//GEN-LAST:event_mnLevelActionPerformed

    private void mnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAddCustomerActionPerformed
        // TODO add your handling code here:
        CustomerIF cus = new CustomerIF();
        dkpMain.add(cus);
        cus.setVisible(true);
        cus.validate();
    }//GEN-LAST:event_mnAddCustomerActionPerformed

    private void mnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEmployeeActionPerformed
        // TODO add your handling code here:
        UserIF user = new UserIF();
        dkpMain.add(user);
        user.setVisible(true);
        user.validate();
    }//GEN-LAST:event_mnEmployeeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BookRoomIF bookRoom = new BookRoomIF();
        dkpMain.add(bookRoom);
        bookRoom.setVisible(true);
        bookRoom.validate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mnCatProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCatProductActionPerformed
        // TODO add your handling code here:
        ProductIF p = new ProductIF();
        dkpMain.add(p);
        p.setVisible(true);
        p.validate();

    }//GEN-LAST:event_mnCatProductActionPerformed


    private void mnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAccountActionPerformed
        // TODO add your handling code here:
        AccountDetailsIF acc = new AccountDetailsIF();
        dkpMain.add(acc);
        acc.setVisible(true);
        acc.validate();
    }//GEN-LAST:event_mnAccountActionPerformed

    private void mnBookRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnBookRoomMouseClicked
        // TODO add your handling code here:
        BookRoomIF bookRoom = new BookRoomIF();
        dkpMain.add(bookRoom);
        bookRoom.setVisible(true);
        bookRoom.validate();
    }//GEN-LAST:event_mnBookRoomMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        userDao.isLogin(false, userName);
        this.dispose();
        loginForm.setIsLogin(false);
        main(null);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void mnStatisticMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatisticMouseClicked
        StatisticsIF s = new StatisticsIF();
        dkpMain.add(s);
        s.setVisible(true);
        s.validate();
    }//GEN-LAST:event_mnStatisticMouseClicked

    private void setNameMenu() {
        mnAccount.setText(Helper.getResources("account"));
        mnAddCustomer.setText(Helper.getResources("addCustomer"));
        mnBookRoom.setText(Helper.getResources("bookRoom"));
        mnCatProduct.setText(Helper.getResources("categoryProduct"));
        mnCatService.setText(Helper.getResources("categoryService"));
        mnCategoryRoom.setText(Helper.getResources("categoryRoom"));
        mnCheckin_Checkout.setText(Helper.getResources("checkinCheckout"));
        mnCupon.setText(Helper.getResources("cupon"));
        mnCustomer.setText(Helper.getResources("customer"));
        mnEmployee.setText(Helper.getResources("employee"));
        mnHome.setText(Helper.getResources("home"));
        mnLevel.setText(Helper.getResources("level"));
        mnManageSystem.setText(Helper.getResources("manageSystem"));
        mnRoom.setText(Helper.getResources("room"));
        mnService.setText(Helper.getResources("service"));
        mnUnit.setText(Helper.getResources("unit"));
        
        btnLogout.setText(Helper.getResources("logout"));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainJFrame main = new MainJFrame();
                main.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnLogout;
    private javax.swing.ButtonGroup buttonGroupLanguage;
    private javax.swing.JDesktopPane dkpMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnAccount;
    private javax.swing.JMenuItem mnAddCustomer;
    private javax.swing.JMenu mnBookRoom;
    private javax.swing.JMenuItem mnCatProduct;
    private javax.swing.JMenuItem mnCatService;
    private javax.swing.JMenuItem mnCategoryRoom;
    private javax.swing.JMenu mnCheckin_Checkout;
    private javax.swing.JMenuItem mnCupon;
    private javax.swing.JMenu mnCustomer;
    private javax.swing.JMenuItem mnEmployee;
    private javax.swing.JMenu mnHome;
    private javax.swing.JMenuItem mnLevel;
    private javax.swing.JMenu mnManageSystem;
    private javax.swing.JMenuItem mnRoom;
    private javax.swing.JMenuItem mnService;
    private javax.swing.JMenu mnStatistic;
    private javax.swing.JMenuItem mnUnit;
    // End of variables declaration//GEN-END:variables
}

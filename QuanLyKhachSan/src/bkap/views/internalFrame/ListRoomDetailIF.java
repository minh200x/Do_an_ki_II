/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views.internalFrame;

import bkap.dao.impl.CategoryRoomDAO;
import bkap.dao.impl.CheckinDAO;
import bkap.dao.impl.CheckinDetailsDAO;
import bkap.dao.impl.CheckinServiceDetailsDAO;
import bkap.dao.impl.CustomerDAO;
import bkap.dao.impl.RoomDAO;
import bkap.model.CategoryRoom;
import bkap.model.Checkin;
import bkap.model.CheckinDetails;
import bkap.model.Room;
import bkap.views.CheckoutJDialog;
import bkap.views.MainJFrame;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;

/**
 *
 * @author hongb
 */
public class ListRoomDetailIF extends javax.swing.JInternalFrame {

    private CheckinDAO checkinDao = new CheckinDAO();
    private CheckinDetailsDAO checkinDetailDao = new CheckinDetailsDAO();
    private CheckinServiceDetailsDAO checkinSerDetailDao = new CheckinServiceDetailsDAO();
    private CustomerDAO cusDao = new CustomerDAO();
    private RoomDAO roomDao = new RoomDAO();

    private RoomDAO roomDAO = new RoomDAO();
    private CategoryRoomDAO catRoomDao = new CategoryRoomDAO();
    private List<Room> listR;
    private List<CategoryRoom> listCatRoom;
    private List<CheckinDetails> listCheckinDetail;

    private JPanel pnl;
    private Border blackline;

    /**
     * Creates new form ListRoomDetailIF
     */
    public ListRoomDetailIF() {
        initComponents();
        setTitle("Thuê - Trả Phòng");
        listCatRoom = catRoomDao.findAll();
        pnlContainer.setLayout(new CardLayout());
        mnStatus0MouseClicked(null);
    }

    private void createNewPanel(List<CheckinDetails> list) {
        pnlContainer.removeAll();
        if (pnl != null) {
            pnl.removeAll();
        } else {
            pnl = new JPanel();
        }
        for (CategoryRoom listCat : listCatRoom) {
            getItemCategoryRoom(listCat.getId(), list);
        }
        pnlContainer.add(pnl);
        pnl.setLayout(new GridLayout(listCatRoom.size(), 1));
        pnl.setVisible(true);
        pnl.validate();
    }

    private void getItemCategoryRoom(int idCat, List<CheckinDetails> list) {
        JPanel pnlItem = new JPanel();
        for (CategoryRoom listC : listCatRoom) {
            if (idCat == listC.getId()) {
                blackline = BorderFactory.createTitledBorder(listC.getName());
            }
        }
        pnlItem.setBorder(blackline);
        pnlItem.setLayout(new FlowLayout(5));

        for (CheckinDetails listItem : list) {
            if (idCat == roomDAO.findByRoomId(listItem.getRoomId()).getTypeId()) {
                Button b = new Button("P " + listItem.getRoomId() + " "+ cusDao.findByPhone(checkinDao.findById(listItem.getCheckinId()).getCusPhone()).get(0).getFullname()  );
                pnlItem.add(b);

                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //your actions
                        if (listItem.getStatus() == 1) {
                            CheckoutJDialog formCheckout = new CheckoutJDialog(null, closable, listItem.getDetailId());
                            formCheckout.setVisible(true);
                            formCheckout.validate();
                        } else if (listItem.getStatus() == 0) {
                            final JPopupMenu editMenu = new JPopupMenu("Edit");
                            JMenuItem receiveMenuItem = new JMenuItem("Nhận phòng");
                            receiveMenuItem.setActionCommand("Nhận phòng");
                            editMenu.add(receiveMenuItem);
                            editMenu.show(b, b.getX(), b.getY());
                            receiveMenuItem.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    int idCheckinDetail = checkinDetailDao.findByIdRoomStatus(listItem.getRoomId(), 0).getDetailId();
                                    checkinDetailDao.changeStatusRoom(idCheckinDetail, 1);
                                }
                            });
                        }else if (listItem.getStatus() == 2) {
                            final JPopupMenu editMenu = new JPopupMenu("Edit");
                            JMenuItem receiveMenuItem = new JMenuItem("Đã dọn phòng");
                            receiveMenuItem.setActionCommand("Đã dọn phòng");
                            editMenu.add(receiveMenuItem);
                            editMenu.show(b, b.getX(), b.getY());
                            receiveMenuItem.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    roomDao.changeStatus(listItem.getRoomId(), 0);
                                }
                            });
                        }
                    }
                });
            }
        }
        pnl.add(pnlItem);
        pnlItem.setVisible(true);
        pnlItem.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnStatus0 = new javax.swing.JMenu();
        mnStatus1 = new javax.swing.JMenu();
        mnStatus2 = new javax.swing.JMenu();
        mnHistory = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(95, 200));

        pnlContainer.setLayout(new java.awt.CardLayout());

        mnStatus0.setText("Phòng chờ");
        mnStatus0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStatus0MouseClicked(evt);
            }
        });
        jMenuBar1.add(mnStatus0);

        mnStatus1.setText("Phòng đang thuê");
        mnStatus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStatus1MouseClicked(evt);
            }
        });
        jMenuBar1.add(mnStatus1);

        mnStatus2.setText("Phòng cần dọn");
        mnStatus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStatus2MouseClicked(evt);
            }
        });
        jMenuBar1.add(mnStatus2);

        mnHistory.setText("Lịch sử");
        mnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnHistoryMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnHistory);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnStatus0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus0MouseClicked
        // TODO add your handling code here:
        setTitle("Phòng chờ");
        listCheckinDetail = checkinDetailDao.findAllByStatus(0);
        createNewPanel(listCheckinDetail);

    }//GEN-LAST:event_mnStatus0MouseClicked

    private void mnStatus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus1MouseClicked
        // TODO add your handling code here:
        setTitle("Phòng đang thuê");
        listCheckinDetail = checkinDetailDao.findAllByStatus(1);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnStatus1MouseClicked

    private void mnStatus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus2MouseClicked
        // TODO add your handling code here:
        setTitle("Phòng cần dọn");
        listCheckinDetail = checkinDetailDao.findAllByStatus(2);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnStatus2MouseClicked

    private void mnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnHistoryMouseClicked
        // TODO add your handling code here:
        setTitle("Lịch sử");
        listCheckinDetail = checkinDetailDao.findAllByStatus(2);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnHistoryMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnHistory;
    private javax.swing.JMenu mnStatus0;
    private javax.swing.JMenu mnStatus1;
    private javax.swing.JMenu mnStatus2;
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables
}

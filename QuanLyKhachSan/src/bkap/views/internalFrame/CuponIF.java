/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views.internalFrame;

import bkap.dao.impl.CuponDAO;
import bkap.model.Cupon;
import bkap.utils.SystemConstant;
import bkap.utils.Utils;
import bkap.views.LoginDialog;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.rmi.CORBA.Util;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hongb
 */
public class CuponIF extends javax.swing.JInternalFrame {

    private List<Cupon> listCupon;
    private CuponDAO cuponDAO = new CuponDAO();

    private DefaultTableModel modelCupon;

    private int indexSelected = 0;
    private int idCupon;

    private String name;
    private String discount;
    private String maxQuantity;
    private String status;
    private Date startDate = null;
    private Date endDate = null;
    private Date createdAt = Utils.getCurrentTime();
    private Date updatedAt = null;

    /**
     * Creates new form CuponIF
     */
    public CuponIF() {
        initComponents();

        listCupon = cuponDAO.findAll();

        modelCupon = (DefaultTableModel) tblCupon.getModel();

        setDataTable(modelCupon, listCupon);
        setDataCombox();
        
        if (LoginDialog.levelUser == SystemConstant.LEVEL_USER) {
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNameCupon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaxQuantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCupon = new javax.swing.JTable();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        messageInformation = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSearch = new javax.swing.JButton();
        txtKeySearch = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mã giảm giá");

        jLabel1.setText("Mã giảm giá");

        jLabel2.setText("Số lượng");

        jLabel3.setText("Ngày kết thúc");

        jLabel4.setText("Ngày bắt đầu");

        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblCupon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảm giá", "Số lượng", "Discount", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuponMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCupon);

        txtStartDate.setDateFormatString("dd-MM-yyyy");

        txtEndDate.setDateFormatString("dd-MM-yyyy");

        jLabel5.setText("Discount");

        jLabel6.setText("%");

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtKeySearch.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        txtKeySearch.setForeground(new java.awt.Color(153, 153, 153));
        txtKeySearch.setText("Mã giảm giá");
        txtKeySearch.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtKeySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtKeySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtKeySearchFocusLost(evt);
            }
        });

        cbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStatusItemStateChanged(evt);
            }
        });

        btnRefresh.setText("Làm mới");
        btnRefresh.setPreferredSize(new java.awt.Dimension(85, 25));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNameCupon)
                                    .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(txtMaxQuantity)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(messageInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNameCupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaxQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        getValueOfFields();
        if (checkValidate()) {
            Cupon c = setPropertiesForObject();
            cuponDAO.add(c);
            Utils.setMessageInformation(messageInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);

            setNullValueFields();
            listCupon = cuponDAO.findAll();
            setDataTable(modelCupon, listCupon);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblCuponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuponMouseClicked
        messageInformation.setText("");
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnAdd.setEnabled(false);

        indexSelected = tblCupon.getSelectedRow();

        if (indexSelected == -1) {
            Utils.setMessageInformation(messageInformation, SystemConstant.MSG_ERROR_CHOOSE_ROW_TABLE, false);
        } else {
            Cupon c = listCupon.get(indexSelected);
            idCupon = c.getId();
            txtNameCupon.setText(c.getName());
            txtMaxQuantity.setText((int) c.getMaxQuantity() + "");
            txtDiscount.setText(c.getDiscount() + "");
            txtStartDate.setDate(c.getStartDate());
            txtEndDate.setDate(c.getEndDate());
        }
    }//GEN-LAST:event_tblCuponMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int reply = JOptionPane.showConfirmDialog(rootPane, SystemConstant.CONFIRM_DELETE);

        if (reply == 0) {
            cuponDAO.delete(idCupon);
            Utils.setMessageInformation(messageInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);

            setNullValueFields();
            listCupon = cuponDAO.findAll();
            setDataTable(modelCupon, listCupon);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int reply = JOptionPane.showConfirmDialog(rootPane, SystemConstant.CONFIRM_UPDATE);

        if (reply == 0) {
            getValueOfFields();
            if (checkValidate()) {
                Cupon c = setPropertiesForObject();
                cuponDAO.edit(c);
                Utils.setMessageInformation(messageInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);

                setNullValueFields();
                listCupon = cuponDAO.findAll();
                setDataTable(modelCupon, listCupon);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStatusItemStateChanged
        String keySearch = txtKeySearch.getText();
        if (cbStatus.getSelectedItem().toString() == "Tất cả") {
            listCupon = cuponDAO.findAll();
            txtKeySearch.setText("Mã giảm giá");
            txtKeySearch.setForeground(new Color(153,153,153));
        } else if (cbStatus.getSelectedItem().toString() == SystemConstant.STATUS_TXT_CUPON_ON && keySearch.equals("Mã giảm giá")) {
            listCupon = cuponDAO.findByStatus(SystemConstant.STATUS_CUPON_ON);
        } else if (cbStatus.getSelectedItem().toString() == SystemConstant.STATUS_TXT_CUPON_OFF && keySearch.equals("Mã giảm giá")) {
            listCupon = cuponDAO.findByStatus(SystemConstant.STATUS_CUPON_OFF);
        } else if (!keySearch.isEmpty()) {
            if (cbStatus.getSelectedItem().toString() == SystemConstant.STATUS_TXT_CUPON_OFF) {
                listCupon = cuponDAO.findByNameAndStatus(keySearch, SystemConstant.STATUS_CUPON_OFF);
            } else {
                listCupon = cuponDAO.findByNameAndStatus(keySearch, SystemConstant.STATUS_CUPON_ON);
            }
        }
        setDataTable(modelCupon, listCupon);
    }//GEN-LAST:event_cbStatusItemStateChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        setNullValueFields();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keySearch = txtKeySearch.getText();
        if (keySearch.isEmpty()) {
            Utils.setMessageInformation(messageInformation, "Vui lòng nhập mã phòng để tìm kiếm!", false);
        } else {
            listCupon = cuponDAO.findByName(keySearch);
            if (listCupon.isEmpty()) {
                Utils.setMessageInformation(messageInformation, "Không tìm thấy mã giảm giá!", false);
            }
            setDataTable(modelCupon, listCupon);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtKeySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKeySearchFocusLost
        if (txtKeySearch.getText().equals("")) {
            txtKeySearch.setText("Mã giảm giá");
            txtKeySearch.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtKeySearchFocusLost

    private void txtKeySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKeySearchFocusGained
        if (txtKeySearch.getText().equals("Mã giảm giá")) {
            txtKeySearch.setText("");
            txtKeySearch.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtKeySearchFocusGained

    private void setDataCombox() {
        cbStatus.addItem("Tất cả");
        cbStatus.addItem(SystemConstant.STATUS_TXT_CUPON_ON);
        cbStatus.addItem(SystemConstant.STATUS_TXT_CUPON_OFF);
    }

    private void getValueOfFields() {
        name = txtNameCupon.getText();
        discount = txtDiscount.getText();
        maxQuantity = txtMaxQuantity.getText();
        startDate = txtStartDate.getDate();
        endDate = txtEndDate.getDate();
    }

    private boolean checkValidate() {
        boolean check = false;

        if (name.isEmpty()) {
            Utils.setMessageInformation(messageInformation, "Vui lòng nhập tên mã giảm giá!", false);
        } else if (startDate == null && endDate == null && maxQuantity.isEmpty()) {
            Utils.setMessageInformation(messageInformation, "Vui lòng nhập số mã giảm giá giới hạn hoặc nhập thời gian bắt đầu!", check);
        } else if (discount.isEmpty()) {
            Utils.setMessageInformation(messageInformation, "Vui lòng nhập giá trị mã giảm giá!", false);
        } else {
            check = true;
        }
        return check;
    }

    private Cupon setPropertiesForObject() {
        Cupon c = new Cupon();
        c.setId(idCupon);
        c.setName(name);
        c.setMaxQuantity(Integer.parseInt(maxQuantity));
        c.setDiscount(Float.parseFloat(discount));
        c.setStartDate(startDate);
        c.setEndDate(endDate);
        c.setCreatedAt(createdAt);
        c.setUpdatedAt(Utils.getCurrentTime());
        c.setStatus(SystemConstant.STATUS_CUPON_ON);
        return c;
    }

    private void setNullValueFields() {
        txtNameCupon.setText("");
        txtMaxQuantity.setText("");
        txtDiscount.setText("");
        txtStartDate.setDate(null);
        txtEndDate.setDate(null);

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
        txtKeySearch.setText("Mã giảm giá");
        txtKeySearch.setForeground(new Color(153, 153, 153));
    }

    private void setDataTable(DefaultTableModel model, List<Cupon> list) {
        model.setRowCount(0);
        for (Cupon c : list) {
            model.addRow(new Object[]{
                c.getName(), c.getMaxQuantity(), c.getDiscount(), c.getStartDate(), c.getEndDate(), c.getStatus() == SystemConstant.STATUS_CUPON_ON ? SystemConstant.STATUS_TXT_CUPON_ON : SystemConstant.STATUS_TXT_CUPON_OFF
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel messageInformation;
    private javax.swing.JTable tblCupon;
    private javax.swing.JTextField txtDiscount;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtKeySearch;
    private javax.swing.JTextField txtMaxQuantity;
    private javax.swing.JTextField txtNameCupon;
    private com.toedter.calendar.JDateChooser txtStartDate;
    // End of variables declaration//GEN-END:variables
}

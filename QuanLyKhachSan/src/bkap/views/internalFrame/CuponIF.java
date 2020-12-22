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
        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCupon = new javax.swing.JTable();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        messageInformation = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

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
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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
                                .addComponent(messageInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnThem)))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
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
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete))
                    .addComponent(messageInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        getValueOfFields();
        if (checkValidate()) {
            Cupon c  = setPropertiesForObject();
            cuponDAO.add(c);
            Utils.setMessageInformation(messageInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);

            setNullValueFields();
            listCupon = cuponDAO.findAll();
            setDataTable(modelCupon, listCupon);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblCuponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuponMouseClicked
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
        c.setStatus(SystemConstant.STATUS_ON);
        return c;
    }

    private void setNullValueFields() {
        txtNameCupon.setText("");
        txtMaxQuantity.setText("");
        txtDiscount.setText("");
        txtStartDate.setDate(null);
        txtEndDate.setDate(null);
    }

    private void setDataTable(DefaultTableModel model, List<Cupon> list) {
        model.setRowCount(0);
        for (Cupon c : list) {
            model.addRow(new Object[]{
                c.getName(), c.getMaxQuantity(), c.getDiscount(), c.getStartDate(), c.getEndDate(), c.getStatus() == SystemConstant.STATUS_OFF ? "Kết thúc" : "Đang diễn ra"
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageInformation;
    private javax.swing.JTable tblCupon;
    private javax.swing.JTextField txtDiscount;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtMaxQuantity;
    private javax.swing.JTextField txtNameCupon;
    private com.toedter.calendar.JDateChooser txtStartDate;
    // End of variables declaration//GEN-END:variables
}

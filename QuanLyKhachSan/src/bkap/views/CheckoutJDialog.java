/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views;

import bkap.dao.impl.CheckinDAO;
import bkap.dao.impl.CheckinDetailsDAO;
import bkap.dao.impl.CheckinServiceDetailsDAO;
import bkap.dao.impl.CuponDAO;
import bkap.dao.impl.CustomerDAO;
import bkap.dao.impl.RoomDAO;
import bkap.dao.impl.ServiceDAO;
import bkap.model.CheckinDetails;
import bkap.model.CheckinServiceDetails;
import bkap.model.Cupon;
import bkap.model.Customer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author hongb
 */
public class CheckoutJDialog extends javax.swing.JDialog {

    private CheckinDAO checkinDao = new CheckinDAO();
    private CheckinDetailsDAO checkinDetailDao = new CheckinDetailsDAO();
    private CheckinServiceDetailsDAO checkinSerDetailDao = new CheckinServiceDetailsDAO();
    private CustomerDAO cusDao = new CustomerDAO();
    private ServiceDAO serDao = new ServiceDAO();
    private RoomDAO roomDao = new RoomDAO();
    private CuponDAO cuponDao = new CuponDAO();

    private int idCheckindetail;
    private int idR;
    private Date startDate;
    private Date endDate;
    private long time;
    private String note;
    private Float TotalPriceRoom;
    private float pricePaymentAdvance; // tiền thanh toán trước
    private float priceAgreement; // tiền thỏa thuận
    private float extendPrice;
    private float subPrice;
    private float totalServicePrice;
    private float totalPrice;
    private String des;
    private String txtService;
    private String txtCupon;
    private List<CheckinServiceDetails> listObjSer;
    private List<Integer> listIntSer = new ArrayList<>();
    private List<Integer> listSerDB = new ArrayList<>();
    private List<Integer> listRoomSelected = new ArrayList<>();
    private Map<Integer, List<Integer>> listServiceSelected = new HashMap<Integer, List<Integer>>();
    private CheckinDetails checkinDetail;
    private Cupon c;

    /**
     * Creates new form CheckoutJDialog
     */
    public CheckoutJDialog(java.awt.Frame parent, boolean modal, int idCheckinDetail) {
        super(parent, modal);
        initComponents();
        this.idCheckindetail = idCheckinDetail;

        checkinDetail = checkinDetailDao.findByDetailId(idCheckindetail).get(0);
        idR = checkinDetail.getRoomId();
        Customer cus = cusDao.findByPhone(checkinDao.findById(checkinDetail.getCheckinId()).getCusPhone()).get(0);
        setTitle("P " + idR + " " + cus.getFullname());

        listObjSer = checkinSerDetailDao.findByIdCheckinDetail(checkinDetail.getDetailId());
        if (listObjSer.size() != 0) {
            for (CheckinServiceDetails listObjSer1 : listObjSer) {
                listIntSer.add(listObjSer1.getIdService());
            }
        }
        listRoomSelected.add(idR);
        listServiceSelected.put(idR, listIntSer);
        setValueOfFields();
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
        lbStartDate = new javax.swing.JLabel();
        lbEndDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        lbRoomPrice = new javax.swing.JLabel();
        txtTotalPriceRoom = new javax.swing.JTextField();
        txtGetDay = new javax.swing.JLabel();
        lbPriceAgreeing = new javax.swing.JLabel();
        txtPriceAgreement = new javax.swing.JLabel();
        lbAdvancedPrice = new javax.swing.JLabel();
        txtPricePaymentAdvance = new javax.swing.JTextField();
        lbExPrice = new javax.swing.JLabel();
        txtSubPrice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTotalServicePrice = new javax.swing.JTextField();
        lbTotalMoney = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPay = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtExtendPrice = new javax.swing.JTextField();
        lbNote = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        btnService = new javax.swing.JButton();
        txtSer = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JButton();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        lblCupon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbStartDate.setText("Thời gian bắt đầu");

        lbEndDate.setText("Thời gian kết thúc");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icons8_sand_clock_20px.png"))); // NOI18N

        lblTime.setText("4 ngày 1 giờ");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icons8_info_20px.png"))); // NOI18N

        lblNote.setText("Nhận phòng sớm 46 phút / Trả phòng muộn 1 giờ 13 phút");

        lbRoomPrice.setText("Tiền phòng");

        txtGetDay.setText("Tiền phòng 4 ngày");

        lbPriceAgreeing.setText("Giá thỏa thuận");

        txtPriceAgreement.setText("1.000.00");

        lbAdvancedPrice.setText("Tiền trả trước");

        txtPricePaymentAdvance.setText("500.000");

        lbExPrice.setText("Thu, giảm trừ");

        txtSubPrice.setText("0.000");

        jLabel13.setText("Tiền dịch vụ");

        txtTotalServicePrice.setText("0.000");

        lbTotalMoney.setText("Tổng tiền");

        txtTotalPrice.setText("1020.000");

        jLabel16.setText("Tiền cần trả");

        txtPay.setText("520.000");

        jLabel18.setText("Phụ thu");

        txtExtendPrice.setText("20.000");
        txtExtendPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExtendPriceActionPerformed(evt);
            }
        });

        lbNote.setText("Ghi chú");

        txtDes.setColumns(20);
        txtDes.setRows(2);
        jScrollPane1.setViewportView(txtDes);

        btnService.setText("Menu sử dụng");
        btnService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiceActionPerformed(evt);
            }
        });

        txtSer.setText("List menu");

        btnCheckout.setText("Trả phòng");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã giảm giá");

        txtDiscount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiscountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiscountFocusLost(evt);
            }
        });

        lblCupon.setText("Giảm ? %");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbStartDate)
                            .addComponent(lbEndDate)
                            .addComponent(lbRoomPrice)
                            .addComponent(lbPriceAgreeing))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalPriceRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPriceAgreement, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGetDay)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbAdvancedPrice)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(27, 27, 27)
                                                .addComponent(txtTotalServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtPricePaymentAdvance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnCheckout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNote)
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbExPrice)
                                    .addComponent(lbTotalMoney))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSubPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtExtendPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblTime)
                                .addGap(97, 97, 97)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblNote))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(80, 80, 80)
                                .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCupon))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnService)
                                .addGap(35, 35, 35)
                                .addComponent(txtSer)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbStartDate)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbEndDate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRoomPrice)
                    .addComponent(txtTotalPriceRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGetDay))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPriceAgreeing)
                    .addComponent(txtPriceAgreement)
                    .addComponent(lbAdvancedPrice)
                    .addComponent(txtPricePaymentAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbExPrice)
                    .addComponent(txtSubPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTotalServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtExtendPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalMoney)
                    .addComponent(txtTotalPrice)
                    .addComponent(jLabel16)
                    .addComponent(txtPay))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCupon))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNote)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnService)
                    .addComponent(txtSer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckout)
                    .addComponent(btnUpdate))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExtendPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExtendPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExtendPriceActionPerformed

    private void btnServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiceActionPerformed
        // TODO add your handling code here:

        ListServiceJDialog listService = new ListServiceJDialog(null, true, listRoomSelected, listServiceSelected);
        listService.setVisible(true);
        listService.validate();
        listServiceSelected = listService.getListServiceSelected();
        setValueOfFields();
    }//GEN-LAST:event_btnServiceActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int sizeListSer = listObjSer.size();
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entrySet : listServiceSelected.entrySet()) {

            Integer key = entrySet.getKey();
            List<Integer> value = entrySet.getValue();
            for (Integer v : value) {
                i++;
                if (i > sizeListSer) {
                    CheckinServiceDetails checkinSerDetail = setPropertiesForObjectCheckinServiceDetails(v);
                    checkinSerDetailDao.add(checkinSerDetail);
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                }
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
        checkinDetailDao.changeStatusRoom(checkinDetail.getDetailId(), 2);
        roomDao.changeStatus(idR, 2);
        JOptionPane.showMessageDialog(this, "Đã trả phòng thành công");
        this.dispose();
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void txtDiscountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscountFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDiscountFocusGained

    private void txtDiscountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscountFocusLost
        // TODO add your handling code here:
        txtCupon = txtDiscount.getText();
        List<Cupon> listCupon = cuponDao.findByNameAndStatus(txtCupon, 0);
        if (listCupon.size() > 0) {
            c = listCupon.get(0);
            lblCupon.setText("Giảm " + c.getDiscount() + " %");
            subPrice = totalPrice * c.getDiscount() / 100;
            txtSubPrice.setText(subPrice + "");
        } else {
            lblCupon.setText("Không tìm thấy mã giảm giá");
            txtSubPrice.setText(0 + "");
        }
        totalPrice = priceAgreement + extendPrice - subPrice;
        txtPay.setText((totalPrice - pricePaymentAdvance) + "");
    }//GEN-LAST:event_txtDiscountFocusLost

    private void getVaLueOfDB() {
        txtService = "";

        for (Map.Entry<Integer, List<Integer>> entrySet : listServiceSelected.entrySet()) {
            Integer key = entrySet.getKey();
            List<Integer> value = entrySet.getValue();
            for (Integer v : value) {
                txtService += serDao.findByID(v).getName() + ", ";
            }
        }
        startDate = checkinDetail.getStartDate();
        endDate = checkinDetail.getEndDate();
        time = (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
        note = "Trống";
        TotalPriceRoom = checkinDetail.getPrice() * time;
        pricePaymentAdvance = 0;
        totalServicePrice = checkinDetail.getTotalServicePrice();
        priceAgreement = TotalPriceRoom + totalServicePrice;
        extendPrice = 0;
        totalPrice = priceAgreement + extendPrice - subPrice;
        subPrice = 0;
        des = "";
    }

    private void setValueOfFields() {
        getVaLueOfDB();

        txtStartDate.setDate(startDate);
        txtEndDate.setDate(endDate);
        lblTime.setText(time + " ngày");
        lblNote.setText(note);
        txtTotalPriceRoom.setText(TotalPriceRoom + "");
        txtGetDay.setText("Tiền phòng trong " + time + " ngày");
        txtPriceAgreement.setText(priceAgreement + "");
        txtPricePaymentAdvance.setText(pricePaymentAdvance + "");
        txtSubPrice.setText(subPrice + "");
        txtExtendPrice.setText(extendPrice + "");
        txtTotalServicePrice.setText(totalServicePrice + "");
        txtTotalPrice.setText(totalPrice + "");
        txtPay.setText((totalPrice - pricePaymentAdvance) + "");
        txtDes.setText(des);
        txtSer.setText(txtService);
    }

    private CheckinServiceDetails setPropertiesForObjectCheckinServiceDetails(int idSer) {
        CheckinServiceDetails c = new CheckinServiceDetails();

        c.setIdCheckinDetails(checkinDetail.getDetailId());
        c.setIdService(idSer);
        c.setPrice(serDao.findByID(idSer).getOutputPrice());
        c.setQuantity(1);
        return c;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckoutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckoutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckoutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckoutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckoutJDialog dialog = new CheckoutJDialog(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnService;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAdvancedPrice;
    private javax.swing.JLabel lbEndDate;
    private javax.swing.JLabel lbExPrice;
    private javax.swing.JLabel lbNote;
    private javax.swing.JLabel lbPriceAgreeing;
    private javax.swing.JLabel lbRoomPrice;
    private javax.swing.JLabel lbStartDate;
    private javax.swing.JLabel lbTotalMoney;
    private javax.swing.JLabel lblCupon;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtDiscount;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtExtendPrice;
    private javax.swing.JLabel txtGetDay;
    private javax.swing.JLabel txtPay;
    private javax.swing.JLabel txtPriceAgreement;
    private javax.swing.JTextField txtPricePaymentAdvance;
    private javax.swing.JLabel txtSer;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JTextField txtSubPrice;
    private javax.swing.JLabel txtTotalPrice;
    private javax.swing.JTextField txtTotalPriceRoom;
    private javax.swing.JTextField txtTotalServicePrice;
    // End of variables declaration//GEN-END:variables
}

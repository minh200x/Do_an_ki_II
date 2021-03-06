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
import bkap.dao.impl.CuponDAO;
import bkap.dao.impl.CustomerDAO;
import bkap.dao.impl.RoomDAO;
import bkap.dao.impl.ServiceDAO;
import bkap.model.Checkin;
import bkap.model.CheckinDetails;
import bkap.model.CheckinServiceDetails;
import bkap.model.Cupon;
import bkap.model.Customer;
import bkap.model.Room;
import bkap.model.Service;
import bkap.utils.Helper;
import bkap.utils.SystemConstant;
import bkap.utils.Utils;
import bkap.views.ListRoomEmptyJDialog;
import bkap.views.ListServiceJDialog;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author THUY
 */
public class BookRoomIF extends javax.swing.JInternalFrame {

    private CheckinDAO checkinDao = new CheckinDAO();
    private CheckinDetailsDAO checkinDetailDao = new CheckinDetailsDAO();
    private CheckinServiceDetailsDAO checkinSerDetailDao = new CheckinServiceDetailsDAO();
    private CuponDAO cuponDao = new CuponDAO();
    private CustomerDAO cusDao = new CustomerDAO();
    private ServiceDAO serDao = new ServiceDAO();
    private RoomDAO roomDao = new RoomDAO();
    private CategoryRoomDAO catRoomDao = new CategoryRoomDAO();
    private List<Cupon> listCupon;
    private List<Integer> listRoomSelected = new ArrayList<>();
    private Map<Integer, List<Integer>> listServiceSelected = new HashMap<Integer, List<Integer>>();

    private int idCheckin;
    private int idService;
    private int idCheckinDetail;
    private int idCheckinSerDetail;
    private String name;
    private String phone;
    private Date startDate = null;
    private Date endDate = null;
    private float pricePaymentAdvance;
    private float priceAgreement = 0;
    private float totalServicePriceSub = 0;
    private float totalServicePrice = 0;
    private String des;
    private int countRoomSingle;
    private int countRoomDouble;
    private int totalPeople;
    private String numIdentityCard;
    private String cupon;
    private List<Room> listRoom;
    private List<Service> listService;
    private List<Checkin> listCheckin;
    private List<CheckinDetails> listCheckinDetail;
    private List<CheckinServiceDetails> listCheckinSerDetail;
    private List<Customer> listCus;

    /**
     * Creates new form BookRoomIF
     */
    public BookRoomIF() {
        Utils.setIconIF(this, Helper.getResources("tBookRoom"));
        initComponents();
        listCheckin = checkinDao.findAll();
//        setNameLabelAndButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jn1 = new javax.swing.JPanel();
        lbNameCustomer = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lbCheckinDate = new javax.swing.JLabel();
        lbCheckoutDate = new javax.swing.JLabel();
        lbAdvancedPrice = new javax.swing.JLabel();
        txtPricePaymentAdvance = new javax.swing.JTextField();
        lbPriceAgreeing = new javax.swing.JLabel();
        txtPriceAgreement = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        btnGetRoom = new javax.swing.JButton();
        lbEmpty = new javax.swing.JLabel();
        lbCategoryRoom = new javax.swing.JLabel();
        lbSingleRoom = new javax.swing.JLabel();
        btnSingleSub = new javax.swing.JButton();
        btnSingleIncrease = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnDoubleSub = new javax.swing.JButton();
        btnDoubleIncrease = new javax.swing.JButton();
        btnBookRoom = new javax.swing.JButton();
        lbTotalPeople = new javax.swing.JLabel();
        txtTotalPeople = new javax.swing.JTextField();
        btnGetService = new javax.swing.JButton();
        txtRoomSingle = new javax.swing.JTextField();
        txtRoomDouble = new javax.swing.JTextField();
        txtInfo = new javax.swing.JLabel();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        lbIdentityCard = new javax.swing.JLabel();
        txtNumIdentityCard = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Đặt phòng");

        lbNameCustomer.setText("Họ tên khách hàng");

        lbPhone.setText("Số điện thoại");

        lbCheckinDate.setText("Ngày nhận phòng");

        lbCheckoutDate.setText("Ngày trả phòng");

        lbAdvancedPrice.setText("Tiền trả trước");

        txtPricePaymentAdvance.setText("0");

        lbPriceAgreeing.setText("Giá thỏa thuận");

        txtPriceAgreement.setText("0");

        jLabel7.setText("Ghi chú");

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane1.setViewportView(txtDes);

        btnGetRoom.setText("Phòng đặt");
        btnGetRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRoomActionPerformed(evt);
            }
        });

        lbEmpty.setText("Trống");

        lbCategoryRoom.setText("Loại phòng");

        lbSingleRoom.setText("Phòng đơn");

        btnSingleSub.setText("-");
        btnSingleSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingleSubActionPerformed(evt);
            }
        });

        btnSingleIncrease.setText("+");
        btnSingleIncrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingleIncreaseActionPerformed(evt);
            }
        });

        jLabel12.setText("Phòng đôi");

        btnDoubleSub.setText("-");
        btnDoubleSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoubleSubActionPerformed(evt);
            }
        });

        btnDoubleIncrease.setText("+");
        btnDoubleIncrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoubleIncreaseActionPerformed(evt);
            }
        });

        btnBookRoom.setText("Đặt phòng");
        btnBookRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookRoomActionPerformed(evt);
            }
        });

        lbTotalPeople.setText("Số người");

        txtTotalPeople.setText("1");

        btnGetService.setText("Dịch vụ");
        btnGetService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetServiceActionPerformed(evt);
            }
        });

        txtRoomSingle.setText("1");

        txtRoomDouble.setText("0");

        txtStartDate.setDateFormatString("dd-MM-yyyy");

        txtEndDate.setDateFormatString("dd-MM-yyyy");

        lbIdentityCard.setText("CMND/ CCCD");

        javax.swing.GroupLayout jn1Layout = new javax.swing.GroupLayout(jn1);
        jn1.setLayout(jn1Layout);
        jn1Layout.setHorizontalGroup(
            jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jn1Layout.createSequentialGroup()
                .addComponent(txtInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBookRoom))
            .addGroup(jn1Layout.createSequentialGroup()
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNameCustomer)
                    .addComponent(lbPhone)
                    .addComponent(lbCheckinDate)
                    .addComponent(lbAdvancedPrice)
                    .addComponent(jLabel7)
                    .addComponent(btnGetRoom)
                    .addComponent(lbCategoryRoom)
                    .addComponent(lbTotalPeople))
                .addGap(18, 18, 18)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jn1Layout.createSequentialGroup()
                        .addComponent(lbEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetService)
                        .addGap(299, 299, 299))
                    .addGroup(jn1Layout.createSequentialGroup()
                        .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtPhone)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(jn1Layout.createSequentialGroup()
                        .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jn1Layout.createSequentialGroup()
                                .addComponent(txtTotalPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(lbIdentityCard)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumIdentityCard))
                            .addGroup(jn1Layout.createSequentialGroup()
                                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jn1Layout.createSequentialGroup()
                                        .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPricePaymentAdvance, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                            .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(97, 97, 97)
                                        .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jn1Layout.createSequentialGroup()
                                                .addComponent(lbPriceAgreeing)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPriceAgreement, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jn1Layout.createSequentialGroup()
                                                .addComponent(lbCheckoutDate)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jn1Layout.createSequentialGroup()
                                        .addComponent(lbSingleRoom)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSingleSub, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRoomSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSingleIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDoubleSub, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRoomDouble, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDoubleIncrease)))
                                .addGap(0, 21, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jn1Layout.setVerticalGroup(
            jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jn1Layout.createSequentialGroup()
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(lbNameCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCheckinDate)
                        .addComponent(lbCheckoutDate))
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPricePaymentAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPriceAgreeing)
                        .addComponent(txtPriceAgreement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbAdvancedPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGetService))
                    .addComponent(btnGetRoom))
                .addGap(18, 18, 18)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSingleRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSingleSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSingleIncrease)
                        .addComponent(btnDoubleIncrease)
                        .addComponent(txtRoomSingle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRoomDouble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDoubleSub))
                    .addComponent(lbCategoryRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotalPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbIdentityCard)
                        .addComponent(txtNumIdentityCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbTotalPeople, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBookRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetRoomActionPerformed
        ListRoomEmptyJDialog listRoom = new ListRoomEmptyJDialog(null, true, listRoomSelected);
        listRoom.setVisible(true);
        listRoom.validate();
        listRoomSelected = listRoom.getListRoomSelected();
        String textList = "";
        for (Integer data : listRoomSelected) {
            textList += "P" + data + ";  ";
        }
        lbEmpty.setText(textList);
    }//GEN-LAST:event_btnGetRoomActionPerformed

    private void btnSingleIncreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingleIncreaseActionPerformed
        // TODO add your handling code here:
        countRoomSingle = Integer.parseInt(txtRoomSingle.getText().trim()) + 1;
        txtRoomSingle.setText(countRoomSingle + "");
    }//GEN-LAST:event_btnSingleIncreaseActionPerformed

    private void btnDoubleSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoubleSubActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtRoomDouble.getText().trim()) > 0) {
            countRoomDouble = Integer.parseInt(txtRoomDouble.getText().trim()) - 1;
            txtRoomDouble.setText(countRoomDouble+"");
        }
    }//GEN-LAST:event_btnDoubleSubActionPerformed

    private void btnGetServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetServiceActionPerformed
        // TODO add your handling code here:
        ListServiceJDialog listService = new ListServiceJDialog(null, true, listRoomSelected, listServiceSelected);
        if (listRoomSelected.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phòng! Vui lòng chọn phòng trước!");
        } else {
            listService.setVisible(true);
            listService.validate();
        }
        listServiceSelected = listService.getListServiceSelected();
    }//GEN-LAST:event_btnGetServiceActionPerformed

    private void btnSingleSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingleSubActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtRoomSingle.getText().trim()) > 0) {
            countRoomSingle = Integer.parseInt(txtRoomSingle.getText().trim()) - 1;
            txtRoomSingle.setText(countRoomSingle + "");
        }
    }//GEN-LAST:event_btnSingleSubActionPerformed

    private void btnBookRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookRoomActionPerformed
        // TODO add your handling code here:
        if (checkValidate()) {
            
            // add customer
            Customer c = setPropertiesForObjectCustomer();
            List<Customer> listCusItem = cusDao.findByPhone(phone);
            if(listCusItem.size() == 0){
                phone = cusDao.add(c);
            }
            // add checkin
            Checkin checkin = setPropertiesForObjectCheckin();
            idCheckin = checkinDao.add(checkin);
            
            for (Integer idRoomItem : listRoomSelected) {
                // add checkinDetail
                CheckinDetails checkinDetail = setPropertiesForObjectCheckinDetails(idRoomItem);
                idCheckinDetail = checkinDetailDao.add(checkinDetail);
                
                for (Map.Entry<Integer, List<Integer>> entrySet : listServiceSelected.entrySet()) {
                    Integer key = entrySet.getKey();
                    List<Integer> value = entrySet.getValue();
                    if(idRoomItem == key){
                        for (Integer v : value) {
                            // add checkinServicer Detail
                            CheckinServiceDetails checkinSerDetail = setPropertiesForObjectCheckinServiceDetails(v);
                            checkinSerDetailDao.add(checkinSerDetail);
                        }
                    }
                }
            }
            
            Utils.setMessageInformation(txtInfo, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
            setNullValueFields();
        }

    }//GEN-LAST:event_btnBookRoomActionPerformed

    private void btnDoubleIncreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoubleIncreaseActionPerformed
        // TODO add your handling code here:
        countRoomDouble = Integer.parseInt(txtRoomDouble.getText().trim()) + 1;
        txtRoomDouble.setText(countRoomDouble+"");
    }//GEN-LAST:event_btnDoubleIncreaseActionPerformed

    private void getValueOfFields() {
        int totalPriceRoom = 0;
        name = txtName.getText();
        phone = txtPhone.getText();
        startDate = txtStartDate.getDate();
        endDate = txtEndDate.getDate();
        pricePaymentAdvance = Float.parseFloat(txtPricePaymentAdvance.getText());
        for (Integer listR : listRoomSelected) {
            totalPriceRoom += catRoomDao.findByCateId(roomDao.findByRoomId(listR).getTypeId()).getPrice();
            totalServicePrice += priceServiceOfRoom(listR);
        }
        priceAgreement = totalPriceRoom + totalServicePrice;
        des = txtDes.getText();
        countRoomSingle = Integer.parseInt(txtRoomSingle.getText());
        countRoomDouble = Integer.parseInt(txtRoomDouble.getText());
        totalPeople = Integer.parseInt(txtTotalPeople.getText());
        numIdentityCard = txtNumIdentityCard.getText();
    }

    private boolean checkValidate() {
        boolean check = false;
        getValueOfFields();
        if (name.isEmpty()) {
            Utils.setMessageInformation(txtInfo, "Vui lòng nhập tên khách hàng!", false);
        } else if (!name.matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")) {
            Utils.setMessageInformation(txtInfo, "Vui lòng tên khách hàng không nhập kí tự đặc biệt!", false);
        } else if (!phone.matches("^[0-9]{10}+$")) {
            Utils.setMessageInformation(txtInfo, "Vui lòng nhập đúng định dạng số điện thoại!", isMaximum);
        } else if (startDate == null) {
            Utils.setMessageInformation(txtInfo, "Vui lòng chọn ngày bắt đầu!", false);
        } else if (endDate.equals(startDate) || endDate.before(startDate)) {
            Utils.setMessageInformation(txtInfo, "Vui lòng chọn ngày kết thúc sau ngày bắt đầu!", false);
        } else if (pricePaymentAdvance < 0) {
            Utils.setMessageInformation(txtInfo, "Vui lòng nhập tiền trả trước phù hợp!", false);
        } else if (countRoomSingle < 0 || countRoomDouble < 0) {
            Utils.setMessageInformation(txtInfo, "Vui lòng nhập số lượng phòng phù hợp!", false);
        } else if (totalPeople < 1) {
            Utils.setMessageInformation(txtInfo, "Vui lòng nhập số lượng người phù hợp!", false);
        } else {
            check = true;
        }
        return check;
    }

    private Checkin setPropertiesForObjectCheckin() {
        Checkin c = new Checkin();
        c.setId(idCheckin);
        c.setCusPhone(phone);
        c.setTotalPeople(totalPeople);
        c.setDescript(des);
        c.setTotalMoney(priceAgreement);
        c.setPricePaymentAdvance(pricePaymentAdvance);

        // truyền mã giảm giá
        c.setCuponId(1);
        c.setTotalServicePrice(totalServicePrice);
        

        return c;
    }

    private Customer setPropertiesForObjectCustomer() {
        Customer cus = new Customer();
        cus.setFullname(name);
        cus.setPhone(phone);
        cus.setEmail(null);
        cus.setAddress(null);
        cus.setDescript(null);
        cus.setGender(true);
        cus.setCreatedAt(startDate);
        cus.setUpdatedAt(endDate);
        cus.setNumIdentityCard(numIdentityCard);
        return cus;
        
    }

    private CheckinDetails setPropertiesForObjectCheckinDetails(int idRoom) {
        CheckinDetails c = new CheckinDetails();

        c.setDetailId(idCheckinDetail);
        c.setCheckinId(idCheckin);

        c.setRoomId(idRoom);
        c.setPrice(catRoomDao.findByCateId(roomDao.findByRoomId(idRoom).getTypeId()).getPrice());

        c.setStartDate(startDate);
        c.setEndDate(endDate);

        c.setTotalServicePrice(priceServiceOfRoom(idRoom));
        c.setStatus(0);

        return c;
    }

    private CheckinServiceDetails setPropertiesForObjectCheckinServiceDetails(int idSer) {
        CheckinServiceDetails c = new CheckinServiceDetails();

        c.setIdCheckinDetails(idCheckinDetail);
        c.setIdService(idSer);
        c.setPrice(serDao.findByID(idSer).getOutputPrice());
        c.setQuantity(1);
        return c;
    }

    private void setNullValueFields() {
        txtName.setText("");
        txtPhone.setText("");
        txtDes.setText("");
        txtEndDate.setDate(null);
        txtStartDate.setDate(null);
        txtNumIdentityCard.setText("");
        txtPriceAgreement.setText("0");
        txtPricePaymentAdvance.setText("0");
        txtRoomDouble.setText("0");
        txtRoomSingle.setText("1");
        txtTotalPeople.setText("1");
        lbEmpty.setText("Trống");
    }

    private int priceServiceOfRoom(int id) {
        int price = 0;
        for (Map.Entry<Integer, List<Integer>> entrySet : listServiceSelected.entrySet()) {
            Integer key = entrySet.getKey();
            List<Integer> value = entrySet.getValue();
            if (key == id) {
                for (Integer v : value) {
                    price += serDao.findByID(v).getOutputPrice();
                }
            }
        }
        return price;
    }

    private void setNameLabelAndButton() {
        lbAdvancedPrice.setText(Helper.getResources("paymentAdvanced"));
        lbCategoryRoom.setText(Helper.getResources("categoryRoom"));
        lbCheckinDate.setText(Helper.getResources("checkinDate"));
        lbCheckoutDate.setText(Helper.getResources("checkoutDate"));
        lbEmpty.setText(Helper.getResources("empty"));
        lbIdentityCard.setText(Helper.getResources("numOfIdentityCard"));
        lbNameCustomer.setText(Helper.getResources("fullnameCus"));
        lbPhone.setText(Helper.getResources("phone"));
        lbSingleRoom.setText(Helper.getResources("singleRoom"));
        lbPriceAgreeing.setText(Helper.getResources("priceAgreeing"));
        lbTotalPeople.setText(Helper.getResources("totalPeople"));
        
        btnBookRoom.setText(Helper.getResources("bookRoom"));
        btnGetRoom.setText(Helper.getResources("chooseRoom"));
        btnGetService.setText(Helper.getResources("chooseService"));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookRoom;
    private javax.swing.JButton btnDoubleIncrease;
    private javax.swing.JButton btnDoubleSub;
    private javax.swing.JButton btnGetRoom;
    private javax.swing.JButton btnGetService;
    private javax.swing.JButton btnSingleIncrease;
    private javax.swing.JButton btnSingleSub;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jn1;
    private javax.swing.JLabel lbAdvancedPrice;
    private javax.swing.JLabel lbCategoryRoom;
    private javax.swing.JLabel lbCheckinDate;
    private javax.swing.JLabel lbCheckoutDate;
    private javax.swing.JLabel lbEmpty;
    private javax.swing.JLabel lbIdentityCard;
    private javax.swing.JLabel lbNameCustomer;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbPriceAgreeing;
    private javax.swing.JLabel lbSingleRoom;
    private javax.swing.JLabel lbTotalPeople;
    private javax.swing.JTextArea txtDes;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JLabel txtInfo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumIdentityCard;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPriceAgreement;
    private javax.swing.JTextField txtPricePaymentAdvance;
    private javax.swing.JTextField txtRoomDouble;
    private javax.swing.JTextField txtRoomSingle;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JTextField txtTotalPeople;
    // End of variables declaration//GEN-END:variables
}

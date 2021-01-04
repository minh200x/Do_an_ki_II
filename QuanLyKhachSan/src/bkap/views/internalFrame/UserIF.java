/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views.internalFrame;

import bkap.dao.impl.LevelDAO;
import bkap.dao.impl.UserDAO;
import bkap.model.Level;
import bkap.model.User;
import bkap.utils.Helper;
import bkap.utils.Security;
import bkap.utils.SystemConstant;
import bkap.utils.Utils;
import bkap.views.LoginDialog;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.DesktopIconUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hongb
 */
public class UserIF extends javax.swing.JInternalFrame {

    private UserDAO userDAO = new UserDAO();
    private LevelDAO levelDAO = new LevelDAO();

    private List<User> listUser;
    private List<Level> listLevel;

    private DefaultTableModel modelUser;
    private DefaultComboBoxModel cbModelLevel;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private int userId;
    private String pathDirImage = "src\\bkap\\images\\users\\";
    private String pathFileImage = "";
    private File fileImg = null;

    private String fullname;
    private String username;
    private String password;
    private String phone;
    private String levelName;
    private String address;
    private String image;
    private String descript;
    private Date birthday = null;
    private Date startDate = null;
    private Date endDate = null;

    /**
     * Creates new form UserIF
     */
    public UserIF() {   
        Utils.setIconIF(this, "Quản lý nhân viên");
        initComponents();        

        listUser = userDAO.findAll();
        listLevel = levelDAO.findAll();

        modelUser = (DefaultTableModel) tblUser.getModel();
        cbModelLevel = (DefaultComboBoxModel) cbLevel.getModel();

        setComboxModelLevel(listLevel);
        setDataTable(listUser);
        setNameLabelAndButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbFullname = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        lbUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lbPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lbPhone = new javax.swing.JLabel();
        cbLevel = new javax.swing.JComboBox();
        txtPhone = new javax.swing.JTextField();
        lbLevel = new javax.swing.JLabel();
        lbAddess = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lbAvartar = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        containImg = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbMale = new javax.swing.JRadioButton();
        lbFemale = new javax.swing.JRadioButton();
        lbBirthday = new javax.swing.JLabel();
        lbNote = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescript = new javax.swing.JTextArea();
        lbStartDate = new javax.swing.JLabel();
        lbEndDate = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        msgInformation = new javax.swing.JLabel();
        txtBirthday = new com.toedter.calendar.JDateChooser();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtKeySearch = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        lbFullname.setText("Họ và tên");

        lbUsername.setText("Username");

        lbPassword.setText("Password");

        lbPhone.setText("Số điện thoại");

        lbLevel.setText("Chức vụ");

        lbAddess.setText("Địa chỉ");

        txtAddress.setColumns(20);
        txtAddress.setRows(2);
        jScrollPane1.setViewportView(txtAddress);

        lbAvartar.setText("Ảnh đại diện");

        btnChooseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_folder_20px.png"))); // NOI18N
        btnChooseImage.setText("Chọn ảnh");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        containImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbGender.setText("Giới tính");

        buttonGroupGender.add(lbMale);
        lbMale.setText("Nam");

        buttonGroupGender.add(lbFemale);
        lbFemale.setText("Nữ");

        lbBirthday.setText("Ngày sinh");

        lbNote.setText("Mô tả");

        txtDescript.setColumns(20);
        txtDescript.setRows(5);
        jScrollPane2.setViewportView(txtDescript);

        lbStartDate.setText("Ngày vào làm");

        lbEndDate.setText("Ngày nghỉ");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_edit_20px.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_add_20px.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        msgInformation.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N

        txtBirthday.setDateFormatString("dd-MM-yyyy");

        txtStartDate.setDateFormatString("dd-MM-yyyy");

        txtEndDate.setDateFormatString("dd-MM-yyyy");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_refresh_20px.png"))); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_remove_20px.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUsername)
                            .addComponent(lbFullname)
                            .addComponent(lbPassword)
                            .addComponent(lbPhone)
                            .addComponent(lbLevel)
                            .addComponent(lbGender)
                            .addComponent(lbBirthday)
                            .addComponent(lbAddess)
                            .addComponent(lbNote)
                            .addComponent(lbStartDate))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbMale)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFemale)
                                        .addGap(192, 192, 192)
                                        .addComponent(lbAvartar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbEndDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbLevel, 0, 210, Short.MAX_VALUE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnChooseImage)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                        .addComponent(containImg, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(41, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addContainerGap())
                    .addComponent(msgInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPhone)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLevel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(containImg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseImage)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbGender)
                        .addComponent(lbMale)
                        .addComponent(lbFemale))
                    .addComponent(lbAvartar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBirthday)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAddess)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbNote))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnRefresh)
                            .addComponent(btnDelete)))
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(msgInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "Username", "Chức vụ", "Số điện thoại", "Giới tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUser);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_search_20px.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtKeySearch.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        txtKeySearch.setForeground(new java.awt.Color(153, 153, 153));
        txtKeySearch.setText("Họ tên, username, sdt");
        txtKeySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtKeySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtKeySearchFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpeg", "jpg", "png");

        fileChooser.setFileFilter(imgFilter);
        fileChooser.setMultiSelectionEnabled(false);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            fileImg = fileChooser.getSelectedFile();
            pathFileImage = fileImg.getAbsolutePath();
            // set image
            Utils.setImage(containImg, pathFileImage);
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (checkValidate()) {
            User u = setPropertiesForObject();
            saveImage();
            userDAO.add(u);
            Utils.setMessageInformation(msgInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
            setNullValueFields();
            listUser = userDAO.findAll();
            setDataTable(listUser);
        }
    }//GEN-LAST:event_btnAddActionPerformed


    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        int indexSelected = tblUser.getSelectedRow();
        User u = listUser.get(indexSelected);
        userId = u.getId();
        txtFullname.setText(u.getFullname());
        txtUsername.setText(u.getUsername());
        txtPhone.setText(u.getPhone());
        txtPassword.setText(Security.decrypt(u.getPassword(), SystemConstant.SECRET_KEY));
        txtAddress.setText(u.getAddress());
        txtDescript.setText(u.getDescript());
        txtBirthday.setDate(u.getBirthday());
        txtStartDate.setDate(u.getStartDate());
        txtEndDate.setDate(u.getEndDate());
        image = u.getImage();
        Utils.setImage(containImg, image);
        for (Level level : listLevel) {
            if (level.getId() == u.getLevelId()) {
                cbLevel.setSelectedItem(level.getName());
            }
        }
        if (u.isGender() == SystemConstant.GENDER_FEMALE) {
            lbFemale.setSelected(true);
        } else {
            lbMale.setSelected(true);
        }
        
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        msgInformation.setText("");
        
//        System.out.println("oke" + containImg.getWidth() + containImg.getHeight());
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (checkValidate()) {
            saveImage();
            User u = setPropertiesForObject();            
            userDAO.edit(u);
            Utils.setMessageInformation(msgInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
            setNullValueFields();
            listUser = userDAO.findAll();
            setDataTable(listUser);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keySearch = txtKeySearch.getText();
        listUser = userDAO.findByPhone(keySearch);
        if (listUser.equals("Họ tên, username, sdt")) {
            Utils.setMessageInformation(msgInformation, SystemConstant.ERROR_NO_RESULT, false);
            listUser = userDAO.findByFullname(keySearch);
            if (listUser.isEmpty()) {
                Utils.setMessageInformation(msgInformation, SystemConstant.ERROR_NO_RESULT, false);
                listUser = userDAO.findByUsername(keySearch);
                if (listUser.isEmpty()) {
                    Utils.setMessageInformation(msgInformation, SystemConstant.ERROR_NO_RESULT, false);
                }
            }
        }
        setDataTable(listUser);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        setNullValueFields();
        txtKeySearch.setText("Họ tên, username, sdt");
        txtKeySearch.setForeground(new Color(153, 153, 153));
        msgInformation.setText("");
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        listUser = userDAO.findAll();
        setDataTable(listUser);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtKeySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKeySearchFocusGained
        if (txtKeySearch.getText().equals("Họ tên, username, sdt")) {
            txtKeySearch.setText("");
            txtKeySearch.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtKeySearchFocusGained

    private void txtKeySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKeySearchFocusLost
        if (txtKeySearch.getText().equals("")) {
            txtKeySearch.setText("Họ tên, username, sdt");
            txtKeySearch.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtKeySearchFocusLost

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int indexSelected = tblUser.getSelectedRow();
        if (indexSelected == -1) {
            Utils.setMessageInformation(msgInformation, SystemConstant.MSG_ERROR_CHOOSE_ROW_TABLE, false);
        } else {
            int reply = JOptionPane.showConfirmDialog(rootPane, SystemConstant.CONFIRM_DELETE);
            if (reply == 0) {
                userDAO.delete(userId);
                Utils.setMessageInformation(msgInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
                setNullValueFields();
                listUser = userDAO.findAll();
                setDataTable(listUser);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private boolean checkValidate() {
        boolean check = false;
        getValueOfFields();

        if (fullname.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập họ và tên!", false);
        } else if (!fullname.matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")) {
            Utils.setMessageInformation(msgInformation, "Vui lòng họ tên không nhập kí tự đặc biệt!", false);
        } else if (username.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập tên tài khoản!", false);
        } else if (password.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập mật khẩu!", false);
        } else if (phone.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập số điện thoại!", false);
        } else if (!phone.matches("^[0-9]{10}+$")) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập đúng định dạng số điện thoại!", isMaximum);
        } else if (!lbFemale.isSelected() && !lbMale.isSelected()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng chọn giới tính!", false);
        } else if (startDate == null) {
            Utils.setMessageInformation(msgInformation, "Vui lòng chọn ngày bắt đầu! ", false);
        } else if (endDate != null && startDate.after(endDate)) {
            Utils.setMessageInformation(msgInformation, "Vui lòng không chọn ngày nghỉ trước ngày bắt đầu làm việc!", false);
        } else {
            check = true;
        }
        return check;
    }

    private void setComboxModelLevel(List<Level> list) {
        for (Level l : list) {
            cbLevel.addItem(l.getName());
        }
    }

    private User setPropertiesForObject() {
        User u = new User();
        u.setId(userId);
        u.setFullname(fullname);
        u.setUsername(username);
        u.setPassword(Security.encrypt(password, SystemConstant.SECRET_KEY));
        u.setPhone(phone);
        for (Level l : listLevel) {
            if (l.getName().equals(levelName)) {
                u.setLevelId(l.getId());
            }
        }
        u.setAddress(address);
        u.setImage(image);
        if (lbFemale.isSelected()) {
            u.setGender(SystemConstant.GENDER_FEMALE);
        } else {
            u.setGender(SystemConstant.GENDER_MALE);
        }
        u.setBirthday(birthday);
        u.setDescript(descript);
        u.setStartDate(startDate);
        u.setEndDate(endDate);

        return u;
    }

    private void getValueOfFields() {
        fullname = txtFullname.getText();
        username = txtUsername.getText();
        password = txtPassword.getText().toString();
        phone = txtPhone.getText();
        levelName = cbLevel.getSelectedItem().toString();
        address = txtAddress.getText();
        descript = txtDescript.getText();
        birthday = txtBirthday.getDate();
        startDate = txtStartDate.getDate();
        endDate = txtEndDate.getDate();
    }

    private void setNullValueFields() {
        txtFullname.setText("");
        txtUsername.setText("");
        txtPhone.setText("");
        txtPassword.setText("");
        txtDescript.setText("");
        txtAddress.setText("");
        buttonGroupGender.clearSelection();
        txtBirthday.setDate(null);
        txtStartDate.setDate(null);
        txtEndDate.setDate(null);
        pathFileImage = "";
        image = "";
        Utils.setImage(containImg, image);

        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        if (LoginDialog.levelUser == SystemConstant.LEVEL_ADMIN) {
            btnDelete.setEnabled(false);
        }
    }

    private void saveImage() {
        if (!pathFileImage.isEmpty()) {
            File dir = new File(pathDirImage);
            if (dir.exists()) {
                Path sourceDirectory = Paths.get(pathFileImage);
                Path targetDirectory = Paths.get(pathDirImage + sourceDirectory.getFileName());
                image = pathDirImage + sourceDirectory.getFileName().toString();
                try {
                    //copy source to target using Files Class
                    Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(UserIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setDataTable(List<User> users) {
        modelUser.setRowCount(0);
        for (User u : users) {
            for (Level level : listLevel) {
                if (level.getId() == u.getLevelId()) {
                    modelUser.addRow(new Object[]{
                        u.getFullname(), u.getUsername(), level.getName(), u.getPhone(), u.isGender() == SystemConstant.GENDER_MALE ? SystemConstant.GENDER_TXT_MALE : SystemConstant.GENDER_TXT_FEMALE
                    });
                }
            }
        }
    }
    
    private void setNameLabelAndButton() {
        lbFullname.setText("full lamen lew elw");
        lbFullname.setText(Helper.getResources("fullname"));
        lbUsername.setText(Helper.getResources("username"));
        lbPassword.setText(Helper.getResources("password"));
        lbPhone.setText(Helper.getResources("phone"));
        lbAddess.setText(Helper.getResources("address"));
        lbAvartar.setText(Helper.getResources("avatar"));
        lbGender.setText(Helper.getResources("gender"));
        lbMale.setText(Helper.getResources("male"));
        lbFemale.setText(Helper.getResources("female"));
        lbLevel.setText(Helper.getResources("level"));
        lbNote.setText(Helper.getResources("note"));
        lbStartDate.setText(Helper.getResources("startDate"));
        lbEndDate.setText(Helper.getResources("endDate"));
        
        btnAdd.setText(Helper.getResources("add"));
        btnChooseImage.setText(Helper.getResources("chooseImg"));
        btnDelete.setText(Helper.getResources("delete"));
        btnRefresh.setText(Helper.getResources("refresh"));
        btnSearch.setText(Helper.getResources("search"));
        btnUpdate.setText(Helper.getResources("update"));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JComboBox cbLevel;
    private javax.swing.JLabel containImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAddess;
    private javax.swing.JLabel lbAvartar;
    private javax.swing.JLabel lbBirthday;
    private javax.swing.JLabel lbEndDate;
    private javax.swing.JRadioButton lbFemale;
    private javax.swing.JLabel lbFullname;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbLevel;
    private javax.swing.JRadioButton lbMale;
    private javax.swing.JLabel lbNote;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbStartDate;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel msgInformation;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextArea txtAddress;
    private com.toedter.calendar.JDateChooser txtBirthday;
    private javax.swing.JTextArea txtDescript;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtKeySearch;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

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
import bkap.utils.SystemConstant;
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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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

    private int userId = 0;
    private String nameImg = "";
    private String pathDirImage = "src\\bkap\\images\\users\\";

    /**
     * Creates new form UserIF
     */
    public UserIF() {
        initComponents();

        listUser = userDAO.findAll();
        listLevel = levelDAO.findAll();

        modelUser = (DefaultTableModel) tblUser.getModel();
        cbModelLevel = (DefaultComboBoxModel) cbLevel.getModel();

        setComboxModelLevel(listLevel);
        setDataTable(listUser);
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
        jLabel1 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cbLevel = new javax.swing.JComboBox();
        txtPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        containImg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        optionMale = new javax.swing.JRadioButton();
        optionFemail = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescript = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        msgInformation = new javax.swing.JLabel();
        txtBirthday = new com.toedter.calendar.JDateChooser();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Họ và tên");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Chức vụ");

        jLabel6.setText("Địa chỉ");

        txtAddress.setColumns(20);
        txtAddress.setRows(2);
        jScrollPane1.setViewportView(txtAddress);

        jLabel7.setText("Ảnh đại diện");

        btnChooseImage.setText("Chọn ảnh");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        containImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setText("Giới tính");

        buttonGroupGender.add(optionMale);
        optionMale.setText("Nam");

        buttonGroupGender.add(optionFemail);
        optionFemail.setText("Nữ");

        jLabel10.setText("Ngày sinh");

        jLabel11.setText("Mô tả");

        txtDescript.setColumns(20);
        txtDescript.setRows(5);
        jScrollPane2.setViewportView(txtDescript);

        jLabel12.setText("Ngày vào làm");

        jLabel13.setText("Ngày nghỉ");

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

        msgInformation.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N

        txtBirthday.setDateFormatString("dd-MM-yyyy");

        txtStartDate.setDateFormatString("dd-MM-yyyy");

        txtEndDate.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(optionMale)
                                                .addGap(18, 18, 18)
                                                .addComponent(optionFemail))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 24, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbLevel, 0, 210, Short.MAX_VALUE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel7))
                                            .addComponent(btnChooseImage))
                                        .addGap(68, 68, 68))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(containImg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(msgInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(containImg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseImage)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(optionMale)
                        .addComponent(optionFemail)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(msgInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd)
                                .addComponent(btnUpdate))))
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "Username", "Chức vụ", "Số điện thoại", "Giới tính"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUser);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
//        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpeg", "jpg", "png");
//
//        fileChooser.setFileFilter(imgFilter);
//        fileChooser.setMultiSelectionEnabled(false);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("choosen");
            File fileImg = fileChooser.getSelectedFile();
            String pathFileImage = fileImg.getAbsolutePath();
            System.out.println("path file img: " + pathFileImage);
            
            File dir = new File(pathDirImage);
            if (dir.exists()) {
                Path sourceDirectory = Paths.get(pathFileImage);
                Path targetDirectory = Paths.get(pathDirImage + sourceDirectory.getFileName());
                nameImg = sourceDirectory.getFileName().toString();
                System.out.println("name img : " + sourceDirectory.getFileName());
                System.out.println("name img: " + nameImg);
                try {
                    //copy source to target using Files Class
                    Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(UserIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                System.out.println("dir thon tai");
            } else {
                System.out.println("dir khong ton tai");
            }
            
            // set image
            ImageIcon imgIcon = new ImageIcon(pathFileImage);
            Image img = imgIcon.getImage();
            Image newImage = img.getScaledInstance(containImg.getWidth(), containImg.getHeight(), Image.SCALE_SMOOTH);
            imgIcon = new ImageIcon(newImage);

            containImg.setIcon(imgIcon);

        }
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String fullname = txtFullname.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText().toString();
        String phone = txtPhone.getText();
        String levelName = cbLevel.getSelectedItem().toString();
        String address = txtAddress.getText();
        String image = nameImg;
        String descript = txtDescript.getText();

        Date birthday = txtBirthday.getDate();
        Date startDate = txtStartDate.getDate();
        Date endDate = txtEndDate.getDate();
        Date currentTime = new Date();

        if (fullname.isEmpty()) {
            setMessageInformation("Vui lòng nhập họ và tên!", false);
        } else if (!fullname.matches("^[a-zA-Z\\s]+$")) {
            setMessageInformation("Vui lòng họ tên không nhập kí tự đặc biệt!", false);
        } else if (username.isEmpty()) {
            setMessageInformation("Vui lòng nhập tên tài khoản!", false);
        } else if (password.isEmpty()) {
            setMessageInformation("Vui lòng nhập mật khẩu!", false);
        } else if (phone.isEmpty()) {
            setMessageInformation("Vui lòng nhập số điện thoại!", false);
        } else if (!phone.matches("^[0-9]{10}+$")) {
            setMessageInformation("Vui lòng nhập đúng định dạng số điện thoại!", isMaximum);
        } else if (!optionFemail.isSelected() && !optionMale.isSelected()) {
            setMessageInformation("Vui lòng chọn giới tính!", false);
        } else if (startDate == null) {
            setMessageInformation("Vui lòng chọn ngày bắt đầu! ", false);
        } else if (currentTime.compareTo(startDate) > 0) {
            setMessageInformation("Vui lòng không chọn ngày trước ngày hiện tại!", false);
        } else {
            User u = new User();
            u.setFullname(fullname);
            u.setUsername(username);
            u.setPassword(password);
            u.setPhone(phone);
            for (Level l : listLevel) {
                if (l.getName().equals(levelName)) {
                    u.setLevelId(l.getId());
                }
            }
            u.setAddress(address);
            u.setImage(pathDirImage + image);
            if (optionFemail.isSelected()) {
                u.setGender(SystemConstant.GENDER_FEMALE);
            } else {
                u.setGender(SystemConstant.GENDER_MALE);
            }
            u.setBirthday(birthday);
            u.setDescript(descript);
            u.setStartDate(startDate);
            if (endDate == null) {
                u.setEndDate(null);
            } else {
                u.setEndDate(endDate);
            }

            userDAO.add(u);
            setMessageInformation(SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
            setNullValueFields();
            listUser = userDAO.findAll();
            setDataTable(listUser);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);

        int indexSelected = tblUser.getSelectedRow();

        User u = listUser.get(indexSelected);
        userId = u.getId();
        txtFullname.setText(u.getFullname());
        txtUsername.setText(u.getUsername());
        txtPassword.setText(u.getPassword());
        txtDescript.setText(u.getDescript());
        txtAddress.setText(u.getAddress());

        if (u.isGender() == SystemConstant.GENDER_FEMALE) {
            optionFemail.setSelected(true);
        } else {
            optionMale.setSelected(true);
        }

        for (Level l : listLevel) {
            if (l.getId() == u.getLevelId()) {
                cbLevel.setSelectedItem(l.getName());
            }
        }

        txtBirthday.setDate(u.getBirthday());
        txtStartDate.setDate(u.getStartDate());
        txtEndDate.setDate(u.getEndDate());

        // set image avatar
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String fullname = txtFullname.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getPassword().toString();
        String phone = txtPhone.getText();
        String levelName = cbLevel.getSelectedItem().toString();
        String address = txtAddress.getText();
        String image = "";
        String descript = txtDescript.getText();

        Date birthday = txtBirthday.getDate();
        Date startDate = txtStartDate.getDate();
        Date endDate = txtEndDate.getDate();

        User u = new User();
        u.setId(userId);
        u.setFullname(fullname);
        u.setUsername(username);
        u.setPassword(password);
        u.setPhone(phone);
        for (Level l : listLevel) {
            if (l.getName().equals(levelName)) {
                u.setLevelId(l.getId());
            }
        }
        u.setAddress(address);
        u.setImage(image);
        if (optionFemail.isSelected()) {
            u.setGender(SystemConstant.GENDER_FEMALE);
        } else {
            u.setGender(SystemConstant.GENDER_MALE);
        }
        u.setBirthday(birthday);
        u.setDescript(descript);
        u.setStartDate(startDate);
        if (endDate == null) {
            u.setEndDate(null);
        } else {
            u.setEndDate(endDate);
        }

        userDAO.edit(u);
        setMessageInformation(SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
        setNullValueFields();
        listUser = userDAO.findAll();
        setDataTable(listUser);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void setComboxModelLevel(List<Level> list) {
        for (Level l : list) {
            cbLevel.addItem(l.getName());
        }
    }

    private void setNullValueFields() {
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);

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
    }

    private void setDataTable(List<User> users) {
        modelUser.setRowCount(0);
        for (User u : users) {
            for (Level level : listLevel) {
                if (level.getId() == u.getLevelId()) {
                    modelUser.addRow(new Object[]{
                        u.getFullname(), u.getUsername(), level.getName(), u.getPhone(), u.isGender() == SystemConstant.GENDER_MALE ? "Nam" : "Nữ"
                    });
                }
            }
        }
    }

    private void setMessageInformation(String msg, Boolean status) {
        if (status == false) {
            msgInformation.setForeground(Color.RED);
            msgInformation.setText(msg);
        } else {
            msgInformation.setForeground(Color.BLUE);
            msgInformation.setText(msg);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JComboBox cbLevel;
    private javax.swing.JLabel containImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel msgInformation;
    private javax.swing.JRadioButton optionFemail;
    private javax.swing.JRadioButton optionMale;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextArea txtAddress;
    private com.toedter.calendar.JDateChooser txtBirthday;
    private javax.swing.JTextArea txtDescript;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

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
import bkap.model.Customer;
import bkap.model.Room;
import bkap.views.CheckoutJDialog;
import com.itextpdf.text.BaseColor;

import java.awt.Button;
import java.awt.CardLayout;

import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;

//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.Document;
//import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

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
    private int page = 0;

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
                Button b = new Button("P " + listItem.getRoomId() + " " + cusDao.findByPhone(checkinDao.findById(listItem.getCheckinId()).getCusPhone()).get(0).getFullname());
                pnlItem.add(b);

                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //your actions
                        switch (listItem.getStatus()) {
                            case 0:
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
                                break;
                            case 1:
                                CheckoutJDialog formCheckout = new CheckoutJDialog(null, closable, listItem.getDetailId());
                                formCheckout.setVisible(true);
                                formCheckout.validate();
                                break;
                            case 2:
                                if (page == 2) {
                                    final JPopupMenu clearMenu = new JPopupMenu("Edit");
                                    JMenuItem clearMenuItem = new JMenuItem("Đã dọn phòng");
                                    clearMenuItem.setActionCommand("Đã dọn phòng");
                                    clearMenu.add(clearMenuItem);
                                    clearMenu.show(b, b.getX(), b.getY());
                                    clearMenuItem.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent ae) {
                                            roomDao.changeStatus(listItem.getRoomId(), 0);
                                        }
                                    });
                                } else if (page == 3) {
                                    final JPopupMenu historyMenu = new JPopupMenu("Edit");
                                    JMenuItem billMenuItem = new JMenuItem("In hóa đơn");
                                    billMenuItem.setActionCommand("In hóa đơn");
                                    historyMenu.add(billMenuItem);
                                    historyMenu.show(b, b.getX(), b.getY());
                                    billMenuItem.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent ae) {
                                            try {
                                                // in hóa đơn
                                                PrintBill(listItem.getDetailId());
                                            } catch (FileNotFoundException ex) {
                                                Logger.getLogger(ListRoomDetailIF.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    });
                                }

                                break;
                            default:
                                break;
                        }
                    }
                });
            }
        }
        pnl.add(pnlItem);
        pnlItem.setVisible(true);
        pnlItem.validate();
    }

    private void PrintBill(int idCheckinDetail) throws FileNotFoundException {
        CheckinDetails checkinDetail = checkinDetailDao.findByDetailId(idCheckinDetail).get(0);
        Checkin checkin = checkinDao.findById(checkinDetail.getCheckinId());
        Customer cus = cusDao.findByPhone(checkin.getCusPhone()).get(0);

        String name = cus.getFullname();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        String stringDate = s.format(date);
        String part = "Bill//"+name + stringDate + ".pdf";

        String nameHotel = "HHotel";
        String line = "-------------------";
        String address = "";
        String phone = "";
        String title = "PHIẾU THANH TOÁN";
        String room = "P "+checkinDetail.getRoomId();
        Date startDate = checkinDetail.getStartDate();
        Date endDate = checkinDetail.getEndDate();
        long time = (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
        String menu = "Menu     SL      Thành Tiền";
        String totalRoom = "Tiền phòng 222";
        String totalSer = "Tiền menu 222";
        String totalPrice = "Tổng tiền 222";
        // gọi lại line
        String copyRight = "©Copyright Phần Mềm HHotel";

        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(part));
            document.open();
            document.add(new Paragraph(nameHotel));
            document.add(new Paragraph(line));
            document.add(new Paragraph(""));
            document.add(new Paragraph(title));
            
            
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
            //Set Column widths
            float[] columnWidths = {1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Phòng"));
            cell1.setPaddingLeft(10);
            cell1.setBorderColor(BaseColor.WHITE);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2 = new PdfPCell(new Paragraph(room));
            cell2.setPaddingLeft(10);
            cell2.setBorderColor(BaseColor.WHITE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Giờ vào"));
            cell3.setPaddingLeft(10);
            cell3.setBorderColor(BaseColor.WHITE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell4 = new PdfPCell(new Paragraph(startDate+""));
            cell4.setPaddingLeft(10);
            cell4.setBorderColor(BaseColor.WHITE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell5 = new PdfPCell(new Paragraph("Giờ ra"));
            cell5.setPaddingLeft(10);
            cell5.setBorderColor(BaseColor.WHITE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell6 = new PdfPCell(new Paragraph(endDate+""));
            cell6.setPaddingLeft(10);
            cell6.setBorderColor(BaseColor.WHITE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell7 = new PdfPCell(new Paragraph("Thời gian"));
            cell7.setPaddingLeft(10);
            cell7.setBorderColor(BaseColor.WHITE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell8 = new PdfPCell(new Paragraph(time));
            cell8.setPaddingLeft(10);
            cell8.setBorderColor(BaseColor.WHITE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            document.add(table);
            
            document.add(new Paragraph(line));
            
            PdfPTable table2 = new PdfPTable(3);
            table2.setWidthPercentage(100); //Width 100%
            table2.setSpacingBefore(10f); //Space before table
            table2.setSpacingAfter(10f); //Space after table
            //Set Column widths
            float[] columnWidths2 = {1f, 1f, 1f};
            table2.setWidths(columnWidths);

            PdfPCell cell9 = new PdfPCell(new Paragraph("MENU"));
            cell9.setPaddingLeft(10);
            cell9.setBorderColor(BaseColor.WHITE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell10 = new PdfPCell(new Paragraph("SL"));
            cell9.setPaddingLeft(10);
            cell9.setBorderColor(BaseColor.WHITE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell11 = new PdfPCell(new Paragraph("Thành tiền"));
            cell9.setPaddingLeft(10);
            cell9.setBorderColor(BaseColor.WHITE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table2.addCell(cell9);
            document.add(table2);
            document.add(new Paragraph(line));
            // for menu 
            document.add(new Paragraph(line));
            
            
            PdfPTable table3 = new PdfPTable(2);
            table3.setWidthPercentage(100); //Width 100%
            table3.setSpacingBefore(10f); //Space before table
            table3.setSpacingAfter(10f); //Space after table
            //Set Column widths
            float[] columnWidths3 = {1f, 1f};
            table3.setWidths(columnWidths);

            PdfPCell cell12 = new PdfPCell(new Paragraph("Tiền phòng"));
            cell12.setPaddingLeft(10);
            cell12.setBorderColor(BaseColor.WHITE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell13 = new PdfPCell(new Paragraph("Tiền phòng"));
            cell13.setPaddingLeft(10);
            cell13.setBorderColor(BaseColor.WHITE);
            cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table3.addCell(cell12);
            table3.addCell(cell13);
            document.add(table3);
            document.add(new Paragraph(line));
            
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        page = 0;
        setTitle("Phòng chờ");
        listCheckinDetail = checkinDetailDao.findAllByStatus(0);
        createNewPanel(listCheckinDetail);

    }//GEN-LAST:event_mnStatus0MouseClicked

    private void mnStatus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus1MouseClicked
        // TODO add your handling code here:
        page = 1;
        setTitle("Phòng đang thuê");
        listCheckinDetail = checkinDetailDao.findAllByStatus(1);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnStatus1MouseClicked

    private void mnStatus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus2MouseClicked
        // TODO add your handling code here:
        page = 2;
        setTitle("Phòng cần dọn");
        listCheckinDetail = checkinDetailDao.findAllByStatus(2);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnStatus2MouseClicked

    private void mnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnHistoryMouseClicked
        // TODO add your handling code here:
        page = 3;
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

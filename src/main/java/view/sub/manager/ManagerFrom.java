/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.manager;

import entities.Category;
import entities.Product;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import org.apache.commons.io.FilenameUtils;
import java.util.Arrays;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import util.ImageUtils;
import util.URL_Factory;

/**
 *
 * @author Admin
 */
public class ManagerFrom extends javax.swing.JFrame {

    private File selectedFile;
    private JButton selectedButton;
    private Product product;
    private final String[] EXIT_FILE = {"png", "jpg", "jpeg", "git"};
    private ProductService productService = new ProductServiceImpl();
    private QuanLyPanel parent;

    /**
     * Creates new form ManagerFrom
     */
    public ManagerFrom(QuanLyPanel parent) {
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);
        Category[] categorys = {new Category(1, "Đồ uống có ga"), new Category(2, "Trà sữa"), new Category(3, "Bánh ngọt"), new Category(4, "Nước ép"), new Category(5, "Sinh tố"), new Category(6, "Coffee")};
        ComboBoxModel<Category> categoryModel = new DefaultComboBoxModel<>(categorys);
        ccbLoaiNuoc.setModel(categoryModel);

        initEvents();
    }

    private void initEvents() {
        btUploadEvents();
        btAddEvent();
        btResetEvent();
    }

    private void btUploadEvents() {
        btUpload.setIcon(ImageUtils.loadImageIcon(URL_Factory.IMAGE_FOLDER_URL + File.separator + "UPLOAD.png", 30, 30));
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JFileChooser fc = new JFileChooser(URL_Factory.CURRENT_PROJECT_URL);
                if (fc.showDialog(null, "UPLOAD") == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fc.getSelectedFile();
                    final String ext = FilenameUtils.getExtension(selectedFile.getName());
                    System.out.println(ext);
                    if (Arrays.stream(EXIT_FILE).anyMatch(t -> t.equalsIgnoreCase(ext))) {
                        System.out.println(selectedFile.getPath());
                        lbImage.setIcon((Icon) ImageUtils.loadImageIcon(selectedFile.getPath(), 100, 120));
                    }

                }
            }

        });
    }
    
    

    private void btAddEvent() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                product = new Product();
                if (tfTeenMonAn.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Mời bạn nhập tên món ăn");
                } else if (tfGiaTien.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Mời bạn nhập gia tien");
                } else {
                    product.setName(tfTeenMonAn.getText());
                    product.setPrice(Float.parseFloat(tfGiaTien.getText()));
                    product.setCategory((Category) ccbLoaiNuoc.getSelectedItem());
                    product.setImage(selectedFile.getName());
                    boolean result = productService.insert(product);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    } else {
                       
                       JOptionPane.showMessageDialog(null, "Thêm thất bại");
                    }
                   
                }
           
                parent.addComponentToPnCenterIn();
                
            }
        });
    }

    private void btResetEvent() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfTeenMonAn.setText(null);
                tfGiaTien.setText(null);
                ccbLoaiNuoc.setSelectedIndex(0);
                lbImage.setIcon(null);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTop = new javax.swing.JPanel();
        lbProductInfo = new javax.swing.JLabel();
        pnBottom = new javax.swing.JPanel();
        btReset = new javax.swing.JButton();
        btSubmit = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfTeenMonAn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfGiaTien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        btUpload = new javax.swing.JButton();
        ccbLoaiNuoc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTop.setBackground(new java.awt.Color(255, 255, 255));
        pnTop.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 0, 5, new java.awt.Color(51, 153, 255)), javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5)));

        lbProductInfo.setBackground(new java.awt.Color(51, 153, 0));
        lbProductInfo.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        lbProductInfo.setForeground(new java.awt.Color(51, 204, 0));
        lbProductInfo.setText("THÔNG TIN MÓN ĂN");
        lbProductInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnTop.add(lbProductInfo);

        getContentPane().add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnBottom.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(51, 153, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5)));
        pnBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btReset.setBackground(new java.awt.Color(51, 153, 0));
        btReset.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btReset.setForeground(new java.awt.Color(255, 255, 255));
        btReset.setText("Reset");
        btReset.setBorderPainted(false);
        btReset.setFocusPainted(false);
        pnBottom.add(btReset);

        btSubmit.setBackground(new java.awt.Color(51, 153, 0));
        btSubmit.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btSubmit.setText("Submit");
        btSubmit.setBorderPainted(false);
        btSubmit.setFocusPainted(false);
        pnBottom.add(btSubmit);

        getContentPane().add(pnBottom, java.awt.BorderLayout.PAGE_END);

        pnCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(51, 153, 255)), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Tên món ăn");

        tfTeenMonAn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Giá tiền");

        tfGiaTien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Loại nước");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Hình ảnh");

        lbImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btUpload.setIcon(new javax.swing.ImageIcon(URL_Factory.IMAGE_FOLDER_URL+ "plus.png")); // NOI18N
        btUpload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUpload.setFocusPainted(false);

        ccbLoaiNuoc.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTeenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCenterLayout.createSequentialGroup()
                        .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccbLoaiNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTeenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ccbLoaiNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCenterLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(pnCenterLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.JComboBox<Category> ccbLoaiNuoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbProductInfo;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnTop;
    private javax.swing.JTextField tfGiaTien;
    private javax.swing.JTextField tfTeenMonAn;
    // End of variables declaration//GEN-END:variables

   
}

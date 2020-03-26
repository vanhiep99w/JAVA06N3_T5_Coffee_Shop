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
import java.util.Arrays;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import util.ImageUtils;
import util.URL_Factory;

/**
 *
 * @author Admin
 */
public final class ManagerEditFrom extends javax.swing.JFrame {

    private File selectedFile;
    private Product product;
    private final Product selectedProduct;
    private final String[] EXIT_FILE = {"png", "jpg", "jpeg", "git"};
    private final ProductService productService = new ProductServiceImpl();

    /**
     * Creates new form ManagerFrom
     *
     * @param product
     */
    public ManagerEditFrom(Product product) {
        initComponents();
        setLocationRelativeTo(null);
        setCombox();
        setManager(product);
        selectedProduct = product;
        initEvents();
    }

    public void setCombox() {
        Category[] categorys = {new Category(1, "Đồ uống có ga"), new Category(2, "Trà sữa"), new Category(3, "Bánh ngọt"), new Category(4, "Nước ép"), new Category(5, "Sinh tố"), new Category(6, "Coffee")};
        ComboBoxModel<Category> categoryModel = new DefaultComboBoxModel<>(categorys);
        ccbLoaiNuoc.setFocusable(false);
        ccbLoaiNuoc.setModel(categoryModel);
    }

    public void setManager(Product product) {
        tfTeenMonAn.setText(product.getName());
        tfGiaTien.setText(Float.toString(product.getPrice()));
        ccbLoaiNuoc.setSelectedIndex(product.getCategory().getId() - 1);
        lbImage.setIcon(ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + "\\" + product.getImage()));
    }

    private void initEvents() {
        btEditEvent();
        btResetEvent();
        btUploadEvents();

    }

    private void btUploadEvents() {
        btUpload.setIcon(ImageUtils.loadImageIcon(URL_Factory.IMAGE_FOLDER_URL + File.separator + "UPLOAD.png", 30, 30));
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JFileChooser fc = new JFileChooser("D:\\JAVA\\coffe_DT5\\JAVA06N3_T5_Coffee_Shop");
                if (fc.showDialog(null, "UPLOAD") == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fc.getSelectedFile();
                    final String ext = FilenameUtils.getExtension(selectedFile.getName());
                    if (Arrays.stream(EXIT_FILE).anyMatch(t -> t.equalsIgnoreCase(ext))) {
                        lbImage.setIcon((Icon) ImageUtils.loadImageIcon(selectedFile.getPath(), 100, 120));
                    }

                }
            }

        });
    }

    private void btEditEvent() {
        btSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedProduct.setName(tfTeenMonAn.getText());
                selectedProduct.setPrice(Float.parseFloat(tfGiaTien.getText()));
                selectedProduct.setCategory((Category) ccbLoaiNuoc.getSelectedItem());
                String changeImage = selectedProduct.getImage();
                if (selectedFile != null) {
                    changeImage = URL_Factory.IMAGE_FOLDER_URL + "\\" + selectedProduct.getImage();
                }
                selectedProduct.setImage(changeImage);

                boolean result = productService.update(selectedProduct);
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thành công");                   
                }
                QuanLyPanel.update(selectedProduct);
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
        pnBottom = new javax.swing.JPanel();
        btReset = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        pnTop = new javax.swing.JPanel();
        lbProductInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(636, 507));

        pnCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(51, 153, 255)), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Tên món ăn");

        tfTeenMonAn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Giá tiền");

        tfGiaTien.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Loại nước");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Hình ảnh");

        lbImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btUpload.setIcon(new javax.swing.ImageIcon("D:\\JAVA\\coffe_DT5\\JAVA06N3_T5_Coffee_Shop\\images\\plus.png")); // NOI18N
        btUpload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUpload.setFocusPainted(false);

        ccbLoaiNuoc.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCenterLayout.createSequentialGroup()
                        .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ccbLoaiNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTeenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addGap(30, 30, 30)
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
                            .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        pnBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnBottom.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 5, 5, 5, new java.awt.Color(51, 153, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5)));
        pnBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        btReset.setBackground(new java.awt.Color(51, 204, 0));
        btReset.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btReset.setForeground(new java.awt.Color(255, 255, 255));
        btReset.setText("Reset");
        btReset.setBorderPainted(false);
        btReset.setFocusPainted(false);
        pnBottom.add(btReset);

        btSave.setBackground(new java.awt.Color(51, 204, 0));
        btSave.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 255, 255));
        btSave.setText("Save");
        btSave.setBorderPainted(false);
        btSave.setFocusPainted(false);
        pnBottom.add(btSave);

        getContentPane().add(pnBottom, java.awt.BorderLayout.PAGE_END);

        pnTop.setBackground(new java.awt.Color(255, 255, 255));
        pnTop.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 0, 5, new java.awt.Color(51, 153, 255)), javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5)));

        lbProductInfo.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        lbProductInfo.setForeground(new java.awt.Color(51, 204, 0));
        lbProductInfo.setText("THÔNG TIN MÓN ĂN");
        lbProductInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnTop.add(lbProductInfo);

        getContentPane().add(pnTop, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ManagerEditFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerEditFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerEditFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerEditFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                new ManagerEditFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSave;
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

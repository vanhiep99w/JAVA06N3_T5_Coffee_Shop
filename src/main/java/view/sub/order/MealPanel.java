/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;

import entities.Product;
import util.ImageUtils;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import util.URL_Factory;


/**
 *
 * @author Admin
 */
public class MealPanel extends javax.swing.JPanel {

    /**
     * Creates new form MealPanel
     */
    
    private final Product product;
    
    private final ImageIcon defaultIcon = ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + "\\food.png");
    
    
    public MealPanel() {
        product = null;
        initComponents();
        setComponents();
        
        
    }
    public MealPanel(Product product){
        this.product = product;
        initComponents();
        setComponents();
        
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
        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        btMinus = new javax.swing.JButton();
        btPlus = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(326, 115));

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbIcon.setIconTextGap(0);

        lbName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setOpaque(true);

        lbPrice.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrice.setOpaque(true);

        btMinus.setBorder(null);
        btMinus.setBorderPainted(false);
        btMinus.setFocusPainted(false);
        btMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMinusActionPerformed(evt);
            }
        });

        btPlus.setBorder(null);
        btPlus.setBorderPainted(false);
        btPlus.setFocusPainted(false);
        btPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btMinus, btPlus});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbName, lbPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btMinus, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(lbPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(1, 1, 1))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btMinus, btPlus});

    }// </editor-fold>//GEN-END:initComponents

    private void btMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMinusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMinusActionPerformed

    private void btPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPlusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMinus;
    private javax.swing.JButton btPlus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPrice;
    // End of variables declaration//GEN-END:variables

    private void setComponents() {
        setIcon();
        setText();
    }

    private void setIcon() {
        setlbIcon();
        btMinus.setIcon(ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + "\\minus.png"));
        btPlus.setIcon(ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + "\\plus.png"));
    }

    private void setlbIcon() {
        if(product == null || "".equals(product.getImage())){
            lbIcon.setIcon(defaultIcon);
        }else{
            lbIcon.setIcon(ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + product.getImage() ));
        }
    }

    private void setText() {
        setlbName();
        setlbPrice();
    }

    private void setlbName() {
        if(product == null){
            lbName.setText("Product");
        }else{
            
            lbName.setText(product.getName());
        }
    }

    private void setlbPrice() {
        String defaultString = "0.000 vnđ";
        if(product == null){
            lbPrice.setText(defaultString);
        }else{
            lbPrice.setText(product.getPrice() + " vnđ");
        }
    }

    public JButton getbtPlus(){
        return btPlus;
    }
    public JButton getbtMinus(){
        return btMinus;
    }
}
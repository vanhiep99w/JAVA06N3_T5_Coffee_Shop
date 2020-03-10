/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.Employee;

import entities.Employee;
import entities.Work;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import render.comboboxbutton.work.ButtonRender;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.work.WorkService;
import service.work.WorkServiceImpl;

/**
 *
 * @author Admin
 */
public class AddDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddDialog
     */
    
    private final List<Work> works ;
    private final WorkService workService;
    private final EmployeeService employeeService;
    
    
    public AddDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        workService = new WorkServiceImpl();
        employeeService = new EmployeeServiceImpl();
        works = workService.getAll();
        
 
        initComponents();      
    }

    public AddDialog(boolean modal) {
        workService = new WorkServiceImpl();
        employeeService = new EmployeeServiceImpl();
        works = workService.getAll();
        setModal(modal);
        initComponents();
        setCombobox();
        setEvent();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnInfor = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbPhoneNumber = new javax.swing.JLabel();
        tfPhoneNumber = new javax.swing.JTextField();
        lbWork = new javax.swing.JLabel();
        cbWork1 = new javax.swing.JComboBox<>();
        btConfirm = new javax.swing.JButton();
        lbShift = new javax.swing.JLabel();
        btExit = new javax.swing.JLabel();
        cbShift3 = new javax.swing.JCheckBox();
        cbShift4 = new javax.swing.JCheckBox();
        cbShift5 = new javax.swing.JCheckBox();
        cbShift6 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        pnInfor.setBackground(new java.awt.Color(204, 255, 255));
        pnInfor.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(153, 153, 153)));

        lbName.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbName.setText("   Số ĐT    :");

        tfName.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        tfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbPhoneNumber.setText("Họ và Tên :");

        tfPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        tfPhoneNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbWork.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbWork.setText("  Vị Trí      :");

        cbWork1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        cbWork1.setFocusable(false);

        btConfirm.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        btConfirm.setForeground(new java.awt.Color(56, 180, 123));
        btConfirm.setText("Xác Nhận");
        btConfirm.setFocusPainted(false);
        btConfirm.setFocusable(false);
        btConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmActionPerformed(evt);
            }
        });

        lbShift.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbShift.setText("      Ca      :");

        btExit.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\exit.png")); // NOI18N

        cbShift3.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        cbShift3.setText("Ca1");
        cbShift3.setFocusPainted(false);
        cbShift3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\unchecked.png")); // NOI18N
        cbShift3.setOpaque(false);
        cbShift3.setSelectedIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\checked.png")); // NOI18N

        cbShift4.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        cbShift4.setText("Ca1");
        cbShift4.setFocusPainted(false);
        cbShift4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\unchecked.png")); // NOI18N
        cbShift4.setOpaque(false);
        cbShift4.setSelectedIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\checked.png")); // NOI18N

        cbShift5.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        cbShift5.setText("Ca1");
        cbShift5.setFocusPainted(false);
        cbShift5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\unchecked.png")); // NOI18N
        cbShift5.setOpaque(false);
        cbShift5.setSelectedIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\checked.png")); // NOI18N

        cbShift6.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        cbShift6.setText("Ca1");
        cbShift6.setFocusPainted(false);
        cbShift6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\unchecked.png")); // NOI18N
        cbShift6.setOpaque(false);
        cbShift6.setSelectedIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\coffe_shop\\images\\checked.png")); // NOI18N

        javax.swing.GroupLayout pnInforLayout = new javax.swing.GroupLayout(pnInfor);
        pnInfor.setLayout(pnInforLayout);
        pnInforLayout.setHorizontalGroup(
            pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInforLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lbPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lbShift, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lbWork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInforLayout.createSequentialGroup()
                        .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbWork1, 0, 656, Short.MAX_VALUE)
                            .addComponent(tfPhoneNumber)
                            .addComponent(tfName))
                        .addGap(102, 102, 102))
                    .addGroup(pnInforLayout.createSequentialGroup()
                        .addComponent(cbShift6)
                        .addGap(94, 94, 94)
                        .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInforLayout.createSequentialGroup()
                                .addComponent(cbShift3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbShift5)
                                .addGap(62, 62, 62))
                            .addGroup(pnInforLayout.createSequentialGroup()
                                .addComponent(btConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(cbShift4)
                        .addGap(94, 94, 94))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInforLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExit))
        );
        pnInforLayout.setVerticalGroup(
            pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInforLayout.createSequentialGroup()
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbWork, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbWork1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbShift, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbShift3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbShift4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbShift5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbShift6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(AddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDialog dialog = new AddDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btConfirm;
    private javax.swing.JLabel btExit;
    private javax.swing.JCheckBox cbShift3;
    private javax.swing.JCheckBox cbShift4;
    private javax.swing.JCheckBox cbShift5;
    private javax.swing.JCheckBox cbShift6;
    private javax.swing.JComboBox<String> cbWork1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhoneNumber;
    private javax.swing.JLabel lbShift;
    private javax.swing.JLabel lbWork;
    private javax.swing.JPanel pnInfor;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhoneNumber;
    // End of variables declaration//GEN-END:variables

    private void setEvent() {
        btConfirmEvent();
        btExitEvent();
        
    }
    
    private void Exit(){
        this.dispose();
    }

    private void btConfirmEvent() {
       btConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Employee newEmployee = new Employee();
                newEmployee.setName(tfName.getText());
                newEmployee.setPhone(tfPhoneNumber.getText());
                newEmployee.setWork((Work)cbWork1.getSelectedItem());
                
                boolean result = employeeService.add(newEmployee);
                if(result){
                    JOptionPane.showMessageDialog(null, "Thêm thành công.");
                    NhanVienPanel.getTableModel().addRow(new Object[]{newEmployee});
                    Exit();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Thêm thất bại.");
                }
            } 
        });
    }

    private void btExitEvent() {
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Exit();
            }  
        });
    }

    private void setCombobox() {
        DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel();
        addElementModel(comboBoxModel1);
        cbWork1.setModel(comboBoxModel1);
        cbWork1.setRenderer(new ButtonRender());
        cbWork1.setFont(new Font("Tahoma", Font.PLAIN, 26));
    }
    private void addElementModel(DefaultComboBoxModel comboBoxModel){
        works.forEach(t -> {
            comboBoxModel.addElement(t);
        });
    }
}

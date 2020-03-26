/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;


import entities.Bill;
import entities.BillToPrint;
import entities.Order;
import entities.Product_Order;
import entities.Table;
import entities.TableStatus;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.ProductOrderTableModel;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import service.bill.BillService;
import service.bill.BillServiceImpl;
import service.product_order.ProductOrderService;
import service.product_order.ProductOrderServiceImpl;
import service.table.TableService;
import service.table.TableServiceImpl;
import util.ImageUtils;
import util.URL_Factory;

/**
 *
 * @author Admin
 */
public class DatMonPanel extends javax.swing.JPanel {

    TablePanel tablePanel = new TablePanel();
    InformationPanel informationPanel = new InformationPanel();
    ProductOrderTableModel productOrderTableModel;
    AddMealDialog addMealDialog;
    private final BillService billService;
    TableButton[] buttonTables;
    JTable tableOrdered;
    JLabel labelTableName, labelOrderStatus, labelSum;
    JButton btnPay;
    String nameTable;
    private TableButton selectedButton;
    private static final TableService tableService;
    private static final ProductOrderService productOrderService;
    static{
        tableService = new TableServiceImpl();
        productOrderService = new ProductOrderServiceImpl();
    }
    
    final String imageDirURL = URL_Factory.IMAGE_FOLDER_URL;
    private final Locale localeVN = new Locale("vi", "VN");
    private final NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    private XWPFDocument document = new XWPFDocument();
    private List<BillToPrint> listBill = new ArrayList<>();

    /**
     * Creates new form DatMonPanel
     */
    public DatMonPanel() {
       
        billService = new BillServiceImpl();

        initComponents();
        setPnLeft();
        setPnRight();
        initEvents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        pnLeft = new javax.swing.JPanel();
        pnRight = new javax.swing.JPanel();

        setLayout(new javax.swing.OverlayLayout(this));

        jSplitPane1.setDividerLocation(700);

        pnLeft.setLayout(new javax.swing.OverlayLayout(pnLeft));
        jSplitPane1.setLeftComponent(pnLeft);

        pnRight.setLayout(new javax.swing.OverlayLayout(pnRight));
        jSplitPane1.setRightComponent(pnRight);

        add(jSplitPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnRight;
    // End of variables declaration//GEN-END:variables

    private void setPnLeft() {
        pnLeft.add(tablePanel);
        
    }

    private void setPnRight() {
        pnRight.add(informationPanel);
    }

    private void initEvents() {
        initEventTableOfTablePanel();
        btAddEvent();
        btPayEvent();

    }

    private void initEventTableOfTablePanel() {
        buttonTables = tablePanel.getTables();
        tableOrdered = informationPanel.getTableFromInformationPanel();
        labelTableName = informationPanel.getLabelFromInformationPanel();
        labelOrderStatus = informationPanel.getOrderStatusLabelFromInformationPanel();
        labelSum = informationPanel.getSumLabelFromInformationPanel();
        btnPay = informationPanel.getbtPay();
        for (TableButton btTable : buttonTables) {
            btTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btTable.setColorEnter();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btTable.setColor();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    nameTable = btTable.getText().trim();
                    selectedButton = btTable;
                    Table selectedTable = selectedButton.getTable();
                    Integer idStatus = selectedTable.getStatus().getId();
                    if (idStatus == TableStatus.EMPTY) {
                        Order order = new Order();
                        order.setId_Order(0);
                        order.setTable(selectedTable);
                        new AddMealDialog(DatMonPanel.this, true, order).setVisible(true);
                        //labelOrderStatus.setIcon(ImageUtils.loadImageIcon(imageDirURL + "\\table_empty.png", 60, 60));
                        btnPay.setEnabled(false);
                    }
                    if (idStatus == TableStatus.ORDERED) {
                        Order order = new Order();
                        order.setId_Order(0);
                        order.setTable(selectedTable);
                        new AddMealDialog(DatMonPanel.this, true, order).setVisible(true);
                        //labelOrderStatus.setIcon(ImageUtils.loadImageIcon(imageDirURL + "\\table_order.png", 60, 60));
                        btnPay.setEnabled(false);
                    }
                    if (idStatus == TableStatus.FULL) {
                        informationPanel.getbtAdd().setEnabled(true);
                        informationPanel.getbtPay().setEnabled(true);
                        Integer idOrder = Integer.parseInt(selectedButton.getActionCommand());
                        productOrderTableModel = new ProductOrderTableModel(tableOrdered, idOrder);
                        productOrderTableModel.loadDataTable();
                        productOrderTableModel.cssForTable();
                        labelOrderStatus.setIcon(ImageUtils.loadImageIcon(imageDirURL + "\\table_full.png", 60, 60));
                        labelSum.setText(currencyVN.format(sumOfBill(productOrderService.getSum(idOrder)) * 110 / 100));
                        btnPay.setEnabled(true);
                        labelTableName.setText("Bàn " + nameTable);
                    }
                }

            });
        }
    }

    private void btAddEvent() {
        final JButton btAdd = informationPanel.getbtAdd();
        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (btAdd.isEnabled()) {
                    Integer idOrder = Integer.parseInt(selectedButton.getActionCommand());
                    Order order = new Order();
                    order.setId_Order(idOrder);
                    order.setTable(selectedButton.getTable());
                    new AddMealDialog(DatMonPanel.this, true, order).setVisible(true);
                }

            }

        });
    }

    private void btPayEvent() {
        btnPay = informationPanel.getbtPay();
        btnPay.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Integer idOrder = Integer.parseInt(selectedButton.getActionCommand());

                //insert bill to db
                Bill bill = new Bill(LocalDateTime.now(), 0.1f, sumOfBill(productOrderService.getSum(idOrder)) * 110 / 100, idOrder);
                billService.add(bill);

                //reset table
                selectedButton.setActionCommand("");
                Table selectedTable = selectedButton.getTable();
                selectedTable.setStatus(new TableStatus(1, selectedTable.getName()));

                //print bill
                listBill = billService.getBillToPrint(idOrder);
                tableService.update(selectedTable);
                try {
                    writeBill(listBill, idOrder);
                } catch (IOException ex) {
                    Logger.getLogger(DatMonPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

                productOrderService.deleteOrder(idOrder);

                //update layout
                selectedButton.setColor();
                labelTableName.setText("Bàn " + nameTable);
                labelOrderStatus.setIcon(ImageUtils.loadImageIcon(imageDirURL + "\\table_empty.png", 60, 60));
                labelSum.setText("");
                productOrderTableModel = new ProductOrderTableModel(tableOrdered, 0);
                productOrderTableModel.loadDataTable();
                productOrderTableModel.cssForTable();
            }
        });
    }

    public TableButton getSelectedButton() {
        return selectedButton;
    }

    public void updateLayout(Order newOrder) {
        int idOrder = newOrder.getId_Order();
        if (idOrder != 0) {
            List<Product_Order> product_Orders = productOrderService.getAll(idOrder);
            productOrderTableModel = new ProductOrderTableModel(tableOrdered, idOrder);
            productOrderTableModel.setDataModel(product_Orders);
            productOrderTableModel.loadDataTable();
            productOrderTableModel.cssForTable();
            labelTableName.setText("Bàn " + nameTable);
            labelOrderStatus.setIcon(ImageUtils.loadImageIcon(imageDirURL + "\\table_full.png", 60, 60));
            labelSum.setText(currencyVN.format(sumOfBill(productOrderService.getSum(idOrder)) * 110 / 100));
            selectedButton.setActionCommand(idOrder + "");
        }
        selectedButton.getTable().setStatus(newOrder.getTable().getStatus());
        selectedButton.setColor();
    }

    private float sumOfBill(List<Float> l) {
        float sum = 0;
        for (float item : l) {
            sum += item;
        }
        return sum;
    }

    private void writeBill(List<BillToPrint> l, Integer id_Order) throws IOException {
        //System.out.println(l.size());
        
        List<Float> listSum = new ArrayList<>();

// Create new Paragraph
        runParagraph(ParagraphAlignment.CENTER, "CAFE BKIT", 30, true, false);

        runParagraph(ParagraphAlignment.LEFT, "Nguyễn Đình Trọng - Liên Chiểu - TP Đà Nẵng", 10, false, false);

        XWPFTable table = document.createTable();
        
        
        table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));

        XWPFTableRow tableRowOne = table.getRow(0);
 
        tableRowOne.getCell(0).setText("Món");
        tableRowOne.addNewTableCell().setText("Số lượng");
        tableRowOne.addNewTableCell().setText("Thành tiền");

        for (BillToPrint item : l) {
            //System.out.println(item);
            listSum.add(item.getSum());
            XWPFTableRow tableRow = table.createRow();
            tableRow.getCell(0).setText(item.getNameProduct());
            tableRow.getCell(1).setText(item.getAmountProduct().toString());
            tableRow.getCell(2).setText(currencyVN.format(item.getSum()));
        }

        runParagraph(ParagraphAlignment.LEFT, "VAT : 10%", 10, false, true);

        runParagraph(ParagraphAlignment.LEFT, "TỔNG: " + currencyVN.format(sumOfBill(listSum) * 110 / 100), 15, true, true);

        runParagraph(ParagraphAlignment.CENTER, "wifi : 123mrquyendeptrai", 10, false, true);

        runParagraph(ParagraphAlignment.CENTER, "\nXIN CẢM ƠN QUÝ KHÁCH ", 12, true, true);

        // Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("bill\\" + id_Order + "_bill.docx"));
        document.write(out);
        out.close();
        //document.close();
        System.out.println("successully");
    }

    private void runParagraph(ParagraphAlignment paragraphAlignment, String text, int size, boolean bold, boolean italic) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        paragraph.setAlignment(paragraphAlignment);
        run.setFontSize(size);
        run.setBold(bold);
        run.setItalic(italic);
    }

}

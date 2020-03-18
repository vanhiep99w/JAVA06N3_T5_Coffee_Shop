/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.product_order;

import dao.bill.BillDao;
import dao.bill.BillDaoImpl;
import entities.BillToPrint;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import service.bill.BillService;
import service.bill.BillServiceImpl;

/**
 *
 * @author PC
 */
public class Test2 {

    private static XWPFDocument document = new XWPFDocument();
    private static final Locale localeVN = new Locale("vi", "VN");
    private static NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

    public static void main(String[] args) throws IOException {
        BillService billService = new BillServiceImpl();
        List<BillToPrint> list = new ArrayList<>();
        list = billService.getBillToPrint(31);
        writeBill(list, 31);
    }

    private static void writeBill(List<BillToPrint> l, int id_Order) throws IOException {
        System.out.println(l.size());
        List<Float> listSum = new ArrayList<>();

        // Create new Paragraph
        runParagraph(ParagraphAlignment.CENTER, "CAFE BKIT", 30, true, false);

        XWPFTable table = document.createTable();
        table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));

        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Món");
        tableRowOne.addNewTableCell().setText("Số lượng");
        tableRowOne.addNewTableCell().setText("Thành tiền");

        for (BillToPrint item : l) {
            System.out.println(item);
            listSum.add(item.getSum());
            XWPFTableRow tableRow = table.createRow();
            tableRow.getCell(0).setText(item.getNameProduct());
            tableRow.getCell(1).setText(item.getAmountProduct().toString());
            tableRow.getCell(2).setText(currencyVN.format(item.getSum()));
        }

        runParagraph(ParagraphAlignment.LEFT, "VAT : 10%", 10, false, true);

        runParagraph(ParagraphAlignment.LEFT, "TỔNG " + currencyVN.format(sumOfBill(listSum) * 110 / 100), 15, true, true);

        runParagraph(ParagraphAlignment.CENTER, "\nXIN CẢM ƠN QUÝ KHÁCH ", 10, true, true);

        // Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("bill\\" + id_Order + "_bill.docx"));
        document.write(out);
        out.close();
        document.close();
        System.out.println("successully");
    }

    private static void runParagraph(ParagraphAlignment paragraphAlignment, String text, int size, boolean bold, boolean italic) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        paragraph.setAlignment(paragraphAlignment);
        run.setFontSize(size);
        run.setBold(bold);
        run.setItalic(italic);
    }

    private static float sumOfBill(List<Float> l) {
        float sum = 0;
        for (float item : l) {
            sum += item;
        }
        return sum;
    }
}

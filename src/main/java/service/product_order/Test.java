/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.product_order;

import dao.bill.BillDao;
import dao.bill.BillDaoImpl;
import entities.BillToPrint;
import entities.ProductOrder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Test {

    public static void main(String[] args) {
        BillDao billDao = new BillDaoImpl();
        List<BillToPrint> list = new ArrayList<>();
        list = billDao.getBillToPrint(23);
        write(list, 23);
        
    }
    
    private static void write(List<BillToPrint> l, int id_Order){
        String pathname = "bill\\"+id_Order+".txt";
		File file = new File(pathname);
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
                        
                        bw.write("\t\tCAFE BKIT\n");
                        bw.newLine();
                        bw.write(String.format("%-30s%-20s%-10s\n","Mon"," So luong","Thanh tien"));
                        for(int i=0;i<60;i++){
                            bw.write("-");
                        }
                        bw.newLine();
                        for(BillToPrint item:l){
                            String nameProduc = item.getNameProduct();
                            String amount = item.getAmountProduct().toString();
                            String sum = item.getSum().toString();
                            bw.write(String.format("%-30s%-20s%-10s\n",nameProduc,amount,sum));
                        }
                        

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // save and close
		}
    }
}

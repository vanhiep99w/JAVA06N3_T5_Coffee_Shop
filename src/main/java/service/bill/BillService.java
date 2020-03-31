/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.bill;

import entities.Bill;
import entities.BillToPrint;
import java.util.List;

/**
 *
 * @author PC
 */
public interface BillService {

    public boolean add(Bill bill);

    public List<BillToPrint> getBillToPrint(int id_Order);

    public Float getSumOfDay(String day);
}

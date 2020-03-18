/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bill;

import entities.Bill;
import entities.BillToPrint;
import java.util.List;

/**
 *
 * @author PC
 */
public interface BillDao {

    public boolean add(Bill bill);

    public List<BillToPrint> getBillToPrint(int id_Order);
}

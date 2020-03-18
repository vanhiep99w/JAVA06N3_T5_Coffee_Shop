/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.bill;

import dao.bill.BillDao;
import dao.bill.BillDaoImpl;
import entities.Bill;
import entities.BillToPrint;
import java.util.List;

/**
 *
 * @author PC
 */
public class BillServiceImpl implements BillService {

    private final BillDao billDao;

    public BillServiceImpl() {
        billDao = new BillDaoImpl();
    }

    @Override
    public boolean add(Bill bill) {
       return billDao.add(bill);
    }

    @Override
    public List<BillToPrint> getBillToPrint(int id_Order) {
        return billDao.getBillToPrint(id_Order);
    }

}

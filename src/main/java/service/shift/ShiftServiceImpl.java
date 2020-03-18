/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.shift;

import dao.shift.ShiftDao;
import dao.shift.ShiftDaoImpl;
import entities.Shift;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ShiftServiceImpl implements ShiftService{
    
    private final ShiftDao ShiftDao;

    public ShiftServiceImpl() {
        this.ShiftDao = new ShiftDaoImpl();
    }

    @Override
    public List<Shift> getAll() {
        return ShiftDao.getAll();
    }

    @Override
    public List<Shift> getAll(Integer idEmployee) {
        return ShiftDao.getAll(idEmployee);
    }
    
}

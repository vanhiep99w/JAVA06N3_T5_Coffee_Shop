/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.work;

import dao.work.WorkDao;
import dao.work.WorkDaoImpl;
import entities.Work;
import java.util.List;

/**
 *
 * @author Admin
 */
public class WorkServiceImpl implements WorkService{
    
    private final WorkDao workDao;
    
    public WorkServiceImpl() {
        workDao = new WorkDaoImpl();
    }
    
    public List<Work> getAll(){
        return workDao.getAll();
    }
}

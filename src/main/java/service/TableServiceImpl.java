/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TableDao;
import dao.TableDaoImpl;
import java.util.List;
import util.Table;

/**
 *
 * @author PC
 */
public class TableServiceImpl implements TableService{
    private TableDao tableDao;
    
    public TableServiceImpl(){
        tableDao = new TableDaoImpl();
    }

    public List<Table> getAllTable() {
        return tableDao.getAllTable();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.TableDao;
import dao.TableDaoImpl;

/**
 *
 * @author PC
 */
public class Test {
    public static void main(String[] args) {
        TableDao tableDao = new TableDaoImpl();
        tableDao.getAllTable();
    }
}

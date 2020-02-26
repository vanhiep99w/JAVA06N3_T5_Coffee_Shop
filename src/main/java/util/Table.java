/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author PC
 */
public class Table {
    private int idTable;
    private String nameTable;
    private String statusTable;
    
    public Table(){
    }

    public Table(int idTable, String nameTable, String statusTable) {
        this.idTable = idTable;
        this.nameTable = nameTable;
        this.statusTable = statusTable;
    }

    public int getIdTable() {
        return idTable;
    }

    public String getNameTable() {
        return nameTable;
    }

    public String getStatusTable() {
        return statusTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public void setStatusTable(String statusTable) {
        this.statusTable = statusTable;
    }

    @Override
    public String toString() {
        return "Table{" + "idTable=" + idTable + ", nameTable=" + nameTable + ", statusTable=" + statusTable + '}';
    }
    
}

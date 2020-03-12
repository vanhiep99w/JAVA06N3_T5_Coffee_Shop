package dao.table;

import java.util.List;

import entities.Table;

public interface TableDao {

    public List<Table> getAll();
    
    public Table getOne(String name_Table);
}

package dao.table;

import java.util.List;

import entities.Table;

public interface TableDao {

    public List<Table> getAll();
    
    public List<Table> getSearch(String name_Table);
    
    public Table getOne(String name_Table);
    
    public boolean update(Table table);
}

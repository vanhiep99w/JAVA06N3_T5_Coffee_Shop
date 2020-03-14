package service.table;

import java.util.List;

import entities.Table;

public interface TableService {

    public List<Table> getAll();

    public Table getOne(String name_Table);
    
    public boolean update(Table table);
}

package service.table;

import java.util.List;

import dao.table.TableDao;
import dao.table.TableDaoImpl;
import entities.Table;

public class TableServiceImpl implements TableService {

    private final TableDao tableDao;

    public TableServiceImpl() {
        tableDao = new TableDaoImpl();
    }

    @Override
    public List<Table> getAll() {
        return tableDao.getAll();
    }

    @Override
    public Table getOne(String name_Table) {
        return tableDao.getOne(name_Table);
    }

    @Override
    public boolean update(Table table) {
        return tableDao.update(table);
    }

}

package service.table;

import java.util.List;

import dao.table.TableDao;
import dao.table.TableDaoImpl;
import entities.Table;

public class TableServiceImpl implements TableService{
	
	private final TableDao tableDao;

	public TableServiceImpl() {
		tableDao = new TableDaoImpl();
	}
	public List<Table> getAll() {
		return tableDao.getAll();
	}

}

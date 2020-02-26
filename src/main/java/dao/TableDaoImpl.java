package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import entities.Category;
import entities.Product;
import entities.Table;
import entities.TableStatus;

public class TableDaoImpl implements TableDao {

	private final Connection connection;
	private Statement statement;
	private PreparedStatement preStatement;
	private ResultSet resultSet;

	public TableDaoImpl() {
		connection = ConnectDB.getInstance().getConnection();
	}

	public List<Table> getAll() {

		final List<Table> tables = new ArrayList<Table>();
		String query = "SELECT t.*,s.status FROM coffee_shop.table t \r\n" + 
				"left join coffee_shop.table_status s \r\n" + 
				"on t.id_table_status = s.id_table_status;";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Integer id_table = resultSet.getInt("id_table");
				String name_table = resultSet.getString("name_table");
				Integer id_table_status = resultSet.getInt("id_table_status");
				String status = resultSet.getString("status");

				TableStatus tableStatus = new TableStatus(id_table_status, status);
				Table table = new Table(id_table, name_table, tableStatus);
				tables.add(table);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tables;
	}

}

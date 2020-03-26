package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import entities.Table;
import entities.TableStatus;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableDaoImpl implements TableDao {

    private final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;

    public TableDaoImpl() {
        connection = ConnectDB.getInstance().getConnection();
    }

    private Table setData(ResultSet resultSet) throws SQLException {
        Integer id_table = resultSet.getInt("id_table");
        String name_table = resultSet.getString("name_table");
        Integer id_table_status = resultSet.getInt("id_table_status");
        String status = resultSet.getString("status");

        TableStatus tableStatus = new TableStatus(id_table_status, status);
        Table table = new Table(id_table, name_table, tableStatus);
        return table;
    }

    public List<Table> getAll() {

        final List<Table> tables = new ArrayList<Table>();
        String query = "SELECT t.*,s.status FROM coffee_shop.table t \r\n"
                + "left join coffee_shop.table_status s \r\n"
                + "on t.id_table_status = s.id_table_status order by t.id_table ;";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Table table = setData(resultSet);
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

    @Override
    public Table getOne(String name_Table) {

        Table table = new Table();
        String query = "SELECT t.*,s.status FROM coffee_shop.table t \r\n"
                + "left join coffee_shop.table_status s \r\n"
                + "on t.id_table_status = s.id_table_status "
                + "where name_table like ? ;";

        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(1, name_Table);
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                table = setData(resultSet);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return table;

    }

    @Override
    public boolean update(Table table) {
        boolean result = false;
        String query = "UPDATE coffee_shop.table\n"
                + "SET \n"
                + "	name_table = ?,\n"
                + "    id_table_status = ?\n"
                + "WHERE\n"
                + "     id_table = ?;";

        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(1, table.getName());
            preStatement.setInt(2, table.getStatus().getId());
            preStatement.setInt(3, table.getId());
            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(TableDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TableDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public List<Table> getSearch(String name_Table) {
        final List<Table> tables = new ArrayList<Table>();
        String query = "SELECT t.*,s.status FROM coffee_shop.table t\n"
                + "left join coffee_shop.table_status s\n"
                + "on t.id_table_status = s.id_table_status where t.name_table like ? order by t.name_table;";

        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(1, "%" + name_Table + "%");
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                Table table = setData(resultSet);
                tables.add(table);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preStatement.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return tables;
    }

}

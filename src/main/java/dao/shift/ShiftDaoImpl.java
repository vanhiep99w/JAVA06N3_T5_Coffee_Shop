/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.shift;

import connection.ConnectDB;
import entities.Shift;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ShiftDaoImpl implements ShiftDao {

    private static final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;

    static {
        connection = ConnectDB.getInstance().getConnection();
    }

    private Shift setData(ResultSet resultSet) throws SQLException {
        Integer idShift = resultSet.getInt("id_shift");
        String nameShift = resultSet.getString("name_shift");
        LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
        LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
        Shift shift = new Shift(idShift, nameShift, startTime, endTime);

        return shift;
    }

    @Override
    public List<Shift> getAll() {
        final List<Shift> shifts = new ArrayList<>();
        String query = "select * from coffee_shop.shift;";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Shift shift = setData(resultSet);
                shifts.add(shift);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShiftDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return shifts;
    }

    @Override
    public List<Shift> getAll(Integer idEmployee) {
        final List<Shift> shifts = new ArrayList<>();

        String query = "select s.* from coffee_shop.shift s\n"
                + "left join coffee_shop.shift_employee e\n"
                + "on s.id_shift = e.id_shift\n"
                + "where e.id_employee = ?;";
        
        try {
            preStatement = connection.prepareCall(query);
            preStatement.setInt(1, idEmployee);
            resultSet = preStatement.executeQuery();
            while(resultSet.next()){
                Shift shift = setData(resultSet);
                shifts.add(shift);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                resultSet.close();
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShiftDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return shifts;
    }

    @Override
    public boolean setShift(int idEmployee, List<Shift> shifts) {
        return false;
    }

}

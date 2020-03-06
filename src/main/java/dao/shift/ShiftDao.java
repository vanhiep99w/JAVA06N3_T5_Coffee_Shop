/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.shift;

import entities.Shift;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ShiftDao {
    public List<Shift> getAll();
}

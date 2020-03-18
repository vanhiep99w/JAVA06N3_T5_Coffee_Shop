/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.shift;

import entities.Shift;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ShiftService {

    public List<Shift> getAll();

    public List<Shift> getAll(Integer idEmployee);
}

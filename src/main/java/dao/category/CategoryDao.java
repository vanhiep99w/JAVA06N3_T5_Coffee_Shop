/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.category;

import entities.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CategoryDao {
    
    public List<Category> getAll();
    
}

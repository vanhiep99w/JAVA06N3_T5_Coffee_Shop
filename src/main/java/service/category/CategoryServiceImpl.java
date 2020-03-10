/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.category;

import dao.category.CategoryDao;
import dao.category.CategoryDaoImpl;
import entities.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryServiceImpl implements CategoryService{
    
    private final CategoryDao categoryDao;

    public CategoryServiceImpl() {
        categoryDao = new CategoryDaoImpl();
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
    
}

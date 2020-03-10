package dao.product;

import java.util.List;

import entities.Product;

public interface ProductDao {

    public List<Product> getAll();
    
    public List<Product> getAll(Integer id_Category);

    public List<Product> getAll(String name_Product);
}

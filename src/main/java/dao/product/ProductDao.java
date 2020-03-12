package dao.product;

import java.util.List;

import entities.Product;

public interface ProductDao {

    public List<Product> getAll();
    
    public List<Product> getAll(Integer id_Category);

    public List<Product> getAll(String name_Product);
    
    public boolean insert(Product product);

    public void update(int id1, int id, String name, float price, String NameCategory);

    public boolean delete(Integer id);
}

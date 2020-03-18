package service.product;

import java.util.List;

import entities.Product;

public interface ProductService {

    public List<Product> getAll();
    
    public List<Product> getAll(Integer id_Category);

    public List<Product> getAll(String name_Product);
    
    public boolean insert(Product product);

    public boolean update(Product product);

    public boolean delete(Integer id);
}

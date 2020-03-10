package service.product;

import java.util.List;

import entities.Product;

public interface ProductService {

    public List<Product> getAll();
    
    public List<Product> getAll(Integer id_category);
    
    public List<Product> getAll(String name_Product);
}

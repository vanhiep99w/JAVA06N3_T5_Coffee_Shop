package service.product;

import java.util.List;

import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import entities.Product;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl() {
        productDao = new ProductDaoImpl();
    }

    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getAll(Integer id_category) {
        return productDao.getAll(id_category);
    }

    @Override
    public List<Product> getAll(String name_Product) {
        return productDao.getAll(name_Product);
    }
    
    @Override
    public boolean insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public void update(int id1, int id, String name, float price, String NameCategory) {

    }

    @Override
    public boolean delete(Integer id) {
        return productDao.delete(id);
    }
}

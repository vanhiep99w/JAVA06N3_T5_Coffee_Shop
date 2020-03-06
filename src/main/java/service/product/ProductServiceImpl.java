package service.product;

import java.util.List;

import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import entities.Product;

public class ProductServiceImpl {
	private final ProductDao productDao;
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	public List<Product> getAll(){
		return productDao.getAll();
	}
}

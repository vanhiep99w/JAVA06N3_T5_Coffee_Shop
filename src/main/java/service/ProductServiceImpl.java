package service;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
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

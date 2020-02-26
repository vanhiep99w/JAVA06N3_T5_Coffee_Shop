package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import entities.Category;
import entities.Product;

public class ProductDaoImpl implements ProductDao {
	
	private final Connection connection ;
	private Statement statement ;
	private PreparedStatement preStatement;
	private ResultSet resultSet ;
	
	public ProductDaoImpl() {
		connection = ConnectDB.getInstance().getConnection();
	}

	public List<Product> getAll() {
		
		final List<Product> products = new ArrayList<Product>();
		String query = "SELECT p.*,c.name_category FROM coffee_shop.product p \r\n" + 
				"left join coffee_shop.category c \r\n" + 
				"on c.id_category = p.id_category;";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Integer id_product = resultSet.getInt("id_product");
				String name_product = resultSet.getString("name_product");
				Float price = resultSet.getFloat("price");
				Integer id_category = resultSet.getInt("id_category");
				String name_category = resultSet.getString("name_category");
				 
				Category category = new Category(id_category, name_category);
				Product product = new Product(id_product, name_product, category);
				products.add(product);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}

}

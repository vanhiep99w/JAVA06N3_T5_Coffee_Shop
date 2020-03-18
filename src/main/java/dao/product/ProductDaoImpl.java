package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import dao.employee.EmployeeDaoImpl;
import entities.Category;
import entities.Employee;
import entities.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductDaoImpl implements ProductDao {

    private static final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;
    static{
        connection = ConnectDB.getInstance().getConnection();
    }

    public ProductDaoImpl() {
        
    }

    private Product setData(ResultSet resultSet) throws SQLException {
        Integer id_product = resultSet.getInt("id_product");
        String name_product = resultSet.getString("name_product");
        Float price = resultSet.getFloat("price");
        String image = resultSet.getString("image");
        Integer id_category = resultSet.getInt("id_category");
        String name_category = resultSet.getString("name_category");

        Category category = new Category(id_category, name_category);
        Product product = new Product(id_product, name_product, price, image, category);
        return product;
    }

    public List<Product> getAll() {

        final List<Product> products = new ArrayList<Product>();
        String query = "SELECT p.*,c.name_category FROM coffee_shop.product p \r\n"
                + "left join coffee_shop.category c \r\n"
                + "on c.id_category = p.id_category;";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = setData(resultSet);
                products.add(product);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return products;
    }

    public List<Product> getAll(Integer id_category) {
        final List<Product> products = new ArrayList<Product>();
        String query = "SELECT p.*,c.name_category FROM coffee_shop.product p \n"
                + "left join coffee_shop.category c  \n"
                + "on c.id_category = p.id_category where c.id_category = ?;";

        try {
            preStatement = connection.prepareCall(query);
            preStatement.setInt(1, id_category);
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                Product product = setData(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return products;

    }

    @Override
    public List<Product> getAll(String name_Product) {
        final List<Product> products = new ArrayList<Product>();
        String query = "SELECT p.*,c.name_category FROM coffee_shop.product p \n"
                + "left join coffee_shop.category c  \n"
                + "on c.id_category = p.id_category where p.name_product like ?;";

        try {
            preStatement = connection.prepareCall(query);
            preStatement.setString(1, "%" + name_Product + "%");
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                Product product = setData(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return products;
    }

    //ok chạy lại đie
    @Override
    public boolean insert(Product product) {
        String query = "INSERT INTO product (name_product, price, id_category, image) VALUES (?,?,?,?)";
        int i = 0;
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(++i, product.getName());
            preStatement.setFloat(++i, product.getPrice());
            preStatement.setInt(++i, product.getCategory().getId());
            preStatement.setString(++i, product.getImage());
            System.out.println(preStatement.toString());
            int n = preStatement.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block

            }
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        boolean result = false;
        int i = 0;
        String query = "update coffee_shop.product p \n"
                + "set p.name_product = ?,\n"
                + "p.price = ?,\n"
                + "p.id_category = ?,\n"
                + "p.image = ?\n"
                + "where p.id_product = ?;";

        if (product != null) {
            try {
                preStatement = connection.prepareStatement(query);
                preStatement.setString(++i, product.getName());
                preStatement.setFloat(++i, product.getPrice());
                preStatement.setInt(++i, product.getCategory().getId());
                preStatement.setString(++i, product.getImage());
                preStatement.setInt(++i, product.getId());

                result = (preStatement.executeUpdate() == 0) ? false : true;
                //lỗi đau e
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    preStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;

        String query = "delete from coffee_shop.product p \n"
                + "where p.id_product = ?;";
        try {
            preStatement = connection.prepareCall(query);
            preStatement.setInt(1, id);

            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

}

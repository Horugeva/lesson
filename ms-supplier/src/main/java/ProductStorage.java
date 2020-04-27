import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
    public ProductStorage() {
    }

    public List<Products> findByTittle(String tittle) throws Exception {
        List<Products> productsList = new ArrayList<>();
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                " select * from products where title=?");
        preparedStatement.setString(1, tittle);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Products products = new Products();
            products.setProdId(resultSet.getInt("prod_id"));
            products.setCategory(resultSet.getInt("category"));
            products.setTittle(resultSet.getString("title"));
            products.setActor(resultSet.getString("actor"));
            products.setPrice(resultSet.getInt("price"));
            products.setSpecial(resultSet.getInt("special"));
            products.setCommonProdId(resultSet.getInt("common_prod_id"));
            productsList.add(products);
        }
        connection.close();

        return productsList;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                " delete from products where prod_id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        connection.close();
        System.out.println("Строка удалена");
    }

    public void update(int id, String tittle) throws SQLException, ClassNotFoundException {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update products set title = ? where prod_id = ?");
        preparedStatement.setString(1, tittle);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void insert(Products products) throws SQLException, ClassNotFoundException {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO products\n" +
                        "(category, title, actor, price, special, common_prod_id)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?);\n"
        );
        preparedStatement.setInt(1, products.getCategory());
        preparedStatement.setString(2, products.getTittle());
        preparedStatement.setString(3, products.getActor());
        preparedStatement.setInt(4, products.getPrice());
        preparedStatement.setInt(5, products.getSpecial());
        preparedStatement.setInt(6, products.getCommonProdId());
        preparedStatement.executeUpdate();
        connection.close();
    }
}

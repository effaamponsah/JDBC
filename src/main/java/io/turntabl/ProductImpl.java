package io.turntabl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductDAO {
    private static final String dbUrl = "jdbc:postgresql:northwind";
    List<ProdcutTO> sales = new ArrayList<>();

    @Override
    public List<ProdcutTO> getProducstByCustomer(String customerName) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"dennis-effa","turntabl")) {
            PreparedStatement ps = db.prepareStatement("select products.product_name, order_details.unit_price from products" +
                    " inner join order_details on order_details.product_id=products.product_id " +
                    "inner join orders on orders.order_id = order_details.order_id inner join " +
                    "customers on customers.customer_id = orders.customer_id where customers.contact_name = ?");
            ps.clearParameters();
            ps.setString(1, customerName);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sales.add(new ProdcutTO(rs.getString("product_name"), rs.getDouble("unit_price")));
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        }
        return sales;
    }

    @Override
    public List<ProdcutTO> topFiveProducts() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"dennis-effa","turntabl")) {
            PreparedStatement ps = db.prepareStatement("select product_name,count(product_name)as count, " +
                    "products.unit_price from products " +
                    "inner join order_details on order_details.product_id = products.product_id group by product_name," +
                    " products.unit_price order by count desc limit 5");
            ps.clearParameters();
//            ps.setString(1, customerName);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sales.add(new ProdcutTO(rs.getString("product_name"), rs.getDouble("unit_price")));
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        }
        return sales;
    }
}

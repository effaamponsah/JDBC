package io.turntabl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesImpl implements  SalesDAO{
    private static final String dbUrl = "jdbc:postgresql:northwind";

    List<SalesTO> sales = new ArrayList<>();

    @Override
    public List<SalesTO> getWeeklysales(Date date) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"dennis-effa","turntabl")) {
            PreparedStatement ps = db.prepareStatement("select order_date as dates, customers.contact_name," +
                    "products.product_name,order_details.unit_price from orders " +
                    "inner join order_details on order_details.order_id=orders.order_id" +
                    " inner join customers on customers.customer_id = orders.customer_id inner " +
                    "join products on products.product_id=order_details.product_id where order_date " +
                    "between date( '1997-08-04' )-interval '7 day' and '1997-08-04'");
            ps.clearParameters();
//            ps.setString(1, date.toString());
//            ps.setDate(2, (java.sql.Date) date);


            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sales.add(new SalesTO(rs.getDate("dates"), rs.getString("contact_name"), rs.getString("product_name"), rs.getDouble("unit_price")));
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        }
        return sales;
    }
}

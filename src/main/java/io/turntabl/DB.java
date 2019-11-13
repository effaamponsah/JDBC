package io.turntabl;

import javax.xml.transform.Result;
import java.sql.*;

public class DB {

    private static final String dbUrl = "jdbc:postgresql:northwind";

    public static void connect() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"dennis-effa","turntabl")) {
            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select * from customers limit 3;");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.format("%5s %17s %15s %10s %15s", rs.getString("customer_id"), rs.getString("contact_name"), rs.getString("city"), rs.getString("country"), rs.getString("phone"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        } ;
    }

    public static void searchCustomersByName(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"dennis-effa","turntabl")) {
            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select * from customers where contact_name like '%"+name+"%';");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.format("%5s %17s %15s %10s %15s", rs.getString("customer_id"), rs.getString("contact_name"), rs.getString("city"), rs.getString("country"), rs.getString("phone"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        } ;
    }

    public static void searchCateByName(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"dennis-effa","turntabl")) {
            PreparedStatement ps = db.prepareStatement("select * from categories where category_name like ?;");
            ps.clearParameters();
            ps.setString(1, "%"+name+"%");

            ResultSet rs = ps.executeQuery();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%15s %15s %15s", "CAT_ID", "CAT_NAME",  "DESCRIPTION");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.format("%15s %15s %20s", rs.getInt("category_id"), rs.getString("category_name"), rs.getString("description"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        } ;
    }

    public static void searchProductByName(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"dennis-effa","turntabl")) {
            PreparedStatement ps = db.prepareStatement("select * from categories where category_name like ?;");
            ps.clearParameters();
            ps.setString(1, "%"+name+"%");

            ResultSet rs = ps.executeQuery();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%15s %15s %15s", "CAT_ID", "CAT_NAME",  "DESCRIPTION");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.format("%15s %15s %20s", rs.getInt("category_id"), rs.getString("category_name"), rs.getString("description"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        } ;
    }
    public DB() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection databasecon = DriverManager.getConnection(dbUrl, "dennis-effa", "turntabl")) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

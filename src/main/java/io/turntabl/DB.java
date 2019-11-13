package io.turntabl;

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

    public static void search(String name) throws ClassNotFoundException {
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
}

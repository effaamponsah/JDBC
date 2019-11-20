package io.turntabl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Main {
    public static void main(String[] args) {

//        ProductImpl pro = new ProductImpl();
//        SalesImpl weeklySales = new SalesImpl();
//        try {
////            gets ordered products by customer nname
////            for (ProdcutTO sales: pro.getProducstByCustomer("Thomas Hardy")){
////                System.out.printf("%10s %30s",sales.getProduct_name(), sales.getPrice());
////                System.out.println();
////            }
//
////            gets top 5 popular products
////            for (ProdcutTO products: pro.topFiveProducts()){
////                System.out.printf("%10s %30s",products.getProduct_name(), products.getPrice());
////                System.out.println();
////            }
//
////            print out the weekly sales
//            for (SalesTO sales: weeklySales.getWeeklysales(new Date(1995,05,93))){
//                System.out.printf("%10s %35s %25s %20s",sales.getCustomer_name(), sales.getProduct_name(),sales.getPrice(), sales.getOrder_date());
//                System.out.println();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        try {
//            System.out.println("Please enter the name of the search candidate: ");
////            String name = scanner.nextLine();
////            DB.searchCustomersByName(name);
//            DB.searchCateByName("Seafood");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Class not found: " + e);
//        }

        ApplicationContext appContext = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate template = (JdbcTemplate) appContext.getBean("jdbcTemplate");

        int numRows = template.queryForObject("select count(*) from customers", Integer.class);
        System.out.println("There are "+ numRows + " customers");

//        RowMapper rowMapper = BeanPropertyRowMapper.newInstance(ProdcutTO.class);

//        ProductImpl product = (ProductImpl) template.queryForObject("select contact_name, customer_id from customers where customer_id='ALFKI'",rowMapper);

//        product.
//        template.queryForObject("select contact_name from customers where contact_name= ?", new Object[]("Maria Andres"),rowMapper);

    }
}

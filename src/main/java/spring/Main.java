package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext appCOntext = new ClassPathXmlApplicationContext("config.xml");

        CustomerDAOImpl customerimpl = (CustomerDAOImpl) appCOntext.getBean("customer");
        System.out.println(customerimpl.getCustomerByName("Maria Anders"));


        ProductDAOImpl products = (ProductDAOImpl) appCOntext.getBean("products");

        System.out.println(products.topFiveProducts());
    }
}

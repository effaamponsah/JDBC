package io.turntabl;

public interface DAOFactory {
    ProductDAO getProductDAO();
    SalesDAO getSalesDAO();
    CustomerDAO getCustomerDAO();
}

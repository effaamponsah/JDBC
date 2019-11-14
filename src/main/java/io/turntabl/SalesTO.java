package io.turntabl;

import java.util.Date;

public class SalesTO {
    private Date order_date;
    private String customer_name;
    private String product_name;
    private Double price;

    public SalesTO(Date order_date, String customer_name, String product_name, Double price) {
        this.order_date = order_date;
        this.customer_name = customer_name;
        this.product_name = product_name;
        this.price = price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

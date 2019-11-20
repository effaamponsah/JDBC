package spring;

public class ProductTO {
    String product_name;
    Double price;

    public ProductTO() {
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

    @Override
    public String toString() {
        return "ProductTO{" +
                "product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}

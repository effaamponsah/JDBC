package spring;

public class CustomerTO {
    private String contact_name;
    private String customer_id;

    public CustomerTO() {
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "CustomerTO{" +
                "contact_name='" + contact_name + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}

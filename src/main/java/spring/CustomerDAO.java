package spring;

import java.util.List;

public interface CustomerDAO {
  CustomerTO getCustomerByName(String customerName);
}

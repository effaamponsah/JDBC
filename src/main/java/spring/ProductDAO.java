package spring;

import java.util.List;

public interface ProductDAO {
    List<ProductTO> getProducstByCustomer(String customer);

    List<ProductTO> topFiveProducts();
}


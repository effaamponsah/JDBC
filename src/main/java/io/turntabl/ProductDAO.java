package io.turntabl;

import java.util.List;

public interface ProductDAO {
    List<ProdcutTO> getProducstByCustomer(String customer) throws ClassNotFoundException;

    List<ProdcutTO> topFiveProducts() throws ClassNotFoundException;
}

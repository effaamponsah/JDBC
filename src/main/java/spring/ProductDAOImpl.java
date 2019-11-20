package spring;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<ProductTO> getProducstByCustomer(String customer){
        RowMapper rows = BeanPropertyRowMapper.newInstance(ProductTO.class);
        return this.template.query("select product_name, count(product_name) as count, products.unit_price as price from products inner join order_details on order_details.product_id = products.product_id group by product_name, products.unit_price order by count desc limit 5",rows);
    }

    @Override
    public List<ProductTO> topFiveProducts(){
        RowMapper rows = BeanPropertyRowMapper.newInstance(ProductTO.class);
        return this.template.query("select product_name, count(product_name) as count, products.unit_price as price from products inner join order_details on order_details.product_id = products.product_id group by product_name, products.unit_price order by count desc limit 5",rows);

    }
}

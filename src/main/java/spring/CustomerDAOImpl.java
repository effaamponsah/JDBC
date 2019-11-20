package spring;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDAOImpl implements CustomerDAO {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomerTO getCustomerByName(String customerName) {
        RowMapper row = BeanPropertyRowMapper.newInstance(CustomerTO.class);
        return (CustomerTO) this.jdbcTemplate.queryForObject("select contact_name, customer_id from customers where customer_id = ?", new Object[]{customerName}, row);
    }
}

package gb.lesson5.repositories;

import gb.lesson5.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Named
@ApplicationScoped
public class ProductRepository {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ServletContext context;

    private Connection conn;

    @Inject
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void init() throws SQLException {
        conn = (Connection) context.getAttribute("jdbcConnection");
        createTableIfNotExists(conn);
        fillInitialTable();
    }

    public void insert(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into products(category_id, title, description, price) values (?, ?, ?, ?);")) {
            stmt.setInt(1, product.getCategoryId());
            stmt.setString(2, product.getTitle());
            stmt.setString(3, product.getDescription());
            stmt.setBigDecimal(4, product.getPrice());
            stmt.execute();
        }
    }

    public void update(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update products set category_id = ?, title = ?, description = ?, price = ? where id = ?;")) {
            stmt.setInt(1, product.getCategoryId());
            stmt.setString(2, product.getTitle());
            stmt.setString(3, product.getDescription());
            stmt.setBigDecimal(4, product.getPrice());
            stmt.setInt(5, product.getId());
            stmt.execute();
        }
    }

    public void delete(Integer id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from products where id = ?;")) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    public Optional<Product> findById(Integer id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, category_id, title, description, price from products where id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getBigDecimal(5)));
            }
        }
        return Optional.empty();
    }

    public List<Product> findAll() throws SQLException {
        List<Product> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, category_id, title, description, price from products");

            while (rs.next()) {
                res.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getBigDecimal(5)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists products (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    category_id int,\n" +
                    "    title varchar(255),\n" +
                    "    description text,\n" +
                    "    price decimal(19,2) \n" +
                    ");");
        }
    }

    private void fillInitialTable() throws SQLException {
        Random random = new Random();
        int categoryQuantity = categoryRepository.findAll().size();
        if(categoryQuantity <= 0) {
            log.info("***** Categories is Empty!");
            return;
        }
        if (findAll().size() == 0) {
            for (int i = 1; i < 10; i++) {
                int categoryId = random.nextInt(categoryQuantity) + 1;
                insert(new Product(-1, categoryId, "Product" + i,
                        "Product" + i + " description", BigDecimal.valueOf(11.11 * i)));
            }

        }
    }
}

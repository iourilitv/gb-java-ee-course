package gb.lesson5.repositories;

import gb.lesson5.entities.Category;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
public class CategoryRepository {

    @Inject
    private ServletContext context;

    private Connection conn;

    @PostConstruct
    public void init() throws SQLException {
        conn = (Connection) context.getAttribute("jdbcConnection");
        createTableIfNotExists(conn);
        fillInitialTable();
    }

    public void insert(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into categories(title, description) values (?, ?);")) {
            stmt.setString(1, category.getTitle());
            stmt.setString(2, category.getDescription());
            stmt.execute();
        }
    }

    public void update(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update categories set title = ?, description = ? where id = ?;")) {
            stmt.setString(1, category.getTitle());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getId());
            stmt.execute();
        }
    }

    public void delete(Integer id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from categories where id = ?;")) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    public Optional<Category> findById(Integer id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, title, description from categories where id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Category(rs.getInt(1), rs.getString(2),
                        rs.getString(3)));
            }
        }
        return Optional.empty();
    }

    public List<Category> findAll() throws SQLException {
        List<Category> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, title, description from categories");

            while (rs.next()) {
                res.add(new Category(rs.getInt(1), rs.getString(2),
                        rs.getString(3)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists categories (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    title varchar(255),\n" +
                    "    description text\n" +
                    ");");
        }
    }

    private void fillInitialTable() throws SQLException {
        if(findAll().isEmpty()) {
            for (int i = 1; i <= 5; i++) {
                insert(new Category("Category" + i, "Category" + i + " description"));
            }
        }
    }
}

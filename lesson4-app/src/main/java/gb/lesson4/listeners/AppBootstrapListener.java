package gb.lesson4.listeners;

import gb.lesson4.entities.Product;
import gb.lesson4.repositories.ProductRepository;
import gb.lesson4.utils.Attributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppBootstrapListener implements ServletContextListener {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Initializing application");

        ServletContext sc = sce.getServletContext();
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcConnectionString, username, password);
            sc.setAttribute("jdbcConnection", connection);

            ProductRepository productRepository = new ProductRepository(connection);
            sc.setAttribute(Attributes.productRepository.name(), productRepository);

            if (productRepository.findAll().size() == 0) {
                for (int i = 1; i < 10; i++) {
                    productRepository.insert(new Product(-1, "Product" + i, "Product" + i + " description", BigDecimal.valueOf(11.11 * i)));
                }

            }
        } catch (SQLException ex) {
            log.error("Can't initialize JDBC connection", ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Closing JDBC connection");

        ServletContext sc = sce.getServletContext();
        Connection connection = (Connection) sc.getAttribute("jdbcConnection");

        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException ex) {
            log.error("Can't close JDBC connection", ex);
        }
    }
}

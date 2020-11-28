package gb.lesson5.repositories;

import gb.lesson5.entities.Category;
import gb.lesson5.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public void insert(Product product) {
        em.persist(product);
    }

    public void update(Product product) {
        em.merge(product);
    }

    public void delete(Integer id) {
        Product product = em.find(Product.class, id);
        if(product != null) {
            em.remove(product);
        }
    }

    public Optional<Product> findById(Integer id) {
        return Optional.of(em.find(Product.class, id));
    }

    public List<Product> findAll() {
        return em.createQuery("select * from Product p", Product.class).getResultList();
    }

}

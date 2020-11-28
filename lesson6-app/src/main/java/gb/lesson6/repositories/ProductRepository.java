package gb.lesson6.repositories;

import gb.lesson6.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

}

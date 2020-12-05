package gb.lesson6.repositories;

import gb.lesson6.entities.Product;
import gb.lesson6.repositories.interfaces.IProductRepository;
import gb.lesson6.reprentities.ProductRepr;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductRepository implements IProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public void insert(Product product) {
        em.persist(product);
    }

    @Override
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public void delete(Integer id) {
        Product product = em.find(Product.class, id);
        if(product != null) {
            em.remove(product);
        }
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.of(em.find(Product.class, id));
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public List<ProductRepr> findAllProductRepr() {
        return em.createQuery("select new gb.lesson6.reprentities.ProductRepr(p.id, c, p.title, p.description, p.price) " +
                "from Product p " +
                " left join p.category c ", ProductRepr.class)
                .getResultList();
    }

    @Override
    public ProductRepr findAllProductReprById(Integer id) {
        return em.createQuery("select new gb.lesson6.reprentities.ProductRepr(p.id, c, p.title, p.description, p.price) " +
                "from Product p " +
                " left join p.category c where p.id = :id", ProductRepr.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
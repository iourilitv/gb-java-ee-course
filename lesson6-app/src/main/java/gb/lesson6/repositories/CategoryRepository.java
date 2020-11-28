package gb.lesson6.repositories;

import gb.lesson6.entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
public class CategoryRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Transactional
    public void insert(Category category) {
        em.persist(category);
    }

    @Transactional
    public void update(Category category) {
        em.merge(category);
    }

    public void delete(Integer id) {
        Category category = em.find(Category.class, id);
        if(category != null) {
            em.remove(category);
        }
    }

    public Optional<Category> findById(Integer id) {
        return Optional.of(em.find(Category.class, id));
    }

    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

}

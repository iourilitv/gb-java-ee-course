package gb.lesson6.repositories;

import gb.lesson6.entities.Category;
import gb.lesson6.repositories.interfaces.ICategoryRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Stateless
public class CategoryRepository implements ICategoryRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    @Transactional
    public void insert(Category category) {
        em.persist(category);
    }

    @Override
    @Transactional
    public void update(Category category) {
        em.merge(category);
    }

    @Override
    public void delete(Integer id) {
        Category category = em.find(Category.class, id);
        if(category != null) {
            em.remove(category);
        }
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.of(em.find(Category.class, id));
    }

    @Override
    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

}

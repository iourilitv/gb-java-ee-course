package gb.lesson6.repositories.interfaces;

import gb.lesson6.entities.Category;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Local
public interface ICategoryRepository extends Serializable {

    void insert(Category category);

    void update(Category category);

    void delete(Integer id);

    Optional<Category> findById(Integer id);

    List<Category> findAll();

}

package gb.lesson7.repositories.interfaces;

import gb.lesson7.entities.Product;
import gb.lesson7.reprentities.ProductRepr;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Local
public interface IProductRepository extends Serializable {

    void insert(Product product);

    void update(Product product);

    void delete(Integer id);

    Optional<Product> findById(Integer id);

    List<Product> findAll();

    List<ProductRepr> findAllProductRepr();

    ProductRepr findAllProductReprById(Integer id);

}
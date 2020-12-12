package gb.lesson8.services.interfaces;

import gb.lesson8.entities.Product;
import gb.lesson8.reprentities.ProductRepr;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Local
public interface IProductService extends Serializable {

    void insert(ProductRepr productRepr);

    void update(ProductRepr productRepr);

    void delete(Integer id);

//    Optional<Product> findById(Integer id);

    List<Product> findAll();

    List<ProductRepr> findAllProductRepr();

    IProductServiceWs getProductServicePort();

}

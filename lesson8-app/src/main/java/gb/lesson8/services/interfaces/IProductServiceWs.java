package gb.lesson8.services.interfaces;

import gb.lesson8.reprentities.ProductRepr;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public interface IProductServiceWs {

    @WebMethod
    void insert(ProductRepr productRepr);

    @WebMethod
    void update(ProductRepr productRepr);

    @WebMethod
    void delete(Integer id);

    @WebMethod
    ProductRepr findProductReprById(Integer id);

    @WebMethod
    List<ProductRepr> findAllProductRepr();

}

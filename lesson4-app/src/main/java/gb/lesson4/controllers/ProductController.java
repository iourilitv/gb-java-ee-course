package gb.lesson4.controllers;

import gb.lesson4.entities.Product;
import gb.lesson4.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ProductRepository productRepository;

    private Product product;

    private List<Product> products;

    public void preloadData(ComponentSystemEvent componentSystemEvent) throws SQLException {
        products = productRepository.findAll();
    }

    //TODO Solved. Почему-то при отображении списка товаров в index.xhtml этот метод вызывается 3 раза вместо одного!!!
    public List<Product> getAllProducts() {
        return products;
    }
//    public List<Product> getAllProducts() throws SQLException {
////        return productRepository.findAll();
//        List<Product> products = productRepository.findAll();
//        log.info("****** products: " + products);
//        return products;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String productDetails(Product product) {
        this.product = product;
        return "/product-details.xhtml?faces-redirect=true";
    }

    public String createProduct() {
        this.product = new Product();
        return "/product-form.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if(product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product-form.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        productRepository.delete(product.getId());
    }

}

package gb.lesson6.controllers;

import gb.lesson6.entities.Category;
import gb.lesson6.repositories.interfaces.ICategoryRepository;
import gb.lesson6.reprentities.ProductRepr;
import gb.lesson6.services.interfaces.IProductService;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private IProductService productService;

    @Inject
    private ICategoryRepository categoryRepository;

    private ProductRepr product;

    private List<ProductRepr> products;

    private List<Category> categories;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        products = productService.findAllProductRepr();
        categories = categoryRepository.findAll();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<ProductRepr> getAllProducts() {
        return products;
    }

    public ProductRepr getProduct() {
        return product;
    }

    public void setProduct(ProductRepr productRepr) {
        product = productRepr;
    }

    public String productDetails(ProductRepr productRepr) {
        product = productRepr;
        return "/product-details.xhtml?faces-redirect=true";
    }

    public String createProduct() {
        product = new ProductRepr();
        return "/product-form.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        if(product.getId() == null) {
            productService.insert(product);
        } else {
            productService.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String editProduct(ProductRepr productRepr) {
        product = productRepr;
        return "/product-form.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductRepr productRepr) {
        productService.delete(productRepr.getId());
    }

}

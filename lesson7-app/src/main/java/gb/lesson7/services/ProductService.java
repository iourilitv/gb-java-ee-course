package gb.lesson7.services;

import gb.lesson7.entities.Category;
import gb.lesson7.entities.Product;
import gb.lesson7.repositories.interfaces.ICategoryRepository;
import gb.lesson7.repositories.interfaces.IProductRepository;
import gb.lesson7.reprentities.ProductRepr;
import gb.lesson7.services.interfaces.IProductService;
import gb.lesson7.services.interfaces.IProductServiceWs;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.jws.WebService;
import java.net.URL;
import java.util.List;

@Stateless
@WebService(endpointInterface = "gb.lesson7.services.interfaces.IProductServiceWs", serviceName = "ProductService")
public class ProductService implements IProductService, IProductServiceWs {

    @Inject
    private IProductRepository productRepository;

    @Inject
    private ICategoryRepository categoryRepository;

    public ProductService() {
    }

    public ProductService(URL url) {
        System.out.println("URL: " + url);
    }

    @TransactionAttribute
    @Override
    public void insert(ProductRepr productRepr) {
        Category category = categoryRepository.findById(productRepr.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));
        productRepository.insert(new Product(category, productRepr.getTitle(), productRepr.getDescription(),
                productRepr.getPrice()));
    }

    @TransactionAttribute
    @Override
    public void update(ProductRepr productRepr) {
        Category category = categoryRepository.findById(productRepr.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));
        productRepository.update(new Product(category, productRepr.getTitle(), productRepr.getDescription(),
                productRepr.getPrice()));
    }

    @TransactionAttribute
    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public ProductRepr findProductReprById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        return new ProductRepr(product.getId(), product.getCategory(), product.getTitle(),
                product.getDescription(), product.getPrice());
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductRepr> findAllProductRepr() {
        return productRepository.findAllProductRepr();
    }

    @Override
    public IProductServiceWs getProductServicePort() {
        return null;
    }

}

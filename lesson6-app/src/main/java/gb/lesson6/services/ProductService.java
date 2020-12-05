package gb.lesson6.services;

import gb.lesson6.entities.Category;
import gb.lesson6.entities.Product;
import gb.lesson6.repositories.interfaces.ICategoryRepository;
import gb.lesson6.repositories.interfaces.IProductRepository;
import gb.lesson6.reprentities.ProductRepr;
import gb.lesson6.services.interfaces.IProductService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductService implements IProductService {

    @Inject
    private IProductRepository productRepository;

    @Inject
    private ICategoryRepository categoryRepository;

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
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductRepr> findAllProductRepr() {
        return productRepository.findAllProductRepr();
    }

}

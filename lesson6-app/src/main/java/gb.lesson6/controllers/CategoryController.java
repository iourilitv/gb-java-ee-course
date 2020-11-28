package gb.lesson5.controllers;

import gb.lesson5.entities.Category;
import gb.lesson5.repositories.CategoryRepository;
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
public class CategoryController implements Serializable {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private CategoryRepository categoryRepository;

    private Category category;

    private List<Category> categories;

    public void preloadData(ComponentSystemEvent componentSystemEvent) throws SQLException {
        categories = categoryRepository.findAll();
    }

    public List<Category> getAll() {
        return categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String details(Category category) {
        this.category = category;
        return "/category-details.xhtml?faces-redirect=true";
    }

    public String create() {
        this.category = new Category();
        return "/category-form.xhtml?faces-redirect=true";
    }

    public String save() throws SQLException {
        if(category.getId() == null) {
            categoryRepository.insert(category);
        } else {
            categoryRepository.update(category);
        }
        return "/categories.xhtml?faces-redirect=true";
    }

    public String edit(Category category) {
        this.category = category;
        return "/category-form.xhtml?faces-redirect=true";
    }

    public void delete(Category category) throws SQLException {
        categoryRepository.delete(category.getId());
    }

}

package gb.lesson7.reprentities;

import gb.lesson7.entities.Category;
import gb.lesson7.entities.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProductRepr implements Serializable {

    private Integer id;

    private Integer categoryId;

    private String categoryTitle;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 4, max = 50,message = "Поле должно содержать от 4 до 50 символов")
    private String title;

    @NotNull(message = "Поле не должно быть пустым")
    private String description;

    @NotNull(message = "Поле не должно быть пустым")
    private BigDecimal price;

    public ProductRepr() {
    }

    public ProductRepr(Integer id, Category category, String title, String description, BigDecimal price) {
        this.id = id;
        this.categoryId = category != null ? category.getId() : null;
        this.categoryTitle = category != null ? category.getTitle() : null;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductRepr{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}

package gb.lesson4.entities;

import javax.inject.Named;
import java.math.BigDecimal;

/**
 * Пример валидации управляемого бина.
 */
@Named
public class Product {
    private Integer id;
    private Integer categoryId;
    private String title;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    public Product(Integer id, Integer categoryId, String title, String description, BigDecimal price) {
        this.id = id;
        this.categoryId = categoryId;
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
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}

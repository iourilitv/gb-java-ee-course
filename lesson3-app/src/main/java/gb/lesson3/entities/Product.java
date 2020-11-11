package gb.lesson3.entities;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String Title;
    private String Description;
    private BigDecimal price;

    public Product(Integer id, String title, String description, BigDecimal price) {
        this.id = id;
        Title = title;
        Description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", price=" + price +
                '}';
    }
}

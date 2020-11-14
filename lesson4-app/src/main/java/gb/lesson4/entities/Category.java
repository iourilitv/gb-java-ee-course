package gb.lesson4.entities;

import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Пример валидации CDI бина.
 */
@Named
//@RequestScoped
//TODO В index.xhtml при этой аннотации в списке товаров(на пустом) все елементы выводятся с пустыми полями!
// Это из-за того, что локальная переменная и бин(сущность) называются одинаково.
// Решение: просто переименовать локальную переменную(var) в index.xhtml или не использовать @RequestScoped для сущностей.
public class Category {
    private Integer id;

    @NotNull(message = "Поле не должно быть пустым")
    @Size (min = 4, max = 50,message = "Поле должно содержать от 4 до 50 символов")
    private String title;

    @NotNull(message = "Поле не должно быть пустым")
    private String description;

    public Category() {
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Category(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

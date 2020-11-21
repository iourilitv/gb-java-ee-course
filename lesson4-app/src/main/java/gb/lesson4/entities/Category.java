package gb.lesson4.entities;

import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Пример валидации CDI бина.
 */
//@Named //с ней работает, но лучше ее удалить - работает и без нее
//@RequestScoped
//TODO В index.xhtml при аннотации @RequestScoped в списке товаров(на пустом) все елементы выводятся с пустыми полями!
// Это из-за того, что локальная переменная и бин(сущность) называются одинаково.
// Решение1: просто переименовать локальную переменную(var) в index.xhtml или не использовать @RequestScoped для сущностей.
// Правильно: не использовать CDI аннотации на сущностях!
public class Category {
    private Integer id;

//    @NotNull(message = "Поле не должно быть пустым") //оба способа работают
    @NotEmpty(message = "Поле не должно быть пустым")
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

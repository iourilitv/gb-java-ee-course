package gb.lesson5.entities;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Integer id;
    private User user;
    private String deliveryAddress;
    private List<OrderItem> items;
    private BigDecimal total;

    public Order() {
    }

    public Order(Integer id, User user, String deliveryAddress, List<OrderItem> items, BigDecimal total) {
        this.id = id;
        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}

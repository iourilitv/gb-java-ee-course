package gb.lesson8.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name = "user")
//    private User user;

    @Column(name = "delivery_addresses")
    private String deliveryAddress;

    @Column(name = "total")
    private BigDecimal total;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> items;

    public Order() {
    }

    public Order(Integer id, /*User user,*/ String deliveryAddress, BigDecimal total, List<OrderItem> items) {
        this.id = id;
//        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.total = total;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
//                ", user=" + user +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}

package gb.lesson6.reprentities;

import gb.lesson6.entities.Product;

import java.math.BigDecimal;

public class OrderItemRepr {

    private Integer id;

    private Integer orderId;

    private Integer productId;

    private String productTitle;

    private Integer quantity;

    private BigDecimal price;

    private BigDecimal cost;

    public OrderItemRepr() {
    }

    public OrderItemRepr(Integer id, Integer orderId, Product product, Integer quantity, BigDecimal price, BigDecimal cost) {
        this.id = id;
        this.orderId = orderId;
        this.productId = product != null ? product.getId() : null;
        this.productTitle = product != null ? product.getTitle() : null;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "OrderItemRepr{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", cost=" + cost +
                '}';
    }
}

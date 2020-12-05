package gb.lesson6.services;

import gb.lesson6.reprentities.OrderItemRepr;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartService implements Serializable {

    private List<OrderItemRepr> items;

    private BigDecimal total;

    public CartService() {
        items = new ArrayList<>();
        total = BigDecimal.ZERO;
    }

    public void addItem(OrderItemRepr itemRepr) {
        items.add(itemRepr);
        recalculate();
    }

    public void deleteItem(OrderItemRepr itemRepr) {
        items.remove(itemRepr);
        recalculate();
    }

    private void recalculate() {
        for (OrderItemRepr item: items) {
            total = total.add(item.getPrice());
        }
    }

    public List<OrderItemRepr> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }
}

package gb.lesson7.controllers;

import gb.lesson7.reprentities.OrderItemRepr;
import gb.lesson7.services.CartService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    private List<OrderItemRepr> items;

    private BigDecimal total;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        items = cartService.getItems();
        total = cartService.getTotal();
    }

    public List<OrderItemRepr> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void addItem(OrderItemRepr itemRepr) {
        cartService.addItem(itemRepr);
    }

    public void deleteItem(OrderItemRepr itemRepr) {
        cartService.deleteItem(itemRepr);
    }


}

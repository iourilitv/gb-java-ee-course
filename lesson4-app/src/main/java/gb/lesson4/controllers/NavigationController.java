package gb.lesson4.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class NavigationController implements Serializable {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public String catalogPage() {
        log.info("******** Catalog - indexPage *******");
        return "/index.xhtml?faces-redirect=true";
    }

    public String categoriesPage() {
        log.info("******** categoriesPage *******");
        return "/categories.xhtml?faces-redirect=true";
    }

    public String cartPage() {
        log.info("******** cartPage *******");
        return "/cart.xhtml?faces-redirect=true";
    }

    public String orderPage() {
        log.info("******** orderPage *******");
        return "/order.xhtml?faces-redirect=true";
    }

    public String aboutPage() {
        log.info("******** aboutPage *******");
        return "/about.xhtml?faces-redirect=true";
    }

}

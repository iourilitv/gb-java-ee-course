import java.net.MalformedURLException;
import java.net.URL;

import gb.lesson7.services.ProductService;
import gb.lesson7.services.interfaces.IProductService;
import gb.lesson7.services.interfaces.IProductServiceWs;

public class WebClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/lesson7-app/ProductService?WSDL");
        IProductService productService = new ProductService(url);
        IProductServiceWs port = productService.getProductServicePort();

        port.findProductReprById(1);
        System.out.println("Product: " + port.findProductReprById(1));

    }
}

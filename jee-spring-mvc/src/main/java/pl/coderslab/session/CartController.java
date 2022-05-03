package pl.coderslab.session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;

@Controller
public class CartController {

    private final Cart cart;
    private final ProductDao productDao;

    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

/*
    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(rand.nextInt(11), new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }
*/

    @GetMapping("/addtocart")
    @ResponseBody
    public String addToCart(@RequestParam("id") long id, @RequestParam("quantity") int quantity) {
        if(cart.hasProductWithId(id)) {
            cart.updateQuantity(id, quantity);
            return "quantityUpdated";
        }
        Product product = productDao.getProductById(id);
        CartItem cartItem = new CartItem(quantity, product);
        cart.addToCart(cartItem);
        return "addtocart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String showCart() {
        StringBuilder sb = new StringBuilder();
        sb.append("W koszyku jest: ")
                .append(cart.getCartItems().size())
                .append(" pozycji. \n");
        sb.append("W koszyku jest: ")
                .append(cart.totalQuantity())
                .append(" produktów. \n");
        sb.append("Wartosc koszyka to: ")
                .append(cart.totalAmount())
                .append(" .\n");

        return sb.toString();
    }

}
package pl.coderslab.session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;

@Controller
public class CartController {

    private final Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(rand.nextInt(11), new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String showCart(){
        StringBuilder sb = new StringBuilder();
        sb.append("W koszyku jest: ")
                .append(cart.getCartItem().size())
                .append(" pozycji");
        sb.append("W koszyku jest: ")
                .append(cart.totalQuantity())
                .append(" w produk" );
        sb.append("Wartosc koszyka to: ")
                .append(cart.totalAmount())
                .append(" .\n");
        return sb.toString();
    }

}

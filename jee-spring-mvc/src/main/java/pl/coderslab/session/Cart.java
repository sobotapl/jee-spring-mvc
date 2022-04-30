package pl.coderslab.session;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import java.util.List;


@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION,
proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<CartItem> cartItem;

    public void addToCart(CartItem cartItem){
        this.cartItem.add(cartItem);
    }

    public List<CartItem> getCartItem(){
        return cartItem;
    }

    public int totalQuantity() {
        return cartItem.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public double totalAmount(){
        return cartItem.stream()
                .mapToDouble(CartItem::itemAmount)
                .sum();
    }


}

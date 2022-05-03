package pl.coderslab.session;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public int totalQuantity() {
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public double totalAmount() {
        return cartItems.stream()
                .mapToDouble(CartItem::itemAmount)
                .sum();
    }

    public boolean hasProductWithId(long id) {
        return cartItems.stream()
                .map(CartItem::getProduct)
                .anyMatch(p -> p.getId() == id);
    }

    public void updateQuantity(long id, int quantity) {
        cartItems.stream()
                .filter(c -> c.getProduct().getId() == id)
                .findFirst()
                .ifPresent(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
    }

}
package com.example.jax_ws.model;

import com.example.jax_ws.entity.CartItem;
import com.example.jax_ws.entity.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartModelImpTest {
    private ShoppingCartModelImp model;
    @BeforeEach
    void setUp() {
        model = new ShoppingCartModelImp();
    }

    @Test
    void save() throws SQLException {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<CartItem> items = new ArrayList<>();
        items.add(new CartItem(0,9,"Pc",30000,1));
        items.add(new CartItem(0,10,"Phone",6000,2));
        shoppingCart.setCartItems(items);
        shoppingCart.setShipAddress("75 Hồ Ba Mẫu");
        shoppingCart.setShipName("Linh");
        shoppingCart.setShipPhone("09489342");
        shoppingCart.setUserId(1);
        System.out.println(shoppingCart.toString());
        assertThat(model.save(shoppingCart).getId()).isNotEqualTo(0);
    }




    @Test
    void get() {
        try {
           ShoppingCart s = model.get(0);
            System.out.println(s.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
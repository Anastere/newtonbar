package com.bar.newtonbar.util;

import com.bar.newtonbar.entity.ShoppingCartItem;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ShoppingCartItemCache {


    public ShoppingCartItem getShoppingCartItem(int id) {
        ShoppingCartItem shoppingCartItem = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppingCartItem;
    }

    public Map<Object, Object> getAllShoppingCartItems() {
        Map<Object, Object> shoppingCartItems = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppingCartItems;
    }
}

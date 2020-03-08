package com.bar.newtonbar.controller;

import com.bar.newtonbar.dto.OrderRequest;
import com.bar.newtonbar.dto.OrderResponse;
import com.bar.newtonbar.entity.Cocktail;
import com.bar.newtonbar.entity.Order;
import com.bar.newtonbar.entity.ShoppingCartItem;
import com.bar.newtonbar.entity.User;
import com.bar.newtonbar.repository.CocktailRepository;
import com.bar.newtonbar.repository.OrderRepository;
import com.bar.newtonbar.repository.UserRepository;
import com.bar.newtonbar.util.ShoppingCartItemCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

@SessionAttributes({"menuSession"})
@Controller
public class MenuController {

    @Autowired
    CocktailRepository cocktailRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/menu")
    public String menu(Model model) {
        List<Cocktail> cocktails = new ArrayList<>();
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        cocktailRepository.findAll().forEach(cocktails::add);
        model.addAttribute("cocktails", cocktails);
        model.addAttribute("shoppingCartItem", shoppingCartItem);
        return "menu";
    }

    @PostMapping(value = "/addOrder")
    public OrderResponse addToShoppingCart(@RequestBody OrderRequest orderRequest) {

        orderRequest.getOrderRequest().forEach(orderItem -> {
            long cocktailId = orderItem.getCocktailId();
            Cocktail cocktail = cocktailRepository.findById(cocktailId).get();
            User user = userRepository.findById(orderRequest.getUserId()).get();
            int quantity = orderItem.getQuantity();
            Set<Cocktail> cocktails = Set.of(cocktail);
            Order order = new Order(quantity, new BigDecimal(quantity * cocktail.getPrice().intValue()), cocktails);
            order.setUser(user);
            orderRepository.save(order);
        });
//        String rec = "{\n" +
//                "    \"rom\":\"50\",\n" +
//                "    \"pineapple\":\"30\",\n" +
//                "    \"liquor drive orange\":\"20\",\n" +
//                "    \"sugar syrup\":\"10\",\n" +
//                "    \"almond syrup\":\"10\",\n" +
//                "    \"ice\":\"200\",\n" +
//                "    \"lime juice\":\"20\",\n" +
//                "    \"cocktail cherry\":\"1\",\n" +
//                "    \"mint\":\"1\"\n" +
//                "}";
        return new OrderResponse()
    }

    //TODO: add custom exception
    @GetMapping("/shoppingCart")
    public String orderCocktail(Model model) {
        List<Cocktail> cocktails = new ArrayList<>();
        cocktailRepository.findAll().forEach(cocktails::add);
        model.addAttribute("cocktails", cocktails);
        return "shoppingCart";
    }

//    @GetMapping("/allorders")
//    public String allOrders (Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//
//    @GetMapping("/order")
//    public String order(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

}
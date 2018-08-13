package ua.com.oliinyk.controllers;

import ua.com.oliinyk.dao.ProductDAO;
import ua.com.oliinyk.dao.SizeDAO;
import ua.com.oliinyk.entity.Cart;
import ua.com.oliinyk.entity.Product;
import ua.com.oliinyk.entity.User;
import ua.com.oliinyk.entity.categories.Size;
import ua.com.oliinyk.orders.Order;
import org.json.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@SessionAttributes("cart")
public class CartController {

  @PostMapping(path = "/addTocart")
  @ResponseBody
  public String addProductToCart(ModelMap model, @RequestParam("product") String json, @SessionAttribute(value = "user", required = false) User user) {

    Cart cart = (Cart) model.get("cart");
    if (cart == null) {
      cart = new Cart();
    }

    Date dateNow = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd ' ' hh:mm:ss a zzz");

    Order order_product = new Order();
    JSONObject jsonObj = new JSONObject(json);

    ProductDAO prodDao = new ProductDAO();
    Product product = prodDao.getEntityById(Product.class, jsonObj.getInt("id"));
    Set<Size> size = new HashSet<>();
    Size s = new SizeDAO().getEntityById(Size.class, jsonObj.getInt("size"));
    size.add(s);
    product.setSize(size);

    order_product.setProduct_id(jsonObj.getInt("id"));
    order_product.setProduct_brand(jsonObj.getString("brand"));
    order_product.setProduct_model(jsonObj.getString("model"));
    order_product.setProduct_size(jsonObj.getInt("size"));
    order_product.setProduct_price(jsonObj.getInt("price"));
    order_product.setDate(formatForDateNow.format(dateNow));
    if (user != null) {
      order_product.setUsername(user.getName());
      order_product.setUser_email(user.getEmail());
      order_product.setUser_phonenumber(user.getPhonenumber());
    }

    if (cart.getProducts().contains(order_product)) {
      order_product = cart.getProducts().get(cart.getProducts().indexOf(order_product));
      order_product.setProduct_quantity(order_product.getProduct_quantity() + 1);
    } else {
      order_product.setProduct_quantity(1);
      cart.getProducts().add(order_product);
    }

    model.addAttribute("cart", cart);

    JSONObject response = new JSONObject();
    response.put("totalItems", cart.getTotalItems());
    response.put("totalAmount", cart.getTotalAmount());

    return response.toString();
  }

  @PostMapping(path = "/removeFromCart")
  @ResponseBody
  public String deleteProductFromCart(ModelMap model, @RequestParam("product") String json) {
    Cart cart = (Cart) model.get("cart");
    Order order_product = new Order();
    JSONObject jsonObj = new JSONObject(json);
    order_product.setProduct_id(jsonObj.getInt("id"));
    order_product.setProduct_brand(jsonObj.getString("brand"));
    order_product.setProduct_model(jsonObj.getString("model"));
    order_product.setProduct_size(jsonObj.getInt("size"));
    order_product.setProduct_price(jsonObj.getInt("price"));

    if (cart.getProducts().contains(order_product)) {
      cart.getProducts().remove(cart.getProducts().indexOf(order_product));
    }

    JSONObject response = new JSONObject();
    response.put("totalItems", cart.getTotalItems());
    response.put("totalAmount", cart.getTotalAmount());

    return response.toString();
  }

}
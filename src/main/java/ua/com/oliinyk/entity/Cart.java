package ua.com.oliinyk.entity;

import java.util.ArrayList;
import java.util.List;

import ua.com.oliinyk.orders.Order;

public class Cart {

	public Cart() {
		products = new ArrayList<Order>();
	}

	private List<Order> products;

	public List<Order> addToCart(Order product) {
		products.add(product);
		return products;
	}
	
	public List<Order> deleteFromCart(Order product) {
		products.remove(product);
		return products;
	}

	public List<Order> getProducts() {
		return products;
	}

	public void setProducts(List<Order> products) {
		this.products = products;
	}

	public int getTotalItems() {
		return products.size();
	}

	public int getTotalAmount() {

		int totalAmount = 0;
		for (Order product : products) {
			totalAmount += product.getTotalAmount();
		}
		return totalAmount;
	}
}

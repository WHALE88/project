package itea.ua.oliinyk.orders;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import itea.ua.oliinyk.entity.ShopEntity;

@Entity
@Table(name = "orders")
@NamedQueries({ @NamedQuery(name = "Order.All", query = "SELECT orders FROM Order orders")})
public class Order implements ShopEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer id;
	
	@Column(name = "product_id", nullable = false)
	public int product_id;
	
	@Column(name = "product_brand", nullable = false)
	public String product_brand;
	
	@Column(name = "product_model", nullable = false)
	public String product_model;
	
	@Column(name = "product_size", nullable = false)
	public int product_size;
	
	@Column(name = "product_price", nullable = false)
	public Integer product_price;
	
	@Column(name = "product_quantity", nullable = false)
	private Integer product_quantity;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "user_email", nullable = false)
	private String user_email;
	
	@Column(name = "user_phonenumber", nullable = false)
	private String user_phonenumber;
	
	@Column(name = "date", nullable = false)
	private String date;

	public Order() {

	}

	public Order(Integer id, int product_id, String product_brand, String product_model, int product_size,
			Integer product_price, Integer product_quantity, String username, String user_email,
			String user_phonenumber, String date) {
		this.id = id;
		this.product_id = product_id;
		this.product_brand = product_brand;
		this.product_model = product_model;
		this.product_size = product_size;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.username = username;
		this.user_email = user_email;
		this.user_phonenumber = user_phonenumber;
		this.date = date;
	}

	public Integer getTotalAmount() {
		int totalAmount = 0;
		if (product_price != null && product_quantity != null) {
			totalAmount = product_price * product_quantity;
		}
		return totalAmount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public String getProduct_model() {
		return product_model;
	}

	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}

	public int getProduct_size() {
		return product_size;
	}

	public void setProduct_size(int product_size) {
		this.product_size = product_size;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phonenumber() {
		return user_phonenumber;
	}

	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product_brand == null) ? 0 : product_brand.hashCode());
		result = prime * result + product_id;
		result = prime * result + ((product_model == null) ? 0 : product_model.hashCode());
		result = prime * result + ((product_price == null) ? 0 : product_price.hashCode());
		result = prime * result + ((product_quantity == null) ? 0 : product_quantity.hashCode());
		result = prime * result + product_size;
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_phonenumber == null) ? 0 : user_phonenumber.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product_brand == null) {
			if (other.product_brand != null)
				return false;
		} else if (!product_brand.equals(other.product_brand))
			return false;
		if (product_id != other.product_id)
			return false;
		if (product_model == null) {
			if (other.product_model != null)
				return false;
		} else if (!product_model.equals(other.product_model))
			return false;
		if (product_price == null) {
			if (other.product_price != null)
				return false;
		} else if (!product_price.equals(other.product_price))
			return false;
		if (product_quantity == null) {
			if (other.product_quantity != null)
				return false;
		} else if (!product_quantity.equals(other.product_quantity))
			return false;
		if (product_size != other.product_size)
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_phonenumber == null) {
			if (other.user_phonenumber != null)
				return false;
		} else if (!user_phonenumber.equals(other.user_phonenumber))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
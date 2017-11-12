package itea.ua.oliinyk.entity.categories;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import itea.ua.oliinyk.entity.Product;
import itea.ua.oliinyk.entity.ShopEntity;

@Entity
@Table(name = "brands")
@NamedQueries({ @NamedQuery(name = "Brand.All", query = "SELECT brand FROM Brand brand") })
public class Brand implements ShopEntity, Comparable<Brand> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "brand", nullable = false)
	private String brand;

	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // name of variable in the class
																						// Product
	private List<Product> products;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String getStringId() {
		return id;
	}

	@Override
	public int compareTo(Brand brand) {
		return getBrand().compareTo(brand.getBrand());
	}

}

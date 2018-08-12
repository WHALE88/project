package ua.com.oliinyk.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import ua.com.oliinyk.entity.categories.Brand;
import ua.com.oliinyk.entity.categories.Category;
import ua.com.oliinyk.entity.categories.Gender;
import ua.com.oliinyk.entity.categories.Liner_Material;
import ua.com.oliinyk.entity.categories.Size;
import ua.com.oliinyk.entity.categories.Upper_Material;

@Entity
@Table(name = "products")
@NamedQueries({ @NamedQuery(name = "Product.All", query = "SELECT products FROM Product products"),
		@NamedQuery(name = "Product.getProdByGender", query = "SELECT products FROM Product products WHERE products.genders = :gender"),
		@NamedQuery(name = "Product.getProdByCategory", query = "SELECT products FROM Product products WHERE products.categories = :category"),
		@NamedQuery(name = "Product.getProdByBrand", query = "SELECT products FROM Product products WHERE products.brand = :brand"),
		@NamedQuery(name = "Product.getProdBySize", query = "SELECT products FROM Product products INNER JOIN products.size AS size WHERE size = :size"),
		@NamedQuery(name = "Product.getProdByLinMat", query = "SELECT products FROM Product products WHERE products.liner_material = :liner_material"),
		@NamedQuery(name = "Product.getProdByUpMat", query = "SELECT products FROM Product products WHERE products.upper_material = :upper_material"),
		@NamedQuery(name = "Product.getProdByGender&Brand", query = "SELECT products FROM Product products WHERE products.brand = :brand AND products.genders = :gender")
	})
public class Product implements ShopEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
	private Brand brand;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "products_size", 
	joinColumns = @JoinColumn(name = "products_id", referencedColumnName="id"), 
	inverseJoinColumns = @JoinColumn(name = "size_id", referencedColumnName ="id"))
	private Set<Size> size = new HashSet<Size>();

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
	private Gender genders;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "liner_material_id", referencedColumnName = "id", nullable = false)
	private Liner_Material liner_material;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "upper_material_id", referencedColumnName = "id", nullable = false)
	private Upper_Material upper_material;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
	private Category categories;

	@Column(name = "model", nullable = false)
	private String model;

	@Column(name = "price", nullable = false)
	private Integer price;

	public Product() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public Set<Size> getSize() {
		return size;
	}

	public void setSize(Set<Size> size) {
		this.size = size;
	}

	public Gender getGenders() {
		return genders;
	}

	public void setGenders(Gender genders) {
		this.genders = genders;
	}

	public Liner_Material getLiner_material() {
		return liner_material;
	}

	public void setLiner_material(Liner_Material liner_material) {
		this.liner_material = liner_material;
	}

	public Upper_Material getUpper_material() {
		return upper_material;
	}

	public void setUpper_material(Upper_Material upper_material) {
		this.upper_material = upper_material;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", genders=" + genders
				+ ", liner_material=" + liner_material + ", upper_material=" + upper_material + ", categories="
				+ categories + ", model=" + model + ", price=" + price + "]";
	}

	@Override
	public String getStringId() {
		return id.toString();
	}

}
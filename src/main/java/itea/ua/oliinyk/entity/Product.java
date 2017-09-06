package itea.ua.oliinyk.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import itea.ua.oliinyk.entity.categories.Brand;
import itea.ua.oliinyk.entity.categories.Category;
import itea.ua.oliinyk.entity.categories.Gender;
import itea.ua.oliinyk.entity.categories.Liner_Material;
import itea.ua.oliinyk.entity.categories.Size;
import itea.ua.oliinyk.entity.categories.Upper_Material;

@Entity
@Table(name = "products")
@NamedQueries({ @NamedQuery(name = "Product.All", query = "SELECT products FROM Product products"),
		/*
		 * @NamedQuery(name = "Product.getProductsByCategory", query =
		 * "SELECT products FROM Product products WHERE products.category_id = :category"
		 * )
		 */ })
public class Product implements ShopEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "size_id", referencedColumnName = "id", nullable = false)
	private Size size;

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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
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
		return "Product [id=" + id + ", brand=" + brand + ", size=" + size + ", genders=" + genders
				+ ", liner_material=" + liner_material + ", upper_material=" + upper_material + ", categories="
				+ categories + ", model=" + model + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((genders == null) ? 0 : genders.hashCode());
		result = (int) (prime * result + id);
		result = prime * result + ((liner_material == null) ? 0 : liner_material.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((upper_material == null) ? 0 : upper_material.hashCode());
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
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (genders == null) {
			if (other.genders != null)
				return false;
		} else if (!genders.equals(other.genders))
			return false;
		if (id != other.id)
			return false;
		if (liner_material == null) {
			if (other.liner_material != null)
				return false;
		} else if (!liner_material.equals(other.liner_material))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (upper_material == null) {
			if (other.upper_material != null)
				return false;
		} else if (!upper_material.equals(other.upper_material))
			return false;
		return true;
	}
	
	
	
}
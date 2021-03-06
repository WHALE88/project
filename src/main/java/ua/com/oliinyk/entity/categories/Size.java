package ua.com.oliinyk.entity.categories;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import ua.com.oliinyk.entity.Product;
import ua.com.oliinyk.entity.ShopEntity;

@Entity
@Table(name = "size")
@NamedQueries({ @NamedQuery(name = "Size.All", query = "SELECT size FROM Size size") })
public class Size implements ShopEntity, Comparable<Size>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "size", nullable = false)
	private String size;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "products_size", joinColumns = @JoinColumn(name = "size_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"))
	private Set<Product> product = new HashSet<Product>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Size other = (Size) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Size [id=" + id + ", size=" + size + "]";
	}

	@Override
	public int compareTo(Size s2) {
		return getSize().compareTo(s2.getSize());
	}

	@Override
	public String getStringId() {
		return id.toString();
	}

}
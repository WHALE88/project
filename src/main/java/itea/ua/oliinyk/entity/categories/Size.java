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

@Entity
@Table(name = "size")
@NamedQueries({ @NamedQuery(name = "Size.All", query = "SELECT size FROM Size size") })
public class Size {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "size", nullable = false)
	private String size;

	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
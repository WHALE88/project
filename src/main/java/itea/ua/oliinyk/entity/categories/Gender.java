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
@Table(name = "gender")
@NamedQueries({ @NamedQuery(name = "Gender.All", query = "SELECT gender FROM Gender gender") })
public class Gender implements ShopEntity, Comparable<Gender> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "gender", nullable = false)
	private String genders;

	@OneToMany(mappedBy = "genders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products;

	public String getGenders() {
		return genders;
	}

	public void setGenders(String genders) {
		this.genders = genders;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getStringId() {
		return id;
	}

	@Override
	public int compareTo(Gender gen) {
		return getGenders().compareTo(gen.getGenders());
	}
}

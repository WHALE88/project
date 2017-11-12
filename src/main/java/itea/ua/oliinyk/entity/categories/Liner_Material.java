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
@Table(name = "liner_materials")
@NamedQueries({ @NamedQuery(name = "Liner_Material.All", query = "SELECT lm FROM Liner_Material lm") })
public class Liner_Material implements ShopEntity, Comparable<Liner_Material>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "liner_material", nullable = false)
	private String liner_material;

    @OneToMany(mappedBy = "liner_material", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  	private List<Product> products;

	public String getLiner_material() {
		return liner_material;
	}

	public void setLiner_material(String liner_material) {
		this.liner_material = liner_material;
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
	public int compareTo(Liner_Material lm) {
		return getLiner_material().compareTo(lm.getLiner_material());
	}

	

}
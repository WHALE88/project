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
@Table(name = "upper_materials")
@NamedQueries({ @NamedQuery(name = "Upper_Material.All", query = "SELECT um FROM Upper_Material um") })
public class Upper_Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "upper_material", nullable = false)
	private String upper_material;

	@OneToMany(mappedBy = "upper_material", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products;

	public String getUpper_material() {
		return upper_material;
	}

	public void setUpper_material(String upper_material) {
		this.upper_material = upper_material;
	}

}
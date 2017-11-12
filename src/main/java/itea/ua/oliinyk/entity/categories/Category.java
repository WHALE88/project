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
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "Category.All", query = "SELECT category FROM Category category")
})
public class Category implements ShopEntity, Comparable<Category> {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "categories", nullable = false)
    private String categories;
    
    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products;

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String getStringId() {
		return id;
	}

	@Override
	public int compareTo(Category category) {
		return getCategories().compareTo(category.getCategories());
	}

	
    
}
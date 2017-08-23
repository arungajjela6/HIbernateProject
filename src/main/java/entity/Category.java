package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="categories")
public class Category implements Serializable{
	
	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="category_date")
	@Temporal(TemporalType.DATE)
	private Date categoryDate;

	@ElementCollection
	@CollectionTable(name="keywords",joinColumns=@JoinColumn(name="category_id"))
	@Column(name="keyword")
	private Set<String> keywords = new HashSet<String>();

	@ManyToMany
	@JoinTable(name="categories_items",joinColumns = @JoinColumn(name="category_id_fk",referencedColumnName="category_id"),
	inverseJoinColumns=@JoinColumn(name="item_id_fk",referencedColumnName="item_id"))
	private Set<Item> items;
	
	public Category() {
		
	}

	public Category(String categoryName, Date categoryDate, Set<String>keywords) {
		super();
		
		this.categoryName = categoryName;
		this.categoryDate = categoryDate;
		this.keywords = keywords;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getCategoryDate() {
		return categoryDate;
	}

	public void setCategoryDate(Date categoryDate) {
		this.categoryDate = categoryDate;
	}

	public Set<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	
	
}

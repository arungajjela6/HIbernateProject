package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="items")
public class Item implements Serializable{
	@Id
	@Column(name="item_id")
	private Long itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_createdname")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="item_intialprice")
	private BigDecimal intialPrice;
	
	@Column(name="item_bidstartdate")
	@Temporal(TemporalType.DATE)
	private Date bidStartDate;
	
	@Column(name="item_bidenddate")
	@Temporal(TemporalType.DATE)
	private Date bidEndDate;
	
	@OneToMany(mappedBy="item")
	private Set<Bid> bids = new HashSet<Bid>();
	
	@ManyToMany(mappedBy="items")
	private Set<Category> categories = new HashSet<Category>();
	
	public Item() {
		
	}

	
	public Item(Long itemId, String itemName, Date createdDate, BigDecimal intialPrice, Date bidStartDate,
			Date bidEndDate) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.createdDate = createdDate;
		this.intialPrice = intialPrice;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getIntialPrice() {
		return intialPrice;
	}

	public void setIntialPrice(BigDecimal intialPrice) {
		this.intialPrice = intialPrice;
	}

	public Date getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	
	

}

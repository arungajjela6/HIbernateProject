package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bids")
public class Bid implements Serializable {
	
	@Id
	@Column(name="bid_id")
	private long bidId;
	
	@Column(name="bid_price")
	private BigDecimal bidPrice;
	
	@Column(name="bid_date")
	@Temporal(TemporalType.DATE)
	private Date bidDate;
	
	@ManyToOne
	@JoinColumn(name="bid_item_id")
	private Item item;
	
	public Bid() {
		
	}
	

	public Bid(long bidId, BigDecimal bidPrice, Date bidDate, Item item) {
		super();
		this.bidId = bidId;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
		this.item = item;
	}


	public long getBidId() {
		return bidId;
	}

	public void setBidId(long bidId) {
		this.bidId = bidId;
	}

	public BigDecimal getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}
	
}

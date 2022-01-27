package study.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="grocery_products")
public class GroceryProductEntity {
	@Id
	@Column(name="product_id")
	private int productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_desc")
	private String  productDesc;
	@Column(name="unit")
	private int unit ;
	@Column(name="cost")
	private int cost;
	@Column(name="expiry_date")
	private java.sql.Date expiryDate;
	
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public int getUnit() {
		return unit;
	}


	public void setUnit(int unit) {
		this.unit = unit;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public java.sql.Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(java.sql.Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public GroceryProductEntity() {
		System.out.println("GroceryProductEntity() ");
		// TODO Auto-generated constructor stub
	}

	

}

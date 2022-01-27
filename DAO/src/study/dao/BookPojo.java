package study.dao;

public class BookPojo {
	private int id;
	private String bname;
	private int cost;
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Book Id:"+id+"Name:"+bname+"Cost:"+cost;
		}
}

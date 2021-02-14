package data;

public class TableOrderDetailVO {
	private int tableNum;
	private int orderNum;
	private int detailNum;
	private int menuNum;
	private int categoryNum;
	private String categoryName;
	private String menuName;
	private int numOf;
	private int menuPrice;
	private String status;
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getDetailNum() {
		return detailNum;
	}
	public void setDetailNum(int detailNum) {
		this.detailNum = detailNum;
	}
	public int getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getNumOf() {
		return numOf;
	}
	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TableOrderDetailVO [tableNum=" + tableNum + ", orderNum=" + orderNum + ", detailNum="
				+ detailNum + ", menuNum=" + menuNum + ", categoryNum=" + categoryNum + ", categoryName=" + categoryName
				+ ", menuName=" + menuName + ", numOf=" + numOf + ", menuPrice=" + menuPrice + ", status=" + status
				+ ", getTableNum()=" + getTableNum() + ", getOrderNum()=" + getOrderNum()
				+ ", getDetailNum()=" + getDetailNum() + ", getMenuNum()=" + getMenuNum() + ", getCategoryNum()="
				+ getCategoryNum() + ", getCategoryName()=" + getCategoryName() + ", getMenuName()=" + getMenuName()
				+ ", getNumOf()=" + getNumOf() + ", getMenuPrice()=" + getMenuPrice() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}

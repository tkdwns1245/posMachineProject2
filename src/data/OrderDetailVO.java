package data;

public class OrderDetailVO {
	private int num;
	private int menuNum;
	private int orderNum;
	private int numOf;
	private String menuName;
	
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getNumOf() {
		return numOf;
	}
	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}
	@Override
	public String toString() {
		return "OrderDetailVO [num=" + num + ", menuNum=" + menuNum + ", orderNum=" + orderNum + ", numOf=" + numOf
				+ ", menuName=" + menuName + "]";
	}
	
}

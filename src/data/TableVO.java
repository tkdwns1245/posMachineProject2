package data;

public class TableVO {
	private int num;
	private int tableNumber;
	private String tableShow;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public String getTableShow() {
		return tableShow;
	}
	public void setTableShow(String tableShow) {
		this.tableShow = tableShow;
	}
	@Override
	public String toString() {
		return "TableVO [num=" + num + ", tableNumber=" + tableNumber + ", tableShow=" + tableShow + "]";
	}
	
}

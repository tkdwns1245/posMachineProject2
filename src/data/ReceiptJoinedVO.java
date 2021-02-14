package data;

import java.sql.Timestamp;

public class ReceiptJoinedVO {
	
	//RECEIPT DB
	
	private int rcNumber;
	private int sumPrice;
	private String payType;
	private Timestamp regTime;
	private String status;
	
	public int getRcNumber() {
		return rcNumber;
	}
	public void setRcNumber(int rcNumber) {
		this.rcNumber = rcNumber;
	}
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//RECEIPT_DETAILS DB
	

	private String menu_Category;
	private String menu_Name;
	private int menu_Price;
	private int numberOf;
	private int rowSum;
	private int rowCount;

	public String getMenu_Category() {
		return menu_Category;
	}
	public void setMenu_Category(String menu_Category) {
		this.menu_Category = menu_Category;
	}
	public String getMenu_Name() {
		return menu_Name;
	}
	public void setMenu_Name(String menu_Name) {
		this.menu_Name = menu_Name;
	}
	public int getMenu_Price() {
		return menu_Price;
	}
	public void setMenu_Price(int menu_Price) {
		this.menu_Price = menu_Price;
	}
	public int getNumberOf() {
		return numberOf;
	}
	public void setNumberOf(int numberOf) {
		this.numberOf = numberOf;
	}
	public int getRowSum() {
		return rowSum;
	}
	public void setRowSum(int rowSum) {
		this.rowSum = rowSum;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

			
	@Override
	public String toString() {
		return "ReceiptJoinedVO [rcNumber=" + rcNumber + ", sumPrice=" + sumPrice + ", payType=" + payType
				+ ", regTime=" + regTime + ", status=" + status + ", menu_Category=" + menu_Category + ", menu_Name="
				+ menu_Name + ", menu_Price=" + menu_Price + ", numberOf=" + numberOf + ", rowSum=" + rowSum
				+ ", rowCount=" + rowCount + "]";
	}


}
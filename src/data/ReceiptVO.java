package data;

import java.security.Timestamp;

public class ReceiptVO {
	
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
	
	
}
package data;

import java.sql.Date;


public class UserVO {

	private int idNumber;
	private String id;
	private String pass;
	private int authority;
	private String regDate;

	
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UserVO [idNumber=" + idNumber + ", id=" + id + ", pass=" + pass + ", authority=" + authority
				+ ", regDate=" + regDate + "]";
	}
	
	
}

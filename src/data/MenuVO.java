package data;

import java.sql.Date;

public class MenuVO {
	
	
	private String menuCategory;
	private String menuName;
	private int Category_num;
	private int menuPrice;
	private int Sequence;
	
	
	
	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	public int getCategory_num() {
		return Category_num;
	}
	public void setCategory_num(int category_num) {
		this.Category_num = category_num;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getSequence() {
		return Sequence;
	}
	public void setSequence(int sequence) {
		Sequence = sequence;
	}
	@Override
	public String toString() {
		return "MenuVO [menuCategory=" + menuCategory + ", menuName=" + menuName + ", Category_num=" + Category_num
				+ ", menuPrice=" + menuPrice + ", Sequence=" + Sequence + "]";
	}

	
}

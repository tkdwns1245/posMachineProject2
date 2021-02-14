package data;

import java.sql.Date;

public class MenuVO {
	
	private String menuCategory;
	private String menuName;
	private int menuPrice;
	

	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
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

	
	@Override
	public String toString() {
		return "MenuVO [menuCategory=" + menuCategory + ", menuName=" + menuName + ", menuPrice=" + menuPrice + "]";
	}

		
}

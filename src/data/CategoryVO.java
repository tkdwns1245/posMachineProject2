package data;

import java.sql.Date;

public class CategoryVO {
	
	private String categoryName;
	private int num;
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "CategoryVO [categoryName=" + categoryName + ", num=" + num + "]";
	}


}


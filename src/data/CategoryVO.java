package data;

import java.sql.Date;

public class CategoryVO {
	
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryVO [categoryName=" + categoryName + "]";
	}
}


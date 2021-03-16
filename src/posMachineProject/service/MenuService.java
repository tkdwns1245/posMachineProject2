package posMachineProject.service;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import data.OrderDetailVO;

public interface MenuService {
	public abstract List<MenuVO> menuList(); 
	public abstract List<CategoryVO> categoryList(); 
	public abstract List<MenuVO> menuListByCategoryName(String categoryName);
	public abstract int insertItemDetail(int categoryNum, String menuName, int menuPrice, int sequence);
	public abstract int insertCategoryDetail(int num, String CategoryName);
	public abstract int deleteItemDetail(String menuName);
	public abstract int deleteCategoryDetail(String categoryName);




}

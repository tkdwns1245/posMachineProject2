package posMachineProject.dao;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import data.OrderDetailVO;

public interface MenuDao {
	public abstract List<MenuVO> menuList() throws Exception;    
	public abstract List<CategoryVO> categoryList() throws Exception;
	public abstract List<MenuVO> menuListByCategoryName(String categoryName) throws Exception;
	public abstract void insertItemDetail(MenuVO vo) throws Exception;
	public abstract void insertCategoryDetail(CategoryVO vo) throws Exception;
	public abstract void deleteItemDetail(MenuVO vo) throws Exception;
	public abstract void deleteCategoryDetail(CategoryVO vo) throws Exception;


}

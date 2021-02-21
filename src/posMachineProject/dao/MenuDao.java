package posMachineProject.dao;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;

public interface MenuDao {
	public abstract List<MenuVO> menuList() throws Exception;
	
	public abstract List<CategoryVO> categoryList() throws Exception;
	public abstract List<MenuVO> menuListByCategoryName(String categoryName) throws Exception;
}

package lmh.manager;

import java.util.ArrayList;
import java.util.List;

import ServiceImpl.MenuServiceImpl;
import data.CategoryVO;
import data.MenuVO;
import service.MenuService;

public class MenuManager {
	MenuService ms = new MenuServiceImpl();	
	
	public List<MenuVO> selectMenuList(){
		return ms.menuList();

	}
	public List<MenuVO> selectMenuListByCategoryName(String categoryName){
		return ms.menuListByCategoryName(categoryName);
	}

	
	public List<CategoryVO> selectCategoryList(){
		return ms.categoryList();

	}

}


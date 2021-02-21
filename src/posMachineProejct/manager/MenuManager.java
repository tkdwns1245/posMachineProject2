package posMachineProejct.manager;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import posMachineProject.service.MenuService;
import posMachineProject.serviceImpl.MenuServiceImpl;

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


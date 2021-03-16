package posMachineProejct.manager;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import data.OrderDetailVO;
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

	public int insertItemDetail(int categoryNum, String menuName, int menuPrice, int sequence) {
		return ms.insertItemDetail(categoryNum, menuName, menuPrice, sequence);
	}
	

	public int insertCategoryDetail(int num, String categoryName) {
		return ms.insertCategoryDetail(num, categoryName);
	}
	
	public int deleteItemDetail(String menuName) {
		return ms.deleteItemDetail(menuName);
	}
	
	public int deleteCategoryDetail(String categoryName) {
		return ms.deleteCategoryDetail(categoryName);
	}


}


package ServiceImpl;

import java.util.List;
import daoImpl.MenuDaoImpl;
import data.CategoryVO;
import data.MenuVO;
import service.MenuService;

public class MenuServiceImpl implements MenuService{
	MenuDaoImpl MenuDao = new MenuDaoImpl();
	
	public MenuServiceImpl() { 
	}

	@Override
	public List<MenuVO> menuList() {
		try {
			return MenuDao.menuList();
		}catch(Exception e) {
				e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryVO> categoryList() {
		try {
			return MenuDao.categoryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<MenuVO> menuListByCategoryName(String categoryName) {
		try {
			return MenuDao.menuListByCategoryName(categoryName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
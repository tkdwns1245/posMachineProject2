package posMachineProject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import data.OrderDetailVO;
import data.ReceiptJoinedVO;
import posMachineProject.daoImpl.MenuDaoImpl;
import posMachineProject.service.MenuService;

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
	

	@Override
	public int insertItemDetail(int categoryNum, String menuName, int menuPrice, int sequence) {
		MenuVO menuVO = new MenuVO();
		try {
			menuVO.setCategory_num(categoryNum);
			menuVO.setMenuName(menuName);
			menuVO.setMenuPrice(menuPrice);
			menuVO.setSequence(sequence);
			menuVO.setCategory_num(categoryNum);
			MenuDao.insertItemDetail(menuVO);
			
			return 1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;		
	}

	@Override
	public int insertCategoryDetail(int num, String categoryName) {
		CategoryVO categoryVO = new CategoryVO();
		try {
			categoryVO.setNum(num);
			categoryVO.setCategoryName(categoryName);
			MenuDao.insertCategoryDetail(categoryVO);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;
	}

	@Override
	public int deleteItemDetail(String menuName) {
		MenuVO menuVO = new MenuVO();
		try {
			menuVO.setMenuName(menuName);
			MenuDao.deleteItemDetail(menuVO);
			
			return 1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;		
	}
	
	@Override
	public int deleteCategoryDetail(String categoryName) {
		CategoryVO categoryVO = new CategoryVO();
		try {
			categoryVO.setCategoryName(categoryName);
			MenuDao.deleteCategoryDetail(categoryVO);
			
			return 1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;		
	}



}

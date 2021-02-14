package service;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;

public interface MenuService {
	public abstract List<MenuVO> menuList(); 
	public abstract List<CategoryVO> categoryList(); 

}

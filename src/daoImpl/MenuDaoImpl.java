package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.MenuDao;
import dao.TableDao;
import data.CategoryVO;
import data.CountVO;
import data.MenuVO;
import data.TableVO;
import database.DatabaseUtil;
import database.VOFactory;

public class MenuDaoImpl implements MenuDao{
	
	final VOFactory voFactory = new VOFactory();
	@Override
	// 荑쇰━臾�,  MenuVO(由ъ뒪�듃)
	public List<MenuVO> menuList() throws Exception {
		StringBuffer sql=new StringBuffer();
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		sql.append("SELECT * ");
		sql.append("FROM posmachine.MENU ");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					MenuVO tmpMenuVO = new MenuVO();
					voFactory.setMenuVO(tmpMenuVO,rs);
					menuList.add(tmpMenuVO);
				}
			}
		}.execute();
		return menuList;
		
	}
	
	@Override
	public List<CategoryVO> categoryList() throws Exception {
		StringBuffer sql=new StringBuffer();
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		sql.append("SELECT * ");
		sql.append("FROM posmachine.MENU_CATEGORY ");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					CategoryVO tmpCategoryVO = new CategoryVO();
					voFactory.setCategoryVO(tmpCategoryVO, rs);
					categoryList.add(tmpCategoryVO);
				}
			}
		}.execute();
		return categoryList;
	}
	
	@Override
	public List<MenuVO> menuListByCategoryName(String categoryName) throws Exception {
		StringBuffer sql=new StringBuffer();
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		sql.append("SELECT m.* ");
		sql.append("FROM posmachine.MENU m ");
		sql.append("LEFT JOIN posmachine.MENU_CATEGORY mc ON m.category_num = mc.num ");
		sql.append("WHERE mc.category_name = ?");
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1,categoryName);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					MenuVO tmpMenuVO = new MenuVO();
					voFactory.setMenuVO(tmpMenuVO,rs);
					menuList.add(tmpMenuVO);
				}
			}
		}.execute();
		return menuList;
	}

}


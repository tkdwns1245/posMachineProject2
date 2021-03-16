package posMachineProject.daoImpl;

import java.util.ArrayList;
import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import data.OrderDetailVO;
import database.DatabaseUtil;
import database.VOFactory;
import posMachineProject.dao.MenuDao;

public class MenuDaoImpl implements MenuDao{
	
	final VOFactory voFactory = new VOFactory();
	@Override

	public List<MenuVO> menuList() throws Exception {
		StringBuffer sql=new StringBuffer();
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		sql.append("SELECT * ");
		sql.append("FROM posmachine.MENU ");
		sql.append("INNER JOIN posmachine.MENU_CATEGORY ON posmachine.MENU.category_num = posmachine.MENU_CATEGORY.num");

		
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

	@Override
//	public void insertItemDetailList(List<MenuVO> itemDetailList) throws Exception {
	public void insertItemDetail(MenuVO vo) throws Exception {
			StringBuffer sql=new StringBuffer();
			sql.append("INSERT INTO posmachine.MENU");
			sql.append("(category_num,menu_name,menu_price,sequence)");
			sql.append("VALUES (?,?,?,?)");
			new DatabaseUtil() {
				@Override
				public void query() throws Exception {
					// TODO Auto-generated method stub
					pstmt=con.prepareStatement(sql.toString());
					pstmt.setInt(1, vo.getCategory_num());
					pstmt.setString(2, vo.getMenuName());
					pstmt.setInt(3, vo.getMenuPrice());
					pstmt.setInt(4, vo.getSequence());
					pstmt.executeUpdate();					
				}
				
			}.execute();
		}
	
	
	public void insertCategoryDetail(CategoryVO vo) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("INSERT INTO posmachine.MENU_CATEGORY");
		sql.append("(num,category_name)");
		sql.append("VALUES (?,?)");
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setInt(1, vo.getNum());
				pstmt.setString(2, vo.getCategoryName());
				pstmt.executeUpdate();					
			}
			
		}.execute();
	}
	
	@Override
	public void deleteItemDetail(MenuVO vo) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("DELETE FROM ");
		sql.append("posmachine.MENU ");
		sql.append("WHERE menu_name= ?");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, vo.getMenuName());
				pstmt.executeUpdate();					
			}
			
		}.execute();
		
	}
	
	@Override
	public void deleteCategoryDetail(CategoryVO vo) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("DELETE FROM ");
		sql.append("posmachine.MENU_CATEGORY ");
		sql.append("WHERE category_name= ?");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, vo.getCategoryName());
				pstmt.executeUpdate();					
			}
			
		}.execute();
		
	}
}



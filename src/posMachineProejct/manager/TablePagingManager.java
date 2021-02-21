package posMachineProejct.manager;

public class TablePagingManager {
	TableManager tm;
	
	int totalTableCount;
	int pagePerTable;
	int totalPageCount;
	int curruntPage;
	int prevPage;
	int nextPage;
	public TablePagingManager(TableManager tm){
		this.tm = tm;
		init();
	}
	public void init() {
		totalTableCount = tm.countOfTables();
		pagePerTable = 20;
		totalPageCount =  totalTableCount / pagePerTable +1;
		curruntPage = 1;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public int getTotalTableCount() {
		return totalTableCount;
	}
	public int getCurruntPage() {
		return curruntPage;
	}
	public int getPagePerTable() {
		return pagePerTable;
	}
	public int getPrevPage() {
		int pageCount = curruntPage - 1;
		if(pageCount == 0)
		{
			this.curruntPage = totalPageCount;
		}else
		{
			this.curruntPage = pageCount;
		}
		return curruntPage;
	}
	public int getNextPage() {
		int pageCount = curruntPage + 1;
			if(pageCount > totalPageCount)
				this.curruntPage = pageCount % totalPageCount;
			else
				this.curruntPage = pageCount;
		return curruntPage;
	}
}

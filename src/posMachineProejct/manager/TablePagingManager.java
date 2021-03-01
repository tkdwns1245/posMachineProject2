package posMachineProejct.manager;

public class TablePagingManager {
	TableManager tm;
	
	int totalTableCount;
	int TablePerPage;
	int totalPageCount;
	int curruntPage;
	int prevPage;
	int nextPage;
	public TablePagingManager(TableManager tm){
		this.tm = tm;
		init();
	}
	public void init() {
		TablePerPage = 15;
		totalTableCount = tm.countOfTables();
		totalPageCount = ((totalTableCount-1) / TablePerPage) +1;
		curruntPage = 1;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount() {
		this.totalPageCount = ((totalTableCount-1) / TablePerPage) +1;
	}
	public int getTotalTableCount() {
		return totalTableCount;
	}
	public void setTotalTableCount(int totalTableCount) {
		this.totalTableCount = totalTableCount;
	}
	public int getCurruntPage() {
		return curruntPage;
	}
	public int getTablePerPage() {
		return TablePerPage;
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
	public int getLastPage() {
		this.curruntPage = this.totalPageCount;
	return curruntPage;
	}
}

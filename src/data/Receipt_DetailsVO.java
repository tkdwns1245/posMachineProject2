package data;

public class Receipt_DetailsVO {
	
	//RECEIPT_DETAILS DB
	
		private int rcNumber;
		private String menu_Category;
		private String menu_Name;
		private int menu_Price;
		private int numberOf;
		private int rowSum;
		private int rowCount;

		
		public int getRcNumber() {
			return rcNumber;
		}
		public void setRcNumber(int rcNumber) {
			this.rcNumber = rcNumber;
		}
		public String getMenu_Category() {
			return menu_Category;
		}
		public void setMenu_Category(String menu_Category) {
			this.menu_Category = menu_Category;
		}
		public String getMenu_Name() {
			return menu_Name;
		}
		public void setMenu_Name(String menu_Name) {
			this.menu_Name = menu_Name;
		}
		public int getMenu_Price() {
			return menu_Price;
		}
		public void setMenu_Price(int menu_Price) {
			this.menu_Price = menu_Price;
		}
		public int getNumberOf() {
			return numberOf;
		}
		public void setNumberOf(int numberOf) {
			this.numberOf = numberOf;
		}
		public int getRowSum() {
			return rowSum;
		}
		public void setRowSum(int rowSum) {
			this.rowSum = rowSum;
		}
		public int getRowCount() {
			return rowCount;
		}
		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

}
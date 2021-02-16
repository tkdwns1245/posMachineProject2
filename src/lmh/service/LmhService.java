package lmh.service;

public interface LmhService {
	
	public Object[][] CreateReceiptDetailJtableContents(int rcNumber);
	public Object[][] CreateReceiptJtableContents(int year,int month,int day);
	public void returnThisSale(int rcNumber);

}

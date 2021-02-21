package posMachineProject.service;

import java.util.List;

import data.ReceiptJoinedVO;

public interface SalesCalendarService {
	
	public int[] getEachMonthTotalSales(int year);
	public int[] getEachDayTotalSales(int year,int month,int lastday);
	public Object[][] getYearDetails(int year);
	public Object[][] getMonthDetails(int year,int month);
	public Object[][] getDayDetails(int year,int month, int day);
	public Object[][] CreateResultObject(List<ReceiptJoinedVO> rjVO);

}

package kukirun.manager;

import kukirun.serviceImpl.SalesCalendarServiceImpl;

public class SalesCalendarManager {

	SalesCalendarServiceImpl salecalendarserviceimpl=new SalesCalendarServiceImpl();
	
	public int[] getMonthTotalSales(int year) {
		return salecalendarserviceimpl.getEachMonthTotalSales(year);
	}
	
	public int[] getDayTotalSales(int year,int month,int lastday) {
		return salecalendarserviceimpl.getEachDayTotalSales(year,month,lastday);
	}
	
	public Object[][] getDayDetails(int year,int month, int day){
		return salecalendarserviceimpl.getDayDetails(year, month, day);
	}
	
	public Object[][] getYearDetails(int year){
		return salecalendarserviceimpl.getYearDetails(year);
	}
	
	public Object[][] getMonthDetails(int year,int month){
		return salecalendarserviceimpl.getMonthDetails(year,month);
	}
	
	
			
	
}

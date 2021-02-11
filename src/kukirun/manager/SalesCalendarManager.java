package kukirun.manager;

import kukirun.gui.SalesCalendar;

import kukirun.gui.Sales_Status;
import kukirun.service.SalesCalendarService;
import daoImpl.ReceiptDaoimpl;

public class SalesCalendarManager {

	SalesCalendarService salecalendarservice=new SalesCalendarService();
	
	public int[] getMonthTotalSales(int year) {
		return salecalendarservice.getEachMonthTotalSales(year);
	}
	
	public int[] getDayTotalSales(int year,int month,int lastday) {
		return salecalendarservice.getEachDayTotalSales(year,month,lastday);
	}
	
	public Object[][] getDayDetails(int year,int month, int day){
		return salecalendarservice.getDayDetails(year, month, day);
	}
	
	public Object[][] getYearDetails(int year){
		return salecalendarservice.getYearDetails(year);
	}
	
	public Object[][] getMonthDetails(int year,int month){
		return salecalendarservice.getMonthDetails(year,month);
	}
	
	
			
	
}

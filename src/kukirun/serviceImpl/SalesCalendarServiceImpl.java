package kukirun.serviceImpl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import daoImpl.ReceiptDaoimpl;
import data.ReceiptJoinedVO;
import kukirun.service.SalesCalendarService;

public class SalesCalendarServiceImpl implements SalesCalendarService {

	ReceiptDaoimpl receiptdaoimpl=new ReceiptDaoimpl();
	

	public int[] getEachMonthTotalSales(int year) {
		
		int[] TotalArray=new int[12];
		
		List<ReceiptJoinedVO> rjVO=receiptdaoimpl.selectJoinedReceiptTable();		
		
		for(ReceiptJoinedVO vo:rjVO) {
			if(Integer.valueOf(vo.getRegTime().toString().substring(0,4))==year) {
				TotalArray[Integer.valueOf(vo.getRegTime().toString().substring(5,7))-1] += vo.getRowSum();
			}
		}
		
		return TotalArray;
	}

	
	public int[] getEachDayTotalSales(int year,int month,int lastday) {
		
		int[] TotalArray=new int[lastday];

		List<ReceiptJoinedVO> rjVO=receiptdaoimpl.selectJoinedReceiptTable();		
		
		for(ReceiptJoinedVO vo:rjVO) {
			if ((Integer.valueOf(vo.getRegTime().toString().substring(0,4))==year) && (Integer.valueOf(vo.getRegTime().toString().substring(5,7))==month)) {
				TotalArray[Integer.valueOf(vo.getRegTime().toString().substring(8,10))-1] += vo.getRowSum();
			}
		}
		
		return TotalArray;
	}
	

	
	public Object[][] getYearDetails(int year){
		
		List<ReceiptJoinedVO> rjVO = new ArrayList<ReceiptJoinedVO>();
		
		DecimalFormat add0=new DecimalFormat("00");
		receiptdaoimpl.selectJoinedReceiptTable().stream().filter(vo->vo.getRegTime().toString().substring(0,4).equals(String.valueOf(year))).forEach(vo->rjVO.add(vo));

		Object[][] data = CreateResultObject(rjVO);		
		return data;
		
	}
	
	public Object[][] getMonthDetails(int year,int month){
		
		List<ReceiptJoinedVO> rjVO = new ArrayList<ReceiptJoinedVO>();
		
		DecimalFormat add0=new DecimalFormat("00");
		receiptdaoimpl.selectJoinedReceiptTable().stream().filter(vo->vo.getRegTime().toString().substring(0,7).equals(year+"-"+add0.format(month))).forEach(vo->rjVO.add(vo));

		Object[][] data = CreateResultObject(rjVO);		
		return data;
		
	}
	
	public Object[][] getDayDetails(int year,int month, int day){
		
		List<ReceiptJoinedVO> rjVO = new ArrayList<ReceiptJoinedVO>();
		
		DecimalFormat add0=new DecimalFormat("00");
		receiptdaoimpl.selectJoinedReceiptTable().stream().filter(vo->vo.getRegTime().toString().substring(0,10).equals(year+"-"+add0.format(month)+"-"+add0.format(day))).forEach(vo->rjVO.add(vo));

		Object[][] data = CreateResultObject(rjVO);		
		return data;
	}
	
	
	public Object[][] CreateResultObject(List<ReceiptJoinedVO> rjVO)
	{
		Object[][] object=new Object[receiptdaoimpl.getRowCount()][7];
		try {
			Object[] header = {"영수증 번호","메뉴 카테고리","메뉴","금액","개수","메뉴별 합 금액","총 금액"};	
			int i=0;
			
			for(ReceiptJoinedVO vo:rjVO) {
				
					for(int j=0;j<7;j++) {
						switch(j) {
							case 0:object[i][j]=vo.getRcNumber(); break;
							case 1:object[i][j]=vo.getMenu_Category(); break;
							case 2:object[i][j]=vo.getMenu_Name(); break;
							case 3:object[i][j]=vo.getMenu_Price(); break;
							case 4:object[i][j]=vo.getNumberOf(); break;
							case 5:object[i][j]=vo.getRowSum(); break;
							case 6:object[i][j]=vo.getSumPrice(); break;
							}
						
					}
				i++;
			}

				
			DecimalFormat addcomma=new DecimalFormat("###,###");
			
			i=0;
			for(ReceiptJoinedVO vo:rjVO) {
				for(int j=0; j<7; j++) {
				
					if(j==3 || j==5 || j==6) object[i][j]=addcomma.format(object[i][j]);
					if(i>0) if(j==6 && object[i-1][0]==object[i][0]) { //영수증 번호와 총 금액을 반복 출력하지 않기 위해
						object[i][0]=null;
						object[i][6]=null;
					}					
				}
				i++;				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}
	
	
			
	
}

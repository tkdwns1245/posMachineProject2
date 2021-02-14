package lmh.serviceimpl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import daoImpl.ReceiptDaoimpl;
import data.ReceiptJoinedVO;
import lmh.service.LmhService;

public class LmhServiceImpl implements LmhService{
	
	ReceiptDaoimpl receiptdaoimpl=new ReceiptDaoimpl();

	@Override
	public Object[][] CreateReceiptJtableContents(int year, int month, int day) {
		// TODO Auto-generated method stub
		List<ReceiptJoinedVO> rjVO=new ArrayList<ReceiptJoinedVO>();
		DecimalFormat add0=new DecimalFormat("00");
		receiptdaoimpl.selectJoinedReceiptTable().stream().filter(vo->vo.getRegTime().toString().substring(0,10).equals(year+"-"+add0.format(month)+"-"+add0.format(day))).forEach(vo->rjVO.add(vo));

		int count=0;
		int rcNumber=0;
		int index=-1;
		
		List<ReceiptJoinedVO> countedrjVO=new ArrayList<ReceiptJoinedVO>();
		for(ReceiptJoinedVO vo:rjVO) {	
			index++;
			if(rcNumber==vo.getRcNumber()) {
				continue;
			}
			rcNumber=vo.getRcNumber();
			count++;	
			countedrjVO.add(vo);
		}
		rjVO.clear();
		
		int row=count;
		int column=2;
		Object[][] data = new Object[row][column+1];	
		

		int i=0;
		for(ReceiptJoinedVO vo:countedrjVO) {

			for(int j=0;j<column+1;j++) {
					switch(j) {
					case 0:data[i][j]=vo.getSumPrice(); break;
					case 1:data[i][j]=vo.getRegTime(); break;
					case 2:data[i][j]=vo.getRcNumber(); break;
					}
			}
		i++;	
		}
		return data;
	}

	@Override
	public Object[][] CreateReceiptDetailJtableContents(int rcNumber) {
		// TODO Auto-generated method stub
		List<ReceiptJoinedVO> rjVO=new ArrayList<ReceiptJoinedVO>();
		DecimalFormat add0=new DecimalFormat("00");
		receiptdaoimpl.selectJoinedReceiptTable().stream().filter(vo->vo.getRcNumber()==rcNumber).forEach(vo->rjVO.add(vo));
		
		int row=rjVO.size();
		int column=3;
		
		Object[][] data=new Object[row][column];
		
		int i=0;
		for(ReceiptJoinedVO vo:rjVO) {

			for(int j=0;j<3;j++) {
					switch(j) {
					case 0:data[i][j]=vo.getMenu_Name(); break;
					case 1:data[i][j]=vo.getNumberOf(); break;
					case 2:data[i][j]=vo.getMenu_Price(); break;
					}
			}
		i++;	
		}
		
		return data;
	}

}

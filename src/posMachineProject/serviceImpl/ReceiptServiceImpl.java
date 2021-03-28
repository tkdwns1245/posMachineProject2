package posMachineProject.serviceImpl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import data.ReceiptJoinedVO;
import posMachineProject.daoImpl.ReceiptDaoimpl;
import posMachineProject.service.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService{
	ReceiptDaoimpl ReceiptDao = new ReceiptDaoimpl();
	
	public ReceiptServiceImpl() { 
	}

	@Override
	public List<ReceiptJoinedVO> selectJoinedReceiptTable() {
		try {
			return ReceiptDao.selectJoinedReceiptTable();
		}catch(Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Object[][] CreateReceiptJtableContents(int year, int month, int day) {
		// TODO Auto-generated method stub
		List<ReceiptJoinedVO> rjVO=new ArrayList<ReceiptJoinedVO>();
		DecimalFormat add0=new DecimalFormat("00");
		ReceiptDao.selectJoinedReceiptTable().stream().filter(vo->vo.getRegTime().toString().substring(0,10).equals(year+"-"+add0.format(month)+"-"+add0.format(day))).forEach(vo->rjVO.add(vo)); // 날짜에 맞는 vo를 필터링
	
		int count=0;
		int rcNumber=0;
		int index=-1;
		
		List<ReceiptJoinedVO> countedrjVO=new ArrayList<ReceiptJoinedVO>(); //중복 제거
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
		Object[][] data = new Object[row][column+2];	
		

		int i=0;
		for(ReceiptJoinedVO vo:countedrjVO) {

			for(int j=0;j<column+2;j++) {
					switch(j) {
					case 0:data[i][j]=vo.getSumPrice(); break;
					case 1:data[i][j]=vo.getRegTime().toString().substring(0, 16); break;
					case 2:data[i][j]=vo.getRcNumber(); break;
					case 3:data[i][j]=vo.getStatus(); break;
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
		ReceiptDao.selectJoinedReceiptTable().stream().filter(vo->vo.getRcNumber()==rcNumber).forEach(vo->rjVO.add(vo)); //rcNumer로 필터링
		
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

	@Override
	public void returnThisSale(int rcNumber) {
		// TODO Auto-generated method stub
		ReceiptDao.returnThisSale(rcNumber);
		
	}
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertReceiptAndReceiptDetail(Object[][] payItems,String payType, int totalPrice) {
		ReceiptDao.insertReceiptAndReceiptDetail(payItems,payType,totalPrice);
	}

}
package com.ygode.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygode.common.result.JsonResult;
import com.ygode.dao.BattleManageCustomMapper;
import com.ygode.bean.BattleManageCustom;
import com.ygode.Service.BattleManageService;

@Service
public class BattleManageServiceImpl implements BattleManageService {

	@Autowired
	private BattleManageCustomMapper battleManageCustomMapper;
	@Override
	public BattleManageCustom findBattling(String insertState) {
		BattleManageCustom battleManageCustom = null;
		List<BattleManageCustom> bList = battleManageCustomMapper.findBattling(insertState);
		if (bList.size()<=0) {
			battleManageCustom =  new BattleManageCustom();
		}else{
			for (BattleManageCustom battleManageCustom2 : bList) {
				if (battleManageCustom2.getState() == 1) {
					battleManageCustom = battleManageCustom2;
					break;
				}else{
					battleManageCustom =  new BattleManageCustom();
				}
			}
		}
		return battleManageCustom;
	}
	@Override
	public JsonResult detailedList1(String insertState) {
		JsonResult jsonResult = new JsonResult();
		 List<BattleManageCustom> bcmList = battleManageCustomMapper.detailedList1(insertState);
		if (insertState!=null) {
			if (Integer.parseInt(insertState)==1) {
				for (BattleManageCustom bList : bcmList) {
					if (bList.getTicketOne()!=null) {
						bList.setScoreTotal1(100 - 2*bList.getTicketOne());
					}else{
						bList.setTicketOne(0);
						bList.setScoreTotal1(0);
					}
					if (bList.getTicketTwo()!=null) {
						bList.setScoreTotal2(100 - 2*bList.getTicketTwo());
					}else{
						bList.setTicketTwo(0);
						bList.setScoreTotal2(0);
					}
					
				}
			}
			
		}
		
		 jsonResult.setObj(bcmList);
		 return jsonResult;
	}
	@Override
	public JsonResult detailedList2(String insertState) {
		JsonResult jsonResult = new JsonResult();
		 List<BattleManageCustom> bcmList = battleManageCustomMapper.detailedList2(insertState);
		 jsonResult.setObj(bcmList);
		 return jsonResult;
	}

}

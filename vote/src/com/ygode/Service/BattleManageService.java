package com.ygode.Service;


import com.ygode.common.result.JsonResult;
import com.ygode.bean.BattleManageCustom;

public interface BattleManageService {
	//查看是否有可以投票的比赛
	BattleManageCustom findBattling(String insertState);
	
	//倒票比赛清单
	JsonResult detailedList1(String insertState);
	//正票比赛清单
	JsonResult detailedList2(String insertState);
}

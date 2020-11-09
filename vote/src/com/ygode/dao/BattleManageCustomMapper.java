package com.ygode.dao;


import java.util.List;
import com.ygode.bean.BattleManageCustom;

public interface BattleManageCustomMapper {
    //查看是否有可以投票的比赛
    List<BattleManageCustom> findBattling(String insertState);
    
    //倒票比赛清单
    List<BattleManageCustom> detailedList1(String insertState);
    //正票比赛清单
    List<BattleManageCustom> detailedList2(String insertState);
}
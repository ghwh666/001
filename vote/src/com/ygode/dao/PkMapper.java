package com.ygode.dao;

import com.ygode.bean.BattleManageVo;
import com.ygode.bean.VoteVo;

import java.util.List;

/**
 * Created by XiaoBingBy on 2017/2/20.
 */
public interface PkMapper {

    /**
     * 查询pk页面当前投票信息
     * @return
     */
    BattleManageVo findBattleManageStateInfo();
    
    /**
     * 查询pk页面当前投票信息
     * @return
     */
    BattleManageVo findBattleManageStateInfoPk2();

    /**
     * 查询出选手投票的分数
     * @param value
     * @return
     */
    List<VoteVo> findCountVoteVo(Integer value);

    BattleManageVo findPK3();
    
    int findPK3TicketOne(Integer value);
    
    int findPK3TicketOneNew(Integer value);

}

package com.ygode.dao;

import com.ygode.bean.BattleManage;

public interface BattleManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BattleManage record);

    int insertSelective(BattleManage record);

    BattleManage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BattleManage record);

    int updateByPrimaryKey(BattleManage record);
}
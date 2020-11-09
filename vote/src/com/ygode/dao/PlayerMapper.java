package com.ygode.dao;

import com.ygode.bean.Player;

public interface PlayerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Player record);

    int insertSelective(Player record);

    Player selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKeyWithBLOBs(Player record);

    int updateByPrimaryKey(Player record);
}
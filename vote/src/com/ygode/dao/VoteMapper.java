package com.ygode.dao;

import com.ygode.bean.Vote;
import com.ygode.bean.VoteKey;

public interface VoteMapper {
    int deleteByPrimaryKey(VoteKey key);

    int insert(Vote record);

    int insertSelective(Vote record);

    Vote selectByPrimaryKey(VoteKey key);

    int updateByPrimaryKeySelective(Vote record);

    int updateByPrimaryKey(Vote record);
}
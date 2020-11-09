package com.ygode.Service;

import com.ygode.bean.Vote;
import com.ygode.bean.VoteKey;

/**
 * 投票的service
 * @author hedonglin
 *
 */
public interface VoteService {
	//插入投一张票的记录
	int insert(Vote vote);
	
	//主键查询
	Vote selectByPrimaryKey(VoteKey key);
}

package com.ygode.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygode.dao.VoteMapper;
import com.ygode.bean.Vote;
import com.ygode.bean.VoteKey;
import com.ygode.Service.VoteService;
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteMapper voteMapper;
	
	public int insert(Vote vote) {
		
		return voteMapper.insert(vote);
	}

	public Vote selectByPrimaryKey(VoteKey key) {
		return voteMapper.selectByPrimaryKey(key);
	}

}

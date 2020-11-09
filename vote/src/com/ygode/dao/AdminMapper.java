package com.ygode.dao;

import com.ygode.bean.BattleManage;
import com.ygode.bean.BattleManageVo;
import com.ygode.bean.Player;
import com.ygode.bean.Vote;
import com.ygode.bean.VoteVo;
import com.ygode.bean.users;

import java.util.List;

/**
 * Created by XiaoBingBy on 2017/2/20.
 */
public interface AdminMapper {

    /**
     * 查询所有选手信息
     * @return
     */
    List<Player> findAllPlayer();
    
    /**
     * 按条件查询所有选手信息
     * @return
     */
    List<Player> findAllPlayerPlus(Player player);

    /**
     * 添加选手进行投票
     * @param battleManage
     * @return
     */
    int addBattleManage(BattleManage battleManage);

    /**
     * 查询所有投票选手
     * @return
     */
    List<BattleManageVo> findAllBattleManageVo();
    
    /**
     * 打开投票通道
     * @return
     */
    int updateBattleOpen(Integer id);
    /**
     * 关闭投票通道
     * @return
     */
    int updateBattleClose(BattleManage battleManage);
    /**
     * 查看所有比赛状态
     * @return
     */
    List<BattleManage> findAllBattleManage();
    
    /**
     * 统计票数
     * @return
     */
    List<VoteVo> findCountVote(Integer id);
    /**
     * 查找当前比赛
     * @return
     */
    BattleManage findBattleManage(Integer id);
    
    /**
     *添加比赛分数
     * @return
     */
    int addScore(BattleManage battleManage);
    
    /**
     * 暂停投票
     * @param battleManage
     * @return
     */
    int updateStopBattle(BattleManage battleManage);

    /**
     *用户查询
     * @return
     */
	users findusers(users users);

	/**
     *选手状态跟改
     * @return
     */
	int updatePlayerStatus(Player player);

	/**
     *查询当前赛季比赛
     * @return
     */
	List<BattleManage> findAllBM(int Mattch);

	/**
     *查询当前赛季
     * @return
     */
	int findMattch();
	
	/**
     *添加用户
     * @return
     */
	boolean addUser(users user);

	/**
     *歌曲和背景
     * @return
     */
	boolean addBM(BattleManage battleManage);
	/**
     *添加选手
     * @return
     */
	boolean addPlayer(Player player);

	boolean upPlayer(Player player);

	int updataPlayerIDsl(int playerSl);

	int updataBM(BattleManage battleManage);
}

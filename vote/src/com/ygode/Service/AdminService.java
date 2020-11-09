package com.ygode.Service;

import com.ygode.common.result.JsonResult;
import com.github.pagehelper.PageInfo;
import com.ygode.bean.BattleManage;
import com.ygode.bean.Player;
import com.ygode.bean.Vote;
import com.ygode.bean.VoteVo;
import com.ygode.bean.users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XiaoBingBy on 2017/2/20.
 */
public interface AdminService {

    /**
     * 查询所有选手信息
     * @return
     */
    public PageInfo findAllPlayer(Integer pn);

    /**
     * 查询用户信息
     * @return
     */
    public users findusers(users users);
    
    /**
     * 添加选手进行投票
     * @param battleManage
     * @return
     */
    public JsonResult addBattleManage(BattleManage battleManage);
    

    /**
     * 自动添加选手进行投票
     * @return
     */
    public JsonResult addBattleManage();
    
    /**
     * 查询所有投票选手
     * @return
     */
    public JsonResult findAllBattleManageVo();
    
    /**
     * 打开投票通道
     * @return
     */
    public JsonResult updateBattleOpen(Integer id);
    /**
     * 关闭投票通道
     * @return
     */
    public JsonResult updateBattleClose(Integer id);
    /**
     * 查看所有比赛状态
     * @param pn 
     * @return
     */
    public PageInfo findAllBattleManage(Integer pn);
    /**
     * 统计票数
     * @return
     */
    public List<VoteVo> findCountVote(Integer id);
    /**
     * 查找当前比赛
     * @return
     */
    public BattleManage findBattleManage(Integer id);
    /**
     *添加比赛分数
     * @return
     */
    public JsonResult addScore(BattleManage battleManage);
    
    /**
     * 暂停投票
     * @param id
     * @return
     */
    public JsonResult updateStopBattle(Integer id);

    /**
     * 查询当前比赛
     * @param id
     * @return
     */
	public PageInfo findAllBM(Integer pn);
	
	/**
     * 查询是否存在打开的通道
     * @param id
     * @return
     */
	public Boolean Success();
	
	/**
     * 查询当前赛季
     * @param id
     * @return
     */
	public int findMattch();

	public JsonResult addUser(users user);

	public JsonResult addBM(HttpServletRequest request,BattleManage battleManage);

	public JsonResult addPlayer(HttpServletRequest request, Player player);

	public JsonResult upPlayer(Player player);

	int findshezhe(Integer id);

	void findCountVote2(Integer id);

    
}

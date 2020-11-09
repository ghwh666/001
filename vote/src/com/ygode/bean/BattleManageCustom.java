package com.ygode.bean;

/**
 * 对战表的扩展类，包含对战歌手的全部信息
 * @author hedonglin
 *
 */
public class BattleManageCustom extends BattleManage {
	private Player player1;//歌手名_1
	private Player player2;//歌手名_2
	private Integer scoreTotal1;//歌手1分数
	private Integer scoreTotal2;//歌手名2分数
	private Integer scoreWin;  //比赛场次
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Integer getScoreTotal1() {
		return scoreTotal1;
	}
	public void setScoreTotal1(Integer scoreTotal1) {
		this.scoreTotal1 = scoreTotal1;
	}
	public Integer getScoreTotal2() {
		return scoreTotal2;
	}
	public void setScoreTotal2(Integer scoreTotal2) {
		this.scoreTotal2 = scoreTotal2;
	}
	public Integer getScoreWin() {
		return scoreWin;
	}
	public void setScoreWin(Integer scoreWin) {
		this.scoreWin = scoreWin;
	}
	
	
	
}

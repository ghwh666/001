package com.ygode.bean;

import java.util.Date;

public class BattleManage {
	private Integer id;

	private String playerOne;  //歌手名_1

	private String songOne;  //歌曲_1
	
	private Integer playerOneID;  //歌手1ID

	private Integer ticketOne;  //票数 插入状态3 赞成票

	private Integer scoreOne;  //评委分数

	private String playerTwo;  //歌手名_2

	private String songTwo; //歌曲_2
	
	private Integer playerTwoID;  //歌手2ID

	private Integer ticketTwo;  //票数 插入状态3 赞成票

	private Integer scoreTwo;  //评委分数

	private String url; //场次背景

	private Integer state;  //投票是否开启

	private Integer insertState; // 当前比赛状态

	private Date createDate; //比赛时间
	
	private Integer Mattch; //比赛场次

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(String playerOne) {
		this.playerOne = playerOne;
	}

	public String getSongOne() {
		return songOne;
	}

	public void setSongOne(String songOne) {
		this.songOne = songOne;
	}

	public Integer getTicketOne() {
		return ticketOne;
	}

	public void setTicketOne(Integer ticketOne) {
		this.ticketOne = ticketOne;
	}

	public Integer getScoreOne() {
		return scoreOne;
	}

	public void setScoreOne(Integer scoreOne) {
		this.scoreOne = scoreOne;
	}

	public String getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(String playerTwo) {
		this.playerTwo = playerTwo;
	}

	public String getSongTwo() {
		return songTwo;
	}

	public void setSongTwo(String songTwo) {
		this.songTwo = songTwo;
	}

	public Integer getTicketTwo() {
		return ticketTwo;
	}

	public void setTicketTwo(Integer ticketTwo) {
		this.ticketTwo = ticketTwo;
	}

	public Integer getScoreTwo() {
		return scoreTwo;
	}

	public void setScoreTwo(Integer scoreTwo) {
		this.scoreTwo = scoreTwo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getInsertState() {
		return insertState;
	}

	public void setInsertState(Integer insertState) {
		this.insertState = insertState;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getMatch() {
		return Mattch;
	}

	public void setMatch(Integer match) {
		Mattch = match;
	}

	public Integer getPlayerOneID() {
		return playerOneID;
	}

	public void setPlayerOneID(Integer playerOneID) {
		this.playerOneID = playerOneID;
	}

	public Integer getPlayerTwoID() {
		return playerTwoID;
	}

	public void setPlayerTwoID(Integer playerTwoID) {
		this.playerTwoID = playerTwoID;
	}

	@Override
	public String toString() {
		return "BattleManage [id=" + id + ", playerOne=" + playerOne + ", songOne=" + songOne + ", playerOneID="
				+ playerOneID + ", ticketOne=" + ticketOne + ", scoreOne=" + scoreOne
				+ ", playerTwo=" + playerTwo + ", songTwo=" + songTwo + ", playerTwoID=" + playerTwoID + ", ticketTwo="
				+ ticketTwo + ", scoreTwo=" + scoreTwo + ", url=" + url + ", state="
				+ state + ", insertState=" + insertState + ", createDate=" + createDate + ", Match=" + Mattch + "]";
	}

}
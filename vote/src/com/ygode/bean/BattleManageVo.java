package com.ygode.bean;

import java.util.Date;

/**
 * 对战表的扩展类，包含对战歌手的基本信息
 * @author hedonglin
 *
 */
public class BattleManageVo extends BattleManage {

    private String playerOneName;//歌手名_1

    private String playerTwoName;//歌手名_2

    private String playerOneImg;//歌手1图片

    private String playerTwoImg;//歌手2图片
    
    private Integer id;

	private String songOne;  //歌曲_1
	
	private Integer playerOneID;  //歌手1ID

	private Integer ticketOne;  //票数 插入状态3 赞成票

	private Integer scoreOne;  //评委分数

	private String songTwo; //歌曲_2
	
	private Integer playerTwoID;  //歌手2ID

	private Integer ticketTwo;  //票数 插入状态3 赞成票

	private Integer scoreTwo;  //评委分数

	private String url; //场次背景

	private Integer state;  //投票是否开启

	private Integer insertState; // 当前比赛状态

	private Date createDate; //比赛时间
	
	private Integer Mattch; //比赛场次


    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public String getPlayerOneImg() {
        return playerOneImg;
    }

    public void setPlayerOneImg(String playerOneImg) {
        this.playerOneImg = playerOneImg;
    }

    public String getPlayerTwoImg() {
        return playerTwoImg;
    }

    public void setPlayerTwoImg(String playerTwoImg) {
        this.playerTwoImg = playerTwoImg;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSongOne() {
		return songOne;
	}

	public void setSongOne(String songOne) {
		this.songOne = songOne;
	}

	public Integer getPlayerOneID() {
		return playerOneID;
	}

	public void setPlayerOneID(Integer playerOneID) {
		this.playerOneID = playerOneID;
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

	public String getSongTwo() {
		return songTwo;
	}

	public void setSongTwo(String songTwo) {
		this.songTwo = songTwo;
	}

	public Integer getPlayerTwoID() {
		return playerTwoID;
	}

	public void setPlayerTwoID(Integer playerTwoID) {
		this.playerTwoID = playerTwoID;
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

	public Integer getMattch() {
		return Mattch;
	}

	public void setMattch(Integer mattch) {
		Mattch = mattch;
	}

	@Override
	public String toString() {
		return "BattleManageVo [playerOneName=" + playerOneName + ", playerTwoName=" + playerTwoName + ", playerOneImg="
				+ playerOneImg + ", playerTwoImg=" + playerTwoImg + ", BattleManageid=" + id + ", songOne=" + songOne
				+ ", playerOneID=" + playerOneID + ", ticketOne=" + ticketOne + ", scoreOne=" + scoreOne + ", songTwo="
				+ songTwo + ", playerTwoID=" + playerTwoID + ", ticketTwo=" + ticketTwo + ", scoreTwo=" + scoreTwo
				+ ", url=" + url + ", state=" + state + ", insertState=" + insertState + ", createDate=" + createDate
				+ ", Mattch=" + Mattch + "]";
	}
    
    
}

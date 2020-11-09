package com.ygode.bean;

public class PkVo {

    private Integer battleManageId; //比赛场次

    private String playerOne; //歌手名_1

    private String playerOneImg; //歌手1图片

    private Integer ticketOne; //票数 插入状态3 赞成票

    private Integer scoreOne;  //评委分数

    private String playerTwo;//歌手名_2

    private String playerTwoImg;//歌手2图片

    private Integer ticketTwo;//票数 插入状态3 赞成票

    private Integer scoreTwo; //评委分数

    private Integer insertState; //场次状态

    public Integer getBattleManageId() {
        return battleManageId;
    }

    public void setBattleManageId(Integer battleManageId) {
        this.battleManageId = battleManageId;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerOneImg() {
        return playerOneImg;
    }

    public void setPlayerOneImg(String playerOneImg) {
        this.playerOneImg = playerOneImg;
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

    public String getPlayerTwoImg() {
        return playerTwoImg;
    }

    public void setPlayerTwoImg(String playerTwoImg) {
        this.playerTwoImg = playerTwoImg;
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

    public Integer getInsertState() {
        return insertState;
    }

    public void setInsertState(Integer insertState) {
        this.insertState = insertState;
    }
}

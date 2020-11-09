package com.ygode.bean;

public class Player {
    private Integer id;

    private String playerName;

    private String playerImg;
    
    private Integer playerStatus;
    
    private String PS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName == null ? null : playerName.trim();
    }

    public String getPlayerImg() {
        return playerImg;
    }

    public void setPlayerImg(String playerImg) {
        this.playerImg = playerImg == null ? null : playerImg.trim();
    }

	public String getPlayer_status() {
		return playerStatus==1?"未参赛":playerStatus==0?"参赛中":playerStatus==2?"淘汰":"停赛中";
	}

	public void setPlayer_status(Integer player_status) {
		this.playerStatus = player_status;
	}

	public String getPS() {
		return PS;
	}

	public void setPS(String pS) {
		PS = pS;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", playerImg=" + playerImg
				+ ", player_status=" + playerStatus + ", PS=" + PS + "]";
	}
    
    
}
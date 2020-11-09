package com.ygode.bean;

public class Vote extends VoteKey {
	
	private Integer battle_manage_id;
	private String user_session;
    private String player;
    private Integer ticket;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player == null ? null : player.trim();
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

	public Integer getBattle_manage_id() {
		return battle_manage_id;
	}

	public void setBattle_manage_id(Integer battle_manage_id) {
		this.battle_manage_id = battle_manage_id;
	}

	public String getUser_session() {
		return user_session;
	}

	public void setUser_session(String user_session) {
		this.user_session = user_session;
	}

	@Override
	public String toString() {
		return "Vote [battle_manage_id=" + battle_manage_id + ", user_session=" + user_session + ", player=" + player
				+ ", ticket=" + ticket + "]";
	}
    
}
package com.ygode.bean;

public class VoteVo extends Vote {
	private String player;
	private Integer ticket;
    private Integer ticketNew;

    public Integer getTicketNew() {
        return ticketNew;
    }

    public void setTicketNew(Integer ticketNew) {
        this.ticketNew = ticketNew;
    }

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Integer getTicket() {
		return ticket;
	}

	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "VoteVo [player=" + player + ", ticket=" + ticket + ", ticketNew=" + ticketNew + "]";
	}
    
}
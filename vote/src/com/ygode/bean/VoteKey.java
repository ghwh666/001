package com.ygode.bean;

public class VoteKey {
    private Integer battleManageId;

    private String userSession;

    public Integer getBattleManageId() {
        return battleManageId;
    }

    public void setBattleManageId(Integer battleManageId) {
        this.battleManageId = battleManageId;
    }

    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession == null ? null : userSession.trim();
    }
}
package com.ygode.Service.impl;

import com.ygode.common.result.JsonResult;
import com.ygode.dao.PkMapper;
import com.ygode.bean.BattleManageVo;
import com.ygode.bean.PkVo;
import com.ygode.bean.VoteVo;
import com.ygode.Service.PkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XiaoBingBy on 2017/2/20.
 */
@Service
public class PkServiceImpl implements PkService {

    @Autowired
    private PkMapper pkDao;

    /**
     * 查询pk页面当前投票信息
     */
    public BattleManageVo findThisBattleManageStateInfo() {

        BattleManageVo battleManageStateInfo = pkDao.findBattleManageStateInfo();

        return battleManageStateInfo;
    }

    @Override
    public JsonResult pk1Api() {
        JsonResult jsonResult = new JsonResult();
        PkVo pkVo = null;

        try {
            pkVo = new PkVo();
            BattleManageVo battleManageStateInfo = pkDao.findBattleManageStateInfo();
            List<VoteVo> countVoteVo = pkDao.findCountVoteVo(battleManageStateInfo.getId());

            pkVo.setBattleManageId(battleManageStateInfo.getId());

            pkVo.setPlayerOne(battleManageStateInfo.getPlayerOne());
            pkVo.setPlayerOneImg(battleManageStateInfo.getPlayerOneImg());

            pkVo.setPlayerTwo(battleManageStateInfo.getPlayerTwo());
            pkVo.setPlayerTwoImg(battleManageStateInfo.getPlayerTwoImg());

            pkVo.setInsertState(battleManageStateInfo.getInsertState());

            for (VoteVo item : countVoteVo) {
                if (item.getPlayer().equals(battleManageStateInfo.getPlayerOne())) {
                    pkVo.setTicketOne(item.getTicketNew());
                } else {
                    pkVo.setTicketTwo(item.getTicketNew());
                }
            }

            jsonResult.setObj(pkVo);
            jsonResult.setSuccess(true);
        } catch (Exception e) {
            System.out.println(e);
            jsonResult.setMsg("网络连接中断!");
            jsonResult.setSuccess(false);
        }

        return jsonResult;
    }

    @Override
    public JsonResult pk2Api() {
        JsonResult jsonResult = new JsonResult();
        PkVo pkVo = null;

        try {
            pkVo = new PkVo();
            BattleManageVo battleManageStateInfo = pkDao.findBattleManageStateInfoPk2();
            List<VoteVo> countVoteVo = pkDao.findCountVoteVo(battleManageStateInfo.getId());

            pkVo.setBattleManageId(battleManageStateInfo.getId());

            /**
             * 选手1信息
             */
            pkVo.setPlayerOne(battleManageStateInfo.getPlayerOne());
            pkVo.setPlayerOneImg(battleManageStateInfo.getPlayerOneImg());
            pkVo.setScoreOne(battleManageStateInfo.getScoreOne());

            /**
             * 选手2信息
             */
            pkVo.setPlayerTwo(battleManageStateInfo.getPlayerTwo());
            pkVo.setPlayerTwoImg(battleManageStateInfo.getPlayerTwoImg());
            pkVo.setScoreTwo(battleManageStateInfo.getScoreTwo());

            pkVo.setInsertState(battleManageStateInfo.getInsertState());

            for (VoteVo item : countVoteVo) {
                if (item.getPlayer().equals(battleManageStateInfo.getPlayerOne())) {
                    pkVo.setTicketOne(item.getTicketNew());
                } else {
                    pkVo.setTicketTwo(item.getTicketNew());
                }
            }

            jsonResult.setObj(pkVo);
            jsonResult.setSuccess(true);
        } catch (Exception e) {
            System.out.println(e);
            jsonResult.setMsg("网络连接中断!");
            jsonResult.setSuccess(false);
        }

        return jsonResult;
    }

    @Override
    public JsonResult findPK3() {

        JsonResult jsonResult = new JsonResult();
        BattleManageVo pk3 = pkDao.findPK3();
        
        pk3.setTicketOne(pkDao.findPK3TicketOne(pk3.getId()));
        
        pk3.setTicketTwo(pkDao.findPK3TicketOneNew(pk3.getId()));
        
        jsonResult.setObj(pk3);
        jsonResult.setSuccess(true);

        return jsonResult;
    }
}

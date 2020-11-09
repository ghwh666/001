package com.ygode.Service;

import com.ygode.common.result.JsonResult;
import com.ygode.bean.BattleManageVo;
import com.ygode.bean.Vote;

/**
 * Created by XiaoBingBy on 2017/2/20.
 */
public interface PkService {

    /**
     * 查询pk页面当前投票信息
     * @return
     */
    public BattleManageVo findThisBattleManageStateInfo();

    public JsonResult pk1Api();

    public JsonResult pk2Api();

    public JsonResult findPK3();

}

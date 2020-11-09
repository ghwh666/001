package com.ygode.Controller;

import com.ygode.common.result.JsonResult;
import com.ygode.bean.BattleManageVo;
import com.ygode.bean.Vote;
import com.ygode.bean.VoteKey;
import com.ygode.Service.AdminService;
import com.ygode.Service.PkService;
import com.ygode.Service.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PkController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private PkService pkService;
    @Autowired
    private VoteService vsService;

    /*@RequestMapping(value = "index.html")
    public String pkIndex() {

        BattleManageVo thisBattleManageStateInfo = pkService.findThisBattleManageStateInfo();
        if(thisBattleManageStateInfo == null) {
            return "pk/demo";
        }
        Integer insertState = thisBattleManageStateInfo.getInsertState();
        
        if (insertState == 1) {

            return "pk/pk1";
        } else if (insertState == 2 || thisBattleManageStateInfo.getState() == 3) {

            return "pk/pk2";
        } else if (insertState == 3) {

            return "pk/pk3";
        }

        return "pk/demo";
    }*/

    /**
     * 查询当前状态来跳转页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findthispkinsertstate")
    public Integer findThisPkInsertState() {

        BattleManageVo thisBattleManageStateInfo = pkService.findThisBattleManageStateInfo();
        if (thisBattleManageStateInfo == null) {
            return 0;
        }

        return 1;
    }

    @ResponseBody
    @RequestMapping(value = "/fintbattlemanagestateinfo", method = RequestMethod.GET)
    public JsonResult fintBattleManageStateInfo() {

        JsonResult jsonResult = pkService.pk1Api();

        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/pk2api")
    public JsonResult pk2Api() {

        JsonResult jsonResult = pkService.pk2Api();

        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/pk3api")
    public JsonResult pk3Api() {

        JsonResult pk3 = pkService.findPK3();
        return pk3;
    }

    /**
     * 关闭投票通道
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/closeBattle/{id}")
    public JsonResult closeBattle(@PathVariable Integer id) {

        JsonResult jsonResult = adminService.updateBattleClose(id);

        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "chaxunBm")
    public BattleManageVo pkIndex() {
        BattleManageVo thisBattleManageStateInfo = pkService.findThisBattleManageStateInfo();
        return thisBattleManageStateInfo;
    }
    
    @ResponseBody
    @RequestMapping(value = "toupiao")
    public int toupiao(Vote vote) {
    	System.out.println(vote);
    	VoteKey key = new VoteKey();
    	key.setBattleManageId(vote.getBattle_manage_id());
    	key.setUserSession(vote.getUser_session());
    	if(vsService.selectByPrimaryKey(key) == null) {
    	vote.setTicket(1);
    	int jsonResult = vsService.insert(vote);
    	adminService.findCountVote2(vote.getBattle_manage_id());
        return jsonResult;
        }else {
        	return 0;
        }
    }

}

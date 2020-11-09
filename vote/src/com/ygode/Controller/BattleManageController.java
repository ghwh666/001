package com.ygode.Controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ygode.common.result.JsonResult;
import com.ygode.bean.BattleManageCustom;
import com.ygode.Service.AdminService;
import com.ygode.Service.BattleManageService;

@Controller
@RequestMapping("/vote")
public class BattleManageController {
	@Autowired
	private BattleManageService battleManageService;
	private AdminService adminService;
	/**
	 * 跳转到对战清单页面
	 */
	@RequestMapping(value = "/todetailedList1")
    public Boolean detailedList1() {
		Boolean detailedList1 = adminService.Success();
        return detailedList1;
    }
	/**
	 * 跳转到对战清单页面
	 */
	@RequestMapping(value = "/todetailedList3")
    public String detailedList3() {
        return "/detailedList/detailedList3";
    }
	/**
	 * 查询对战的比赛
	 * @return
	 */
	@RequestMapping("/findBattling")
	@ResponseBody
	public BattleManageCustom findBattling(String insertState){
		BattleManageCustom battleManageCustom = battleManageService.findBattling(insertState);
		return battleManageCustom;
	}
	
	@RequestMapping("/detailedList1")
	@ResponseBody
	public JsonResult detailedList(@RequestBody String insertState){
		JsonResult bmcList = battleManageService.detailedList1(insertState);
		return bmcList;
	}
	@RequestMapping("/detailedList2")
	@ResponseBody
	public JsonResult detailedList2(@RequestBody String insertState){
		JsonResult bmcList = battleManageService.detailedList2(insertState);
		return bmcList;
	}
}

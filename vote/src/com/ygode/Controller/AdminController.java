package com.ygode.Controller;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.ygode.bean.BattleManage;
import com.ygode.bean.Player;
import com.ygode.common.result.JsonResult;
import com.ygode.bean.users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygode.Service.AdminService;

/**
 * Created by XiaoBingBy on 2017/2/10.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    private static users userzj;
    
    /*登录验证
	 * return 
	 * */
	@RequestMapping("/denglu")
	@ResponseBody
	public ModelAndView dlyz(String uname,String pwd){
		users user = new users();
		user.setUsername(uname);
		user.setUser_pass(pwd);
			userzj = adminService.findusers(user);
			if( userzj !=null && userzj.getUser_right() == 1) {
				return new ModelAndView("_admin/logo","user",userzj);
			}else if(userzj !=null || userzj.getUser_right() != 1){
				return new ModelAndView("login");
			}{
				return new ModelAndView("login");	
			}
		
	}
	/*跳转
	 * return 
	 * */
	@RequestMapping("/top")
	@ResponseBody
	public ModelAndView top(){
		
		return new ModelAndView("_admin/top");	
	}
	/*跳转schedule页面
	 * return 
	 * */
	@RequestMapping("/schedule")
	@ResponseBody
	public ModelAndView schedule(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
		PageInfo page =adminService.findAllBM(pn);
		return new ModelAndView("_admin/schedule","page",page);	
	}
    /**
     * 查询所有选手信息
     * @return
     */
    @RequestMapping(value = "/admin")
    public ModelAndView admin(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
    	// TODO Auto-generated method stub
    	PageInfo page =adminService.findAllPlayer(pn);
        return new ModelAndView("_admin/select","page",page);
    }

    /**
     * 添加选手进行参赛
     * @param battleManage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addbattlemanage")
    public JsonResult addBattleManage(BattleManage battleManage) {

        JsonResult jsonResult = adminService.addBattleManage(battleManage);

        return jsonResult;
    }
    

    /**
     * 自动添加选手进行参赛
     * @param battleManage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addbattlemanages")
    public JsonResult addBattleManage() {

        JsonResult jsonResult = adminService.addBattleManage();

        return jsonResult;
    }

    /**
     * 查询所有参赛选手
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findallbattlemanagevo")
    public JsonResult findAllBattleManageVo() {

        JsonResult allBattleManageVo = adminService.findAllBattleManageVo();

        return allBattleManageVo;
    }
    
    /**
     * 查询所有比赛信息
     * @return
     */
    @RequestMapping(value = "/Evedet")
    @ResponseBody
    public ModelAndView Event_details(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
    	// TODO Auto-generated method stub
    	PageInfo page = adminService.findAllBattleManage(pn);
        return new ModelAndView("_admin/Event_details","page",page);
    }
    
    /**
     * 查询当前赛季所有比赛信息
     * @return
     */
    @RequestMapping(value = "/fillBM")
    @ResponseBody
    public JsonResult fillBM(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
    	// TODO Auto-generated method stub
    	PageInfo BattleManage = adminService.findAllBM(pn);
    	JsonResult jsonResult = new JsonResult();
    	jsonResult.setObj(jsonResult);
    	jsonResult.setSuccess(true);
    	return jsonResult;
    }
    
    /**
     * 打开投票通道
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/openBattle/{id}",method = RequestMethod.POST)
    public JsonResult openBattle(@PathVariable Integer id){
    	JsonResult jsonResult = adminService.updateBattleOpen(id);
		return jsonResult;
    }
    /**
     * 关闭投票通道
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/closeBattle/{id}",method = RequestMethod.POST)
    public JsonResult closeBattle(@PathVariable Integer id){
    	 JsonResult jsonResult = adminService.updateBattleClose(id);
		return jsonResult;
    }
    /**
     *添加比赛分数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addscore")
    public JsonResult addScore(@RequestBody BattleManage battleManage) {

        JsonResult jsonResult = adminService.addScore(battleManage);

        return jsonResult;
    }
    
    /**
     * 关闭投票
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stopbattle/{id}")
    public JsonResult stopBattle(@PathVariable Integer id) {
    	
    	JsonResult jsonResult = adminService.updateStopBattle(id);
    	
    	return jsonResult;
    }
    
    /*addBattleManage
     * 添加歌曲
     * */
    @ResponseBody
    @RequestMapping(value = "/adduser")
    public JsonResult stopBattle(users user) {
    	System.out.println(user);
    	JsonResult jsonResult = adminService.addUser(user);
    	
    	return jsonResult;
    }
    
    /*addBattleManage
     * 添加歌曲
     * */

    @ResponseBody
    @RequestMapping(value = "/addBM")
public String addUser(HttpServletRequest request,String songOne,String songTwo,String id){
    	BattleManage battleManage = new BattleManage();
    	battleManage.setSongOne(songOne);
    	battleManage.setSongTwo(songTwo);
    	battleManage.setId(Integer.valueOf(id));
   	JsonResult jsonResult = adminService.addBM(request,battleManage);
    	    return "_admin/schedule";
    	}
    
    /*跳转添加选手页面*/
    @RequestMapping(value = "/insertuser")
    public String insertuser() {
    	return "_admin/insertUser";
    }
    /*添加选手*/
    @RequestMapping(value = "/addPlayer")
    public String addPlayer(HttpServletRequest request,String name) {
    	Player player = new Player();
    	player.setPlayerName(name);
    	JsonResult jsonResult = adminService.addPlayer(request,player);
    	return "_admin/insertUser";
    }
    /*跳转详情页面添加选手页面*/
    @RequestMapping(value = "/chakan")
    public ModelAndView chakan(Integer tl) {
    	BattleManage battleManage = adminService.findBattleManage(tl);
    	return new ModelAndView("_admin/chakan","tl",battleManage);
    }
    
    /*改变选手状态*/
    @RequestMapping(value = "/upPlayer")
    public JsonResult upPlayer(String PS,String playerStatus,String id){
    	Player player = new Player();
    	player.setPS(PS);
    	player.setPlayer_status(Integer.valueOf(playerStatus));
    	player.setId(Integer.valueOf(id));
    	System.out.println(player);
    	JsonResult jsonResult = adminService.upPlayer(player);
    	return jsonResult;
    }
    @RequestMapping(value = "/zewai1")
    public ModelAndView zewai1(String id){
    	return new ModelAndView("_admin/h1","id",id);
    }
    @RequestMapping(value = "/zewai2")
    public ModelAndView zewai2(String id){
    	return new ModelAndView("_admin/h2","id",id);
    }
    @RequestMapping(value = "/zewai3")
    public ModelAndView zewai3(String id){
    	return new ModelAndView("_admin/h3","id",id);
    }
    
    @RequestMapping(value = "/upMbScore")
    public JsonResult upMbScore(BattleManage battleManage){
    	System.out.println(battleManage);
    	JsonResult jsonResult = adminService.addScore(battleManage);
    	this.closeBattle(battleManage.getId());
    	return jsonResult;
    }
    
	}

package com.ygode.Service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ygode.common.result.JsonResult;
import com.ygode.dao.AdminMapper;
import com.ygode.bean.BattleManage;
import com.ygode.bean.BattleManageVo;
import com.ygode.bean.PhotoDao;
import com.ygode.bean.Player;
import com.ygode.bean.VoteVo;
import com.ygode.bean.users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygode.Service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	/**
	 * 鐢ㄦ埛鐧诲綍
	 * @return
	 */
	@Override
	public users findusers(users users) {
		// TODO Auto-generated method stub
		users user = adminMapper.findusers(users);
		return user;
	}
	
	/**
	 * 鏌ヨ褰撳墠姣旇禌鍦烘
	 * @return
	 */
	@Override
	public int findMattch() {
		// TODO Auto-generated method stub
		int Mattch = adminMapper.findMattch();
		return Mattch;
	}

	/**
	 * 鏌ヨ鎵�鏈夐�夋墜淇℃伅
	 * 
	 * @return
	 */
	@Override
	public PageInfo findAllPlayer(Integer pn) {

		PageHelper.startPage(pn, 10);
		// startPage鍚庨潰绱ц窡鐨勮繖涓煡璇㈠氨鏄竴涓垎椤垫煡璇�
		List<Player> allPlayer = adminMapper.findAllPlayer();

		// 浣跨敤pageInfo鍖呰鏌ヨ鍚庣殑缁撴灉锛屽彧闇�瑕佸皢pageInfo浜ょ粰椤甸潰灏辫浜嗐��
		// 灏佽浜嗚缁嗙殑鍒嗛〉淇℃伅,鍖呮嫭鏈夋垜浠煡璇㈠嚭鏉ョ殑鏁版嵁锛屼紶鍏ヨ繛缁樉绀虹殑椤垫暟
		PageInfo page = new PageInfo(allPlayer,5);
		return page;
	}

	/**
	 * 娣诲姞閫夋墜杩涜鎶曠エ
	 * 
	 * @param battleManage
	 * @return
	 */
	@Override
	public JsonResult addBattleManage(BattleManage battleManage) {

		JsonResult jsonResult = new JsonResult();

		int i = adminMapper.addBattleManage(battleManage);
		if (i >= 1) {
			jsonResult.setObj(battleManage);
			jsonResult.setSuccess(true);
			jsonResult.setMsg("娣诲姞鎴愬姛");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("娣诲姞澶辫触");
		}

		return jsonResult;
	}

	/**
	 * 鏌ヨ鎵�鏈夋姇绁ㄩ�夋墜
	 * 
	 * @return
	 */
	@Override
	public JsonResult findAllBattleManageVo() {

		List<BattleManageVo> allBattleManageVo = adminMapper.findAllBattleManageVo();
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(allBattleManageVo);
		jsonResult.setSuccess(true);

		return jsonResult;
	}

	/**
	 * 鎵撳紑鎶曠エ閫氶亾
	 * 
	 * @return
	 */
	@Override
	public JsonResult updateBattleOpen(Integer id) {
		JsonResult jsonResult = new JsonResult();
		if (Success()) {
			int i = adminMapper.updateBattleOpen(id);
			if (i >= 1) {
				jsonResult.setSuccess(true);
				jsonResult.setMsg("鏇存柊鎴愬姛");
			}else {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("鏇存柊澶辫触");
			}
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setMsg("璇峰叧闂叾瀹冩姇绁ㄩ�氶亾");
		}
		System.out.println(jsonResult.getMsg()+jsonResult.isSuccess());
		return jsonResult;
	}

	/**
	 * 鍏抽棴鎶曠エ閫氶亾
	 * 
	 * @return
	 */
	@Override
	public JsonResult updateBattleClose(Integer id) {
		BattleManage battleManage = this.findBattleManage(id);	
		List<VoteVo> allVoteVo = this.findCountVote(id);
		String playerOne = battleManage.getPlayerOne();
		String playerTwo = battleManage.getPlayerTwo();
		for(VoteVo voteVo : allVoteVo){
			if(battleManage.getInsertState()==3){
				if(voteVo.getTicket()==1){
					battleManage.setTicketOne(voteVo.getTicketNew());
				}else if(voteVo.getTicket()==-1){
					battleManage.setTicketTwo(voteVo.getTicketNew());
				}
			}else if(playerOne!=null && playerOne.equals(voteVo.getPlayer())){
				battleManage.setTicketOne(voteVo.getTicketNew());
			}else if(playerTwo!=null && playerTwo.equals(voteVo.getPlayer())){
				battleManage.setTicketTwo(voteVo.getTicketNew());
			}
			adminMapper.updataBM(battleManage);
		}
		JsonResult jsonResult = new JsonResult();
		int i = adminMapper.updateBattleClose(battleManage);
		if (i >= 1) {
			jsonResult.setSuccess(true);
			jsonResult.setMsg("鏇存柊鎴愬姛");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("鏇存柊澶辫触");
		}
		this.findshezhe(battleManage.getId());
		return jsonResult;
	}
	/**
     * 鏌ョ湅鎵�鏈夋瘮璧涚姸鎬�
     * @return
     */
	@Override
	public PageInfo findAllBattleManage(Integer pn){
		PageHelper.startPage(pn, 10);
		// startPage鍚庨潰绱ц窡鐨勮繖涓煡璇㈠氨鏄竴涓垎椤垫煡璇�
		List<BattleManage> allBattleManage2 = adminMapper.findAllBattleManage();	
		// 浣跨敤pageInfo鍖呰鏌ヨ鍚庣殑缁撴灉锛屽彧闇�瑕佸皢pageInfo浜ょ粰椤甸潰灏辫浜嗐��
		// 灏佽浜嗚缁嗙殑鍒嗛〉淇℃伅,鍖呮嫭鏈夋垜浠煡璇㈠嚭鏉ョ殑鏁版嵁锛屼紶鍏ヨ繛缁樉绀虹殑椤垫暟
		PageInfo page = new PageInfo(allBattleManage2,5);
		return page;
	}
	/**
     * 璁＄畻鑾疯儨鑰呭苟鏀瑰彉鐘舵��
     * @return
     */
	@Override
	public int findshezhe(Integer id) {
		Player player = new Player();
		int playerSl =0;
		int playerSb =0;
		BattleManage battleManage =findBattleManage(id);
		int x = battleManage.getTicketOne() + battleManage.getScoreOne() * 100;
		int y = battleManage.getTicketTwo() + battleManage.getScoreTwo() * 100;
		playerSl = x>y?battleManage.getPlayerOneID():battleManage.getPlayerTwoID();
		player.setId(playerSl);
		player.setPlayer_status(1);
		adminMapper.updatePlayerStatus(player);
		
		playerSb = x<y?battleManage.getPlayerOneID():battleManage.getPlayerTwoID();
		player.setId(playerSb);
		player.setPlayer_status(2);
		
		adminMapper.updatePlayerStatus(player);
		return playerSl;
	}
	 /**
     * 缁熻绁ㄦ暟
     * @return
     */
	@Override
	public List<VoteVo> findCountVote(Integer id) {
		List<VoteVo> allVote = adminMapper.findCountVote(id);
		return allVote;
	}
	/**
     * 娣诲姞绁ㄦ暟
     * @return
     */
	@Override
	public void findCountVote2(Integer id) {
		List<VoteVo> allVote = adminMapper.findCountVote(id);
		System.out.println(allVote);
		BattleManage battleManage = findBattleManage(id);
		System.out.println(battleManage);
		int PlayerOneID = battleManage.getPlayerOneID();
		int PlayerTwoID = battleManage.getPlayerTwoID();
		
		for(VoteVo voteVo : allVote){
			int PlayerID = Integer.valueOf(voteVo.getPlayer());
			System.out.println(PlayerID+"  "+ PlayerOneID +"  "+PlayerTwoID);
			if(PlayerOneID==PlayerID){
				System.out.println(1);
				battleManage.setTicketOne(voteVo.getTicketNew());
			}else if(PlayerTwoID==PlayerID){
				System.out.println(2);
				battleManage.setTicketTwo(voteVo.getTicketNew());
			}
		}
		System.out.println(battleManage);
		adminMapper.updataBM(battleManage);
	}
	/**
     * 鏌ユ壘褰撳墠姣旇禌
     * @return
     */
	@Override
	public BattleManage findBattleManage(Integer id) {
		BattleManage battleManage = adminMapper.findBattleManage(id);
		return battleManage;
	}
	/**
     *娣诲姞姣旇禌鍒嗘暟
     * @return
     */
	@Override
	public JsonResult addScore(BattleManage battleManage) {
		JsonResult jsonResult = new JsonResult();

		int i = adminMapper.addScore(battleManage);
		
		if (i >= 1) {
			jsonResult.setObj(battleManage);
			jsonResult.setSuccess(true);
			jsonResult.setMsg("娣诲姞鎴愬姛");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("娣诲姞澶辫触");
		}

		return jsonResult;		
	}
	
	/**
	 * 鏆傚仠鎶曠エ
	 * 
	 * @return
	 */
	@Override
	public JsonResult updateStopBattle(Integer id) {
		BattleManage battleManage = this.findBattleManage(id);	
		List<VoteVo> allVoteVo = this.findCountVote(id);
		String playerOne = battleManage.getPlayerOne();
		String playerTwo = battleManage.getPlayerTwo();
		for(VoteVo voteVo : allVoteVo){
			if(playerOne!=null && playerOne.equals(voteVo.getPlayer())){
				battleManage.setTicketOne(voteVo.getTicketNew());
			}else if(playerTwo!=null && playerTwo.equals(voteVo.getPlayer())){
				battleManage.setTicketTwo(voteVo.getTicketNew());
			}
		}
		JsonResult jsonResult = new JsonResult();
		int i = adminMapper.updateStopBattle(battleManage);
		if (i >= 1) {
			jsonResult.setSuccess(true);
			jsonResult.setMsg("鏇存柊鎴愬姛");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("鏇存柊澶辫触");
		}
		return jsonResult;
	}

	/**
     * 鑷姩娣诲姞閫夋墜杩涜鍙傝禌
     * @param battleManage
     * @return
     */
	@Override
	public JsonResult addBattleManage(){
		// TODO Auto-generated method stub
		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(false);
		Player player = new Player();
		BattleManage battleManage = new BattleManage();
		battleManage.setMatch(findMattch()+1);
		player.setPlayer_status(1);
		int temp1=0; //鎶藉彇閫夋墜1
		int temp2=0; //鎶藉彇閫夋墜2
		Random random=new Random();	       
		List<Integer> tempList=new ArrayList<Integer>();
		List<Player> allPlayer = adminMapper.findAllPlayerPlus(player);
		if(successPlus()) {
			if(allPlayer.size()>1) {
				jsonResult.setSuccess(true);
				for(int i=0;i<=allPlayer.size();i=i+2) {
			            temp1=random.nextInt(allPlayer.size()-1);//灏嗕骇鐢熺殑闅忔満鏁颁綔涓鸿鎶絣ist鐨勭储寮�
			            temp2=random.nextInt(allPlayer.size()-1);//灏嗕骇鐢熺殑闅忔満鏁颁綔涓鸿鎶絣ist鐨勭储寮�
			          if(temp1 != temp2 && !tempList.contains(temp1) && !tempList.contains(temp2)) {
			            	tempList.add(temp1);tempList.add(temp2);
			            	
				            player.setPlayer_status(0);
				            player.setId(allPlayer.get(temp1).getId());
				            
				            battleManage.setPlayerOne(allPlayer.get(temp1).getPlayerName());
				            battleManage.setPlayerOneID(allPlayer.get(temp1).getId());
				            if(adminMapper.updatePlayerStatus(player)==1) {
				            	System.out.println(allPlayer.get(temp1).getId());
				            	}
				            player.setId(allPlayer.get(temp2).getId());
				            
				            battleManage.setPlayerTwoID(allPlayer.get(temp2).getId());
				            battleManage.setPlayerTwo(allPlayer.get(temp2).getPlayerName());
				            if(adminMapper.updatePlayerStatus(player)==1) {
				            	System.out.println(allPlayer.get(temp2).getId());
					            }
					     adminMapper.addBattleManage(battleManage);
					  }else {
						  i=i-2;
					  }
				}
			}
		}
		return jsonResult;
	}

	/*鏌ヨ鏄惁鏈夋墦寮�鐨勬姇绁ㄩ�氶亾*/
	public Boolean Success() {
		boolean switchState = true;
		List<BattleManage> allBattleManage = adminMapper.findAllBattleManage();
		for (BattleManage battleManage : allBattleManage) {
			if (battleManage.getState() == 1) {
				switchState = false;
				break;
			}
		}
		return switchState;
		
	}
	
	/*鏌ヨ褰撳墠璧涘鏄惁缁撴潫*/
	public Boolean successPlus() {
		boolean switchState = true;
		List<BattleManage> allBattleManage = adminMapper.findAllBattleManage();
		for (BattleManage battleManage : allBattleManage) {
			if (battleManage.getState() != 2) {
				switchState = false;
				break;
			}
		}
		return switchState;
		
	}

	@Override
	public PageInfo findAllBM(Integer pn) {
		int Mattch = findMattch();
		PageHelper.startPage(pn, 10);
		// startPage鍚庨潰绱ц窡鐨勮繖涓煡璇㈠氨鏄竴涓垎椤垫煡璇�
		List<BattleManage> allBattleManage = adminMapper.findAllBM(Mattch);
		// 浣跨敤pageInfo鍖呰鏌ヨ鍚庣殑缁撴灉锛屽彧闇�瑕佸皢pageInfo浜ょ粰椤甸潰灏辫浜嗐��
		// 灏佽浜嗚缁嗙殑鍒嗛〉淇℃伅,鍖呮嫭鏈夋垜浠煡璇㈠嚭鏉ョ殑鏁版嵁锛屼紶鍏ヨ繛缁樉绀虹殑椤垫暟
		PageInfo page = new PageInfo(allBattleManage,5);
		System.out.println(Mattch);
		System.out.println(allBattleManage);
		return page;
	}

	@Override
	public JsonResult addUser(users user) {
		// TODO Auto-generated method stub
		JsonResult jsonResult = new JsonResult();
		boolean success = adminMapper.addUser(user);
		jsonResult.setSuccess(success);
		return jsonResult;
	}

	/*姝屾洸鍜岃儗鏅坊鍔狅紝鎶婅儗鏅浘鏀惧叆椤圭洰鏂囦欢澶�*/
	@Override
	public JsonResult addBM(HttpServletRequest request,BattleManage battleManage) {
		// TODO Auto-generated method stub
   	 String filename=PhotoDao.getPhotoNewName();
   	 ServletContext servletContext=null;
   	 servletContext=request.getSession().getServletContext();
   	 //鏁版嵁搴撲腑瀛樺偍鏍煎紡:***.jpg
   	 //绗竴姝�:鑾峰彇椤甸潰涓婁笂浼犵殑鍥剧墖璧勬簮
   	 List<FileItem> items=PhotoDao.getRequsetFileItems(request,servletContext);
   	 System.out.println(items);
   	 boolean isLoadToSQL=false;
   	 for(FileItem item:items) {
   		System.out.println(item.isFormField());
   	     if(!item.isFormField()){
   	         //鍒ゆ柇鍚庣紑鍚嶆槸鍚︽槸jpg
   	    	 if(PhotoDao.isjpg(item)) {
   	    		 battleManage.setUrl(filename);
   	             isLoadToSQL=PhotoDao.saveFile(item,filename);
   	                  }else {
   	                     System.out.println("鍚庣紑鏍煎紡鏈夎锛屼繚瀛樻枃浠跺け璐�");
   	                  } 
   	     	}
   	 	}
	   	JsonResult jsonResult = new JsonResult();
		boolean success = adminMapper.addBM(battleManage);
		jsonResult.setSuccess(success);
		return null;
	}

	@Override
	public JsonResult addPlayer(HttpServletRequest request, Player player) {
		// TODO Auto-generated method stub
	   	 String filename=PhotoDao.getPhotoNewName();
	   	 ServletContext servletContext=null;
	   	 servletContext=request.getSession().getServletContext();
	   	 //鏁版嵁搴撲腑瀛樺偍鏍煎紡:***.jpg
	   	 //绗竴姝�:鑾峰彇椤甸潰涓婁笂浼犵殑鍥剧墖璧勬簮
	   	 List<FileItem> items=PhotoDao.getRequsetFileItems(request,servletContext);
	   	 boolean isLoadToSQL=false;
	   	 for(FileItem item:items) {
	   	     if(!item.isFormField()){
	   	         //鍒ゆ柇鍚庣紑鍚嶆槸鍚︽槸jpg
	   	    	 if(PhotoDao.isjpg(item)) {
	   	    		player.setPlayerImg(filename);;
	   	             isLoadToSQL=PhotoDao.saveFile(item,filename);
	   	                  }else {
	   	                     System.out.println("鍚庣紑鏍煎紡鏈夎锛屼繚瀛樻枃浠跺け璐�");
	   	                  } 
	   	     	}
	   	 	}
		   	JsonResult jsonResult = new JsonResult();
			boolean success = adminMapper.addPlayer(player);
			jsonResult.setSuccess(success);
			return null;
	}

	@Override
	public JsonResult upPlayer(Player player) {
		// TODO Auto-generated method stub
		JsonResult jsonResult = new JsonResult();
		boolean success = adminMapper.upPlayer(player);
		System.out.println(success);
		jsonResult.setSuccess(success);
		return jsonResult;
	}
}

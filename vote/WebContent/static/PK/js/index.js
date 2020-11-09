"use strict";
/*------------------文字 闪烁效果-------------------------------*/
    function changeColor() {
        var color = "#f00|#0f0|#00f|#880|#808|#088|yellow|green|blue|gray|#234|#534|#0AD9DB";//定义一条变换颜色的字符串
        color = color.split("|");
        //var ss = document.getElementsByTagName("h2");//获得元素
        let ss = document.getElementsByClassName("mzc_h1");
        for (var i = 0; i < ss.length; i++) {
            ss[i].style.color = color[parseInt(Math.random() * color.length)];//设置样式
        }
        $.ajax({
			type:'Post',
    		url:'findthispkinsertstate',
    		async:false,
			cache:false,
			data:"{}",
			contentType: "application/json; charset=utf-8",
    		dataType:"json",
    		success:function(data){
    			if(data){
    				$("#mzc_ewmBtn").show();
    			}else{
    				$("#mzc_ewmBtn").hide();
    			}
    		},
			error:function(){
    		}
    		})
    		
    }
    setInterval("changeColor()", 500);

    $(function () { /*--------------------显示与隐藏效果-----------------*/

    var datanew;
    function shuaxin(){
    	$.ajax({
			type:'Post',
    		url:'chaxunBm',
    		async:false,
			cache:false,
			data:"{}",
			contentType: "application/json; charset=utf-8",
    		dataType:"json",
    		success:function(data){
    			console.log(data);
    			if(data.id==null){
    				console.log(5555555);
    				$("#showWinner").show();
    				if(datanew.ticketOne>datanew.ticketTwo){
    				$("#showWinnername").html(datanew.playerOneName);
    				$("#showWinnerimg").attr("src","static/img/"+data.playerTwoImg);
    				}else{
    				$("#showWinnername").html(datanew.playerOneName);
        			$("#showWinnerimg").attr("src","static/img/"+data.playerTwoImg);
    				}
    				
    			}else{
    				datanew=data;
    				$(".mzc_pk").css("background","static/img/"+data.url);
    				
    				$("#PlayerOneimg").attr("src","static/img/"+data.playerOneImg);
    				$("#PlayerOneScore").html(data.ticketOne);
    				$("#PlayerOnename").html(data.playerOneName);
    				
    				$("#PlayerTwoimg").attr("src","static/img/"+data.playerTwoImg);
    				$("#PlayerTwoscore").html(data.ticketTwo);
    				$("#PlayerTwoname").html(data.playerTwoName);
    			}
    		},
			error:function(){
    		}
    	})
    }
    $("#mzc_ewmBtn").click(function () {
    	var a = 1; 
        if(a){
        	var xx =  setInterval(shuaxin,1000);
            $("#showWinner").hide();
            $(".mzc_move").hide();
            $(".mzc_pk").show();
            a=0;
        }else{
        	clearInterval(xx); 
            $(".mzc_move").show();
            $(".mzc_pk").hide();
            a=1;
        }
    })
    


})
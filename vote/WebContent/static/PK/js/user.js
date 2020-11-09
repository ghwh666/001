
/*------------适应手机端------------------------------*/
(function change(){
    var oFz = document.getElementsByTagName("html")[0];
    var width = window.innerWidth;
    oFz.style.fontSize = width/10 +"px";
    window.onresize=function(){change();};

/*------------适应手机端------------------------------*/
    function getUserIP(onNewIP) { //  onNewIp - your listener function for new IPs
        //compatibility for firefox and chrome
        var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
        var pc = new myPeerConnection({
                    iceServers: []
                }),
                noop = function() {},
                localIPs = {},
                ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g,
                key;

        function iterateIP(ip) {
            if (!localIPs[ip]) onNewIP(ip);
            localIPs[ip] = true;
        }

        //create a bogus data channel
        pc.createDataChannel("");

        // create offer and set local description
        pc.createOffer().then(function(sdp) {
            sdp.sdp.split('\n').forEach(function(line) {
                if (line.indexOf('candidate') < 0) return;
                line.match(ipRegex).forEach(iterateIP);
            });

            pc.setLocalDescription(sdp, noop, noop);
        }).catch(function(reason) {
            // An error occurred, so handle the failure to connect
        });

        //sten for candidate events
        pc.onicecandidate = function(ice) {
            if (!ice || !ice.candidate || !ice.candidate.candidate || !ice.candidate.candidate.match(ipRegex)) return;
            ice.candidate.candidate.match(ipRegex).forEach(iterateIP);
        };
    }

    // Usage

    getUserIP(function(ip){
    
    
    var x=1;
    var y=1;
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
    			console.log(data)
    			if(data.id==null){
    				x=0;
    				alert("投票结束");
    				clearInterval(shusa);
    				
    			}else{
    				datanew=data;
    				$("#user").css("background","static/img/"+data.url);
    				
    				$("#user1img").attr("src","static/img/"+data.playerOneImg);
    				
    				$("#user2img").attr("src","static/img/"+data.playerTwoImg);
    			}
    		},
			error:function(){
    		}
    	})
    }
    
    var shusa = setInterval(shuaxin(),500);
    $("#button1").click(function () {
        if(x){
        	if(y){
        		var data= 'battle_manage_id='+datanew.id+'&player='+datanew.playerOneID+'&user_session='+ip;
        	$.ajax({
    			type:'Post',
        		url:'toupiao?'+data,
        		async:false,
    			cache:false,
    			data:"{}",
    			contentType: "application/json; charset=utf-8",
        		dataType:"json",
        		success:function(data){
        			if(data){
        				alert("投票成功");
        					$("#user1p").html("已投");
        					y=0;
        			}else{
        				alert("投票失败，你以投票");
        			}
        		},
    			error:function(){
        		}
        	})
        	}else{
        		alert("已投");
        	}
        }else{
        	alert("投票结束");
        
        }
    })
    
    $("#button2").click(function () {
        if(x){
        	if(y){
        		data= 'battle_manage_id='+datanew.id+'&player='+datanew.playerTwoID+'&user_session='+ip;
        	$.ajax({
    			type:'Post',
        		url:'toupiao?'+data,
        		async:false,
    			cache:false,
    			contentType: "application/json; charset=utf-8",
        		dataType:"json",
        		success:function(data){
        			if(data){
        				alert("投票成功");
        					$("#user2p").html("已投");
        					y=0;
        			}else{
        				alert("投票失败，你以投票");
        			}
        		},
    			error:function(){
        		}
        	})
        	}else{
        		alert("已投");
        	}
        }else{
        	alert("投票结束");
        }
    })
    
    });
})();











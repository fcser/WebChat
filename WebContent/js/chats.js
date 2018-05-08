function $$(id){
	return document.getElementById(id);
}
var strList="";
var sender='';
var receiver='';
var objWs=null;
var SocketCreated=false;
var arrState=new Array("正在建立连接...","连接成功！","正在关闭连接...","连接已关闭","正在初始化值...","连接出错！");
//初始化建立连接
$(function(){
	sender=prompt("请输入您的用户名","zym");
	  if (sender==null || sender=="")
	    {
		  sender=prompt("请输入您的用户名","");
	    }
	  $("#user-chat").html(sender);
	if (!window.WebSocket) {
        alert("你的浏览器没有websocket");
        return;
    }
	objWs= new WebSocket('ws://localhost:8080/WebChat/websockets/'+sender);
	objWs.onopen=function(){
		//alert("1");
		Handle_List(arrStage[1]);
	};
	objWs.onmessage=function(event){
		var message=JSON.parse(event.data);
		var iswhat=message.iswhat;
		if(iswhat=="xinxi"){
			receiver=message.sender;
			$("#select-home").attr('href','select.jsp?sender='+sender+'&receiver='+receiver +'&page=-1');//聊天记录
			$("#desknumber").html(receiver);
		Handle_List(message.datetime);
		Handle_List(message.sender+"说："+message.content);
	    }else{
	    	Handle_User(message.name);
	    }
	};
	objWs.onclose=function(){
		//alert("2");
		Handle_List(arrState[objWs.readyState]);
	};
});
//发送消息
sendmessage=(function(message){
	if(message!=''){
		objWs.send(message);
	}
});
//获取要发送者名称
function getname(target){
	receiver=$(target).text();
	$("#desknumber").html(receiver);
	$("#select-home").attr('href','select.jsp?sender='+sender+'&receiver='+receiver +'&page=-1');//聊天记录
	strList="";
	//$$("txtaList").innerHTML="";
	$(".chat01_content li").remove();
}
//发送信息
function btnSend_Click(){
	var strTxtMessage=$$("txtMessage").value;
	var strTime=new Date();
	if(strTxtMessage.length>0){
		Handle_List(strTime.toLocaleDateString());
		Handle_List("我说:"+strTxtMessage);
		$$("txtMessage").value="";
		sendmessage(JSON.stringify({
			content:strTxtMessage,datetime:strTime.toLocaleDateString(),receiver:receiver
		}));
	}
}
//接收到的信息显示
function Handle_List(message){
	//messages=h(message);
	var messages=message.replace("*#","<img src='img/");
	var messagess='<li>'+messages.replace("#*",".gif'/>")+'</li>';
	strList+=messagess+"\n";
	//$$("txtaList").innerHTML=strList;
	$(messagess).appendTo('.chat01_content');
}
//显示用户
function Handle_User(message){
	//receivers +=message+"\n";
	receivers='<li>'+
    '<label class="online">'+
    '</label>'+
    '<a href="javascript:;">'+
        '<img src="img/head/2013.jpg"></a><a href="javascript:void(0)" class="chat03_name" onclick="getname(this)">'+message+'</a>'+
'</li>';
        $(receivers).appendTo('#users-list');
}
////////////////////////////
/*$(".ctb01").onclick(function(){
	alert("pengdaowol");
	$(".wl_faces_box").show();
	});*/
//显示和隐藏表情
function dosw(){
	
	$(".wl_faces_box").show();
}
function dtsw(){
	
	$(".wl_faces_box").hide();
}
//运用ajax查询用户信息
function domsg(){
	if(receiver=="undefined"||receiver==''){
		//alert("没有查询的用户");
		return;
	}
	//alert("查询的d 用户");
	var xhr=getXMLHttpRequest();
	
	xhr.onreadystatechange=function(){
		//alert(xhr.readyState);
	if(xhr.readyState==4){//请求正常
		if(xhr.status==200){//服务器响应一切正常
			//接收到返回的数据
			//alert("hh");
			var usermsg=xhr.responseText;
			//alert(usermsg);
			var mes=JSON.parse(usermsg);
			$("#name").html(mes.user);
			$("#sex").html(mes.sex);
			$("#age").html(mes.age);
			$("#home").html(mes.home);
			$("#intro").html(mes.intro);
		}
	 }
	};
	xhr.open("post","User_servlet?name="+receiver);
	xhr.send(null);
	$(".wl_msg_box").show();
}
function dtmsg(){
	$(".wl_msg_box").hide();
}
//获取表情
function choose(message){
	var a=$(message)[0].src;
    $$("txtMessage").value=$$("txtMessage").value+"*#"+a.substr(a.indexOf("img/")+4,6)+"#*";
    $$("txtMessage").focusEnd();
    $(".wl_faces_box").hide();
}
//ajax
function getXMLHttpRequest(){
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}


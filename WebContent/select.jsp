<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cn.javaweb.javabean.*"%>
<%@ page import="cn.javaweb.sql.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天记录查询</title>
<style type="text/css">
.header{
 background-color:white;
 color:black;
 text-align:center;
 padding:5px
}
.nav{
 width:800px;
 height:25px;
 font-family:"Times New Roman";
 font-size:15px;
 margin:0 auto
}

.section{
 width:800px; 
 height:400px;
 border:0.5px solid #000;
 margin:0 auto;
 overflow-y:scroll;
}
.date{
 width:400px;
 height:30px;
 margin:0 auto;
 text-align:right;
 float:left
}
.sender{
 color:#00F
}
.receiver{
 color:#F00
}
.pagediv{
 width:400px;
 height:30px;
 margin:0 auto;
 text-align:center;
}
li,ul{ 
border:0; 
padding:0; 
margin:0; 
list-style:none
}
ul.page{ 
margin-top:10px
} 
ul.page li{
text-align:center; 
float:left;
width:80px; 
height:40px; 
line-height:30px;
font-size:14px;
font-weight:bold
 } 
ul.page li a{ 
text-align:center; 
display:block;
 width:80%; 
 height:80%; 
 font-size:15px; 
color:#FFF; 
text-decoration:none; 
background:url(image/a.jpg) no-repeat 0 0
} 
ul.page li a:hover{
background:url(image/b.jpg) no-repeat 0 0
}

</style>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8"); 
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	//获得发送者
	String sender=(String) request.getParameter("sender");
	request.setAttribute("sender", sender); 
	//获得连接者
	String receiver=(String)request.getParameter("receiver");
	request.setAttribute("receiver", receiver);
	//获得页面请求
	String PAGE=(String) request.getParameter("page");
	System.out.println(PAGE);
	int pages=Integer.parseInt(PAGE);
		String sql="select * from chatting where (sender='"+sender+"' and receiver='"+receiver+"') or (sender='"+receiver+"' and receiver='"+sender+"') order by datatime desc";
		//ArrayList<News> news=NewsDAO.findALLNewsbysorttime(sort);
		Vector <Chatting> chatting=ChatDAO.search(sql,pages);
		request.setAttribute("chatting", chatting); 
   
   %>
   
  <div class=header>
    <h1>消息记录</h1>
  </div>
  <div class=nav>
       您的位置：
   <a href="javascript:;">聊天查询</a> <!--聊天室链接-->
  </div>
  <div class=section>
  <c:forEach items="${chatting}" var="stu1">
  <p class=sender>${stu1.sender } ${stu1.datatime }</p>
  <p>${stu1.content }</p>
  </c:forEach>
  </div>
  <div class=pagediv>
  <ul class=page>
    <li><a href="select.jsp?sender=${sender }&receiver=${receiver }&page=-1">首页</a></li> 
    <li><a href="select.jsp?sender=${sender }&receiver=${receiver }&page=-2">上一页</a></li>
    <li><a href="select.jsp?sender=${sender }&receiver=${receiver }&page=-3">下一页</a></li>
    <li><a href="select.jsp?sender=${sender }&receiver=${receiver }&page=-4">尾页</a></li>
  </ul> 
  </div>
    
</body>
</html>
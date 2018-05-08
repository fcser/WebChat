<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>在线聊天</title>
<meta charset="utf-8">
<meta name="keywords" content="前端js在线聊天" />
<meta name="description" content="前端js在线聊天" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- Set render engine for 360 browser -->
<meta name="renderer" content="webkit">

<!-- No Baidu Siteapp-->
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="css/chat.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/chats.js"></script>
<style type="text/css">
 .wl_msg_box { 
 background: url('img/wlf_bg.png') repeat 0 0; 
 position: absolute; 
 width: 228px; 
 height: 100px; 
 bottom: 22px; 
 left: -50px; 
 display: none; 
 }
 .nas{
 width:800px;
 height:55px;
 font-family:"Times New Roman";
 font-size:25px;
 margin:0 auto;
 text-align:center
}
</style>
</head>
<body>
    <div class="content">
    <div class=nas><span id="user-chat" class=nas></span>,欢迎访问web聊天</div>
        <div class="chatBox">
            <div class="chatLeft">
                <div class="chat01">
                    <div class="chat01_title">
                        <ul class="talkTo">
                            <li><a href="javascript:;" onmouseover="domsg()" onmouseout="dtmsg()"><span id="desknumber"></span></a></li></ul>
                        <div class="wl_msg_box" onmouseover="domsg()" onmouseout="dtmsg()">
                        <!-- 用户信息显示 -->
                        <ul>
                            <li>用户名：    <span id="name"></span></li>
                            <li>性别：       <span id="sex"></span></li>
                            <li>年龄：       <span id="age"></span></li>
                            <li>家乡：       <span id="home"></span></li>
                            <li>个人简介：<span id="intro"></span></li>
                        </ul>
                        </div>
                        <a class="close_btn" href="javascript:;"></a>
                    </div>
                   <div class="chat01_content">
                   
                          <!--  <textarea rows="16" cols="75" id="txtaList" readonly="true"></textarea>-->
                    </div>
                </div>
                <div class="chat02">
                    <div class="chat02_title">
                          <a class="chat02_title_btn ctb01" href="javascript:void(0)" onmouseover="dosw()" onmouseout="dtsw()"></a>
                        <label class="chat02_title_t">
                            <a href="javascript:;" target="_blank" id="select-home">聊天记录</a></label>
                        <div class="wl_faces_box" onmouseover="dosw()" onmouseout="dtsw()">
                            <div class="wl_faces_content">
                                <div class="title">
                                    <ul>
                                        <li class="title_name">常用表情</li><li class="wl_faces_close"><span>&nbsp;</span></li></ul>
                                </div>
                                <div class="wl_faces_main">
                                    <ul>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_01.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_02.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_03.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_04.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_05.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_06.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_07.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_08.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_09.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_10.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_11.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_12.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_13.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_14.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_15.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_16.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_17.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_18.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_19.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_20.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_21.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_22.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_23.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_24.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_25.gif" /onclick="choose(this)"></a></li><li><a href="javascript:;">
                                                <img src="img/emo_26.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_27.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_28.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_29.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_30.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_31.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_32.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_33.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_34.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_35.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_36.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_37.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_38.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_39.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_40.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_41.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_42.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_43.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_44.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_45.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_46.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_47.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_48.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_49.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_50.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_51.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_52.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_53.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_54.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_55.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_56.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_57.gif" onclick="choose(this)"/></a></li>
                                        <li><a href="javascript:;">
                                            <img src="img/emo_58.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                <img src="img/emo_59.gif" onclick="choose(this)"/></a></li><li><a href="javascript:;">
                                                    <img src="img/emo_60.gif" onclick="choose(this)"/></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="wlf_icon">
                            </div>
                        </div>
                    </div>
                    <div class="chat02_content">
                        <textarea id="txtMessage"></textarea>
                    </div>
                    <div class="chat02_bar">
                        <ul>
                            <!--  --<li style="right: 5px; top: 5px;"><a href="javascript:;">
                                <img src="img/send_btn.jpg"></a></li>-->
                            <li style="right: 5px; top: 5px;"><input id="btnAdd" type="button" value="发送" class="inputbtn w85 m14" onClick="btnSend_Click();"></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="chatRight">
                <div class="chat03">
                    <div class="chat03_title">
                        <label class="chat03_title_t">
                            成员列表</label>
                    </div>
                    <div class="chat03_content">
                        <ul id="users-list">
                            <!--<li>
                                <label class="online">
                                </label>
                                <a href="javascript:;">
                                    <img src="img/head/2013.jpg"></a><a href="javascript:;" class="chat03_name">fgh </a>
                            </li>-->
                        </ul>
                    </div>
                </div>
            </div>
            <div style="clear: both;">
            </div>
        </div>
    </div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p></p>
<p></p>
</div>
<!-- 遇到的问题：1.img表情发送
             2.ajax status为0
             3.个人信息显示乱码
              -->
</body>
</html>
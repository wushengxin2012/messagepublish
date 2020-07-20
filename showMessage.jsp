<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>消息发布系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	<meta name="Robots" content="index,follow" />
	<link rel="stylesheet" type="text/css" href="web-model/css/main.css" media="screen" />
	<script type="text/javascript">
	// toggle dynamic divs
    function toggle(div) {
    	var elem = document.getElementById(div);
    	if (elem.style.display=='') {elem.style.display='none'; return;}
    	elem.style.display='';
    }
	</script>
</head>
<body>
	<div id="content">	
		<div id="header">
			<div id="logo">
				<h1>消息发布系统<sup> beta</sup></h1>
				<p>这是一个用于管理企业消息发布的管理系统。所有已经注册的员工都可以在里面发布消息，评论消息。使得消息能够以更加快的速度传播与公司企业的内部。突破消息壁垒。</p>
			</div>
	
			<div id="search">
				<!-- <a onclick="toggle('searchform');">+ SEARCH</a> -->
				<a>+ SEARCH</a>
				<div id="searchform" style="display: none;">
					<form method="post" action="">
						<p><input class="searchfield" name="search_query" id="keywords" value="Search Keywords" type="text" />
						<input class="searchbutton" name="submit" value="Search" type="submit" /></p>
					</form>
				</div>
			</div>
		</div>
		<ul id="menu">
			<li><a href="index.jsp">主页</a></li>
			<li><a href="recognise.jsp">登录</a></li>
			<li><a href="publishMessage.jsp">消息发布</a></li>
			<li><a class="current" href="MessageListAction?page=1">消息列表</a></li>
			<!-- <li><a href="#">Accessibility Test</a></li> -->
			<!-- <li><a href="#">About</a></li> -->
			<!-- <li><a id="last" href="#">Contact</a></li>	 -->
		</ul>
		<div style="clear: both;"></div>
			
		<div class="third_01">
			<h2>消息详情</h2>
			
				<div id="showMessage">
					<p>标题：${requestScope.message.messageTitle}</p>
					<p>内容：</p>
					<p>${requestScope.message.messageContent}</p>
					<p align="right">发布人：${requestScope.member.memberName}</p>
					<p align="right">发布时间：${requestScope.message.messagePublishTime}</p>
				</div>

				<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

				<div id="addReply">
				<p></p>
					<font color="red">${requestScope.error}</font>
					<form method="POST" action="AddReplyAction">
						<textarea cols="100%" rows="2" name="replyContent"></textarea><br/>
						<input type="hidden" name="messageID" value="${requestScope.message.messageID}">
						<input type="submit" value="提交"/>
					</form>
				</div>

				<div id="showReply">
				<p></p>
					<ul>
						<c:forEach items="${requestScope.replyList}" var="reply">
							<li><dl><dt>${reply.replyContent}</dt><dd><p align="right">发布人：${reply.memberID}&nbsp&nbsp&nbsp发布时间：${reply.replyTime}</p></dd></dl></li><br/>
						</c:forEach>
					</ul>
				</div>
			
			<p class="more"><a href="#">Read More</a></p>
		</div>
		
		
		<div style="clear: both;"></div>
	</div>
	<div id="prefooter">
		<p>这是自己开发的企业管理系统，主要用途是发布和评论消息</p>
	</div>
	<div id="footer">
		<p class="right"><a href="#">Sitemap</a><a href="#">Contact</a></p>
		<p>© Copyright 2008, <a href="#">Website Traffic</a>, Design: Luka Cvrk, <a title="Awsome Web Templates" href="#">cssMoban.com</a></p>
	</div>
</body>
</html>
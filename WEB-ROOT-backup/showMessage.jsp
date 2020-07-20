<div id="showMessage">
	<p>标题：${requestScope.message.messageTitle}</p>
	<p>内容：</p>
	<p>${requestScope.message.messageContent}</p>
	<p align="right">发布人：${requestScope.member.memberName}</p>
	<p align="right">发布时间：${requestScope.message.messagePublishTime}</p>
</div>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="addReply">
	<font color="red">${requestScope.error}</font>
	<form method="POST" action="AddReplyAction">
		<textarea cols="50" rows="2" name="replyContent"></textarea><br/>
		<input type="hidden" name="messageID" value="${requestScope.message.messageID}">
		<input type="submit" value="提交"/>
	</form>
</div>

<div id="showReply">
	<ul>
		<c:forEach items="${requestScope.replyList}" var="reply">
			<li><dl><dt>${reply.replyContent}</dt><dd>发布人：${reply.memberID}&nbsp&nbsp&nbsp发布时间：${reply.replyTime}</dd></dl></li>
		</c:forEach>
	</ul>
</div>
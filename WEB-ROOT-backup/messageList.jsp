<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="messageList">
	<ul>
		<c:forEach items="${requestScope.messageList}" var="message">
		<li><dl><dt><a href="ShowMessageAction?messageID=${message.messageID}" >${message.messageTitle}</a></dt><dd>发布时间：${message.messagePublishTime}&nbsp &nbsp &nbsp发布人ID：${message.memberID}</dd></dl></li>
		</c:forEach>
	</ul>
	<br/>
	<c:choose>
		<c:when test="${sessionScope.page.hasPrePage}">
			<a href="MessageListAction?page=1">首页</a>|<a href="MessageListAction?page=${sessionScope.page.currentPage-1}">上一页</a>&nbsp&nbsp
		</c:when>
		<c:otherwise>
			首页|上一页 &nbsp&nbsp
		</c:otherwise>
	</c:choose>
	当前页：${sessionScope.page.currentPage}&nbsp&nbsp
	<c:choose>
		<c:when test="${sessionScope.page.hasNextPage}">
			<a href="MessageListAction?page=${sessionScope.page.currentPage+1}">下一页</a>|<a href="MessageListAction?page=${sessionScope.page.totalPage}">尾页</a>
		</c:when>
		<c:otherwise>
			下一页|尾页
		</c:otherwise>
	</c:choose>
</div>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="personalMessage">
	<c:choose>
		<c:when test="${empty sessionScope.member}">
			您还没有登录
		</c:when>
		<c:otherwise>
			<ul>
				<li>账号ID：${sessionScope.member.memberID}</li>
				<li>成员姓名：${sessionScope.member.memberName}</li>
				<li>成员性别：${sessionScope.member.memberSex?"男":"女"}</li>
				<li>成员生日：${sessionScope.member.memberBirth}</li>
				<li>是否领导：${sessionScope.member.isAdminister?"是":"否"}</li>
			</ul>
		</c:otherwise>
	</c:choose>
</div>
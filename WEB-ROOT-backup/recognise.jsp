<div id="recognise">
	<p color="red">${requestScope.error}</p>
	<form method="POST" action="RecogniseAction">
		用户ID：<input type="text" name="memberID"/><br/>
		密码：<input type="password" name="memberPassword"/><br/>
		<input type="submit" value="提交"/><input type="reset" value="重置"/>
	</form>
</div>
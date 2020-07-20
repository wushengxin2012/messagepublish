<div id="publishMessage">
	<p color="red">${requestScope.error}</p>
	<form method="POST" action="PublishMessageAction">
		<p>消息标题：<input type="text" name="messageTitle"/></p>
		<p>消息内容：</p>
		
		<script src="ckeditor/ckeditor.js"></script>
		<p><textarea id="editor" rows="5" cols="5" name="messageContent"></textarea></p>
		<script>CKEDITOR.replace("editor");</script>
		
		<p align="center" > <input type="submit" value="提交"/><input type="reset" value="重置"/></p>
	</form>
</div>
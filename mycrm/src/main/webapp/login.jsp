<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎登陆</title>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/windowAdapter.js"></script>
		<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
	</head>
	<style>
		#loginpanel {
			background: #fafafa;
		}
	</style>

	<body>

		<div id="loginpanel" class="easyui-panel" style="width:300px;height:150px; padding-left: 20px;" data-options="">
			<form id="ff" method="post">

				<p><input id="username" name="username" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:180px;"></p>
				<p><input id="password" name="password" class="easyui-passwordbox" data-options="" style="width:180px;"></p>
				<p>
					<a id="btn" href="javascript:subLogin();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登陆</a>
				</p>
			</form>
		</div>

	</body>

	<script>
		function subLogin() {
			$.messager.progress();
			$.ajax({
				url: "http://localhost:8080/mycrm/user/subLogin.do",
				dataType: "JSON",
				type: "POST",
				data: {
					userLoginname : $('#username').textbox('getValue'),
					userPassword : $('#password').textbox('getValue')
				},
				success: function(data) {
					$.messager.progress('close');
					if (data.success) {
						window.location.href = "index.html";	
					}else{
						$.messager.alert('登陆失败',data.msg,'info');
					}
					
					console.log(data);
				}

			});	
			
		}
	</script>
</html>

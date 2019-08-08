<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>上传下载</title>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/windowAdapter.js"></script>
	<script type="text/javascript" src="../js/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">
</head>


<body>

	<!-- 	



	<form name="Form2" action="http://localhost:8080/mycrm/file/springUpload" method="post" enctype="multipart/form-data">
		<h1>使用spring mvc提供的类的方法上传文件</h1>
		<input type="file" name="file"> <input type="submit" value="upload" />
	</form> -->





	<table class="easyui-datagrid" style="width: 100%;" data-options="toolbar:'#uptb',rownumbers:'true',singleSelect:'true',collapsible:'true',pagination:'true'">
		<thead>
			<tr>
				<th data-options="field:'1',align:'center',width:'100'">编号</th>
				<th data-options="field:'2',align:'center',width:'100'">名称</th>
				<th data-options="field:'3',align:'center',width:'100'">创建时间</th>
				<th data-options="field:'4',align:'center',width:'100'">修改时间</th>
			</tr>
		</thead>
	</table>


	<div id="uptb">
		<a href="#" onclick="showFilter()" class="easyui-linkbutton" data-options="iconCls:'icon-filter',plain:true">上传</a>
	</div>




	<div class="easyui-window" id="winShowFilter" title="上传文件" closed="true" style="width: 400px; padding: 30px 70px 50px 70px">
		<!--action="${pageContext.request.contextPath}/file/springUpload" enctype="multipart/form-data" method="post"-->
		<form id="uploadFilter">
			<div style="margin-bottom: 20px">
				<div>文件:</div>
				<input class="easyui-filebox" id="fileObj" name="fileObj" data-options="buttonText:'选择文件',prompt:'选择上传文件'" style="width: 100%">
			</div>

			<div>
				<a href="#" onclick="subFilter()" type="submit" class="easyui-linkbutton" style="width: 100%">上传</a>
			</div>
		</form>

	</div>











	<script>
		function showFilter() {
			$('#winShowFilter').window('open');
		}

		function shutAisle() {
		//	$("#fileName").textbox("clear");
			$("#fileObj").filebox("clear");
			$('#winShowFilter').window('close');
		}



		//TODO 该提交方式 返回值有问题,需要重新考虑提交方式
		function subFilter() {
			var form = new FormData(document.getElementById("uploadFilter"));
			$.ajax({
				url: "${pageContext.request.contextPath}/file/springUpload",
				type: "post",
				dataType: "json",
				data: form,
				processData: false,
				contentType: false,
				success: function(data) {
					if (data.success) {
						shutAisle();
					}
					$.messager.show({
						title: '系统消息',
						msg: data.msg,
						timeout: 2000,
						showType: 'slide'
					});
				},
				error: function(e) {
					$.messager.alert('错误', "错误代码:" + e.status + "</br>请重新上传", 'info');
				}
			});
		}
	</script>

</body>
</html>

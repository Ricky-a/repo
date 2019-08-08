<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

	<head>	
		<meta charset="UTF-8">
		<title>角色管理</title>
		<!-- 1.引入Jquery的Js文件 -->
		<script type="text/javascript" src="../js/jquery-easyui/jquery.min.js"></script>
		<!-- 2.引入Easyui的Js文件 -->
		<script type="text/javascript" src="../js/jquery-easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../js/windowAdapter.js"></script>
		<!-- 3.引用Easy UI的国际化文件 -->
		<script type="text/javascript" src="../js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
		<!-- 4.导入Easy UI的主题Css文件 -->
		<link rel="stylesheet" type="text/css" href="../js/jquery-easyui/themes/material/easyui.css">
		<!-- 5.导入Easy UI的图标Css文件 -->
		<link rel="stylesheet" type="text/css" href="../js/jquery-easyui/themes/icon.css">


	</head>
	

	

	<body>

		<table  class="easyui-datagrid" id="roletable" data-options="rownumbers:true, toolbar:'#tb', singleSelect:true,collapsible:true,pagination:true">
			<thead>
				<tr>
					<th data-options="field:'roleCode',align:'center',width:'10%'">编号</th>
					<th data-options="field:'roleName',align:'center',width:'10%'">名称</th>					
					<th data-options="field:'roleCreator',align:'center',width:'10%'">创建人</th>
					<th data-options="field:'roleCreateDate',align:'center',width:'10%'">创建时间</th>	
					<th data-options="field:'setEdit',align:'center',width:'10%',formatter:formatterEdit">修改</th>	
					<th data-options="field:'setRole',align:'center',width:'10%',formatter:formatterSet">设置</th>	
				</tr>
			</thead>
		</table>
		
		
		<div id="tb">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
		</div>
		
		<div id="setRoleWin" class="easyui-window" title="My Window" style="width:600px;height:400px"   
		        data-options="iconCls:'icon-save',modal:true,closed:true">   
		   
		   	<ul id="setRoleTree" class="easyui-tree" data-options="animate:true,lines:true,checkbox:true"></ul>  

  
		</div>  
		
	</body>
	
	
<script>
	$(function() {
		
	});
	
	$("#roletable").datagrid({
	    url:"http://localhost:8080/mycrm/role/setRoleList.do",       
	    method:'post'
	}); 
	
	function formatterEdit(value,row,index){		
		return "<a style='cursor: pointer;' onclick='editRole(" + index + ")'>修改</a>";
	}
	
	function formatterSet(value,row,index){
	return "<a style='cursor: pointer;' onclick='setRole(" + index + ")'>权限</a>";
	}
	
	function editRole(index){
		console.log(index);	
	}
		
	function setRole(index){
	var data = $("#roletable").datagrid("getRows");
		$("#setRoleWin").window({    
		     closed:false,
		     title: "您正在设置" + data[index].roleName
		});  
		var role = {
			roleCode : data[index].roleCode,
			roleName : data[index].roleName		
		};
		$.ajax({
			url: "http://localhost:8080/mycrm/role/setRole.do",
			dataType: "JSON",
			contentType: 'application/json;character:utf-8',
			type: "POST",
			data: JSON.stringify(role),
			success: function(data) {
				console.log("success===>"+JSON.stringify(data.message));
				console.log("success===>"+data.success);
				if(data.success){
					$("#setRoleTree").tree("loadData", data.message);
				}else{
					$.messager.alert('info',JSON.stringify(data.message),'info');
					$("#setRoleTree").tree("loadData", data.message);
					
				}
			}
		});
		

	}
 
	
	
	
	
</script>












































</html>


	
		
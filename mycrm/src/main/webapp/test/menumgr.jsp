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
		<title>菜单管理</title>
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
	
	<style>
		a:hover{ color: red;}
		
	</style>

	

	<body>

		<table  class="easyui-treegrid" id="menutable" data-options="rownumbers:true, toolbar:'#tb', singleSelect:true,  collapsible:true,  pagination:true">
			<thead>
				<tr>
					<th data-options="field:'id',align:'center',width:'10%'">编号</th>
					<th data-options="field:'text',align:'center',width:'30%'">菜单名称</th>
					<th data-options="field:'attributes',align:'center',width:'30%',formatter:formatterURL">菜单地址</th>
					<th data-options="field:'setActionMenu',align:'center',width:'20%',formatter:formatterActionMenu">操作</th>
				</tr>
			</thead>
		</table>
		
		
		
		<div id="tb">
			<a href="JavaScript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			<a href="JavaScript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
			<a href="JavaScript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
			<a href="JavaScript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
		</div>
	
		
	</body>
	
	
<script>

	$(function() {
		

	});
	
	$("#menutable").treegrid({
	    url:"http://localhost:8080/mycrm/menu/getAllMenu.do",    
	    idField:'id',    
	    treeField:'text',  	    
	    method:'post'
	});  

	function formatterURL(value,row,index){
		return row.attributes.url;	
	}
	function formatterActionMenu(value,row,index){
		return  "<a style='cursor: pointer;' onclick='lockUser(" + index + ")'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a style='cursor: pointer;' onclick='lockUser(" + index + ")'>修改</a>";	 		
	}
	

	
</script>












































</html>


	
		
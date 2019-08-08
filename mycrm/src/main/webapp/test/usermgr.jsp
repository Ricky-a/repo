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
		<title>用户管理</title>
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

		<table  class="easyui-datagrid" id="usertable" data-options="rownumbers:true,toolbar:'#tb',singleSelect:true,collapsible:true,pagination:true,url:'http://localhost:8080/mycrm/setUserList.do',method:'post'">
			<thead>
				<tr>
					<th data-options="field:'userCode',align:'center',width:'10%'">编号</th>
					<th data-options="field:'userName',align:'center',width:'10%'">名称</th>
					<th data-options="field:'userGender',align:'center',width:'5%'">性别</th>
					<th data-options="field:'userLoginName',align:'center',hidden:true,width:'15%'">登陆名</th>			
					<th data-options="field:'userAge',align:'center',width:'5%'">年龄</th>
					<th data-options="field:'userStature',align:'center',hidden:true,width:'5%'">身高</th>
					<th data-options="field:'userWeight',align:'center',hidden:true,width:'5%'">体重</th>
					<th data-options="field:'userTel1',align:'center',width:'10%'">电话1</th>
					<th data-options="field:'userTel2',align:'center',hidden:true,width:'10%'">电话2</th>
					<th data-options="field:'userWX',align:'center',width:'10%'">微信</th>
					<th data-options="field:'userQQ',align:'center',width:'10%'">QQ</th>
					<th data-options="field:'userBirthday',align:'center',width:'15%'">生日</th>			
				</tr>
			</thead>
		</table>
		
		
		
		<div id="tb">
			<a href="JavaScript:initInsertUser();" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			<a href="JavaScript:removeUser();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
			<a href="JavaScript:initUpdateUser();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
			<a href="JavaScript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
		</div>
		
		<div class="easyui-window" id="userinfo" title="用户资料" style="width: 660px; height: 400px;" data-options="iconCls:'icon-edit',resizable:false,modal:true,closed:true,inline:true">
			<table>
				<tr>
					<td>编号:</td>
					<td><input id="ucode" class="easyui-textbox tbox" style="width:150px;">
					</td>
					<td>名称:</td>
					<td><input id="uname" class="easyui-textbox tbox" style="width:150px;"></td>
				</tr>
			
				<tr>
					<td>性别:</td>
					<td><input id="ugender" class="easyui-textbox tbox" style="width:150px;"></td>
					<td>登陆名:</td>
					<td><input id="uloginname" class="easyui-textbox tbox" style="width:150px;"></td>
				</tr>
				<tr>
					<td>年龄:</td>
					<td><input id="uage" class="easyui-textbox tbox" style="width:150px;"></td>
					<td>身高:</td>
					<td><input id="ustature" class="easyui-textbox tbox" style="width:150px;"></td>
				</tr>
				<tr>
					<td>体重:</td>
					<td><input id="uweight" class="easyui-textbox tbox" style="width:150px;"></td>
					<td>电话1:</td>
					<td><input id="utel1" class="easyui-textbox tbox" style="width:150px;"></td>
				</tr>
				<tr>
					<td>电话2:</td>
					<td><input id="utel2" class="easyui-textbox tbox" style="width:150px;"></td>
					<td>微信:</td>
					<td><input  id="uwx" class="easyui-textbox tbox" style="width:150px;"></td>
				</tr>
				<tr>
					<td>QQ:</td>
					<td><input id="uqq" class="easyui-textbox tbox" style="width:150px;"></td>
					<td>生日:</td>
					<td><input  id="ubirthday"  type= "text" class= "easyui-datebox tbox" required ="required" ></td>
				</tr>
				<tr>
					<td> </td>
					<td> </td>
					<td> </td>
			
					<td>
						<a id="btn" href="#">保存</a>  					
					</td>
				</tr>
			</table>
			
		</div>
		
		
		
		
	</body>
	
	
<script>

	$(function() {
		initUserTable();

	});

	function initUpdateUser() {
		var data = $("#usertable").datagrid("getSelected");
		if(null == data) {
			$.messager.alert('提示', '请选择一个用户！', 'info');
		} else {
			$("#userinfo").window("open");
			setUserTableValue(data);
			$('#btn').linkbutton({
				iconCls: 'icon-save',
				onClick: updateUser
			});
		}
	}

	function setUserTableValue(data) {
		$("#ucode").textbox("setValue", data.userCode);
		$("#uname").textbox("setValue", data.userName);
		$("#ugender").textbox("setValue", data.userGender);
		$("#uloginname").textbox("setValue", data.userLoginName);
		$("#uage").textbox("setValue", data.userAge);
		$("#ustature").textbox("setValue", data.userStature);
		$("#uweight").textbox("setValue", data.userWeight);
		$("#utel1").textbox("setValue", data.userTel1);
		$("#utel2").textbox("setValue", data.userTel2);
		$("#uwx").textbox("setValue", data.userWX);
		$("#uqq").textbox("setValue", data.userQQ);
		$("#ubirthday").textbox("setValue", data.userBirthday);
	}

	function updateUser() {
		var user = {
			userCode: $("#ucode").textbox("getValue"),
			userName: $("#uname").textbox("getValue"),
			userGender: $("#ugender").textbox("getValue"),
			userLoginName: $("#uloginname").textbox("getValue"),
			userAge: $("#uage").textbox("getValue"),
			userStature: $("#ustature").textbox("getValue"),
			userWeight: $("#uweight").textbox("getValue"),
			userTel1: $("#utel1").textbox("getValue"),
			userTel2: $("#utel2").textbox("getValue"),
			userWX: $("#uwx").textbox("getValue"),
			userQQ: $("#uqq").textbox("getValue"),
			userBirthday: $("#ubirthday").datebox("getValue")
		}
		$.ajax({
			url: "http://localhost:8080/mycrm/updateUser.do",
			dataType: "JSON",
			contentType: 'application/json;character:utf-8',
			type: "POST",
			data: JSON.stringify(user),
			success: function(data) {
				console.log("editUser-------------------------------");
				$("#userinfo").window("close");
				$(".tbox").textbox("clear");
				$('#usertable').datagrid('reload');
			}
		});

	}

	function removeUser() {
		var data = $("#usertable").datagrid("getSelected");		
		if(null == data) {
			$.messager.alert('提示', '请选择一个用户！', 'info');
		} else {
			var user = {
				userCode: data.userCode
			}
			$.messager.confirm('询问', '确定要删除&nbsp;<span style="color: red;">' + data.userName + '</span>&nbsp;用户吗?', function(r) {
				if(r) {
					$.ajax({
						url: "http://localhost:8080/mycrm/removeUser.do",
						dataType: "JSON",
						contentType: 'application/json;character:utf-8',
						type: "POST",
						data: JSON.stringify(user),
						success: function(data) {
							$('#usertable').datagrid('reload');
						}
					});
				}
			});

		}
	}

	function initInsertUser() {
		$("#userinfo").window("open");
		$(".tbox").textbox("clear");
		$('#btn').linkbutton({
			iconCls: 'icon-save',
			onClick: insertUser
		});
	}

	function insertUser() {
		var user = {
			userCode: $("#ucode").textbox("getValue"),
			userName: $("#uname").textbox("getValue"),
			userGender: $("#ugender").textbox("getValue"),
			userLoginName: $("#uloginname").textbox("getValue"),
			userAge: $("#uage").textbox("getValue"),
			userStature: $("#ustature").textbox("getValue"),
			userWeight: $("#uweight").textbox("getValue"),
			userTel1: $("#utel1").textbox("getValue"),
			userTel2: $("#utel2").textbox("getValue"),
			userWX: $("#uwx").textbox("getValue"),
			userQQ: $("#uqq").textbox("getValue"),
			userBirthday: "848505600000" // $("#ubirthday").textbox("getValue")			
		}
		$.ajax({
			url: "http://localhost:8080/mycrm/saveUser.do",
			dataType: "JSON",
			contentType: 'application/json;character:utf-8',
			type: "POST",
			data: JSON.stringify(user),
			success: function(data) {
				console.log("saveUser-------------------------------");
				$("#userinfo").window("close");
				$(".tbox").textbox("clear");
				$('#usertable').datagrid('reload');
			}
		});

	}

	function initUserTable() {
		//console.log("log1=>"+$("#tt",parent.document).text());获取父级元素
		//console.log("log2=>"+$("#tt",top.document).text());获取顶级元素
		//$("#tt",parent.document).html("sdsd");	
		$("#usertable").datagrid({
			onSelect: function(index, row) {
				parent.initUserPG(row); //调用父级方法
			}
		});
	}
</script>












































</html>


	
		
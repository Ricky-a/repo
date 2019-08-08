<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" type="text/css" href="js/themes/material/easyui.css">
		<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
	</head>

	<style>
		.ui-north {
			height: 80px;
		}

		.ui-west {
			width: 200px;
		}

		.ui-east {
			width: 280px;
		}

		.ui-center {
			padding: 5px;
			background: #eee;
		}

		.ui-south {
			height: 30px;
		}

		#east-userpg {
			width: 300px;
		}
	</style>
	<body class="easyui-layout" data-options="fit:true">

		<div class="ui-north" data-options="region:'north'"></div>

		<div class="ui-west" data-options="region:'west',title:'菜单栏',collapsible:false">

			<div class="easyui-accordion" data-options="collapsible:false" fit="true" id="navmenu"></div>
			<!--			
			<div id="menu">
				<ul id="myTree" class="easyui-tree"></ul>
			</div>-->

		</div>

		<div class="ui-east" data-options="region:'east',title:'右'">

			<table id="east-userpg" class="easyui-propertygrid" data-options="closed:true"></table>


		</div>

		<div class="ui-center" data-options="region:'center',title:'欢迎'">
			<div id="center-tab" class="easyui-tabs" fit="true"></div>
		</div>

		<div class="ui-south" data-options="region:'south'"></div>

	</body>

	<script>
		$(function() {
			//loadTree();
			initRightAccordion();
		});

		/*		
		 *加载功能树
		function loadTree() {
			$('#myTree').tree({
					url: "init/treedata.do",
					onSelect: function(node) { //当点击tree的节点时发生
						var re = node.text;
						var url = node.attributes.url;
						console.log("url==>"+url);
						var flag = $("#center-tab").tabs('exists', re); //在选项卡中获取指定的名称的选项卡是否已经构建过。
						var isLeaf = $('#myTree').tree('isLeaf', node.target);
						if(isLeaf) { //是叶子节点么？叶子节点才会对应一个具体的功能块。
							if(!flag) {
								$('#center-tab').tabs('add', { //在tt选项卡中，创建一个选项页
											title: re,
											closable: true,
											content: "<iframe frameborder='0' src=' "+ url +" '  style='width:100%;height:100%;'  />"  //推荐使用iframe引入一个完整页面
										});
							} else { //如果已经构建过，则直接选中即可。
								$("#center-tab").tabs('select', re);
							}
						}
					}
				});
		}
		*/

		/**
		 * 初始化 east-userpg
		 * @param {Object} row 
		 */
		function initUserPG(row) {
			$("#east-userpg").propertygrid({
				closed: false,
				showGroup: true,
				scrollbarSize: 0,
				columns: [
					[{
							field: 'name',
							title: '属性',
							width: 50,
							sortable: true
						},
						{
							field: 'value',
							title: '值',
							width: 100,
							resizable: false
						}
					]
				]
			});
			var lst = [{
					"name": "编号",
					"value": row.userCode,
					"group": "基本信息"
				},
				{
					"name": "姓名",
					"value": row.userName,
					"group": "基本信息"
				},
				{
					"name": "性别",
					"value": row.userGender,
					"group": "基本信息"
				},
				{
					"name": "登陆名",
					"value": row.userLoginName,
					"group": "基本信息"
				},
				{
					"name": "年龄",
					"value": row.userAge,
					"group": "基本信息"
				},
				{
					"name": "身高",
					"value": row.userStature,
					"group": "基本信息"
				},
				{
					"name": "体重",
					"value": row.userWeight,
					"group": "基本信息"
				},
				{
					"name": "电话1",
					"value": row.userTel1,
					"group": "联系方式"
				},
				{
					"name": "电话2",
					"value": row.userTel2,
					"group": "联系方式"
				},
				{
					"name": "微信",
					"value": row.userWX,
					"group": "联系方式"
				},
				{
					"name": "QQ",
					"value": row.userQQ,
					"group": "联系方式"
				},
				{
					"name": "生日",
					"value": row.userBirthday,
					"group": "基本信息"
				}
			];
			$("#east-userpg").propertygrid('loadData', lst);
		}

		function initRightAccordion() {
			$.ajax({
				url: "init/getParentMenu.do",
				dataType: "JSON",
				contentType: 'application/json;character:utf-8',
				type: "POST",
				success: function(data) {
					$.each(data, function(index, m) {
						$('#navmenu').accordion('add', {
							title: m.text,
							content: "<ul id='tree" + m.id + "'></ul>"
						});
						detailMenu(m.id);
					})

				}

			});

		}

		function detailMenu(menuid) {
			var menu = {
				menuCode: menuid
			};
			$.ajax({
				url: "init/getDetailMenu.do",
				dataType: "JSON",
				contentType: 'application/json;character:utf-8',
				data: JSON.stringify(menu),
				type: "POST",
				success: function(data) {
					$("#tree" + menuid).tree({
						data: data,
						onSelect: function(node) {
							var re = node.text;
							var url = node.attributes.url;
							var flag = $("#center-tab").tabs('exists', re);
							var isLeaf = $('#myTree').tree('isLeaf', node.target);
							if (isLeaf) {
								if (!flag) {
									$('#center-tab').tabs('add', {
										title: re,
										closable: true,
										content: "<iframe frameborder='0' src=' " + url + " '  style='width:100%;height:100%;'  />" //推荐使用iframe引入一个完整页面
									});
								} else {
									$("#center-tab").tabs('select', re);
								}
							}
						}
					});
				}

			});

		}
	</script>

</html>

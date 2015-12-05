<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/jquery-easyui-1.4.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/jquery-easyui-1.4.4/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/base.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/button.css">
	<script type="text/javascript" src="<%=path %>/resources/jquery-easyui-1.4.4/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/common.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/main.js"></script>
</head>
<body class="easyui-layout" style="width:100%;height:100%;" data-options="fit:true,fitColumns:true">
	<div id="search" class="easyui-panel" title="查询条件">
		<form id="searchForm">
			<table>
				<tr>
					<td>渠道ID:</td>
					<td><input type="text" id="channelId" name="channelId" /></td>
					<td width="70px" align="right">中文描述:</td>
					<td><input type="text" id="chineseDesc" name="chineseDesc" /></td>
					<td width="70px" align="right">弃包标识:</td>
					<td>
					<span><input type="radio" value='true' name="throwFlag" id="throwFlag" />是</span> 
					<span style="margin-left: 10px"><input type="radio" value="false" name="throwFlag" id="throwFlag" />否</span>
					</td>
					<td width='70px' align="right">停用标识:</td>
					<td>
					<span><input type="radio" value='true' name="isDown" id="isDown" />是</span> 
					<span style="margin-left: 10px"><input type="radio" value="false" name="isDown" id="isDown" />否</span>
					</td>
					<td width='20px'>&nbsp;</td>
					<td><input type="button" class="btn-search" onclick="queryData()" value="查询" /></td>
					<td></td>
					<td><input type="button" class="btn-clear" onclick="clearText()" value="清空" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="height: 10px; display: block;"></div>
	<div id="dataList" title="运营渠道表" class="easyui-panel" style="width: 100%; max-height: 95%; height: auto !important;" align="center"></div>

	<div id="addwindow" class="easyui-dialog" title="添加" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
		<form id="addForm">
			<div class="div_margin_top">
				<label for="name">渠  道  ID :</label> 
				<input class="easyui-validatebox" type="text" id="channelId" style="width: 150px;" name="channelId" data-options="required:true" />
			</div>															
			<div class="div_margin_top">
				<label for="name">中文描述:</label> 
				<input class="easyui-textbox" data-options="multiline:true" id="chineseDesc" name="chineseDesc" 					
					style="width: 150px; height: 80px">
			</div>
			<div class="div_margin_top">
				<label for="name">供应商ID:</label>
				<input class="easyui-combobox"type="text" id="supplierId_A"  style="width: 150px;" name="supplierId" data-options="required:true" />
			</div>
			<div class="div_margin_top">
				<label for="name">弃包标识:</label> 
				<span><input type="radio" value='true' name="throwFlag" id="throwFlag" />是</span> 
				<span style="margin-left: 20px"><input type="radio" value="false" name="throwFlag" id="throwFlag" />否</span>
			</div>
			<div class="div_margin_top">
				<label for="name">看板标识:</label>
				 <span><input type="radio" value='true' name="paintFlag" id="paintFlag" />是</span> 
				 <span style="margin-left: 20px"><input type="radio" value="false" name="paintFlag" id="paintFlag" />否</span>
			</div>
			<div class="div_margin_top">
				<label for="name">是否停用:</label> 
				<span><input type="radio" value='true' name="isDown" id="isDown" />是</span> 
				<span style="margin-left: 20px"><input type="radio" value="false" name="isDown" id="isDown" />否</span>
			</div>
		</form>
		<div class="toolbar div_margin_top" align="center">
			<a href="javascript:insertData();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> 
			<a href="javascript:closeDialog('add');" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
		</div>
	</div>
	<div id="updatewindow" class="easyui-dialog" title="修改" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
		<form id="updateForm">
			<div>
				<input type="hidden" id="id" name="id" /> 
				<label for="name">渠  道  ID :</label>
				<input class="easyui-validatebox" type="text" id="channelId" name="channelId" data-options="required:true" readonly />
			</div>
			<div class="div_margin_top">
				<label for="name">中文描述:</label> 
				<input class="easyui-textbox" data-options="multiline:true" id="chineseDesc" name="chineseDesc" 
					style="width: 150px; height: 80px">
			</div>
			<div class="div_margin_top">
				<label for="name">供应商ID:</label>
				<input class="easyui-combobox"type="text" id="supplierId_E" name="supplierId" data-options="required:true" />
			</div>
			<div class="div_margin_top">
				<label for="name">弃包标识:</label> 
				<span><input type="radio" value='true' name="throwFlag" id="throwFlag" />是</span> 
				<span style="margin-left: 20px"><input type="radio" value="false" name="throwFlag" id="throwFlag" />否</span>
			</div>
			<div class="div_margin_top">
				<label for="name">看板标识:</label>
				 <span><input type="radio" value='true' name="paintFlag" id="paintFlag" />是</span> 
				 <span style="margin-left: 20px"><input type="radio" value="false" name="paintFlag" id="paintFlag" />否</span>
			</div>
			<div class="div_margin_top">
				<label for="name">是否停用:</label> 
				<span><input type="radio" value='true' name="isDown" id="isDown" />是</span> 
				<span style="margin-left: 20px"><input type="radio" value="false" name="isDown" id="isDown" />否</span>
			</div>
		</form>
		<div class="toolbar div_margin_top" align="center">
			<a href="javascript:updateData();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> 
			<a href="javascript:closeDialog('update');" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
		</div>
	</div>
	<div id="checkwindow" class="easyui-dialog" title="查看" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
		<form id="checkForm">
			<div>
				<input type="hidden" id="id" name="id" /> 
				<label for="name">渠  道  ID :</label>
				<input class="easyui-validatebox" type="text" id="channelId" name="channelId" data-options="required:true" />
			</div>
			<div class="div_margin_top">
				<label for="name">中文描述:</label> 
				<input class="easyui-textbox" data-options="multiline:true" id="chineseDesc" name="chineseDesc" style="width: 150px; height: 80px"/>
			</div>
			<div class="div_margin_top">
				<label for="name">供应商ID:</label>
				<input class="easyui-combobox"type="text" id="supplierId_E" name="supplierId" data-options="required:true"/>
			</div>
			<div class="div_margin_top">
				<label for="name">弃包标识:</label> 
				<span><input type="radio" value='true' name="throwFlag" id="throwFlag" />是</span> 
				<span style="margin-left: 20px"><input type="radio" value="false" name="throwFlag" id="throwFlag"/>否</span>
			</div>
			<div class="div_margin_top">
				<label for="name">看板标识:</label>
				 <span><input type="radio" value='true' name="paintFlag" id="paintFlag" />是</span> 
				 <span style="margin-left: 20px"><input type="radio" value="false" name="paintFlag" id="paintFlag" />否</span>
			</div>
			<div class="div_margin_top">
				<label for="name">是否停用:</label> 
				<span><input type="radio" value='true' name="isDown" id="isDown" />是</span> 
				<span style="margin-left: 20px"><input type="radio" value="false" name="isDown" id="isDown" />否</span>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function() {
	$('#addwindow').window('close');
	$('#updatewindow').window('close');
	$('#checkwindow').window('close');	
	$('#dataList').datagrid({
		url : '<%=path %>/operatorChannel/getDataGrid',
		method : 'GET',
		columns : [[
		{field:'id',title:'ID',align:'center',hidden:true},
		{field:'channelId',title:'渠道ID',align:'center',width:100},
		{field:'chineseDesc',title:'中文描述',align:'left',width:200},
		{field:'supplierId',title:'渠道商ID',align:'center',width:100},
		{field:'throwFlag',title:'弃包标识',align:'center',width:100,
			formatter: function(value,row,index){
				if(value==true){
					return '弃包';
				}else if(value == false){
					return '不弃包';
				}
			}
		},
		{field:'paintFlag',title:'看板标识',align:'center',width:100,
			formatter: function(value,row,index){
				if(value==true){
					return '可看';
				}else if(value == false){
					return '不可看';
				}
			}
		},
		{field:'isDown',title:'是否停用',align:'center',width:100,
			formatter: function(value,row,index){
				if(value==true){
					return '是';
				}else if(value == false){
					return '否';
				}
			}
		},
		{field:'createName',title:'创建人',align:'center',width:100},
		{field:'createDatetime',title:'创建时间',align:'center',width:130,formatter:formatTime},
		{field:'updateName',title:'修改人',align:'center',width:100},
		{field:'updateDatetime',title:'修改时间',align:'center',width:130,formatter:formatTime},
		{field:'operate',title:'操作',align:'center',width:100,
			formatter: function(value,row,index){
				var edit = '<a href="javascript:view(\''+row.id+'\')">查看详情</a>';
				return edit;
			}
		}]],
		toolbar : [ {
			id : 'btnadd',
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				$('#addwindow').window('open');
			}
		}, {
			id : 'btnmodify',
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				var row = $('#dataList').datagrid("getSelected");
				if(row == null){
					$.messager.alert('提示','请选择一条记录!','warn');
					return;
				}
				showModifyDialog(row);
			}
		}, {
			id : 'btncut',
			text : '删除',
			iconCls : 'icon-cut',
			handler : function() {
				var rows = $('#dataList').datagrid("getSelections");
				// var row = $('#dataList').datagrid("getSelected");
				if(rows.length != 1){
					$.messager.alert('提示框','请选择一条记录','warning');  
				}else {
					var params = {"id" : rows[0].id};
					$.ajax({
							url:'<%=path %>/operatorChannel/delete',
							type:'POST',
							dataType:"json",
							data:params,
							async:false,
							success:function(data){
								if(data.code == 200){
									$.messager.alert('提示',"删除成功!",'info');
								}else{
									$.messager.alert('提示',data.message,'error');
								}
							}
					});
					freshPage();
				}			
			}
		} ],
		nowrap:false,
		striped:true,//设置为true将交替显示行背景
        singleSelect:false,//设置为true将只允许选择一行
        checkOnSelect:true,//如果设置为 true，当用户点击一行的时候checkbox checked(选择)/unchecked(取消选择)。 如果为false，当用户点击刚好在checkbox的时候，checkbox checked(选择)/unchecked(取消选择)
	    selectOnCheck:true,
        rownumbers:true, //设置为true将显示行数
	    pagination:true, //设置true将在数据表格底部显示分页工具栏
	    remoteSort:false,
	    pageNumber:1,//当设置分页属性时，初始化分页码
	    pageSize:20,//当设置分页属性时，初始化每页记录数
	    pageList:[20,30,40] //当设置分页属性时，初始化每页记录数列表
	});	
});

function view(id){
	var params = {};
	 $.ajax({
			url:'<%=path %>/operatorChannel/queryById?id='+ id,
			type:'POST',
			dataType:"json",
			async:false,
			success:function(data){
				if(data.code == 200){
					params = data.result;
				}else{
					$.messager.alert('提示',data.message,'error');
				}
			}
	 });
	 $('#checkForm').form('load',params);
	 $('#checkwindow').window('open');
}

function showModifyDialog(row){
	 var params = row;
	 $('#updateForm').form('load',params);
	 $('#updatewindow').window('open');
}

function insertData() {
	 var params = $("#addForm").toJson();
	 $.ajax({
			url:'<%=path %>/operatorChannel/insert',
			type:'POST',
			dataType:"json",
			data:params,
			success:function(data){
				if(data.code == 200){
					$.messager.alert('提示','新增成功!','info');
					closeDialog('add');
					freshPage();
				}else{
					$.messager.alert('提示',data.message,'error');
				}
			}
	 });
}

function updateData() {
	var params = $("#updateForm").toJson();
	 $.ajax({
			url:'<%=path %>/operatorChannel/update',
			type:'POST',
			dataType:"json",
			data:params,
			success:function(data){
				if(data.code == 200){
					$.messager.alert('提示','修改成功!','info');
					closeDialog('update');
					freshPage();
				}else{
					$.messager.alert('提示',data.message,'error');
				}
			}
	 });
}

function queryData() {
	 var params = {};
	 var channelId = $("#channelId").val();
	 if(channelId!=null && channelId!=''){
		 params.channelId = channelId;
	 }
	 var chineseDesc = $("#chineseDesc").val();
	 if(chineseDesc!=null && chineseDesc!=''){
		 params.chineseDesc = chineseDesc;
	 }
	 var throwFlag = $("input[name='throwFlag']:checked").val();
	 if(throwFlag!=null && throwFlag!=''){
		 params.throwFlag = throwFlag;
	 }
	 var isDown = $("input[name='isDown']:checked").val();
	 if(isDown!=null && isDown!=''){
		 params.isDown = isDown;
	 }
	 $('#dataList').datagrid('load',params);
}

function closeDialog(type){
	 $("#"+type+"Form").form("clear");
	 $("#"+type+"window").window("close");
}

function freshPage(){
	$('#dataList').datagrid({
		   url:'<%=path %>/operatorChannel/getDataGrid',
		   method:'GET',
	       loadMsg : "正在加载，请稍等..."
	});
}
</script>
</html>
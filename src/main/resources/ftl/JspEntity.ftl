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
<#if pro?exists>
<body class="easyui-layout" style="width:100%;height:100%;" data-options="fit:true,fitColumns:true">
	<div id="search" class="easyui-panel" title="查询条件">
		<form id="searchForm">
			<table>
				<tr>
					<#list pro.columns as c>
					<#if c_index != 0>
					<td>${c.fieldDesc}</td>
					<td><input type="text" id="${c.fieldName}" name="${c.fieldName}" /></td>
					</#if>
					</#list>
					<td width='20px'>&nbsp;</td>
					<td><input type="button" class="btn-search" onclick="queryData()" value="查询" /></td>
					<td></td>
					<td><input type="button" class="btn-clear" onclick="clearText()" value="清空" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="height: 10px; display: block;"></div>
	<div id="dataList" title="" class="easyui-panel" style="width: 100%; max-height: 95%; height: auto !important;" align="center"></div>

	<div id="addwindow" class="easyui-dialog" title="添加" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
		<div class="form_div">
		  <form id="addForm" name="proform" method="post" style="padding: 20px 10px 20px 10px">
		  	<table width="380px" border="0" cellpadding="0" cellspacing="0" class="tab">
			<#list pro.columns as c>
			<#if c_index != 0>
				<tr>
				 	<td class="td_remark"><span style="color: red;">*</span>&nbsp;<label>${c.fieldDesc}:</label></td>
                    <td><input class="easyui-validatebox" type="text" id="${c.fieldName}" style="width: 150px;" name="${c.fieldName}" data-options="required:true" /></td>
                </tr>
			</#if>
			</#list>
				<tr>
                    <td colspan="2" align="center" height="40px">
                        <a href="javascript:insertData();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> 
						<a href="javascript:closeDialog('add');" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
                    </td>
                </tr>
            </table>
		 </form>
	    </div>
	</div>
	<div id="updatewindow" class="easyui-dialog" title="修改" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
		<div class="form_div">
		  <form id="updateForm" name="proform" method="post" style="padding: 20px 10px 20px 10px">
		  	<#if c_index == 0>
			<input type="hidden" id="${c.fieldName}" name="${c.fieldName}" /> 
			</#if>
		  	<table width="380px" border="0" cellpadding="0" cellspacing="0" class="tab">
			<#list pro.columns as c>
			<#if c_index != 0>
				<tr>
				 	<td class="td_remark"><span style="color: red;">*</span>&nbsp;<label>${c.fieldDesc}:</label></td>
                    <td><input class="easyui-validatebox" type="text" id="${c.fieldName}" style="width: 150px;" name="${c.fieldName}" data-options="required:true" /></td>
                </tr>
			</#if>
			</#list>
				<tr>
                    <td colspan="2" align="center" height="40px">
                        <a href="javascript:updateData();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> 
						<a href="javascript:closeDialog('add');" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
                    </td>
                </tr>
            </table>
		 </form>
	    </div>
	</div>
	<div id="checkwindow" class="easyui-dialog" title="查看详情" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
		<div class="form_div">
		  <form id="checkForm" name="proform" method="post" style="padding: 20px 10px 20px 10px">
		  	<table width="380px" border="0" cellpadding="0" cellspacing="0" class="tab">
			<#list pro.columns as c>
			<#if c_index != 0>
				<tr>
				 	<td class="td_remark"><span style="color: red;">*</span>&nbsp;<label>${c.fieldDesc}:</label></td>
                    <td><input class="easyui-validatebox" type="text" id="${c.fieldName}" style="width: 150px;" name="${c.fieldName}" data-options="required:true" /></td>
                </tr>
			</#if>
			</#list>
            </table>
		 </form>
	    </div>
	</div>
</body>
</#if>
<script type="text/javascript">
$(function() {
	$('#addwindow').window('close');
	$('#updatewindow').window('close');
	$('#checkwindow').window('close');	
	$('#dataList').datagrid({
		url : '<%=path %>/${pro.className?uncap_first}/getDataGrid',
		method : 'GET',
		columns : [[
		<#list pro.columns as c>
		<#if c_index == 0>
		{field:'${c.fieldName}',title:'${c.fieldDesc}',align:'center',hidden:true},
		</#if>
		<#if c_index != 0>
		{field:'${c.fieldName}',title:'${c.fieldDesc}',align:'center',width:100},
		</#if>
		</#list>
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
							url:'<%=path %>/${pro.className?uncap_first}/delete',
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
			url:'<%=path %>/${pro.className?uncap_first}/queryById?id='+ id,
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
			url:'<%=path %>/${pro.className?uncap_first}/insert',
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
			url:'<%=path %>/${pro.className?uncap_first}/update',
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
	 <#list pro.columns as c>
	 <#if c_index != 0>
	 var ${c.fieldName} = $("#${c.fieldName}").val();
	 if(${c.fieldName} !=null && ${c.fieldName} !=''){
		 params.${c.fieldName} = ${c.fieldName};
	 }
	 </#if>
	 </#list>
	 //var throwFlag = $("input[name='throwFlag']:checked").val();
	 //if(throwFlag!=null && throwFlag!=''){
	 //	 params.throwFlag = throwFlag;
	 //}
	 $('#dataList').datagrid('load',params);
}

function closeDialog(type){
	 $("#"+type+"Form").form("clear");
	 $("#"+type+"window").window("close");
}

function freshPage(){
	$('#dataList').datagrid({
		   url:'<%=path %>/${pro.className?uncap_first}/getDataGrid',
		   method:'GET',
	       loadMsg : "正在加载，请稍等..."
	});
}
</script>
</html>
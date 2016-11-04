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
	<div id="search" class="easyui-panel" title="镆ヨ鏉′欢">
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
					<td><input type="button" class="btn-search" onclick="queryData()" value="镆ヨ" /></td>
					<td></td>
					<td><input type="button" class="btn-clear" onclick="clearText()" value="娓呯┖" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="height: 10px; display: block;"></div>
	<div id="dataList" title="" class="easyui-panel" style="width: 100%; max-height: 95%; height: auto !important;" align="center"></div>

	<div id="addwindow" class="easyui-dialog" title="娣诲姞" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
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
                        <a href="javascript:insertData();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">淇濆瓨</a> 
						<a href="javascript:closeDialog('add');" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">鍏抽棴</a>
                    </td>
                </tr>
            </table>
		 </form>
	    </div>
	</div>
	<div id="updatewindow" class="easyui-dialog" title="淇敼" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
		<div class="form_div">
		  <form id="updateForm" name="proform" method="post" style="padding: 20px 10px 20px 10px">
		  	<#list pro.columns as c>
		  	<#if c_index == 0>
			<input type="hidden" id="${c.fieldName}" name="${c.fieldName}" /> 
			</#if>
			</#list>
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
                        <a href="javascript:updateData();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">淇濆瓨</a> 
						<a href="javascript:closeDialog('update');" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">鍏抽棴</a>
                    </td>
                </tr>
            </table>
		 </form>
	    </div>
	</div>
	<div id="checkwindow" class="easyui-dialog" title="镆ョ湅璇︽儏" style="width: 350px;top:10%;height: 300px; display: block;" data-options="resizable:false,modal:true,closed:true">
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
		{field:'operate',title:'鎿崭綔',align:'center',width:100,
			formatter: function(value,row,index){
				var edit = '<a href="javascript:view(\''+row.id+'\')">镆ョ湅璇︽儏</a>';
				return edit;
			}
		}]],
		toolbar : [ {
			id : 'btnadd',
			text : '鏂板',
			iconCls : 'icon-add',
			handler : function() {
				$('#addwindow').window('open');
			}
		}, {
			id : 'btnmodify',
			text : '淇敼',
			iconCls : 'icon-edit',
			handler : function() {
				var row = $('#dataList').datagrid("getSelected");
				if(row == null){
					$.messager.alert('鎻愮ず','璇烽€夋嫨涓€鏉¤褰?','warn');
					return;
				}
				showModifyDialog(row);
			}
		}, {
			id : 'btncut',
			text : '鍒犻櫎',
			iconCls : 'icon-cut',
			handler : function() {
				var rows = $('#dataList').datagrid("getSelections");
				// var row = $('#dataList').datagrid("getSelected");
				if(rows.length != 1){
					$.messager.alert('鎻愮ず妗?,'璇烽€夋嫨涓€鏉¤褰?,'warning');  
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
									$.messager.alert('鎻愮ず',"鍒犻櫎鎴愬姛!",'info');
								}else{
									$.messager.alert('鎻愮ず',data.message,'error');
								}
							}
					});
					freshPage();
				}			
			}
		} ],
		nowrap:false,
		striped:true,//璁剧疆涓篓rue灏嗕氦镟挎樉绀鸿鑳屾櫙
        singleSelect:false,//璁剧疆涓篓rue灏嗗彧鍏佽阃夋嫨涓€琛?
        checkOnSelect:true,//濡傛灉璁剧疆涓?true锛屽綋鐢ㄦ埛镣瑰向涓€琛岀殑镞跺€檆heckbox checked(阃夋嫨)/unchecked(鍙栨秷阃夋嫨)銆?濡傛灉涓篺alse锛屽綋鐢ㄦ埛镣瑰向鍒氩ソ鍦╟heckbox镄勬椂链欙紝checkbox checked(阃夋嫨)/unchecked(鍙栨秷阃夋嫨)
	    selectOnCheck:true,
        rownumbers:true, //璁剧疆涓篓rue灏嗘樉绀鸿鏁?
	    pagination:true, //璁剧疆true灏嗗湪鏁版嵁琛ㄦ牸搴曢儴鏄剧ず鍒嗛〉宸ュ叿镙?
	    remoteSort:false,
	    pageNumber:1,//褰撹缃垎椤靛睘镐ф椂锛屽垵濮嫔寲鍒嗛〉镰?
	    pageSize:20,//褰撹缃垎椤靛睘镐ф椂锛屽垵濮嫔寲姣忛〉璁板綍鏁?
	    pageList:[20,30,40] //褰撹缃垎椤靛睘镐ф椂锛屽垵濮嫔寲姣忛〉璁板綍鏁板垪琛?
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
					$.messager.alert('鎻愮ず',data.message,'error');
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
				$.messager.alert('鎻愮ず','鏂板鎴愬姛!','info');
				closeDialog('add');
				freshPage();
			}else{
				$.messager.alert('鎻愮ず',data.message,'error');
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
				$.messager.alert('鎻愮ず','淇敼鎴愬姛!','info');
				closeDialog('update');
				freshPage();
			}else{
				$.messager.alert('鎻愮ず',data.message,'error');
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
	    loadMsg : "姝ｅ湪锷犺浇锛岃绋岖瓑..."
	});
}
</script>
</html>
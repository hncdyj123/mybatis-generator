$(function(){
	//启动验证框
	$('.validatebox-text').bind('blur', function(){
		$(this).validatebox('enableValidation').validatebox('validate');
	});
})

function toFixed(s,precision) {
	s+="";
	if(s==""&&s==null){
		return 0.00;
	}
	var n = 0;
	if(precision!=""){
		n=2;
	}else{
		n = (s.length-1)-(s.split(".")[0].length) > 0 && n <= 20 ? n : 2;  
	}
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";  
	var l = s.split(".")[0].split("").reverse(),  
	r = s.split(".")[1];  
	t = "";  
	for(i = 0; i < l.length; i ++ )  
	{  
	   t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");  
	}  
	return t.split("").reverse().join("") + "." + r;  
}

function dateFormat(value) {
	if(value!=""&&value!=null){
		var time = value.toString();
		var year=time.substring(0, 4);
		var month=time.substring(4, 6);
		var date=time.substring(6, 8);
		var hours=time.substring(8, 10);
		var minutes=time.substring(10, 12);
		var seconds=time.substring(12, 14);
		var dateTime="";
		if(year!=""){
			dateTime+=year;
			if(month!=""){
				dateTime+="-"+month;
				if(date!=""){
					dateTime+="-"+date;
					if(hours!=""){
						dateTime+=" "+hours
						if(minutes!=""){
							dateTime+=":"+minutes
							if(seconds!=""){
								dateTime+=":"+seconds
							}
						}
					}
				}
			}
		}
		return dateTime
	}
}

function formatTime(value) {
	var time = new Date(value);
	var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var f = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+' '+(h<10?('0'+h):h)+':'+(f<10?('0'+f):f)+':'+(s<10?('0'+s):s) ;
}


function formatterDate(date) {
	var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
	var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
	+ (date.getMonth() + 1);
	return date.getFullYear() + '-' + month + '-' + day;
};

//提示谈出框（居中）
function messageShow(title,message,top,time){
	top = top ? top : document.body.scrollTop+document.documentElement.scrollTop;
	$.messager.show({
		width:'300px',
		height:'100px',
		title:title,
		msg:message,
		showType:'show',
		timeout:time?time:1000,
		closable:false,
		style:{
			right:'',
			top:document.body.scrollTop+document.documentElement.scrollTop,
			bottom:''
		}

	});  
}
/**
 * 计算两值相除的百分率
 * @param a
 * @param b
 * @param c
 * @returns {String}
 */
function checkNum(a,b,c){
	if(a==null||b==0){
		return '0.00%'
	}else if(b==null||b==0){
		return '0.00%'
	}
	return toFixed(a*100/b,c)+'%'
}

/**
* 加法运算，避免数据相加小数点后产生多位数和计算精度损失。
*
* @param num1加数1 | num2加数2
*/
function numAdd(num1, num2) {
	var baseNum, baseNum1, baseNum2;
	try {
		baseNum1 = num1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = num2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
	return (num1 * baseNum + num2 * baseNum) / baseNum;
};
/**
* 减法运算，避免数据相减小数点后产生多位数和计算精度损失。
*
* @param num1被减数 | num2减数
*/
function numSub(num1, num2) {
	var baseNum, baseNum1, baseNum2;
	var precision;// 精度
	try {
		baseNum1 = num1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = num2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
	precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2;
	return ((num1 * baseNum - num2 * baseNum) / baseNum).toFixed(precision);
};

/**
* 乘法运算，避免数据相乘小数点后产生多位数和计算精度损失。
*
* @param num1被乘数 | num2乘数
*/ 
function numMulti(num1, num2) {
	var baseNum = 0;
	try {
		baseNum += num1.toString().split(".")[1].length;
	} catch (e) {
		
	}
	try {
		baseNum += num2.toString().split(".")[1].length;
	} catch (e) {
		
	}
	return Number(num1.toString().replace(".", "")) * Number(num2.toString().replace(".", "")) / Math.pow(10, baseNum);
};

/**
* 除法运算，避免数据相乘小数点后产生多位数和计算精度损失。
*
* @param num1被乘数 | num2乘数
*/ 
function numDiv(num1, num2) {
	var baseNum1 = 0, baseNum2 = 0;
	var baseNum3, baseNum4;
	try {
		baseNum1 = num1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = num2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	with (Math) {
		baseNum3 = Number(num1.toString().replace(".", ""));
		baseNum4 = Number(num2.toString().replace(".", ""));
		return (baseNum3 / baseNum4) * pow(10, baseNum2 - baseNum1);
	}
};
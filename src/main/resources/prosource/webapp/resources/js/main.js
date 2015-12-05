(function($){
        $.fn.toJson=function(){
            var serializeObj={};
            var array=this.serializeArray();
            var str=this.serialize();
            $(array).each(function(){
                if(serializeObj[this.name]){
                    if($.isArray(serializeObj[this.name])){
                        serializeObj[this.name].push(this.value);
                    }else{
                        serializeObj[this.name]=[serializeObj[this.name],this.value];
                    }
                }else{
                    serializeObj[this.name]=this.value;
                }
            });
            return serializeObj;
        };
    })(jQuery);

function isNull( str ){
	if ( str == "" ){
		return true;
	}
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

/**
 * 获取当前时间的前几天 或后几天
 * @param AddDayCount -1（前一天） 2（后两天） 0（今天）
 * @returns {String}
 */
function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期
    var d = dd.getDate();
    return y+"-"+m+"-"+d;
}
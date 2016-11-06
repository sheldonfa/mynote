/**
 * Created by fangxin on 2016/11/5.
 *
 */

var $$ = function(){};
$$.prototype = {
    extend:function(tar,source){
        for(var i in source){
            tar[i] = source[i]
        }
        return tar;
    }
};
$$ = new $$();


/*基础模块*/
$$.extend($$,{
    alert:function(){
        alert("aa");
    }
});
/*事件模块*/
/*选择框架*/
/*字符串相关操作模块*/
/*日期相关操作模块*/
/*数字相关操作模块*/
/*判断数据类型*/

$.extend()
/**
 * Created by fangxin on 2016/11/5.
 *
 */




/*立即函数不用写调用了，本身就包含了函数定义和调用*/
(function(window,id){
    var ff = function(id){
        this.element;
        return this.$id(id)
    };
    ff.prototype = {
        extend:function(tar,source){
            for(var i in source){
                tar[i] = source[i]
            }
            return tar;
        },
        $id:function(id){
            this.element = document.getElementById(id);
            return this;
        },
        html:function(data){
            this.element.innerHTML=data;
        }
    };

    var $$ = function(id){
        return new ff(id);
    };


    /*基础模块*/
    /*事件模块*/
    /*选择框架*/
    /*字符串相关操作模块*/
    /*日期相关操作模块*/
    /*数字相关操作模块*/
    /*判断数据类型*/


    window.ff=window.$$ = $$;
})(window);

/*公共*/
(function(){

})($$);
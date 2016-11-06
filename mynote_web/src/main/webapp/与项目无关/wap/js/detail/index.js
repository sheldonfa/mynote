/**
 * Created by zhousg on 2015/12/18.
 */

/*事件处理对象*/
//var evtHandler = {
//    getPro: function(){
//        network.getPro().done(function(data){
//            var proJson = JSON.parse(data);
//            var product = new Product();
//        })
//    }
//};
///*网络请求对象*/
//var network = {
//    getPro: function(){
//        var q = $.Deferred();
//        $.ajax({
//            "async":true,
//            "type":"POST",
//            "url":"/product/getMPro",
//            "data":{},
//            "success":function(data){
//                q.resolve(data);
//            },
//            "error" : function(data){
//            }
//        });
//        return q;
//    }
//};
//
///*dom操作对象*/
//var dom = {
//
//};

/*页面ready*/
$(function(){
    // 产品
    var product = new Product();
    product.name="小绿衣服";
    product.marketPrice="100";
    product.sellPrice="10";
    product.stock="200";

    product.bindBasic();
    product.bindEvents();

    // 店铺
    var store = new Store();
    store.bindBasic();
    store.bindEvents();

    // 评论
    var comment = new Comment();
    comment.bindBasic();
    comment.bindEvents();

    //evtHandler.bind();

});

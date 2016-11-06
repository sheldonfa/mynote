/**
 * Created by zhousg on 2015/12/18.
 */

var btnEnterStore = ".enter";

function MyStore(){
    this.config = {
        // 店铺信息
        storeName:".enterStore .enterStoreCt .title",
        connect:".enterStore .enterStoreCt .shopCustomer span",
        time:".enterStore .enterStoreCt .time span",
        credibility:".enterStore .enterStoreCt .credibility",
        /*查看店铺详情*/
        // 按钮
        btnLookShopDetail:".lookShopDetail .scrapt i",
        // 描述
        shopDetail:".lookShopDetail .evaludeate",

        /*优惠券*/
        // 按钮
        btnCoupon:".valueVoucher .scrapt i",
        // 内容
        couponContent:".valueVoucher .scrapt ul"
    };
    // 名称
    this.storeName = "店铺名称";
    // 店主名称
    this.connect = "李三";
    // 时间
    this.time = "09:00-18:00";
    // 信誉度
    this.cred = 5;

}
MyStore.prototype={
    bindDom:function(){
        $(this.config.storeName).html(this.storeName);
        $(this.config.connect).html(this.connect);
        $(this.config.time).html(this.time);
    },
    bindCred:function(){
        $(this.config.credibility).empty().append('<span>信誉度 :</span>');
        var str = '';
        for(var i=0;i<this.cred;i++){
            str += '<i><img src="image/star.png" alt=""></i>';
        }
        for(var i=0;i<5-this.cred;i++){
            str += '<i><img src="image/star.png" alt=""></i>';
        }
        $(this.config.credibility).append(str);
    },
    /*绑定基本事件*/
    bindBasic:function(){
        this.bindDom();
        this.bindCred();
    },
    // 绑定事件
    bindEvents:function(){
        // 进入店铺
        $(btnEnterStore).on("click"),function(){
            alert("aa");
        }
    }
};

/**
 * Created by zhousg on 2015/12/18.
 */

function Product(){
    this.config = {
        /*产品*/
        proName:"#proName",
        marketPrice:".yuanPrice a",
        sellPrice:".price a",
        stock:"#stock",
        /*优惠券*/
        btnShowCoupon:".coupon .scrapt .amount i:last",
        btnHideCoupon:".coupon .scrapt .amount i:first",
        couponContent:".coupon ul.couponList",
        couponLi:".coupon .couponList li:gt(2)",
        /*规格*/
        sizeContent:".sizeColor .size p",
        sizeElement:".sizeColor .size p a",
        colorContent:".sizeColor .color p",
        colorElement:".sizeColor .color p a",
        /*配送*/
        deliverContent:".send",
        /*产品详情*/
        prop:".productDetile .productDetileCt",
        content:".positionImg"
    };
    // 名称
    this.name = "";
    // 原价
    this.marketPrice = "0";
    // 市价
    this.sellPrice = "0";
    // 库存
    this.stock = "0";
    // 轮播图片
    this.images = [
        {des1:'../image/image_0.png'},
        {des2:'../image/image_0.png'},
        {des3:'../image/image_0.png'},
        {des4:'../image/image_0.png'},
        {des5:'../image/image_0.png'}
    ];
    // 优惠券
    this.couponList = [{price:10,useCondition:100},
        {price:11,useCondition:110},
        {price:11,useCondition:110},
        {price:11,useCondition:110},
        {price:11,useCondition:110},
        {price:11,useCondition:110},
        {price:11,useCondition:110},
        {price:11,useCondition:110}
    ];
    // 类型
    this.type = 1;
    // 尺寸
    this.size = ["XX","XS","XL"];
    // 颜色
    this.color = ["红色","蓝色","白色"];
    // 配送说明
    this.deliver = ["大连","琅琊山","九州岛"];
    // 属性
    this.prop = [{key:"产地",value:"齐齐哈尔"},{key:"等级",value:"AAAAA级"}, {key:"颜色",value:"红色"},{key:"尺寸",value:"XX"}];
    // 产品详情
    this.detail = '<p><img src="image/image_2.png" alt=""></p>';
}
Product.prototype={
    // 绑定图片
    // TODO
    bindDOMImage:function(){
        //var str = '';
        //for(var i= 0,len=this.images.length;i<len;i++){
        //    str+=''
        //}
    },
    // 绑定基本信息
    bindDomDetail:function(){
        $(this.config.proName).html(this.name);
        $(this.config.sellPrice).html(this.sellPrice);
        $(this.config.marketPrice).html(this.marketPrice);
        $(this.config.stock).html(this.stock+"件");
    },
    /*绑定优惠券基本信息*/
    bindCoupon:function(){
        var str = '';
        for(var i in this.couponList){
            //if(i==2){
            //    str +=  '<ul id="showList" style="display: none;">';
            //}
            //if(i==this.couponList.length){
            //    str +=  '</ul>';
            //}
            if(i>=2){
                str += '<li style="display: none;">'+
                            '<i><img src="image/leftImg.png" alt=""></i>'+
                                '<p>满'+this.couponList[i].useCondition+'减'+this.couponList[i].price+'</p>'+
                            '<b><img src="image/rightImg.png" alt=""></b>'+
                        '</li>';
            }else{
                str += '<li>'+
                            '<i><img src="image/leftImg.png" alt=""></i>'+
                                '<p>满'+this.couponList[i].useCondition+'减'+this.couponList[i].price+'</p>'+
                            '<b><img src="image/rightImg.png" alt=""></b>'+
                        '</li>';
            }
        }
        $(this.config.couponContent).empty().append(str);

    },
    /*绑定规格*/
    bindSpec:function(){
        if(this.type==1){
            // 颜色
            var strc = '';
            for(var i in this.color){
                strc +='<a>'+this.color[i]+'</a>'
            }
            $(this.config.colorContent).empty().append(strc);
            // 尺寸
            var strs = '';
            for(var i in this.size){
                strs +='<a>'+this.size[i]+'</a>'
            }
            $(this.config.sizeContent).empty().append(strs);
        }else{
            $(this.config.colorContent).parent().hide();
            $(this.config.sizeContent).parent().hide();
        }
    },
    /*配送说明*/
    bindDeliver:function(){
        $(this.config.deliverContent).empty().append('<span>配送说明</span>');
        var str = '';
        for(var i in this.deliver){
            str += '<a>'+this.deliver[i]+'</a><b>    </b>';
        }
        $(this.config.deliverContent).append(str);
    },
    /*绑定商品详情*/
    bindDetail:function(){
        var str = '';
        for(var i in this.prop){
            str += '<li style="border-right: 1px solid #b3b3b3;">'+
                        '<div class="scrapt">'+
                        ''+this.prop[i].key+': <span>'+this.prop[i].value+'</span>'+
                        '</div>'+
                    '</li>'
        }
        $(this.config.prop).empty().append(str);
        $(this.config.content).empty().append(this.detail);
    },
    /*绑定基本事件*/
    bindBasic:function(){
        this.bindDOMImage();
        this.bindDomDetail();
        this.bindCoupon();
        this.bindSpec();
        this.bindDetail();
        this.bindDeliver();
    },
    bindInit:function(){
        $(this.config.sizeElement).eq(0).trigger("click");
        $(this.config.colorElement).eq(0).trigger("click");
    },
    // 绑定事件
    bindEvents:function(){
        // 显示更多优惠券
        $(this.config.btnShowCoupon).on("click",function(){
            $(".coupon .couponList li:gt(2)").show();
            $(this).hide().siblings("i").show();
        });
        $(this.config.btnHideCoupon).on("click",function(){
            $(".coupon .couponList li:gt(2)").hide();
            $(this).hide().siblings("i").show();
        });
        // 选择尺寸
        $(this.config.sizeElement).on("click",function(){
            $(this).addClass("selected").siblings().removeClass("selected");
        });
        // 选择颜色
        $(this.config.colorElement).on("click",function(){
            $(this).addClass("selected").siblings().removeClass("selected");
        });
        this.bindInit();
    }
};

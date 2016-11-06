/**
 * Created by zhousg on 2015/12/18.
 */

function Comment(){
    this.config = {
        /*btn*/
        btnLookAll: ".lookAllRate",
        // 好评率
        goodRate: ".goodRated .exp a",
        // 评论数
        count: ".goodRated .right span",
        // 评论列表
        content: ".goodRated .goodRatedList"
    };
    this.goodRate = "99.9%";
    this.count = "1061";
    this.content = [
        {username:"刘德华",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"李连杰",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"张学友",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"张学友2",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"张学友3",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"张学友4",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"张学友5",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"张学友6",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]},
        {username:"张学友7",headImg:"image/image_1.png",time:"2016-10-12",content:"超棒！总算等到打折了！这个腰部很贴身，一定要量好自己的腰围买，这件裙子被好多朋友夸了。",spec:[{color:"亮黑"},{size:"XX"}]}
        ];
}
Comment.prototype={
    bindDom:function(){
        $(this.config.goodRate).html(this.goodRate);
        $(this.config.count).html(this.count);
    },
    bindContent:function(){
        var str = '';
        for(var i in this.content){
            str +=  '<li>'+
                        '<div class="scrapt">'+
                            '<div class="information">'+
                                '<div class="left">'+
                                    '<i><img src="'+this.content[i].headImg+'" alt=""></i>'+
                                    '<span>'+this.content[i].username+'</span>'+
                                '</div>'+
                                '<p class="time">'+this.content[i].time+'</p>'+
                            '</div>'+
                            '<div class="exp">'+this.content[i].content+'</div>'+
                            '<div class="colorSize">'+
                                '<p class="color">颜色 :<a></a></p>'+
                                '<p class="size">尺寸 :<a>XL</a></p>'+
                            '</div>'+
                        '</div>'+
                    '</li>'
        }
        $(this.config.content).empty().html(str);
    },
    /*绑定基本事件*/
    bindBasic:function(){
        this.bindDom();
        this.bindContent();
    },
    // 绑定事件
    bindEvents:function(){
        // 进入店铺
        $(this.config.btnLookAll).on("click",function(){
            alert("aa");
        })
    }
};

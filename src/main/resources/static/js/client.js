var url = 'localhost:8080/websocket/';
var websocket = null;
var visitInfo = null;
$(function () {
    //公司信息
    getConpany();
    //获取访客信息
    getVisitorInfo();
    //随机获取一个客服
    getKF();

    /*----------------------------websocket---------------*/
    //创建websocket实例
    websocket = new WebSocket('ws://' + url + visitInfo.id);
    console.log(visitInfo.visitid);

    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        layui.use(['layer'], function () {
            var layer = layui.layer;
            layer.ready(function () {
                layer.msg('链接成功', {time: 1000});
            });
        });
        //发送连接信息
       /* var kfid = $("#active-user").attr('data-id');
        var kfname = $("#active-user").attr('data-name');
        websocket.send(JSON.stringify({
            type: 'connect',
            data: {
                toid: kfid,
                toname: kfname,
                content: "生成列表",
                fromname: visitInfo.visitid,
                fromid: visitInfo.id
            }
        }));*/
    };

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        var data = eval("(" + event.data + ")");
        console.log(data.type);
        switch (data['type']) {
            case "ping":
                break;

            case "connect":

                break;
            case "chatMessage" :
                showUserMessage(data);
                break;
        }
        console.log(data);
    };

    //连接发生错误的回调方法
    websocket.onerror = function (event) {
        layui.use(['layer'], function () {
            var layer = layui.layer;
            layer.ready(function () {
                layer.msg('链接发生未知错误', {time: 1000});
            });
        });
    };

    //连接关闭的回调方法
    websocket.onclose = function () {
        console.log("连接关闭")
    };
    /*-----------------------------websocket------------------------------*/

    // 发送消息
    $("#send").click(function () {
        sendMessage();
    });

    // 监听快捷键发送
    document.getElementById('msg-area').addEventListener('keydown', function (e) {
        if (e.keyCode != 13) return;
        e.preventDefault();  // 取消事件的默认动作
        sendMessage();
    });

    //表情
    $("#face").click(function (e) {
        console.log("biaoqing1")
    });

    //显示留言，隐藏访客信息和聊天面板
    $("#workorderBtn").click(function () {
        $("#workorder").show();
        $("#info").hide();
        $("#chatbox").hide();
    });
    //显示消息面板
    $("#hs").click(function () {
        $("#workorder").hide();
        $("#info").show();
        $("#chatbox").show();
    });


});

//显示服务器端发来的消息
function showUserMessage(data) {
    var word = msgFactory(data.data.content,"user",data.data);
    setTimeout(function () {
        $("#chats").append(word);
        // 滚动条自动定位到最底端
        wordBottom();
        showBigPic();
    }, 200);
}

//获取客服信息
function  getKF() {
    $.ajax({
        url:"/user/getOnlineUser",
        dataType:"json",
        async:true,
        type:"GET",
        success:function(data){
           //设置当前客服信息到dom对象
           $("#active-user").attr('data-id',data.id).attr('data-name',data.username);
            websocket.send(JSON.stringify({
                type: 'connect',
                data: {
                    toid: data.id,
                    toname: data.username,
                    content: "生成列表",
                    fromname: visitInfo.visitid,
                    fromid: visitInfo.id
                }
            }));
        },
        error:function(){
            //请求出错处理
            console.log("没有客服上线");
        }
    });
}

// 发送消息
function sendMessage(sendMsg) {
    var msg = (typeof (sendMsg) == 'undefined') ? $(".msg-area").val() : sendMsg;
    if ('' == msg) {
        layui.use(['layer'], function () {
            var layer = layui.layer;
            return layer.msg('请输入回复内容', {time: 1000});
        });
        return false;
    }
    //获取客服信息
    var kfid = $("#active-user").attr('data-id');
    var kfname = $("#active-user").attr('data-name');
    var word = msgFactory(msg,'mine',visitInfo);
    websocket.send(JSON.stringify({
        type: 'chatMessage',
        data: {
            toid: kfid,
            toname: kfname,
            content: msg,
            fromname: visitInfo.visitid,
            fromid: visitInfo.id
        }
    }));
    //添访客消息到消息面板
    $("#chats").append(word);
    //清空消息输入区域
    $(".msg-area").val('');
    //滚动条定位到底部
    wordBottom();
}
//消息处理工厂
function msgFactory(content, type, userInfo) {
    var _html = '';
    if ('mine' == type) {
        _html += '<li class="kefu-chat-mine">';
    } else {
        _html += '<li>';
    }
    _html += '<div class="kefu-chat-user">';
    if ('mine' == type) {
        _html += '<cite><i>' + getDate() + '</i>' + userInfo.visitid + '</cite>';
    } else {
        _html += '<cite>' + userInfo.fromname + '<i>' + getDate() + '</i></cite>';
    }
    _html += '</div><div class="kefu-chat-text">' + content + '</div>';
    _html += '</li>';

    return _html;
}

// 获取日期
function getDate() {
    var d = new Date(new Date());

    return d.getFullYear() + '-' + digit(d.getMonth() + 1) + '-' + digit(d.getDate())
        + ' ' + digit(d.getHours()) + ':' + digit(d.getMinutes()) + ':' + digit(d.getSeconds());
}

//补齐数位
var digit = function (num) {
    return num < 10 ? '0' + (num | 0) : num;
};

// 滚动条自动定位到最底端
function wordBottom() {
    var box = $(".chat-box");
    box.scrollTop(box[0].scrollHeight);
}

// 图片上传
layui.use(['upload', 'layer'], function () {
    var upload = layui.upload;
    var layer = layui.layer;

    // 执行实例
    var uploadInstImg = upload.render({
        elem: '#image' // 绑定元素
        , accept: 'images'
        , exts: 'jpg|jpeg|png|gif'
        , url: '/chatMsg/uploadImg' // 上传接口
        , done: function (res) {
            console.log(res.data.src);
            sendMessage( '<img class="layui-kefu-photos" src="' + res.data.src + '" width="100px" height="100px">');
            showBigPic();
        }
        , error: function () {
            // 请求异常回调
        }
    });
});

// 显示大图
function showBigPic(){
    $(".layui-kefu-photos").on('click', function () {
        var src = this.src;
        layer.photos({
            photos: {
                data: [{
                    "alt": "大图模式",
                    "src": src
                }]
            }
            , shade: 0.5
            , closeBtn: 2
            , anim: 5
            , resize: false
            , success: function (layero, index) {
            }
        });
    });
}

//获取访客信息,cookie中没有就请求服务器生成
function getVisitorInfo() {
    //获取cookie中的访客信息
    var visitCookie = $.cookie('visitInfo');
    if(visitCookie !== undefined){
        //console.log(visitCookie);
        //转换为json对象
        visitInfo = eval("(" + visitCookie +")");
    }else {
        //生成
        generateVisit();
    }
    return visitInfo;
}
//请求服务器生成访客信息,并返回访客信息
function generateVisit() {
    //使用搜狐的API获取访客本地ip和地址
    var visitip = returnCitySN.cip;
    var visitAddress = returnCitySN.cname;
    //console.log('ip:'+visitip +'地址:'+visitAddress);
    $.ajax({
        url:"/visitor/addVisitor",
        type:"POST",
        async: false,
        data:{
            "id":"",
            "visitid":"",
            "ip":visitip,
            "address":visitAddress
        },
        success:function (data) {
            visitInfo = data;
            console.log(visitInfo);
        }
    });
}

//获取公司信息
function getConpany() {
    $.ajax({
        url:"/company/getCompany", //请求的url地址
        dataType:"json", //返回格式为json
        async:true,//请求是否异步，默认为异步，这也是ajax重要特性
        data:{"id":"1"}, //参数值
        type:"GET", //请求方式
        success:function(data){
            $("#company").html(data.company);
            $("#present").html(data.present);
            $("#phone").append(data.phone);
            $("#website").append(data.website).attr('href',data.website);
            //console.log(data);
        }
    });

}

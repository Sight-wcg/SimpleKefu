var visitInfo = null;
$(function () {
    //获取cookie中的访客信息
    var visitCookie = $.cookie('visitInfo');
    //console.log(visitCookie);
    //转换为json对象
    visitInfo = eval("(" + visitCookie +")");

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

    //获取公司信息
    $.ajax({
        url:"/company/getCompany", //请求的url地址
        dataType:"json", //返回格式为json
        async:true,//请求是否异步
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
});

//和机器人对话
var chatbotmsg = null;
function chatbot(id,msg) {
    $.ajax({
        url:"/chatbot/conversation", //请求的url地址
        dataType:"json", //返回格式为json
        async:true,//请求是否异步
        data:{"userid":id,"text":msg}, //参数值
        type:"GET", //请求方式
        success:function(data){
            chatbotmsg = data.data.string;
            //添加机器人消息到消息面板
            var chatbotword = msgFactory(chatbotmsg,' ',visitInfo);
            $("#chats").append(chatbotword);
            wordBottom();
            //console.log(data.data.string);
        }
    })
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
    //添访客消息到消息面板
    var word = msgFactory(msg,'mine',visitInfo);
    $("#chats").append(word);
    //清空消息输入区域
    $(".msg-area").val('');
    wordBottom();
    //发送给机器人
    chatbot(visitInfo.visitid,msg);
}

//消息处理工厂
function msgFactory(content, type, visitInfo) {
    var _html = '';
    if ('mine' == type) {
        _html += '<li class="kefu-chat-mine">';
    } else {
        _html += '<li>';
    }
    _html += '<div class="kefu-chat-user">';
    if ('mine' == type) {
        _html += '<cite><i>' + getDate() + '</i>' + visitInfo.visitid + '</cite>';
    } else {
        _html += '<cite>' + '机器人' + '<i>' + getDate() + '</i></cite>';
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
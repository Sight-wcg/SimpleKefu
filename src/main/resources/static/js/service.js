var url = 'localhost:8080/websocket/';
var websocket = null;
var kefuInfo = null;
$(function () {
    //获取常用语信息

    //获取客服信息
    kefuInfo = getKefuInfo();
    //console.log(kefuInfo);

    //显示工单管理，隐藏访客信息和聊天面板
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

    // 发送消息
    $("#send").click(function () {
        sendMessage();
    });

    /*----------------------------websocket---------------*/
    //创建websocket实例
    websocket = new WebSocket('ws://' + url + kefuInfo.id);
    console.log(kefuInfo.id);

    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        layui.use(['layer'], function () {
            var layer = layui.layer;
            layer.ready(function () {
                layer.msg('链接成功', {time: 1000});
            });
        });
    };

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        var data = eval("(" + event.data + ")");
        console.log(data.type);
        switch (data['type']) {
            case "ping":
                break;

            case "connect":
                if ($('#f-' + data.data.fromid).length == 0) {
                    addUser(data.data);
                }
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
                layer.msg('连接发生未知错误', {time: 1000});
            });
        });
    };

    //连接关闭的回调方法
    websocket.onclose = function () {
        console.log("连接关闭")
    };
    /*-----------------------------websocket------------------------------*/

    // 监听快捷键发送
    document.getElementById('msg-area').addEventListener('keydown', function (e) {
        if (e.keyCode != 13) return;
        e.preventDefault();  // 取消事件的默认动作
        sendMessage();
    });

});

// hover用户
$(".layui-unselect li").hover(function () {
    $(this).find('i').show();
}, function () {
    $(this).find('i').hide();
});

// 关闭用户
$('.close').click(function () {
    var uid = $(this).parent().data('id');
    $(this).parent().remove(); // 清除左侧的用户列表
    $('#u-' + uid).remove(); // 清除右侧的聊天详情
});

// 添加用户到面板
function addUser(data) {
    console.log(data);
    var _html = '<li class="layui-nav-item" data-id="' + data.fromid + '"  data-name="' + data.fromname + '" id="f-' + data.fromid +
        '">';
    _html += '<span class="user-name">' + data.fromname + '</span>';
    _html += '<span class="layui-badge" style="margin-left:5px">0</span>';
    _html += '<i class="layui-icon close" style="display:none">ဇ</i>';
    _html += '</li>';
    // 添加左侧列表
    $("#user_list").append(_html);

    // 如果没有选中人，选中第一个
    var hasActive = 0;
    $("#user_list li").each(function(){
        if($(this).hasClass('active')){
            hasActive = 1;
        }
    });

    var _html2 = '';
    _html2 += '<ul id="u-' + data.fromid + '">';
    _html2 += '</ul>';
    // 添加主聊天面板
    $('.chat-box').append(_html2);

    if(0 == hasActive){
        $("#user_list").find('li').eq(0).addClass('active').find('span:eq(1)').removeClass('layui-badge').text('');
        $("#u-" + data.fromid).show();

        var id = $(".layui-unselect").find('li').eq(0).data('id');
        var visitid = $(".layui-unselect").find('li').eq(0).data('name');
        console.log(id+"---"+visitid);

        // 设置当前会话用户
        $("#active-user").attr('data-id', id).attr('data-name', visitid);

        //设置ip,地址，visitid信息
        $.getJSON('/visitor/getVisitor',{id:id},function (res) {
            $("#f-ip").val(res.ip);
            $("#f-area").val(res.address);
        });
        $("#f-user").val(visitid);

    }
    //getChatLog(data.id, 1);
    checkUser();
}

// 发送快捷语句
function sendWord(obj) {
    var msg = $(obj).data('word');
    sendMessage(msg);
}

// 切换在线用户
function changeUserTab(obj) {
    obj.addClass('active').siblings().removeClass('active');
    wordBottom();
}
// 操作新连接用户的 dom操作
function checkUser() {
    $(".layui-unselect").find('li').unbind("click"); // 防止事件叠加
    // 切换用户
    $(".layui-unselect").find('li').bind('click', function () {
        changeUserTab($(this));
        var uid = $(this).data('id');
        var name = $(this).data('name');
        // 展示相应的对话信息
        $('.chat-box ul').each(function () {
            if ('u-' + uid == $(this).attr('id')) {
                $(this).addClass('show-chat-detail').siblings().removeClass('show-chat-detail').attr('style', '');
                return false;
            }
        });

        // 去除消息提示
        $(this).find('span').eq(1).removeClass('layui-badge').text('');

        // 设置当前会话的用户
        $("#active-user").attr('data-id', uid).attr('data-name', name);

        //设置ip,地址，visitid信息
        $.getJSON('/visitor/getVisitor',{id:uid},function (res) {
            $("#f-ip").val(res.ip);
            $("#f-area").val(res.address);
        });
        $("#f-user").val(name);
        //工单隐藏
        $("#workorder").hide();
        $("#info").show();
        $("#chatbox").show();
        //getChatLog(uid, 1);

        wordBottom();
    });
}

// 删除用户聊天面板
function delUser(data) {
    $("#f-" + data.data.fromid).remove(); // 清除左侧的用户列表
    $('#u-' + data.data.fromid).remove(); // 清除右侧的聊天详情
}


//显示服务器端发来的消息
function showUserMessage(data) {
    if ($('#f-' + data.data.fromid).length == 0) {
        addUser(data.data);
    }

    // 未读条数计数
    if (!$('#f-' + data.data.fromid).hasClass('active')) {
        var num = $('#f-' + data.data.fromid).find('span:eq(1)').text();
        if (num == '') num = 0;
        num = parseInt(num) + 1;
        $('#f-' + data.data.fromid).find('span:eq(1)').removeClass('layui-badge').addClass('layui-badge').text(num);
    }

    var word = msgFactory(data.data.content,"user",data.data);
    setTimeout(function () {
        $("#u-"+data.data.fromid).append(word);
        // 滚动条自动定位到最底端
        wordBottom();
        showBigPic();
    }, 200);
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
    var vid = $("#active-user").attr('data-id');
    var vname = $("#active-user").attr('data-name');
    var word = msgFactory(msg,'mine',kefuInfo);
    //socket发送
    websocket.send(JSON.stringify({
        type: 'chatMessage',
        data: {
            toid: vid,
            toname: vname,
            content: msg,
            fromname: kefuInfo.username,
            fromid: kefuInfo.id
        }
    }));
    //添加到消息面板
    $("#u-"+vid).append(word);
    //清空消息输入区域
    $(".msg-area").val('');
    //滚动条定位到底部
    wordBottom();
}

//消息处理工厂
function msgFactory(content, type, uinfo) {
    var _html = '';
    if ('mine' == type) {
        _html += '<li class="kefu-chat-mine">';
    } else {
        _html += '<li>';
    }
    _html += '<div class="kefu-chat-user">';
    if ('mine' == type) {
        _html += '<cite><i>' + getDate() + '</i>' + uinfo.username + '</cite>';
    } else {
        _html += '<cite>' + uinfo.fromname + '<i>' + getDate() + '</i></cite>';
    }
    _html += '</div><div class="kefu-chat-text">' + content + '</div>';
    _html += '</li>';

    return _html;
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
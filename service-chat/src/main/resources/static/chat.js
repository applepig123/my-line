var stompClient = null;
//gateway网关的地址
var host="http://127.0.0.1:12820";
function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    $('#response').html();
}
function connect() {
    //地址+端点路径，构建websocket链接地址
    var socket = new SockJS('http://localhost:12810/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected:' + frame);
        //监听的路径以及回调
        stompClient.subscribe('/topic/info', function(response) {
            showResponse(response.body);
        });
    });
}
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
function send() {
    var name = $('#name').val();
    var message = $('#messgae').val();
    //发送消息的路径
    stompClient.send("/toAll", {}, JSON.stringify({content:name}));
}
function showResponse(message) {
    var response = $('#response');
    response.html(message);
}
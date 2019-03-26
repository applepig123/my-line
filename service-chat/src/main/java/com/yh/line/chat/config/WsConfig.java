package com.yh.line.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by yanghua on 2019/3/10.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    // 这个方法的作用是添加一个服务端点，来接收客户端的连接
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个Stomp的节点（endpoint）,客户端就可以通过这个端点来进行连接。
        // withSockJS()的作用是开启SockJS支持
        registry.addEndpoint("/chat").withSockJS();
    }

    // 这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 服务端发送消息给客户端的域,多个用逗号隔开,也就是客户端接收服务端消息的地址的前缀信息
        // queue: 指定用户; topic：广播
        registry.enableSimpleBroker("/queue","/topic");
        // 指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
//        registry.setApplicationDestinationPrefixes("/app");
    }
}

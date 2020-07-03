package com.hope.firstsb.domain.vo;

import lombok.Data;

/**
 * @author zwh
 */
@Data
public class WsMessage {
    /**
     * 消息发送者
     */
    private WsUser fromUser;

    /**
     * 消息接收者
     */
    private WsUser toUser;

    /**
     * 消息内容
     */
    private String content;

    public WsMessage() {

    }

}

package com.hope.firstsb.domain.vo;

import lombok.Data;

/**
 * @author zwh
 */
@Data
public class WsUser {
    /**
     * 用户id
     */
    private Long uid;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户昵称
     */
    private String nickname;
}

package com.server.servers.redis;

import java.io.Serializable;

/**
 * Created by chaos on 2017/7/11 0011.
 */

/**
 * 定义消息类接收消息内容和设置消息的下标
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -6522856831609820247L;
    private int id;
    private String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package com.chen.simplekefu.entity;

/**
 * @author chen
 * @create 2020-05-15-13:03
 */
public class ChatMsg {
    private Integer id;
    private Integer toid; //接收人
    private String toname;
    private Integer fromid; //发送人
    private String fromname;
    private String content;  //消息内容
    private Long sendtime; //发送时间

    public ChatMsg() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSendtime() {
        return sendtime;
    }

    public void setSendtime(Long sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        return "ChatMsg{" +
                "id=" + id +
                ", toid=" + toid +
                ", toname='" + toname + '\'' +
                ", fromid=" + fromid +
                ", fromname='" + fromname + '\'' +
                ", content='" + content + '\'' +
                ", sendtime='" + sendtime + '\'' +
                '}';
    }
}

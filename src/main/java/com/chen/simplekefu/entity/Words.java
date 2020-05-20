package com.chen.simplekefu.entity;

/**
 * @author chen
 * @create 2020-04-22-20:51
 */
public class Words {
    private Integer id; //常用语id
    private String content;  //常用语内容
    private Integer status; //常用语状态

    public Words() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "words{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}

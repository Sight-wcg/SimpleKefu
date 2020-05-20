package com.chen.simplekefu.entity;

/**
 * @author chen
 * @create 2020-04-22-21:19
 */
public class Visitor {
    private Integer id;// 访客id
    private String visitid;  //访客编号
    private String ip;  //访客ip地址
    private String address; //访客地址

    public Visitor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitid() {
        return visitid;
    }

    public void setVisitid(String visitid) {
        this.visitid = visitid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "visitor{" +
                "id=" + id +
                ", visitid='" + visitid + '\'' +
                ", ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

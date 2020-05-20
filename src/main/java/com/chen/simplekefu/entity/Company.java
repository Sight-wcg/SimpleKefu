package com.chen.simplekefu.entity;

/**
 * @author chen
 * @create 2020-04-22-21:18
 */
public class Company {
    private Integer id;      //公司id
    private String company;  //公司名称
    private String website;  //官网链接
    private String phone;   //联系电话
    private String present; //公司介绍

    public Company() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", website='" + website + '\'' +
                ", phone='" + phone + '\'' +
                ", present='" + present + '\'' +
                '}';
    }
}

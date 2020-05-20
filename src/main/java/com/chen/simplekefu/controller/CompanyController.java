package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.Company;
import com.chen.simplekefu.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chen
 * @create 2020-04-24-11:06
 */
@Controller
@RequestMapping("company/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 公司信息页面
     * @return
     */
    @RequestMapping("page")
    public String page(){
        return "admin/companyInfo";
    }

    /**
     * 更新公司信息
     * @param company
     * @return
     */
    @RequestMapping("updataCompany")
    public String updataCompany(Company company){
        companyService.updataCompany(company);
        return "admin/companyInfo";
    }

    /**
     * 查询公司信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getCompany")
    public Company getCompany(Integer id){
        return companyService.findCompany(id);
    }
}

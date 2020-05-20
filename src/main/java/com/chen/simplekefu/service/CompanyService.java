package com.chen.simplekefu.service;

import com.chen.simplekefu.entity.Company;

/**
 * @author chen
 * @create 2020-04-24-11:07
 */
public interface CompanyService {
    /**
     * 更新公司信息
     * @param company
     */
    void updataCompany(Company company);

    /**
     * 查询公司信息
     * @return
     */
    Company findCompany(Integer id);
}

package com.chen.simplekefu.service.impl;

import com.chen.simplekefu.dao.CompanyDao;
import com.chen.simplekefu.entity.Company;
import com.chen.simplekefu.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen
 * @create 2020-04-24-11:08
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    /**
     * 更新公司信息
     *
     * @param company
     */
    @Override
    public void updataCompany(Company company) {
        companyDao.updataCompany(company);
    }

    /**
     * 查询公司信息
     *
     * @return
     */
    @Override
    public Company findCompany(Integer id) {

        return companyDao.findCompany(id);
    }
}

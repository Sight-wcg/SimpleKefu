package com.chen.simplekefu.dao;

import com.chen.simplekefu.entity.Company;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chen
 * @create 2020-04-24-11:08
 */
@Mapper
public interface CompanyDao {

    /**
     * 更新公司信息
     * @param company
     */
    void updataCompany(Company company);

    /**
     * 查询公司信息
     * @return
     */
    Company findCompany (Integer id);
}

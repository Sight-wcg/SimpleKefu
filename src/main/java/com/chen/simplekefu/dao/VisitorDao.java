package com.chen.simplekefu.dao;

import com.chen.simplekefu.entity.Visitor;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chen
 * @create 2020-05-14-14:44
 */
@Mapper
public interface VisitorDao {

    /**
     * 添加访客
     */
    void addVisitor(Visitor visitor);

    /**
     * 查询访客
     * @param id
     * @return
     */
    Visitor getVisitor(Integer id);

    Integer getVisitorMax();
}

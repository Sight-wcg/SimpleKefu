package com.chen.simplekefu.service;

import com.chen.simplekefu.entity.Visitor;

/**
 * @author chen
 * @create 2020-05-14-14:43
 */
public interface VisitorService {
    /**
     * 添加方可信息
     * @param visitor
     */
    Visitor addVisitor(Visitor visitor);

    /**
     * 根据id查询访客信息
     * @param id
     * @return
     */
    Visitor getVisitor(Integer id);
}

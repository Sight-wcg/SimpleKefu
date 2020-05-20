package com.chen.simplekefu.service.impl;

import com.chen.simplekefu.dao.VisitorDao;
import com.chen.simplekefu.entity.Visitor;
import com.chen.simplekefu.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.viewer.context.AxBridgeAppletContext;

/**
 * @author chen
 * @create 2020-05-14-14:43
 */
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    /**
     * 添加访客
     * @param visitor
     */
    @Override
    public Visitor addVisitor(Visitor visitor) {
        int id = visitorDao.getVisitorMax() + 1;
        visitor.setVisitid("访客" + id);
        visitorDao.addVisitor(visitor);
        return visitorDao.getVisitor(id);
    }

    /**
     * 根据id查询访客信息
     *
     * @param id
     * @return
     */
    @Override
    public Visitor getVisitor(Integer id) {
        return visitorDao.getVisitor(id);
    }
}

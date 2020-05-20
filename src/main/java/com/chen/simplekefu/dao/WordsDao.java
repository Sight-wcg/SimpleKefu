package com.chen.simplekefu.dao;

import com.chen.simplekefu.entity.Words;
import org.apache.ibatis.annotations.Mapper;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-20:58
 */
@Mapper
public interface WordsDao {
    /**
     * 查询所有常用语言
     * @return
     */
    List<Words> findAllWords();

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    Words findWordsById(Integer id);

    /**
     * 添加
     * @param words
     */
    void insertWords(Words words);

    /**
     * 更新
     * @param words
     */
    void updateWords(Words words);

    /**
     * 根据id删除
     * @param id
     */
    void deleteWordsById(Integer id);

    /**
     * 更改状态
     * @param id
     * @param status
     */
    void changeStatus(Integer id, Integer status);
}

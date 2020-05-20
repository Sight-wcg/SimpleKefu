package com.chen.simplekefu.service;

import com.chen.simplekefu.entity.Words;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-20:58
 */
public interface WordsService {
    /**
     * 查询所有
     * @return
     */
    List<Words> findAllWords();

    /**
     * 根据id查询
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

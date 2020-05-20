package com.chen.simplekefu.service.impl;

import com.chen.simplekefu.dao.WordsDao;
import com.chen.simplekefu.entity.Words;
import com.chen.simplekefu.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-20:58
 */
@Service
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordsDao wordsDao;
    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Words> findAllWords() {
        return wordsDao.findAllWords();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Words findWordsById(Integer id) {
        return wordsDao.findWordsById(id);
    }

    /**
     * 添加
     *
     * @param words
     */
    @Override
    public void insertWords(Words words) {
        if(words.getStatus() == null){
            words.setStatus(0);
        }
        wordsDao.insertWords(words);
    }

    /**
     * 更新
     *
     * @param words
     */
    @Override
    public void updateWords(Words words) {
        if(words.getStatus() == null){
            words.setStatus(0);
        }
        wordsDao.updateWords(words);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    public void deleteWordsById(Integer id) {
        wordsDao.deleteWordsById(id);
    }

    /**
     * 更改状态
     *
     * @param id
     * @param status
     */
    @Override
    public void changeStatus(Integer id, Integer status) {
        wordsDao.changeStatus(id,status);
    }
}

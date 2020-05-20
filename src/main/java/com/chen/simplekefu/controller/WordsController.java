package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.Words;
import com.chen.simplekefu.service.WordsService;
import com.chen.simplekefu.utils.ResultVOUtil;
import com.chen.simplekefu.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author chen
 * @create 2020-04-24-20:57
 */
@Controller
@RequestMapping("words/")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    /**
     * 页面
     * @return
     */
    @RequestMapping("page")
    public String page(){
        return "admin/wordsInfo";
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping("add/page")
    public String addPage(){
        return "admin/wordsAdd";
    }

    /**
     * 更新页面
     * @return
     */
    @RequestMapping("update/page")
    public String updatePage(){
        return "admin/wordsEdit";
    }

    /**
     * 获取所有
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllWords")
    public ResultVO getAllWords(){
        List<Words> wordsList = wordsService.findAllWords();
        return ResultVOUtil.success(wordsList);
    }


    /**
     * 根据id获取
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getWords")
    public Words getWords(Integer id){
        return wordsService.findWordsById(id);
    }

    /**
     * 根据id删除
     * @param id
     * @param response
     */
    @RequestMapping("deleteWords")
    public void deleteWords(@RequestParam("id") Integer id, HttpServletResponse response){
        wordsService.deleteWordsById(id);
    }

    /**
     * 更改状态
     * @param id
     * @param status
     * @param response
     */
    @RequestMapping("changeStatus")
    public void changeStatus(@RequestParam("id") Integer id,
                             @RequestParam("status") Integer status, HttpServletResponse response){
        wordsService.changeStatus(id,status);
    }

    /**
     * 添加
     * @param words
     */
    @RequestMapping("addWords")
    public String addWords(Words words){
        wordsService.insertWords(words);
        return "redirect:page";
    }

    /**
     * 更新
     * @param words
     * @param response
     */
    @RequestMapping(value = "updateWords",method = RequestMethod.POST)
    public String updateWords(Words words,HttpServletResponse response){
        wordsService.updateWords(words);
        return "redirect:page";
    }
}

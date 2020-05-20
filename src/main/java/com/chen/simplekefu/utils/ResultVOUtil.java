package com.chen.simplekefu.utils;

import com.chen.simplekefu.vo.ResultVO;

/**
 * @author chen
 * @create 2020-04-22-17:40
 */
public class ResultVOUtil {
    //处理成功返回的对象数据封装
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }
    //处理成功返回的空对象的数据的封装
    public static ResultVO success(){
        return success(null);
    }
    //处理错误返回的对象数据的封装
    public static ResultVO error(Integer code,String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }
}

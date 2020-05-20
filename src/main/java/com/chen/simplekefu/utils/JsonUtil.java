package com.chen.simplekefu.utils;

import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chen
 * @create 2020-04-28-2:56
 */
public class JsonUtil {
    /**
     * 返回json字符串
     * @param jsonObject
     * @param response
     * @return
     */
    public static void writeValue(JSONObject jsonObject, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(String.valueOf(jsonObject));
    }
}

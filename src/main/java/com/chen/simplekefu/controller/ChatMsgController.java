package com.chen.simplekefu.controller;

import com.chen.simplekefu.entity.ChatMsg;
import com.chen.simplekefu.service.ChatMsgService;
import com.chen.simplekefu.utils.ResultVOUtil;
import com.chen.simplekefu.vo.ResultVO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author chen
 * @create 2020-05-14-19:28
 */
@Controller
@RequestMapping("chatMsg/")
public class ChatMsgController {

    @Autowired
    private ChatMsgService chatMsgService;

    @RequestMapping("page")
    public String page(){
        return "admin/servicelog";
    }

    /**
     * 上传图片
     * @param file
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @PostMapping("uploadImg")
    public ResultVO uploadImg(MultipartFile file, HttpServletResponse response) throws IOException {
        String fileName = file.getOriginalFilename();//原始文件名
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));//文件后缀
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");//生成新名字
        String filenames = newFileName + fileSuffix;
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload/images/";
        file.transferTo(new File(path + filenames));//保存文件
        Map<String,String> res = new HashMap<>();
        res.put("src","/upload/images/" + filenames);
        System.out.println(res);
        return ResultVOUtil.success(res);
    }

    @ResponseBody
    @RequestMapping("getChats")
    public List<ChatMsg> getChats(Model model){
        return chatMsgService.getChats();
    }

    @ResponseBody
    @RequestMapping("getChatMsg")
    public List<ChatMsg> getChatMsg(Integer toid,Integer fromid){
        return chatMsgService.getChatMsg(toid,fromid);
    }
}

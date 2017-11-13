package com;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.DateTimeUtils;
import util.PropertiesUtil;

import java.io.File;
import java.util.Date;
import java.util.UUID;

@Controller
public class CVRController {

    /**
     * 识别
     *
     * @return
     */
    @RequestMapping(value = "/recognition")
    @ResponseBody
    public String recognition(String json, MultipartFile file, Model model) {
        try {
            String dateStr = DateTimeUtils.dateToString(new Date(), "yyyy-MM-dd");
            String path = PropertiesUtil.IMAGE_PATH() + dateStr + "/";
            //文件名= 企业id + 当前日期的时间值
            String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            File targetFile = new File(path + fileName);
            if (!targetFile.exists()) {
                targetFile.getParentFile().mkdirs();
            }
            //保存
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println("aa");
    }
}

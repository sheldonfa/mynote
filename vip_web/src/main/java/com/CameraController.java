package com;


import com.service.CameraService;
import entity.common.CodeMsg;
import entity.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @RequestMapping(value = "test")
    @ResponseBody
    public Result test() {
        return Result.success();
    }

    @RequestMapping(value = "testGet", method = RequestMethod.GET)
    @ResponseBody
    public Result testGet() {
        return Result.success();
    }

    @RequestMapping(value = "testPost", method = RequestMethod.POST)
    @ResponseBody
    public Result testPost() {
        return Result.success();
    }


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public Result upload(MultipartFile file, HttpServletRequest request) {
        if (!file.getOriginalFilename().endsWith(".csv")) {
            return Result.error(CodeMsg.FILE_FORMAT_EXCEPTION, "不是csv文件");
        }
        try {
            // 保存文件
            String sourceName = file.getOriginalFilename(); // 原始文件名
            String baseDir = getBaseDir(request);
            String path = baseDir + File.separator + sourceName;
            file.transferTo(new File(path));
            // 解析
            cameraService.parseCsv(path);
        } catch (Exception e) {
            return Result.error(CodeMsg.FILE_PARSE_EXCEPTION, e.getMessage());
        }
        return Result.success();

    }

    private String getBaseDir(HttpServletRequest request) {
        String base = request.getSession().getServletContext().getRealPath("/upload");  //获取文件上传的路径，在webapp下的upload中
        File file = new File(base);
        if (!file.exists()) {
            file.mkdirs();
        }
        return base;
    }

    @RequestMapping("/stats")
    @ResponseBody
    public Result stats(String filePath, String storeName, Long startTimeLong, Long endTimeLong) {
        return Result.success(cameraService.statsResult(filePath, storeName, startTimeLong, endTimeLong));
    }

//    @RequestMapping("/download_jsp")
//    public void download(String filePath, String storeName, Long startTime, Long endTime, HttpServletResponse response) throws IOException {
//        // 输入流
////        FileInputStream fileInputStream = new FileInputStream(new File("E:\\workspace\\vipmanage\\mynote_web\\src\\绵阳店.csv"));
////        BufferedInputStream is = new BufferedInputStream(fileInputStream);
//        ExportFile ef = cameraService.export(filePath, storeName, startTime, endTime);
//        // 输出
//        response.reset();
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + ef.getFileName() + "\"");
////        response.addHeader("Content-Length", "" + data.length);
//        response.setContentType("application/octet-stream;charset=UTF-8");
//        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//
//        byte[] buff = new byte[2048];
//        int bytesRead;
//        while (-1 != (bytesRead = ef.getFile().read(buff, 0, buff.length))) {
//            outputStream.write(buff, 0, bytesRead);
//        }
//        outputStream.flush();
//        outputStream.close();
//    }
}

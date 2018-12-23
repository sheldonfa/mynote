package com;


import com.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test() {
        return "index";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, Model model, HttpServletRequest request) {
        if (!file.getOriginalFilename().endsWith(".csv")) {
            model.addAttribute("reason", "不是csv文件");
            return "upload_fail";
        }
        try {
            // 保存文件
            String sourceName = file.getOriginalFilename(); // 原始文件名
            String fileType = sourceName.substring(sourceName.lastIndexOf("."));
            String baseDir = getBaseDir(request);
            String path = baseDir + File.separator + sourceName;
            file.transferTo(new File(path));
            // 解析
            cameraService.parseCsv(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload_success";

    }

    private String getBaseDir(HttpServletRequest request) {
        String base = request.getSession().getServletContext().getRealPath("/upload");  //获取文件上传的路径，在webapp下的upload中
        File file = new File(base);
        if (!file.exists()) {
            file.mkdirs();
        }
        return base;
    }

//    @RequestMapping("/download_jsp")
//    public void download(HttpServletResponse response) throws IOException {
//        String fileName = "asd.csv";
//        fileName = URLEncoder.encode(fileName, "UTF-8");
//        // 输入流
//        FileInputStream fileInputStream = new FileInputStream(new File("E:\\workspace\\vipmanage\\mynote_web\\src\\绵阳店.csv"));
//        BufferedInputStream is = new BufferedInputStream(fileInputStream);
//        // 输出
//        response.reset();
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
////        response.addHeader("Content-Length", "" + data.length);
//        response.setContentType("application/octet-stream;charset=UTF-8");
//        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//
//        byte[] buff = new byte[2048];
//        int bytesRead;
//        while (-1 != (bytesRead = is.read(buff, 0, buff.length))) {
//            outputStream.write(buff, 0, bytesRead);
//        }
//        outputStream.flush();
//        outputStream.close();
//    }
}

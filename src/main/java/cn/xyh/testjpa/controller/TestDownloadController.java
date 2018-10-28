package cn.xyh.testjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
public class TestDownloadController {


    @GetMapping("download")
    public void downloadFile(HttpServletResponse response) {


        String fileName = "test.txt";

        String filePath = "F:/test/";

        File file = new File(filePath + fileName);

        if (!file.exists()) {
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);


            byte[] b = new byte[1024];

            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os = null;

            try {
                os = response.getOutputStream();

                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(b);
                while(i != -1){
                    os.write(b);
                    i = bis.read(b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

package cn.xyh.testjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@RestController
public class TestDownloadController {


    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setGroupingSize(0);
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
//        tempPrice = tempPrice - (tempPrice * (disCount / 10));

        double a = 0.01;
        double b = 9;
//        System.out.println(a * (b / 10));

        double c = a * (10 - b) / 10;
        double e = Double.valueOf(decimalFormat.format(c));
        System.out.println(e);
        System.out.println(a - e);

        double d = 0.001;

    }

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

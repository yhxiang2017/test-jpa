package cn.xyh.testjpa.util;

import java.io.*;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@RestController
public class FileUtil {

    public static void main(String[] args) throws InterruptedException {
        File file = new File("C:\\cd_das\\data\\2018-04-08.cd");
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
            BufferedReader reader = new BufferedReader(read);
            String line;

            while ((line = reader.readLine()) != null) {
//                fileContent += line;
                DataModel dataModel = JSON.parseObject(line, new TypeReference<DataModel>() {});
                Thread.sleep(0b111110100);
                System.out.println(dataModel);
            }
            read.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileUtil f = new FileUtil();
//        f.createXMLByDOM(file);

//        OutputStream out = new BufferedOutputStream();
    }


    @GetMapping("/export")
    public void export(HttpServletResponse response) {
//        response.setHeader("content-type", "text/xml;charset=UTF-8");
//        Date date = new Date();
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/xml;charset=UTF-8");
        try {
            String fileName = "哈哈_"+ new Date().getTime() +".xml";
            OutputStream os = null;
            response.setHeader("content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            os = response.getOutputStream();
           createXMLByDOM(os);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void createXMLByDOM(OutputStream os) {
        // 创建DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            // 创建DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 创建Document
            Document document = builder.newDocument();

            // 设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
             document.setXmlStandalone(true);

            // 创建根节点
            Element bookstore = document.createElement("bookstore");

            for (int i = 0; i < 3; i++) {
                Element book = document.createElement("book");

                // 创建子节点，并设置属性
                book.setAttribute("id", "1");

                // 为book添加子节点
                Element name = document.createElement("name");
                name.setTextContent("安徒生童话");
                book.appendChild(name);
                Element author = document.createElement("author");
                author.setTextContent("安徒生");
                book.appendChild(author);
                Element price = document.createElement("price");
                price.setTextContent("49");
                book.appendChild(price);
                // 为根节点添加子节点
                bookstore.appendChild(book);

            }


            // 将根节点添加到Document下
            document.appendChild(bookstore);

            Source source = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult(stringWriter);
            TransformerFactory factoryaa = TransformerFactory.newInstance();
            Transformer transformer = factoryaa.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.transform(source, result);
            String s = stringWriter.getBuffer().toString();
            System.out.println(s);
            /*
             * 下面开始实现： 生成XML文件
             */

            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();

            // 创建Transformer对象
            Transformer tf = tff.newTransformer();

            // 设置输出数据时换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            tf.setOutputProperty(OutputKeys.STANDALONE, "yes");

            // 使用Transformer的transform()方法将DOM树转换成XML
            tf.transform(new DOMSource(document), new StreamResult(os));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

package cn.xyh.testjpa.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FileUtil {

    public static void main(String[] args) {
        File file = new File("c:/test/d.xml");
        FileUtil f = new FileUtil();
        f.createXMLByDOM(file);

//        OutputStream out = new BufferedOutputStream();
    }

    public void createXMLByDOM(File dest) {
        // 创建DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            // 创建DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 创建Document
            Document document = builder.newDocument();

            // 设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
            // document.setXmlStandalone(true);

            // 创建根节点
            Element bookstore = document.createElement("bookstore");

            // 创建子节点，并设置属性
            Element book = document.createElement("book");
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

            // 将根节点添加到Document下
            document.appendChild(bookstore);


            /*
             * 下面开始实现： 生成XML文件
             */

            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();

            // 创建Transformer对象
            Transformer tf = tff.newTransformer();

            // 设置输出数据时换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");

            // 使用Transformer的transform()方法将DOM树转换成XML
            tf.transform(new DOMSource(document), new StreamResult(dest));

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

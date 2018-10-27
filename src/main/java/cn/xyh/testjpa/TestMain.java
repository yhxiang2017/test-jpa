package cn.xyh.testjpa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestMain {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        TestMain testMain = new TestMain();
        testMain.readXML();
    }

    public void readXML() throws ParserConfigurationException, IOException, SAXException {
        //1.获取DocumentBuilder工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //2.获取解析器
        DocumentBuilder builder = dbf.newDocumentBuilder();
        //3.解析文件
        Document document = builder.parse(this.getClass().getClassLoader().getResourceAsStream("/b.xml"));
        //获取根元素
        Element root =  document.getDocumentElement();
        //获取属性
        String cat = root.getAttribute("cat");
        System.out.println("根元素为："+root.getNodeName()+" 属性cat:"+cat);
        //获取所有名字为lang的标签
        NodeList langs = root.getElementsByTagName("lang");
        int length = langs.getLength();
        System.out.println("lang名称的节点长度为："+length);
        for (int i = 0; i < length; i++) {
            Node node = langs.item(i);
            //获取下面所有的子节点
            NodeList childNodes = node.getChildNodes();
            int len = childNodes.getLength();
            System.out.println("第"+(i+1)+"个lang标签子节点长度:"+len);//长度为5（因为含有三个回车）
            for (int j = 0; j < len; j++) {
                Node item = childNodes.item(j);
                //只对节点类型为ELEMENT_NODE的操作   回车的类型为TEXT_NODE
                if(item.getNodeType()== Node.ELEMENT_NODE){
                    System.out.println(item.getNodeName()+"="+item.getTextContent());
                }
            }
        }
    }

}

package cn.xyh.testjpa.util;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Ha {

    public static void main(String[] args) {
        domXml("C:\\work\\test-jpa\\src\\main\\resources\\c.xml");
    }

    /**解析本地xml(响应) 文件 格式 见定义*/
    public  static PosSign domXml(String fileName){
        PosSign pos = new PosSign();
        Element element = null;
        File f = new File(fileName);
        DocumentBuilder db = null; // documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
        DocumentBuilderFactory dbf = null;
        try {
            dbf = DocumentBuilderFactory.newInstance(); // 返回documentBuilderFactory对象
            db = dbf.newDocumentBuilder();// 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
            Document dt = db.parse(f); // 得到一个DOM并返回给document对象
            element = dt.getDocumentElement();// 得到一个elment根元素
            System.out.println("根元素：" + element.getNodeName()); // 获得根节点
            NodeList childNodes = element.getChildNodes(); // 获得根元素下的子节点
            System.out.println("childNodes = " + childNodes);
            for (int i = 0; i < childNodes.getLength(); i++) // 遍历这些子节点
            {
                Node node1 = childNodes.item(i); // childNodes.item(i);
                // 获得每个对应位置i的结点
                if ("PUB".equals(node1.getNodeName())) {
                    System.out.println("find person node!");
                    NodeList nodeDetail = node1.getChildNodes(); // 获得<Accounts>下的节点
                    for (int j = 0; j < nodeDetail.getLength(); j++) { // 遍历<Accounts>下的节点
                        Node detail = nodeDetail.item(j); // 获得<Accounts>元素每一个节点
                        if ("TRXTIME".equals(detail.getNodeName())) { // 输出PUB
                            System.out.println("交易时间: "+ detail.getTextContent());
                            pos.setTradeTime(detail.getTextContent());
                        } else if ("TRXDATE".equals(detail.getNodeName())) { // 输出pass
                            System.out.println("交易日期: "+ detail.getTextContent());
                            pos.setTradeDate(detail.getTextContent());
                        }
                    }
                }else if ("OUT".equals(node1.getNodeName())) {

                    NodeList nodeDetail = node1.getChildNodes(); // 获得<Accounts>下的节点
                    for (int j = 0; j < nodeDetail.getLength(); j++) { // 遍历<Accounts>下的节点
                        Node detail = nodeDetail.item(j); // 获得<Accounts>元素每一个节点
                        if ("TRXCODE".equals(detail.getNodeName())) { // 输出PUB
                            System.out.println("83390: "+ detail.getTextContent());
                            pos.setJiaoyma(detail.getTextContent());
                        } else if ("RETCODE".equals(detail.getNodeName())) { // 输出pass
                            System.out.println("响应码: "+ detail.getTextContent());
                            pos.setResponseCode(detail.getTextContent());
                        }else if("RETMSG".equals(detail.getNodeName())){
                            System.out.println("响应信息: "+ detail.getTextContent());
                            pos.setResponseInfo(detail.getTextContent());
                        }else if("POSID".equals(detail.getNodeName())){
                            System.out.println("pos终端编号: "+ detail.getTextContent());
                            pos.setPosPartNum(detail.getTextContent());
                        }else if("MERID".equals(detail.getNodeName())){
                            System.out.println("pos商场编号: "+ detail.getTextContent());
                            pos.setPosShopNum(detail.getTextContent());
                        }else if("PINKEY".equals(detail.getNodeName())){
                            System.out.println("PIN_KEY: "+ detail.getTextContent());
                            pos.setPin_KEY( detail.getTextContent());
                        }else if("TKEY".equals(detail.getNodeName())){
                            System.out.println("T_KEY: "+ detail.getTextContent());
                            pos.setT_KEY(detail.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pos;
    }
}

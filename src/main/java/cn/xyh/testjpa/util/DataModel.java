package cn.xyh.testjpa.util;

import java.util.Date;

/**
 * Created by syj on 2018/3/29.
 *
 * 等待处理数据
 */
public class DataModel {

    /**
     * 串口编号
     */
    private String portCode;
    /**
     * 串口名字
     */
    private String portName;
    /**
     * 传输数据
     */
    private String portMsg;
    /**
     * 时间
     */
    private Date createTime;

    public DataModel() {}

    public DataModel(String portCode, String portName, String portMsg, Date createTime) {
        this.portCode = portCode;
        this.portName = portName;
        this.portMsg = portMsg;
        this.createTime = createTime;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortMsg() {
        return portMsg;
    }

    public void setPortMsg(String portMsg) {
        this.portMsg = portMsg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "{" + "\"createTime\":\"" + DateUtil.getDateString(createTime, "yyyy-MM-dd HH:mm:ss") + "\", " +
                "\"portCode\":\"" + portCode + "\", \"portMsg\":\"" + portMsg + "\", \"portName\":\"" + portName + "\"}";
    }
}
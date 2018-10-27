package cn.xyh.testjpa.util;

import java.io.Serializable;

public class PosSign implements Serializable {
 
	/**交易时间*/
	private String tradeTime;
	/**交易日期*/
	private String tradeDate;
	
	/**交易码*/
	private String  jiaoyma  ;
	/**响应代码*/
	private String responseCode;
	/**响应信息*/
	private String responseInfo;
	/**pos终端编号*/
	private String posPartNum;
	/**pos商场编号*/
	private String posShopNum;
	/**终端流水号*/
	private String pointNum;
        /**PIN_KEY*/
	private String pin_KEY;
	/**T_KEY*/
	private String t_KEY;

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getJiaoyma() {
		return jiaoyma;
	}

	public void setJiaoyma(String jiaoyma) {
		this.jiaoyma = jiaoyma;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(String responseInfo) {
		this.responseInfo = responseInfo;
	}

	public String getPosPartNum() {
		return posPartNum;
	}

	public void setPosPartNum(String posPartNum) {
		this.posPartNum = posPartNum;
	}

	public String getPosShopNum() {
		return posShopNum;
	}

	public void setPosShopNum(String posShopNum) {
		this.posShopNum = posShopNum;
	}

	public String getPointNum() {
		return pointNum;
	}

	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}

	public String getPin_KEY() {
		return pin_KEY;
	}

	public void setPin_KEY(String pin_KEY) {
		this.pin_KEY = pin_KEY;
	}

	public String getT_KEY() {
		return t_KEY;
	}

	public void setT_KEY(String t_KEY) {
		this.t_KEY = t_KEY;
	}
}
package cn.xyh.testjpa.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SpecParam {

    private String staffName;

    private String address;

    private Date inTime;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
}

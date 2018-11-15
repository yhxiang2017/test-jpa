package cn.xyh.testjpa.param;

public class SomeParam extends PageParam{

    private String staffName;

    private String address;

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
}

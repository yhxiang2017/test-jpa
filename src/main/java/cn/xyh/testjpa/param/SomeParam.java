package cn.xyh.testjpa.param;

import javax.validation.constraints.NotEmpty;

public class SomeParam extends PageParam{

    @NotEmpty
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

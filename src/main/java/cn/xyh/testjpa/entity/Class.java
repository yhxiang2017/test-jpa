package cn.xyh.testjpa.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Class {

    @Id
    @GeneratedValue
    private int id;

    private int pId;

    private String className;

    private String classInfo;

    @Transient
    private String anyFiled;

    private String anyFiledHaha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getAnyFiled() {
        return anyFiled;
    }

    public void setAnyFiled(String anyFiled) {
        this.anyFiled = anyFiled;
    }

    public String getAnyFiledHaha() {
        return anyFiledHaha;
    }

    public void setAnyFiledHaha(String anyFiledHaha) {
        this.anyFiledHaha = anyFiledHaha;
    }
}

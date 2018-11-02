package cn.xyh.testjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Persion implements Serializable, Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, columnDefinition = "int(20) COMMENT '年龄'")
    private int age;

    @Column(nullable = false, columnDefinition = "varchar(50) COMMENT '名字'")
    private String name;

    public Persion() {
    }

    public Persion(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

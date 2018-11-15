package cn.xyh.testjpa.mapper;

import cn.xyh.testjpa.model.Staff;
import cn.xyh.testjpa.param.SomeParam;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> selectListByParam(SomeParam someParam);

    int selectListCount(SomeParam someParam);
}
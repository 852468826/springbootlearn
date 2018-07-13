 package com.huawei.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huawei.springboot.entries.MUser;
//mapper注入
@Mapper
public interface MUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(MUser record);

    int insertSelective(MUser record);

    MUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);

	List<MUser> getAll();
}
package com.luo.mapper;

import org.apache.ibatis.annotations.Param;

import com.luo.pojo.Student;

public interface StudentMapper {

	Student selectStudent(@Param("id") Integer id);
}

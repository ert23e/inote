package com.whencout.inote.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomSelectMapper {
    
    @Select("${sql}")
    List<Map<String, Object>> executeSelect(@Param("sql") String sql);
}
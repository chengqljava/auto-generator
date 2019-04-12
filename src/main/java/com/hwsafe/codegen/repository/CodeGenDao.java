package com.hwsafe.codegen.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CodeGenDao {

    Map<String, String> queryTable(@Param("tableName")String tableName);

    List<Map<String, String>> queryColumns(@Param("tableName")String tableName);
    
}

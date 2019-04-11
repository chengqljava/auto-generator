package com.chengql.codegen.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeGenDao {

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
    List<String> queryTables();
}

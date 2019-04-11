package com.chengql.codegen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chengql.codegen.GenUtils;
import com.chengql.codegen.repository.CodeGenDaoMapper;



@Service
public class CodeGenService {

    @Autowired
    private CodeGenDaoMapper codeGenDaoMapper;

    /**
     * @param tableName
     * 指定单表名
     */
    public void generatorCode(String tableName) {

        //查询表信息
        Map<String, String> table = codeGenDaoMapper.queryTable(tableName);
        //查询列信息
        List<Map<String, String>> columns = codeGenDaoMapper.queryColumns(tableName);
        //生成代码
        GenUtils.generatorCode(table, columns);
    }

    /**
     * @param tableNames
     * 指定多表
     */
    public void generatorCode(List<String> tableNames) {
        for (String tableName : tableNames) {
        	generatorCode(tableName);
        }
    }
    
    
}

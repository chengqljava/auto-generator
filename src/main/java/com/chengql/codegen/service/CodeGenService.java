package com.chengql.codegen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengql.codegen.GenUtils;
import com.chengql.codegen.repository.CodeGenDao;



@Service
public class CodeGenService {

    @Autowired
    private CodeGenDao codeGenDao;

    /**
     * @param tableName
     * 指定单表名
     */
    public void generatorCode(String tableName) {

        //查询表信息
        Map<String, String> table = codeGenDao.queryTable(tableName);
        //查询列信息
        List<Map<String, String>> columns = codeGenDao.queryColumns(tableName);
        //生成代码
        GenUtils.generatorCode(table, columns);
    }
    /**
     * 连接数据库所有表
     */
    public void generatorCode() {
    	List<String> tableNames=codeGenDao.queryTables();
    	if(tableNames!=null&&tableNames.size()>0){
    		 for (String tableName : tableNames) {
    			 generatorCode(tableName);
    	        }
    		
    	}
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

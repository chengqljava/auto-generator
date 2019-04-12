package com.hwsafe.codegen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwsafe.codegen.GenUtils;
import com.hwsafe.codegen.repository.CodeGenDao;

@Service
public class CodeGenService {

	@Autowired
	private CodeGenDao codeGenDao;

	/**
	 * @param tableName 单表
	 */
	public void generatorCode(String tableName) {
		try {
		// 查询表信息
		Map<String, String> table = codeGenDao.queryTable(tableName);
		// 查询列信息
		List<Map<String, String>> columns = codeGenDao.queryColumns(tableName);
		// 生成代码
				GenUtils.generatorCode(table, columns);
		}catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	/**
	 * @param tableNames 多表
	 */
	public void generatorCode(List<String> tableNames) {
		for (String tableName : tableNames) {
			generatorCode(tableName);
		}
	}

	/**
	 * @param tableNames 多表
	 */
	public void generatorCode(String... tableNames) {
		for (String tableName : tableNames) {
			generatorCode(tableName);
		}
	}
}

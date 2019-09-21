package com.generator.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlMap {
	public void generator() throws Exception {
		// 集合warnings用来存放生成过程中的警告信息
		List<String> warnings = new ArrayList<String>();
		// overwrite指定是否覆盖重名文件
		boolean overwrite = true;
		// 加载逆向工程配置文件
		File generatorConfigFile = new File("generatorConfig.xml");
		// 配置解析类
		ConfigurationParser cp = new ConfigurationParser(warnings);
		// 配置解析类解析逆向工程配置文件,生成Configuration对象
		Configuration config = cp.parseConfiguration(generatorConfigFile);
		// 处理重复文件,指定Java或XML文件已存在情况下如何处理重复文件
		ShellCallback callback = new DefaultShellCallback(overwrite);
		// 逆向工程对象
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		// 执行逆向文件生成操作
		myBatisGenerator.generate(null);
	}
	
	public static void main(String[] args) throws Exception {
		GeneratorSqlMap generatorSqlmap = new GeneratorSqlMap();
		generatorSqlmap.generator();
	}
}

package com.yihaomen.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GenMain {

	@Test
	public void main() {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//String genCfg = "mbgConfiguration.xml";
		//用户模块账户部分
		//String genCfg = "passportAccount.xml";
		//用户模块组织部分
		//String genCfg = "passportOrganize.xml";
		//用户模块合作商部分
		//String genCfg = "passportPartner.xml";
		//用户模块基础部分
		//String genCfg = "passportPrimary.xml";
		//用户模块权限部分
		String genCfg = "passportPrivilege.xml";
		
		
		File configFile = new File(GenMain.class.getResource(genCfg).getFile());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		try {
			config = cp.parseConfiguration(configFile);
			System.out.println(config);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = null;
		try {
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		try {
			myBatisGenerator.generate(null);
			System.out.println("executing......");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
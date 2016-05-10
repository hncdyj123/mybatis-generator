package org.mybatis.supergen.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.supergen.domain.PropertyClass;
import org.mybatis.supergen.domain.TemplateInfoDesc;
import org.mybatis.supergen.util.ResManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 程序主入口类
 * 
 * @author hncdyj123@163.com
 * @date 2015年11月26日 下午3:35:30
 *
 */
public class GeneratorMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorMain.class);

	/**
	 * 主程序入口
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		LOGGER.info("---------开始生成文件---------");
		OverCore core = new OverCore();
		core.createProject();
		// 获取数据库表所有的描述信息
		List<PropertyClass> propertyClassList = core.getAllFileInfo(ResManager.getString("system.db.name"));
		List<TemplateInfoDesc> templateInfoDescList = core.getTemplateInfo(propertyClassList);
		for (TemplateInfoDesc desc : templateInfoDescList) {
			new WriteFile(desc).run();
		}

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String genCfg = "/mbgConfiguration.xml";
		File configFile = new File(GeneratorMain.class.getResource(genCfg).getFile());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

		LOGGER.info("---------结束生成文件---------");
	}
}

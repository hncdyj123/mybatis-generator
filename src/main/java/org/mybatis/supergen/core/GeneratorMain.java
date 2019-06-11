package org.mybatis.supergen.core;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.supergen.domain.PropertyClass;
import org.mybatis.supergen.domain.TemplateInfoDesc;
import org.mybatis.supergen.util.FileUtil;
import org.mybatis.supergen.util.ResManager;

import lombok.extern.slf4j.Slf4j;

/**
 * 程序入口类
 * 
 * @author hncdyj123@163.com
 * @version 2019年6月11日
 * @see GeneratorMain
 * @since
 */
@Slf4j
public class GeneratorMain {
	/**
	 * 主程序入口
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		log.info("---------开始生成文件---------");
		OverCore core = new OverCore();
		core.createProject();
		// 获取数据库表所有的描述信息
		List<PropertyClass> propertyClassList = core.getAllTableInfo();

		List<TemplateInfoDesc> templateInfoDescList = core.getTemplateInfo(propertyClassList);
		for (TemplateInfoDesc desc : templateInfoDescList) {
			new WriteFile().run(desc);
		}

		generator(propertyClassList);

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String genCfg = "/mbgConfiguration.xml";
		String configFileStr = URLDecoder.decode(GeneratorMain.class.getResource(genCfg).getFile(), "UTF-8");
		File configFile = new File(configFileStr);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

		log.info("---------结束生成文件---------");
	}

	/**
	 * 生成额外的查询语句文件
	 * 
	 * @param propertyClassList
	 * @throws Exception
	 * @see
	 */
	private static void generator(List<PropertyClass> propertyClassList) throws Exception {
		// 生成表查询头，未外部mapper.xml 提供所有字段-表字段映射，避免写select *
		for (PropertyClass pro : propertyClassList) {
			String tableStr = "";
			for (int i = 0; i < pro.getColumns().size(); i++) {
				if (i == pro.getColumns().size() - 1) {
					tableStr += (pro.getColumns().get(i).getDatabaseName() + " AS " + pro.getColumns().get(i).getFieldName());
					break;
				}
				tableStr += (pro.getColumns().get(i).getDatabaseName() + " AS " + pro.getColumns().get(i).getFieldName() + ",\n");
			}
			String uri = MavenStruts.covertUri(ResManager.getString("system.projectname") + File.separator + pro.getTableName() + ".txt");
			FileUtil.writeFile(uri, tableStr, "UTF-8");
		}
	}
}

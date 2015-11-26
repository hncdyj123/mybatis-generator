package com.xs.gen.core;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xs.gen.domain.Column;
import com.xs.gen.domain.PropertyClass;
import com.xs.gen.domain.TemplateInfoDesc;
import com.xs.gen.freemarker.FtlProvider;

/**
 * 
 * @ClassName: WriteClass
 * @Description: 写class线程
 * @author hncdyj123@163.com
 * @date 2015年11月21日 上午11:39:30
 *
 */
public class WriteFile implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(WriteFile.class);
	// 参数Map
	@SuppressWarnings("rawtypes")
	// private Map paramMap;
	private FtlProvider ftlProvider = new FtlProvider();
	private List<TemplateInfoDesc> list;
	// 生成文件目录
	// private String filePath;
	// 模板文件名
	// private String ftlName;
	// 模板路径
	// private String ftlPath;
	// 文件前缀
	// private String filePrefix = "";
	// java类型需要导包的类
	private static Map<String, String> importMapper = new LinkedHashMap<String, String>();
	static {
		importMapper.put("String", "java.lang.String;");
		importMapper.put("Date", "java.sql.Date;");
		importMapper.put("Timestamp", "java.sql.Timestamp;");
		importMapper.put("BigDecimal", "java.math.BigDecimal;");
		importMapper.put("Time", "java.sql.Time;");
	}

	public WriteFile() {

	}

	public WriteFile(List<TemplateInfoDesc> templateInfoDesc) {
		this.list = templateInfoDesc;

	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public void run() {
		try {
			for (TemplateInfoDesc desc : list) {
				PropertyClass pro = desc.getPropertyClass();
				Map currentMap = new HashMap();
				currentMap.put("importMap", getImportPackage(pro));
				// 生成文件的文件名
				String fileName = desc.getOutFilePath() + File.separator + pro.getClassName() + desc.getFilePrefix() + desc.getFileSuffixes();
				// 当前文件包名
				currentMap.put("packageName", pro.getPackageName());
				currentMap.put("pro", pro);
				ftlProvider.initFreemarker(desc.getTemplateName(), desc.getTemplatePath(), fileName, currentMap);
			}
		} catch (Exception e) {
			LOGGER.error("生成文件文件异常", e);
		}
	}

	/**
	 * 
	 * @Description: 获取当前需要导入的包
	 * @param propertyClass
	 *            当前表映射的类
	 * @return
	 * @return Map<String,String>
	 * @throws
	 */
	private Map<String, String> getImportPackage(PropertyClass propertyClass) {
		Map<String, String> importPackageMap = new HashMap<String, String>();
		for (Column column : propertyClass.getColumns()) {
			if (importMapper.containsKey(column.getJdkType())) {
				importPackageMap.put(importMapper.get(column.getJdkType()), importMapper.get(column.getJdkType()));
			}
		}
		return importPackageMap;
	}
}

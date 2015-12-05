package com.xs.gen.core;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
	private FtlProvider ftlProvider = new FtlProvider();
	private TemplateInfoDesc desc;

	// java类型需要导包的类
	private static Map<String, String> importMapper = new LinkedHashMap<String, String>();
	static {
		importMapper.put("String", "java.lang.String;");
		importMapper.put("Date", "java.sql.Date;");
		importMapper.put("Timestamp", "java.sql.Timestamp;");
		importMapper.put("BigDecimal", "java.math.BigDecimal;");
		importMapper.put("Time", "java.sql.Time;");
		importMapper.put("Boolean", "java.lang.Boolean;");
		importMapper.put("Long", "java.lang.Long;");
		importMapper.put("Integer", "java.lang.Integer;");
		importMapper.put("Float", "java.lang.Float;");
		importMapper.put("Double", "java.lang.Double;");
	}

	public WriteFile() {

	}

	public WriteFile(TemplateInfoDesc templateInfoDesc) {
		this.desc = templateInfoDesc;

	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public void run() {
		try {
			PropertyClass pro = desc.getPropertyClass();
			Map currentMap = new HashMap();
			currentMap.put("importMap", getImportPackage(pro));
			// 生成文件的文件名
			String fileName = desc.getOutFilePath() + pro.getClassName() + desc.getFilePrefix() + desc.getFileSuffixes();
			// 当前文件包名
			currentMap.put("packageName", pro.getPackageName());
			currentMap.put("pro", pro);
			ftlProvider.initFreemarker(desc.getTemplateName(), desc.getTemplatePath(), fileName, currentMap);
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

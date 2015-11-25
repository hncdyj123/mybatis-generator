package com.xs.gen.core;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xs.gen.constants.Constant;
import com.xs.gen.domain.Column;
import com.xs.gen.domain.PropertyClass;
import com.xs.gen.freemarker.FtlProvider;

/**
 * 
 * @ClassName: WriteClass
 * @Description: 写class线程
 * @author hncdyj123@163.com
 * @date 2015年11月21日 上午11:39:30
 *
 */
public class WriteClass implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(WriteClass.class);
	// 参数Map
	@SuppressWarnings("rawtypes")
	private Map paramMap;
	private FtlProvider ftlProvider = new FtlProvider();
	// 生成文件目录
	private String filePath;
	// 模板文件名
	private String ftlName;
	// 模板路径
	private String ftlPath;
	// 文件前缀
	private String filePrefix = "";
	// java类型需要导包的类
	private static Map<String, String> importMapper = new LinkedHashMap<String, String>();
	static {
		importMapper.put("String", "java.lang.String;");
		importMapper.put("Date", "java.sql.Date;");
		importMapper.put("Timestamp", "java.sql.Timestamp;");
		importMapper.put("BigDecimal", "java.math.BigDecimal;");
		importMapper.put("Time", "java.sql.Time;");
	}

	public WriteClass() {

	}

	/**
	 *
	 * @param filePath
	 *            生成文件地址
	 * @param ftlPath
	 *            模板文件地址
	 * @param paramMap
	 *            模板map数据
	 * @param filePrefix
	 *            文件前缀
	 * @param ftlName
	 *            模板文件名
	 */
	@SuppressWarnings("rawtypes")
	public WriteClass(String filePath, String ftlPath, Map paramMap, String filePrefix, String ftlName) {
		this.ftlName = ftlName;
		this.ftlPath = ftlPath;
		this.paramMap = paramMap;
		this.filePrefix = filePrefix;
		this.filePath = filePath;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public void run() {
		try {
			List<PropertyClass> propertyClassList = (List<PropertyClass>) paramMap.get("proList");
			for (PropertyClass pro : propertyClassList) {
				Map currentMap = new HashMap();
				// 导入的包
				Map<String, String> importPackages = getImportPackage(pro);
				currentMap.put("importMap", importPackages);
				// 生成文件的文件名
				String fileName = filePath + File.separator + (pro.getPackageName().replace(".", File.separator)) + File.separator + pro.getClassName() + filePrefix + Constant.JAVA_FILE_SUFFIX;
				LOGGER.info("类文件名是 : " + fileName);
				// 当前文件包名
				currentMap.put("packageName", pro.getPackageName());
				LOGGER.info("类包名是 : " + pro.getPackageName());
				String className = pro.getClassName();
				if (pro.getClassName().equals(className)) {
					currentMap.put("pro", pro);
					// 生成实体类
					ftlProvider.initFreemarker(ftlName, ftlPath, fileName, currentMap);
				}
			}
		} catch (Exception e) {
			LOGGER.error("生成class文件异常", e);
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

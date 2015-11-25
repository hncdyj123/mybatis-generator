package com.xs.gen.core;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xs.gen.domain.PropertyClass;
import com.xs.gen.freemarker.FtlProvider;

/**
 * 
 * @ClassName: WriteXml
 * @Description: 写xml文件线程
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:12:11
 *
 */
public class WriteXml implements Runnable {
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

	public WriteXml() {

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
	public WriteXml(String filePath, String ftlPath, Map paramMap, String filePrefix, String ftlName) {
		this.ftlName = ftlName;
		this.ftlPath = ftlPath;
		this.paramMap = paramMap;
		this.filePrefix = filePrefix;
		this.filePath = filePath;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public void run() {
		try {
			List<PropertyClass> PropertyClassList = (List<PropertyClass>) paramMap.get("proList");
			for (PropertyClass pro : PropertyClassList) {
				Map currentMap = new HashMap();
				// 生成文件的文件名
				String fileName = filePath + File.separator + (pro.getPackageName().replace(".", File.separator)) + File.separator + pro.getClassName() + filePrefix;
				LOGGER.info("xml文件名是 : " + fileName);
				currentMap.put("packageName", pro.getPackageName());
				LOGGER.info("packageName is " + pro.getPackageName());
				String className = pro.getClassName();
				LOGGER.info("类包名是 : " + pro.getPackageName());
				if (pro.getClassName().equals(className)) {
					currentMap.put("pro", pro);
					// 生成实体类
					ftlProvider.initFreemarker(ftlName, ftlPath, fileName, currentMap);
				}
			}
		} catch (Exception e) {
			LOGGER.error("生成xml文件异常", e);
		}
	}

}

package com.xs.gen.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件帮助类
 * 
 * @author hncdyj123@163.com
 * @date 2015年11月25日 下午7:10:43
 *
 */
public class FileHelper {
	private Map<String, String> mavenProFramework = new HashMap<String, String>();
	private Map<String, String> templatePathMap = new HashMap<String, String>();

	private String fileSeparator = File.separator;
	private String projectPath = PropertiesHelper.getString("system.projectname") + fileSeparator;
	private String packageName = PropertiesHelper.getString("system.project.packagename").replace(".", fileSeparator) + fileSeparator;
	private String webapp = projectPath + "src" + fileSeparator + "main" + fileSeparator + "webapp" + fileSeparator;
	private String srcMainJava = projectPath + "src" + fileSeparator + "main" + fileSeparator + "java" + fileSeparator;
	private String srcMainResources = projectPath + "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator;
	private String srcTestJava = projectPath + "src" + fileSeparator + "test" + fileSeparator + "java" + fileSeparator;
	private String srcTestResources = projectPath + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator;
	private String domainPath = srcMainJava + packageName + "domain" + fileSeparator;
	private String daoPath = srcMainJava + packageName + "dao" + fileSeparator;
	private String servicePath = srcMainJava + packageName + "service" + fileSeparator;
	private String daoImplPath = srcMainJava + packageName + "dao" + fileSeparator + "impl" + fileSeparator;
	private String serviceImplPath = srcMainJava + packageName + "service" + fileSeparator + "impl" + fileSeparator;
	private String controllerPath = srcMainJava + packageName + "controller" + fileSeparator;
	private String mybatisPath = srcMainResources + fileSeparator + "mybatis" + fileSeparator;
	private String pomPath = projectPath;
	private String jspPath = webapp + "WEB-INF" + fileSeparator + "views" + fileSeparator;
	private String baseEntityPath = domainPath + fileSeparator + "base" + fileSeparator;

	public FileHelper() {
		mavenProFramework.put("srcMainJava", srcMainJava);
		mavenProFramework.put("srcMainResources", srcMainResources);
		mavenProFramework.put("srcTestJava", srcTestJava);
		mavenProFramework.put("srcTestResources", srcTestResources);
		mavenProFramework.put("domainPath", domainPath);
		mavenProFramework.put("daoPath", daoPath);
		mavenProFramework.put("servicePath", servicePath);
		mavenProFramework.put("daoImplPath", daoImplPath);
		mavenProFramework.put("serviceImplPath", serviceImplPath);
		mavenProFramework.put("controllerPath", controllerPath);
		mavenProFramework.put("pomPath", pomPath);
		mavenProFramework.put("mybatisPath", mybatisPath);
		mavenProFramework.put("webapp", webapp);
		mavenProFramework.put("jspPath", jspPath);
		mavenProFramework.put("baseEntityPath", baseEntityPath);

		templatePathMap.put("domainPath", domainPath);
		templatePathMap.put("daoPath", daoPath);
		templatePathMap.put("servicePath", servicePath);
		templatePathMap.put("daoImplPath", daoImplPath);
		templatePathMap.put("serviceImplPath", serviceImplPath);
		templatePathMap.put("controllerPath", controllerPath);
		templatePathMap.put("pomPath", pomPath);
		templatePathMap.put("mybatisPath", mybatisPath);
		templatePathMap.put("jspPath", jspPath);
	}

	public void createProject() throws IOException {
		// 复制webapp
		String webapp = this.getClass().getResource("/").getPath() + "prosource/webapp/";
		FileUtil.copyFolder(new File(webapp), new File(mavenProFramework.get("webapp")));
		String baseEntity = this.getClass().getResource("/").getPath() + "prosource/base/";
		FileUtil.copyFolder(new File(baseEntity), new File(mavenProFramework.get("baseEntityPath")));
		String mybatisConfig = this.getClass().getResource("/").getPath() + "prosource/mybatis-config.xml";
		FileUtil.CopyFile(new File(mybatisConfig), mybatisPath + "mybatis-config.xml");
		PropertyPlaceholderReplace proPlaceholderReplace = new PropertyPlaceholderReplace(PropertiesHelper.getString("prosource.fileNames"));
		proPlaceholderReplace.placeholderReplace();
	}

	public void createDir() {
		for (Map.Entry<String, String> dir : mavenProFramework.entrySet()) {
			File file = new File(dir.getValue());
			createDir(file);
		}
	}

	public void createDir(File dir) {
		if (!dir.getParentFile().exists()) {
			createDir(dir.getParentFile());
		}
		dir.mkdir();
	}

	public Map<String, String> getMavenProFramework() {
		return mavenProFramework;
	}

	public static void main(String[] args) throws IOException {
		// PropertiesHelper.initProperties("D:\\workspace\\super-generator\\src\\main\\resources\\config.properties");
		// System.out.println(PropertiesHelper.getByKey("system.project.packagename"));
		// System.out.println(PropertiesHelper.getByKey("system.projectname"));
		// new FileHelper().createDir();
		new FileHelper().createProject();
	}

	public Map<String, String> getTemplatePathMap() {
		return templatePathMap;
	}

	public void setTemplatePathMap(Map<String, String> templatePathMap) {
		this.templatePathMap = templatePathMap;
	}

}

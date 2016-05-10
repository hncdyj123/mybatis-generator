package org.mybatis.supergen.util;

import java.io.File;
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
	// 项目框架Map
	private Map<String, String> mavenProFramework = new HashMap<String, String>();
	// 模板文件Map
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
	private String innerServicePath = srcMainJava + packageName + "inner" + fileSeparator;
	private String innerServiceImplPath = srcMainJava + packageName + "inner" + fileSeparator + "impl" + fileSeparator;
	private String servicePath = srcMainJava + packageName + "service" + fileSeparator;
	private String serviceImplPath = srcMainJava + packageName + "service" + fileSeparator + "impl" + fileSeparator;
	private String controllerPath = srcMainJava + packageName + "controller" + fileSeparator;
	private String mybatisPath = srcMainResources + fileSeparator + "mybatis" + fileSeparator;
	private String pomPath = projectPath;
	private String jspPath = webapp + "WEB-INF" + fileSeparator + "views" + fileSeparator;
	private String baseEntityPath = domainPath + fileSeparator + "base" + fileSeparator;
	private String baseDaoPath = daoPath + fileSeparator + "base" + fileSeparator;

	public FileHelper() {
		mavenProFramework.put("srcMainJava", srcMainJava);
		mavenProFramework.put("srcMainResources", srcMainResources);
		mavenProFramework.put("srcTestJava", srcTestJava);
		mavenProFramework.put("srcTestResources", srcTestResources);
		mavenProFramework.put("domainPath", domainPath);
		mavenProFramework.put("daoPath", daoPath);
		mavenProFramework.put("innerServicePath", innerServicePath);
		mavenProFramework.put("innerServiceImplPath", innerServiceImplPath);
		mavenProFramework.put("servicePath", servicePath);
		mavenProFramework.put("serviceImplPath", serviceImplPath);
		mavenProFramework.put("controllerPath", controllerPath);
		mavenProFramework.put("pomPath", pomPath);
		mavenProFramework.put("mybatisPath", mybatisPath);
		mavenProFramework.put("webapp", webapp);
		mavenProFramework.put("jspPath", jspPath);
		mavenProFramework.put("baseEntityPath", baseEntityPath);
		mavenProFramework.put("baseDaoPath", baseDaoPath);

		templatePathMap.put("domainPath", domainPath);
		templatePathMap.put("daoPath", daoPath);
		templatePathMap.put("innerServicePath", innerServicePath);
		templatePathMap.put("innerServiceImplPath", innerServiceImplPath);
		templatePathMap.put("servicePath", servicePath);
		templatePathMap.put("serviceImplPath", serviceImplPath);
		templatePathMap.put("controllerPath", controllerPath);
		templatePathMap.put("pomPath", pomPath);
		templatePathMap.put("mybatisPath", mybatisPath);
		templatePathMap.put("jspPath", jspPath);
	}

	public void createProject() throws Exception {
		// 复制webapp
		String webapp = this.getClass().getResource("/").getPath() + "prosource/webapp/";
		FileUtil.copyFolder(new File(webapp), new File(mavenProFramework.get("webapp")));
		// 复制baseEntity
		String baseEntity = this.getClass().getResource("/").getPath() + "prosource/javaclass/base/";
		PropertyPlaceholderReplace baseReplace = new PropertyPlaceholderReplace();
		baseReplace.placeholderReplace(baseEntity, mavenProFramework.get("baseEntityPath"));
		// 复制baseDaoEntity
		String baseDaoEntity = this.getClass().getResource("/").getPath() + "prosource/javaclass/dao/";
		PropertyPlaceholderReplace daoReplace = new PropertyPlaceholderReplace();
		daoReplace.placeholderReplace(baseDaoEntity, mavenProFramework.get("baseDaoPath"));
		// 复制mybatisConfig
		String mybatisConfig = this.getClass().getResource("/").getPath() + "prosource/mybatis-config.xml";
		FileUtil.CopyFile(new File(mybatisConfig), mybatisPath + "mybatis-config.xml");
		// 复制sources文件
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

	public static void main(String[] args) throws Exception {
		PropertiesHelper.initProperties("D:\\workspace\\super-mybatis-generator\\src\\main\\resources\\config.properties");
		System.out.println(PropertiesHelper.getByKey("system.project.packagename"));
		System.out.println(PropertiesHelper.getByKey("system.projectname"));
		new FileHelper().createDir();
		new FileHelper().createProject();
	}

	public Map<String, String> getTemplatePathMap() {
		return templatePathMap;
	}

	public void setTemplatePathMap(Map<String, String> templatePathMap) {
		this.templatePathMap = templatePathMap;
	}

}

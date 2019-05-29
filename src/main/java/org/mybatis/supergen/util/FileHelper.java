package org.mybatis.supergen.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
	private String mybatisPath = srcMainResources + "mybatis" + fileSeparator;
	private String pomPath = projectPath;
	private String jspPath = webapp + "WEB-INF" + fileSeparator + "views" + fileSeparator;
	private String baseEntityPath = domainPath + "base" + fileSeparator;
	private String baseDaoPath = daoPath + "base" + fileSeparator;

	public FileHelper() {
		try {
			mavenProFramework.put("srcMainJava", new String(srcMainJava.getBytes(), "UTF-8"));
			mavenProFramework.put("srcMainResources", new String(srcMainResources.getBytes(), "UTF-8"));
			mavenProFramework.put("srcTestJava", new String(srcTestJava.getBytes(), "UTF-8"));
			mavenProFramework.put("srcTestResources", new String(srcTestResources.getBytes(), "UTF-8"));
			mavenProFramework.put("domainPath", new String(domainPath.getBytes(), "UTF-8"));
			mavenProFramework.put("daoPath", new String(daoPath.getBytes(), "UTF-8"));
			mavenProFramework.put("innerServicePath", new String(innerServicePath.getBytes(), "UTF-8"));
			mavenProFramework.put("innerServiceImplPath", new String(innerServiceImplPath.getBytes(), "UTF-8"));
			mavenProFramework.put("servicePath", new String(servicePath.getBytes(), "UTF-8"));
			mavenProFramework.put("serviceImplPath", new String(serviceImplPath.getBytes(), "UTF-8"));
			mavenProFramework.put("controllerPath", new String(controllerPath.getBytes(), "UTF-8"));
			mavenProFramework.put("pomPath", new String(pomPath.getBytes(), "UTF-8"));
			mavenProFramework.put("mybatisPath", new String(mybatisPath.getBytes(), "UTF-8"));
			mavenProFramework.put("webapp", new String(webapp.getBytes(), "UTF-8"));
			mavenProFramework.put("jspPath", new String(jspPath.getBytes(), "UTF-8"));
			mavenProFramework.put("baseEntityPath", new String(baseEntityPath.getBytes(), "UTF-8"));
			mavenProFramework.put("baseDaoPath", new String(baseDaoPath.getBytes(), "UTF-8"));

			templatePathMap.put("domainPath", new String(domainPath.getBytes(), "UTF-8"));
			templatePathMap.put("daoPath", new String(daoPath.getBytes(), "UTF-8"));
			templatePathMap.put("innerServicePath", new String(innerServicePath.getBytes(), "UTF-8"));
			templatePathMap.put("innerServiceImplPath", new String(innerServiceImplPath.getBytes(), "UTF-8"));
			templatePathMap.put("servicePath", new String(servicePath.getBytes(), "UTF-8"));
			templatePathMap.put("serviceImplPath", new String(serviceImplPath.getBytes(), "UTF-8"));
			templatePathMap.put("controllerPath", new String(controllerPath.getBytes(), "UTF-8"));
			templatePathMap.put("pomPath", new String(pomPath.getBytes(), "UTF-8"));
			templatePathMap.put("mybatisPath", new String(mybatisPath.getBytes(), "UTF-8"));
			templatePathMap.put("jspPath", new String(jspPath.getBytes(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void createProject() throws Exception {
		// 复制webapp
		String webapp = URLDecoder.decode(this.getClass().getResource("/").getPath() + "prosource/webapp/", "UTF-8");
		FileUtil.copyFolder(new File(webapp), new File(mavenProFramework.get("webapp")));
		// 复制baseEntity
		String baseEntity = URLDecoder.decode(this.getClass().getResource("/").getPath() + "prosource/javaclass/base/", "UTF-8");
		PropertyPlaceholderReplace baseReplace = new PropertyPlaceholderReplace();
		baseReplace.placeholderReplace(baseEntity, mavenProFramework.get("baseEntityPath"));
		// 复制baseDaoEntity
		String baseDaoEntity = URLDecoder.decode(this.getClass().getResource("/").getPath() + "prosource/javaclass/dao/", "UTF-8");
		PropertyPlaceholderReplace daoReplace = new PropertyPlaceholderReplace();
		daoReplace.placeholderReplace(baseDaoEntity, mavenProFramework.get("baseDaoPath"));
		// 复制mybatisConfig
		String mybatisConfig = URLDecoder.decode(this.getClass().getResource("/").getPath() + "prosource/mybatis-config.xml", "UTF-8");
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

package org.mybatis.supergen.core;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.supergen.util.FileUtil;
import org.mybatis.supergen.util.PropertiesHelper;
import org.mybatis.supergen.util.PropertyPlaceholderReplace;

/**
 * maven目录构建类
 * 
 * @author hncdyj123@163.com
 * @version 2019年6月11日
 * @see MavenStruts
 * @since
 */
public class MavenStruts {
	// 项目框架Map
	private Map<String, String> mavenProFramework = new HashMap<String, String>();
	// 模板文件Map
	private Map<String, String> templatePathMap = new HashMap<String, String>();
	// 文件分割符
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

	public MavenStruts() {
		mavenProFramework.put("srcMainJava", covertUri(srcMainJava));
		mavenProFramework.put("srcMainResources", covertUri(srcMainResources));
		mavenProFramework.put("srcTestJava", covertUri(srcTestJava));
		mavenProFramework.put("srcTestResources", covertUri(srcTestResources));
		mavenProFramework.put("domainPath", covertUri(domainPath));
		mavenProFramework.put("daoPath", covertUri(daoPath));
		mavenProFramework.put("innerServicePath", covertUri(innerServicePath));
		mavenProFramework.put("innerServiceImplPath", covertUri(innerServiceImplPath));
		mavenProFramework.put("servicePath", covertUri(servicePath));
		mavenProFramework.put("serviceImplPath", covertUri(serviceImplPath));
		mavenProFramework.put("controllerPath", covertUri(controllerPath));
		mavenProFramework.put("pomPath", covertUri(pomPath));
		mavenProFramework.put("mybatisPath", covertUri(mybatisPath));
		mavenProFramework.put("webapp", covertUri(webapp));
		mavenProFramework.put("jspPath", covertUri(jspPath));
		mavenProFramework.put("baseEntityPath", covertUri(baseEntityPath));
		mavenProFramework.put("baseDaoPath", covertUri(baseDaoPath));

		templatePathMap.put("domainPath", covertUri(domainPath));
		templatePathMap.put("daoPath", covertUri(daoPath));
		templatePathMap.put("innerServicePath", covertUri(innerServicePath));
		templatePathMap.put("innerServiceImplPath", covertUri(innerServiceImplPath));
		templatePathMap.put("servicePath", covertUri(servicePath));
		templatePathMap.put("serviceImplPath", covertUri(serviceImplPath));
		templatePathMap.put("controllerPath", covertUri(controllerPath));
		templatePathMap.put("pomPath", covertUri(pomPath));
		templatePathMap.put("mybatisPath", covertUri(mybatisPath));
		templatePathMap.put("jspPath", covertUri(jspPath));
	}

	/**
	 * 创建简单MAVEN项目文件结构目录
	 * 
	 * @throws Exception
	 * @see
	 */
	public void createProject() throws Exception {
		// 复制WEBAPP
		String webapp = covertUri(this.getClass().getResource("/").getPath() + "prosource/webapp/");
		FileUtil.copyFolder(new File(webapp), new File(mavenProFramework.get("webapp")));
		// 复制baseEntity
		String baseEntity = covertUri(this.getClass().getResource("/").getPath() + "prosource/javaclass/base/");
		PropertyPlaceholderReplace baseReplace = new PropertyPlaceholderReplace();
		baseReplace.placeholderReplace(baseEntity, mavenProFramework.get("baseEntityPath"));
		// 复制baseDaoEntity
		String baseDaoEntity = covertUri(this.getClass().getResource("/").getPath() + "prosource/javaclass/dao/");
		PropertyPlaceholderReplace daoReplace = new PropertyPlaceholderReplace();
		daoReplace.placeholderReplace(baseDaoEntity, mavenProFramework.get("baseDaoPath"));
		// 复制mybatisConfig
		String mybatisConfig = covertUri(this.getClass().getResource("/").getPath() + "prosource/mybatis-config.xml");
		FileUtil.CopyFile(new File(mybatisConfig), mavenProFramework.get("mybatisPath") + "mybatis-config.xml");
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

	public Map<String, String> getTemplatePathMap() {
		return templatePathMap;
	}

	public void setTemplatePathMap(Map<String, String> templatePathMap) {
		this.templatePathMap = templatePathMap;
	}

	/**
	 * 处理中文文件路径乱码问题
	 * 
	 * @param uri
	 * @return
	 * @see
	 */
	public static String covertUri(String uri) {
		try {
			return URLDecoder.decode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		PropertiesHelper.initProperties("D:\\github\\mybatis-generator\\src\\main\\resources\\config.properties");
		System.out.println(PropertiesHelper.getByKey("system.project.packagename"));
		System.out.println(PropertiesHelper.getByKey("system.projectname"));
		new MavenStruts().createDir();
		new MavenStruts().createProject();
	}

}

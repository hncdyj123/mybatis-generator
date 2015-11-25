package com.xs.gen.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件帮助类
 * 
 * @author hncdyj123@163.com
 * @date 2015年11月25日 下午7:10:43
 *
 */
public class FileHelper {
	private String FILE_SEPARATOR = File.separator;
	private String PROJECT_PATH = PropertiesHelper.getByKey("system.projectname") + FILE_SEPARATOR;
	private String PACKAGE_NAME = PropertiesHelper.getByKey("system.project.packagename").replace(".", FILE_SEPARATOR) + FILE_SEPARATOR;
	private String SRC_MAIN_JAVA = PROJECT_PATH + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "java";
	private String SRC_MAIN_RESOURCES = PROJECT_PATH + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "resources";
	private String SRC_TEST_JAVA = PROJECT_PATH + "src" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "java";
	private String SRC_TEST_RESOURCES = PROJECT_PATH + "src" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "resources";
	private String DOMAIN_PATH = PROJECT_PATH + PACKAGE_NAME + FILE_SEPARATOR + "domain";
	private String DAO_PATH = PROJECT_PATH + PACKAGE_NAME + FILE_SEPARATOR + "dao";
	private String SERVICE_PATH = PROJECT_PATH + PACKAGE_NAME + FILE_SEPARATOR + "service";
	private String DAO_IMPL_PATH = PROJECT_PATH + PACKAGE_NAME + FILE_SEPARATOR + "dao" + FILE_SEPARATOR + "impl";
	private String SERVICE_IMPL_PATH = PROJECT_PATH + PACKAGE_NAME + FILE_SEPARATOR + "service" + FILE_SEPARATOR + "impl";
	private String CONTROLLER_PATH = PROJECT_PATH + PACKAGE_NAME + FILE_SEPARATOR + "controller";
	private String POM_PATH = PROJECT_PATH;

	private List<String> MAVEN_PROJECT_FRAMEWORK = new ArrayList<String>();

	public FileHelper() {
		MAVEN_PROJECT_FRAMEWORK.add(SRC_MAIN_JAVA);
		MAVEN_PROJECT_FRAMEWORK.add(SRC_MAIN_RESOURCES);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + SRC_TEST_JAVA + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + SRC_TEST_RESOURCES + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + DOMAIN_PATH + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + DAO_PATH + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + SERVICE_PATH + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + DAO_IMPL_PATH + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + SERVICE_IMPL_PATH + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + CONTROLLER_PATH + PACKAGE_NAME);
		MAVEN_PROJECT_FRAMEWORK.add(PROJECT_PATH + POM_PATH + PACKAGE_NAME);
	}

	public void createDir() {
		for (String dir : MAVEN_PROJECT_FRAMEWORK) {
			File file = new File(dir);
			createDir(file);
		}
	}

	public void createDir(File dir) {
		if (!dir.getParentFile().exists()) {
			createDir(dir.getParentFile());
		}
		dir.mkdir();
	}

	public static void main(String[] args) throws IOException {
		PropertiesHelper.initProperties("D:/git/super-generator/src/main/resources/config.properties");
		System.out.println(PropertiesHelper.getByKey("system.project.packagename"));
		System.out.println(PropertiesHelper.getByKey("system.projectname"));
		new FileHelper().createDir();
	}

}

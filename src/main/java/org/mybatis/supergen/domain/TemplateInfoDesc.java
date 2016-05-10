package org.mybatis.supergen.domain;

/**
 * 模板描述信息
 * 
 * @author hncdyj123@163.com
 * @date 2015年11月26日 下午2:41:28
 *
 */
public class TemplateInfoDesc {
	/** 模板文件位置 **/
	private String templatePath;
	/** 模板文件名 **/
	private String templateName;
	/** 输出文件路径 **/
	private String outFilePath;
	/** 表映射信息 **/
	private PropertyClass propertyClass;
	/** 文件前缀 **/
	private String filePrefix;
	/** 文件后缀 **/
	private String fileSuffixes;

	public TemplateInfoDesc() {

	}

	public TemplateInfoDesc(String templatePath, String templateName, String outFilePath, String filePrefix, String fileSuffixes) {
		super();
		this.templatePath = templatePath;
		this.templateName = templateName;
		this.outFilePath = outFilePath;
		this.filePrefix = filePrefix;
		this.fileSuffixes = fileSuffixes;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getOutFilePath() {
		return outFilePath;
	}

	public void setOutFilePath(String outFilePath) {
		this.outFilePath = outFilePath;
	}

	public PropertyClass getPropertyClass() {
		return propertyClass;
	}

	public void setPropertyClass(PropertyClass propertyClass) {
		this.propertyClass = propertyClass;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getFileSuffixes() {
		return fileSuffixes;
	}

	public void setFileSuffixes(String fileSuffixes) {
		this.fileSuffixes = fileSuffixes;
	}

}

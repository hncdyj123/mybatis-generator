package org.mybatis.supergen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模板描述信息
 * 
 * @author hncdyj123@163.com
 * @date 2015年11月26日 下午2:41:28
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	public TemplateInfoDesc(String templatePath, String templateName, String outFilePath, String filePrefix, String fileSuffixes) {
		this.templatePath = templatePath;
		this.templateName = templateName;
		this.outFilePath = outFilePath;
		this.filePrefix = filePrefix;
		this.fileSuffixes = fileSuffixes;
	}
}

package org.mybatis.supergen.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.mybatis.supergen.constants.Constant;
import org.mybatis.supergen.db.DbColumn;
import org.mybatis.supergen.domain.Column;
import org.mybatis.supergen.domain.PropertyClass;
import org.mybatis.supergen.domain.TemplateInfoDesc;
import org.mybatis.supergen.util.DbUtil;
import org.mybatis.supergen.util.FileUtil;
import org.mybatis.supergen.util.PropertiesHelper;
import org.mybatis.supergen.util.ResManager;
import org.mybatis.supergen.util.XmlUtil;

/**
 * 
 * @Title: OverCore.java
 * @Description: 核心类
 * @Package org.app.mybatis.core
 * @author hncdyj123@163.com
 * @date 2012-7-20
 * @version V1.0
 * 
 */
public class OverCore {
	// 项目骨架构建实体类
	private MavenStruts struts = new MavenStruts();

	/**
	 * 存放模板文件目录下所有模板定义的文件名<br/>
	 * key - > 文件名 <br/>
	 * value - > 文件路径 不包含文件名 <br/>
	 */
	private static Map<String, String> templateMap = new LinkedHashMap<String, String>();

	// 外部文件模板位置
	private String outFtlFilePath = ResManager.getString("system.freemarker.filepath");

	/**
	 * 创建MAVEN项目主框架
	 * 
	 * @throws Exception
	 * @see
	 */
	public void createProject() throws Exception {
		FileUtil.deleteFolder(PropertiesHelper.getString("system.projectname"));
		struts.createDir();
		struts.createProject();
	}

	/**
	 * 获取所有的表信息
	 * 
	 * @throws Exception
	 */
	public List<PropertyClass> getAllTableInfo() throws Exception {
		// 存放所有数据库表映射实体类信息
		List<PropertyClass> propertyClassList = new ArrayList<PropertyClass>();
		List<String> xmlTableNameList = XmlUtil.getXmlTableName(); // 获取xml配置中的表名称
		DbUtil dbUtil = new DbUtil();
		for (String xmlTableName : xmlTableNameList) {
			PropertyClass propertyClass = new PropertyClass();
			List<DbColumn> dbColumnList = dbUtil.getTableColumns(StringUtils.isEmpty(ResManager.getString("system.db.schema")) ? null : ResManager.getString("system.db.schema"), xmlTableName);
			propertyClass.setTableName(xmlTableName); // 设置表名称
			propertyClass.setClassName(this.getClassName(xmlTableName)); // 设置类名称
			List<Column> columnList = new ArrayList<Column>();
			for (DbColumn dbColumn : dbColumnList) {
				Column column = new Column(dbColumn.getColumnName(), dbColumn.getDataType(), dbColumn.getRemarks(), dbColumn.getColumnSize(), dbColumn.getDecimalDigits());
				columnList.add(column);
			}
			propertyClass.setColumns(columnList);
			// 获取表的schema
			String tableschema = XmlUtil.tableMap.get(xmlTableName);
			List<String> primaryKeyList = dbUtil.getAllPrimaryKeys(StringUtils.isEmpty(tableschema) ? ResManager.getString("system.db.schema") : tableschema, xmlTableName);
			propertyClass.setPrimaryKeyList(primaryKeyList);
			if (primaryKeyList != null && primaryKeyList.size() > 0) {
				String primaryKeyName = primaryKeyList.get(0);
				for (Column column : columnList) {
					if (StringUtils.equalsIgnoreCase(column.getFieldName(), primaryKeyName)) {
						propertyClass.setPriJavaType(column.getJdkType());
					}
				}
			}
			// 设置主键类型
			propertyClass.getPriJava();
			propertyClassList.add(propertyClass);
		}
		return propertyClassList;
	}

	/**
	 * 获取数据库映射所有模板文件信息
	 * 
	 * @param PropertyClassList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<TemplateInfoDesc> getTemplateInfo(List<PropertyClass> propertyClassList) throws Exception {
		List<TemplateInfoDesc> templateInfoDescList = new ArrayList<TemplateInfoDesc>();
		// 获取模板文件位置
		templateMap = FileUtil.listFile((StringUtils.isEmpty(outFtlFilePath) ? (this.getClass().getResource("/").getPath() + "ftl") : outFtlFilePath));
		for (PropertyClass propertyClass : propertyClassList) { // 循环数据库表信息
			TemplateInfoDesc templateInfoDesc = null;
			for (Iterator iter = templateMap.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				if (StringUtils.equalsIgnoreCase(Constant.CONTROLLERENTITY_TEMPLATE_FILENAME, key)) {
					String outFilePath = struts.getTemplatePathMap().get("controllerPath");
					templateInfoDesc = new TemplateInfoDesc(value, key, outFilePath, Constant.CONTROLLER_FILE_PREFIX, Constant.JAVA_FILE_SUFFIX);
				}
				if (StringUtils.equalsIgnoreCase(Constant.SERVICEENTITY_TEMPLATE_FILENAME, key)) {
					String outFilePath = struts.getTemplatePathMap().get("servicePath");
					templateInfoDesc = new TemplateInfoDesc(value, key, outFilePath, Constant.SERVICE_FILE_PREFIX, Constant.JAVA_FILE_SUFFIX);
				}
				if (StringUtils.equalsIgnoreCase(Constant.SERVICEIMPLENTITY_TEMPLATE_FILENAME, key)) {
					String outFilePath = struts.getTemplatePathMap().get("serviceImplPath");
					templateInfoDesc = new TemplateInfoDesc(value, key, outFilePath, Constant.SERVICEIMPL_FILE_PREFIX, Constant.JAVA_FILE_SUFFIX);
				}
				if (StringUtils.equalsIgnoreCase(Constant.INNERSERVICEENTITY_TEMPLATE_FILENAME, key)) {
					String outFilePath = struts.getTemplatePathMap().get("innerServicePath");
					templateInfoDesc = new TemplateInfoDesc(value, key, outFilePath, Constant.INNERSERVICE_FILE_PREFIX, Constant.JAVA_FILE_SUFFIX);
				}
				if (StringUtils.equalsIgnoreCase(Constant.INNERSERVICEIMPLENTITY_TEMPLATE_FILENAME, key)) {
					String outFilePath = struts.getTemplatePathMap().get("innerServiceImplPath");
					templateInfoDesc = new TemplateInfoDesc(value, key, outFilePath, Constant.INNERSERVICEIMPL_FILE_PREFIX, Constant.JAVA_FILE_SUFFIX);
				}
				if (StringUtils.equalsIgnoreCase(Constant.DAOENTITY_TEMPLATE_FILENAME, key)) {
					String outFilePath = struts.getTemplatePathMap().get("daoPath");
					templateInfoDesc = new TemplateInfoDesc(value, key, outFilePath, Constant.DAO_FILE_PREFIX, Constant.JAVA_FILE_SUFFIX);
				}
				if (StringUtils.equalsIgnoreCase(Constant.JSPENTITY_TEMPLATE_FILENAME, key)) {
					String outFilePath = struts.getTemplatePathMap().get("jspPath");
					templateInfoDesc = new TemplateInfoDesc(value, key, outFilePath, "", Constant.JSP_FILE_SUFFIX);
				}
				propertyClass.setPackageName(PropertiesHelper.getString("system.project.packagename"));
				templateInfoDesc.setPropertyClass(propertyClass);
				templateInfoDescList.add(templateInfoDesc);
			}
		}
		return templateInfoDescList;
	}

	/**
	 * 获取类名称
	 * 
	 * @param tableName
	 * @return
	 */
	private String getClassName(String tableName) {
		// 分隔前缀
		String prefix = StringUtils.isEmpty(ResManager.getString("system.table.sub")) ? "_" : ResManager.getString("system.table.sub");
		String[] clazz = tableName.split(prefix);
		String className = "";
		for (int i = 0; i < clazz.length; i++) {
			if (i == 0) {
				className += clazz[0].toLowerCase();
				continue;
			}
			className += WordUtils.capitalize(clazz[i].toLowerCase());
		}
		className = WordUtils.capitalize(className);
		return className;
	}
}

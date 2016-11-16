package org.mybatis.supergen.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: PropertyClass
 * @Description: 模板映射实体类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:24:38
 *
 */
public class PropertyClass {
	// 类名
	private String className;
	// 表名
	private String tableName;
	// 包名
	private String packageName;
	// 主键java字段
	private String priJava;
	// 主键java类型
	private String priJavaType;
	// 表列
	private List<Column> columns = new ArrayList<Column>();
	// 主键List
	private List<String> primaryKeyList = new ArrayList<String>();

	public String getClassName() {
		// 处理多主键问题
		if (this.getPrimaryKeyList().size() > 1) {
			return className + "Key";
		}
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPriJava() {
		// 多主键只拿第一个主键
		for (String primaryKey : primaryKeyList) {
			for (Column column : columns) {
				if (column.getDatabaseName().equalsIgnoreCase(primaryKey)) {
					column.setColumnKey("PRI");
					priJava = column.getFieldName();
					priJavaType = column.getJdkType();
					break;
				}
			}
			break;
		}
		return priJava;
	}

	public void setPriJava(String priJava) {
		this.priJava = priJava;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<String> getPrimaryKeyList() {
		return primaryKeyList;
	}

	public void setPrimaryKeyList(List<String> primaryKeyList) {
		this.primaryKeyList = primaryKeyList;
	}

	public String getPriJavaType() {
		return priJavaType;
	}

	public void setPriJavaType(String priJavaType) {
		this.priJavaType = priJavaType;
	}

}
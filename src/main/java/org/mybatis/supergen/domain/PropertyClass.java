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
	// 主键数据库类型
	private String priType;
	// 主键java类型
	private String priJava;
	// 表列
	private List<Column> columns = new ArrayList<Column>();

	public String getClassName() {
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

	public String getPriType() {
		return priType;
	}

	public void setPriType(String priType) {
		this.priType = priType;
	}

	public String getPriJava() {
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

}

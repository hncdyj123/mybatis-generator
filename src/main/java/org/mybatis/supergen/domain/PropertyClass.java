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
	private String className;
	private String tableName;
	private String packageName;

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

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

}

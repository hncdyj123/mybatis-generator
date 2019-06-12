package org.mybatis.supergen.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

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
	@Setter
	private String className;

	// 表名
	@Getter
	@Setter
	private String tableName;

	// 包名
	@Getter
	@Setter
	private String packageName;

	// 主键java字段
	@Setter
	private String priJava;

	// 主键java类型
	@Getter
	@Setter
	private String priJavaType;

	// 模块名
	@Getter
	@Setter
	private String modelName;

	// 表列
	@Getter
	@Setter
	private List<Column> columns = new ArrayList<Column>();

	// 主键List
	@Getter
	@Setter
	private List<String> primaryKeyList = new ArrayList<String>();

	public String getClassName() {
		// 处理多主键问题
		if (this.getPrimaryKeyList().size() > 1) {
			return className + "Key";
		}
		return className;
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

}
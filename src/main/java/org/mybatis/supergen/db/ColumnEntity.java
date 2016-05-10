package org.mybatis.supergen.db;

/**
 * 
 * @ClassName: ColumnEntity
 * @Description: 映射数据库表字段实体类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:22:46
 *
 */
public class ColumnEntity {
	/** 表名称 **/
	private String tableName;
	/** 字段名 **/
	private String columnName;
	/** 数据库字段名 **/
	private String dataType;
	/** 数据库类型 **/
	private String columnComment;
	/** 数据库名称 **/
	private String dbName;
	/**是否主键(PRI为主键)**/
	private String columnKey;

	public ColumnEntity() {

	}

	public ColumnEntity(String tableName, String dbName) {
		super();
		this.tableName = tableName;
		this.dbName = dbName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

}

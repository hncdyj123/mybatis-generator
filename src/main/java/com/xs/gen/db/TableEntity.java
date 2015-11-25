package com.xs.gen.db;

/**
 * 
 * @ClassName: TableEntity
 * @Description: 映射数据库表实体类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:23:44
 *
 */
public class TableEntity {
	/** 数据库名称 **/
	private String dbName;
	/** 表名称 **/
	private String tableName;
	/** 表描述 **/
	private String tableComment;

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

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

}

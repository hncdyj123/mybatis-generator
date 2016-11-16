package org.mybatis.supergen.db;

/**
 * 数据库实体映射类
 * 
 * @author
 * @date 2016年11月15日
 */
public class DbColumn {
	private String tableCat;
	private String tableSchemaName;
	private String tableName;
	private String columnName;
	private int dataType;
	private String dataTypeName;
	private int columnSize;
	private int decimalDigits;
	private int nullAble;
	private String remarks;
	private String columnDef;
	private int sqlDataType;
	private int ordinalPosition;

	public DbColumn() {
		super();
	}

	public DbColumn(String tableCat, String tableSchemaName, String tableName, String columnName, int dataType, String dataTypeName, int columnSize, int decimalDigits, int nullAble, String remarks,
			String columnDef, int sqlDataType, int ordinalPosition) {
		super();
		this.tableCat = tableCat;
		this.tableSchemaName = tableSchemaName;
		this.tableName = tableName;
		this.columnName = columnName;
		this.dataType = dataType;
		this.dataTypeName = dataTypeName;
		this.columnSize = columnSize;
		this.decimalDigits = decimalDigits;
		this.nullAble = nullAble;
		this.remarks = remarks;
		this.columnDef = columnDef;
		this.sqlDataType = sqlDataType;
		this.ordinalPosition = ordinalPosition;
	}

	public String getTableCat() {
		return tableCat;
	}

	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}

	public String getTableSchemaName() {
		return tableSchemaName;
	}

	public void setTableSchemaName(String tableSchemaName) {
		this.tableSchemaName = tableSchemaName;
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

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public int getDecimalDigits() {
		return decimalDigits;
	}

	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	public int getNullAble() {
		return nullAble;
	}

	public void setNullAble(int nullAble) {
		this.nullAble = nullAble;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getColumnDef() {
		return columnDef;
	}

	public void setColumnDef(String columnDef) {
		this.columnDef = columnDef;
	}

	public int getSqlDataType() {
		return sqlDataType;
	}

	public void setSqlDataType(int sqlDataType) {
		this.sqlDataType = sqlDataType;
	}

	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

}

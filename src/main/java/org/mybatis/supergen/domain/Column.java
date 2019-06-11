package org.mybatis.supergen.domain;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.mybatis.supergen.util.ResManager;

/**
 * 
 * @ClassName: Column
 * @Description: 相关列配置信息
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:24:00
 * @update 2016年11月16日
 */
public class Column {
	/** SQL对应java数据类型映射 **/
	private static Map<Integer, String> typeMap = new LinkedHashMap<Integer, String>();

	static {
		typeMap.put(Types.ARRAY, Object.class.getName());
		typeMap.put(Types.BIGINT, Long.class.getName());
		typeMap.put(Types.BINARY, "byte[]");
		typeMap.put(Types.BIT, Boolean.class.getName());
		typeMap.put(Types.BLOB, "byte[]");
		typeMap.put(Types.BOOLEAN, Boolean.class.getName());
		typeMap.put(Types.CHAR, String.class.getName());
		typeMap.put(Types.CLOB, String.class.getName());
		typeMap.put(Types.DATALINK, Object.class.getName());
		typeMap.put(Types.DATE, Date.class.getName());
		typeMap.put(Types.DECIMAL, BigDecimal.class.getName());
		typeMap.put(Types.DISTINCT, Object.class.getName());
		typeMap.put(Types.DOUBLE, Double.class.getName());
		typeMap.put(Types.FLOAT, Double.class.getName());
		typeMap.put(Types.INTEGER, Integer.class.getName());
		typeMap.put(Types.JAVA_OBJECT, Object.class.getName());
		typeMap.put(Types.LONGNVARCHAR, String.class.getName());
		typeMap.put(Types.LONGVARBINARY, "byte[]");
		typeMap.put(Types.LONGVARCHAR, String.class.getName());
		typeMap.put(Types.NCHAR, String.class.getName());
		typeMap.put(Types.NCLOB, String.class.getName());
		typeMap.put(Types.NVARCHAR, String.class.getName());
		typeMap.put(Types.NULL, Object.class.getName());
		typeMap.put(Types.NUMERIC, BigDecimal.class.getName());
		typeMap.put(Types.OTHER, Object.class.getName());
		typeMap.put(Types.REAL, Float.class.getName());
		typeMap.put(Types.REF, Object.class.getName());
		typeMap.put(Types.SMALLINT, Short.class.getName());
		typeMap.put(Types.STRUCT, Object.class.getName());
		typeMap.put(Types.TIME, Date.class.getName());
		typeMap.put(Types.TIMESTAMP, Date.class.getName());
		typeMap.put(Types.TINYINT, Byte.class.getName());
		typeMap.put(Types.VARBINARY, "byte[]");
		typeMap.put(Types.VARCHAR, String.class.getName());
	}

	/** 字段名 **/
	private String fieldName;
	/** 数据库字段名 **/
	private String databaseName;
	/** 数据库类型 **/
	private int dataType;
	/** java数据类型 **/
	private String jdkType;
	/** 字段描述 **/
	private String fieldDesc;
	/** 是否主键(PRI为主键) **/
	private String columnKey;
	/** 列大小 **/
	private int columnSize;
	/** 小数长度 **/
	private int decimalDigits;

	public Column(String databaseName, int dataType, String fieldDesc, int columnSize, int decimalDigits) {
		super();
		this.databaseName = databaseName;
		this.dataType = dataType;
		this.fieldDesc = fieldDesc;
		this.columnSize = columnSize;
		this.decimalDigits = decimalDigits;
	}

	public String getFieldName() {
		// 字段分隔前缀
		String prefix = StringUtils.isEmpty(ResManager.getString("system.column.sub")) ? "_" : ResManager.getString("system.column.sub");
		String[] fields = databaseName.split(prefix);
		fieldName = "";
		for (int i = 0; i < fields.length; i++) {
			if (i == 0) {
				fieldName += fields[0].toLowerCase();
				continue;
			}
			fieldName += WordUtils.capitalize(fields[i].toLowerCase());
		}
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getJdkType() {
		String defaultJdkType = typeMap.get(dataType);
		jdkType = overrideDefaultType(this, defaultJdkType);
		return jdkType;
	}

	public void setJdkType(String jdkType) {
		this.jdkType = jdkType;
	}

	public String getFieldDesc() {
		if (fieldDesc == null) {
			fieldDesc = "";
		}
		return fieldDesc;
	}

	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
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

	/**
	 * 覆盖缺省类型
	 * 
	 * @param column
	 * @param defaultType
	 * @return
	 */
	protected String overrideDefaultType(Column column, String defaultJdkType) {
		String answer = defaultJdkType;
		switch (column.getDataType()) {
		case Types.BIT:
			answer = calculateBitReplacement(column, defaultJdkType);
			break;
		case Types.DECIMAL:
			answer = calculateBigDecimalReplacement(column, defaultJdkType);
			break;
		case Types.NUMERIC:
			break;
		}

		return answer;
	}

	protected String calculateBitReplacement(Column column, String defaultJdkType) {
		String answer = defaultJdkType;
		if (column.getColumnSize() > 1) {
			answer = "byte[]";
		} else {
			answer = defaultJdkType;
		}

		return answer;
	}

	protected String calculateBigDecimalReplacement(Column column, String defaultJdkType) {
		String answer;
		if (column.getDecimalDigits() > 0 || column.getColumnSize() > 18) {
			answer = defaultJdkType;
		} else if (column.getColumnSize() > 9) {
			answer = Long.class.getName();
		} else if (column.getColumnSize() > 4) {
			answer = Integer.class.getName();
		} else {
			answer = Short.class.getName();
		}
		return answer;
	}

}
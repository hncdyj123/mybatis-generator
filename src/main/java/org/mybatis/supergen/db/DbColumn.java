package org.mybatis.supergen.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库实体映射类
 * 
 * @author
 * @date 2016年11月15日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

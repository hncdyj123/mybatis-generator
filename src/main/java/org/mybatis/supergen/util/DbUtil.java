package org.mybatis.supergen.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.supergen.db.DbColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DbUtil.class);
	private Connection connection = null;
	private DatabaseMetaData dbMetaData = null;

	public DbUtil() {
		try {
			Map<String, String> dbconnectionMap = XmlUtil.getJdbcConnection();
			Class.forName(dbconnectionMap.get("driverClass"));
			String url = dbconnectionMap.get("connectionURL");
			String user = dbconnectionMap.get("userId");
			String password = dbconnectionMap.get("password");
			connection = DriverManager.getConnection(url, user, password);
			dbMetaData = connection.getMetaData();
		} catch (Exception ex) {
			LOGGER.error("init db connection error", ex);
		}
	}

	/**
	 * 获得表或视图中的所有列信息
	 */
	public List<DbColumn> getTableColumns(String schemaName, String tableName) {
		List<DbColumn> columnList = new ArrayList<DbColumn>();
		try {
			ResultSet rs = dbMetaData.getColumns(null, schemaName.toUpperCase(), tableName.toUpperCase(), null);
			while (rs.next()) {
				String tableCat = rs.getString("TABLE_CAT");// 表目录（可能为空）
				String tableSchemaName = rs.getString("TABLE_SCHEM");// 表的架构（可能为空）
				String tableName_ = rs.getString("TABLE_NAME");// 表名
				String columnName = rs.getString("COLUMN_NAME");// 列名
				int dataType = rs.getInt("DATA_TYPE"); // 对应的java.sql.Types类型
				String dataTypeName = rs.getString("TYPE_NAME");// java.sql.Types类型 名称
				int columnSize = rs.getInt("COLUMN_SIZE");// 列大小
				int decimalDigits = rs.getInt("DECIMAL_DIGITS");// 小数位数
				int nullAble = rs.getInt("NULLABLE");// 是否允许为null
				String remarks = rs.getString("REMARKS");// 列描述
				String columnDef = rs.getString("COLUMN_DEF");// 默认值
				int sqlDataType = rs.getInt("SQL_DATA_TYPE");// sql数据类型
				int ordinalPosition = rs.getInt("ORDINAL_POSITION"); // 表中列的索引（从1开始）
				DbColumn dbColumn = new DbColumn();
				dbColumn.setTableCat(tableCat);
				dbColumn.setTableSchemaName(tableSchemaName);
				dbColumn.setTableName(tableName_);
				dbColumn.setColumnName(columnName);
				dbColumn.setDataType(dataType);
				dbColumn.setDataTypeName(dataTypeName);
				dbColumn.setColumnSize(columnSize);
				dbColumn.setDecimalDigits(decimalDigits);
				dbColumn.setNullAble(nullAble);
				dbColumn.setRemarks(remarks);
				dbColumn.setColumnDef(columnDef);
				dbColumn.setSqlDataType(sqlDataType);
				dbColumn.setOrdinalPosition(ordinalPosition);
				columnList.add(dbColumn);
			}
		} catch (SQLException e) {
			LOGGER.error("get Columns error", e);
		}
		return columnList;
	}

	/**
	 * 获得一个表的主键信息
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 */
	public List<String> getAllPrimaryKeys(String schemaName, String tableName) {
		List<String> columnNameList = new ArrayList<String>();
		try {
			ResultSet rs = dbMetaData.getPrimaryKeys(null, schemaName.toUpperCase(), tableName.toUpperCase());
			while (rs.next()) {
				String columnName = rs.getString("COLUMN_NAME");// 列名
				// short keySeq = rs.getShort("KEY_SEQ");// 序列号(主键内值1表示第一列的主键，值2代表主键内的第二列)
				// String pkName = rs.getString("PK_NAME"); // 主键名称
				columnNameList.add(columnName);
			}
		} catch (SQLException e) {
			LOGGER.error("get getAllPrimaryKeys error", e);
		}
		return columnNameList;
	}
}

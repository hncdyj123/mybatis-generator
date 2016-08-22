package org.mybatis.supergen.db;

import java.sql.SQLException;
import java.util.List;

public interface DbMapper {
	/** 获取所有的表信息 **/
	public List<TableEntity> getAllTable(String dbName) throws SQLException;

	/** 获取表信息 **/
	public List<ColumnEntity> getTableColumns(ColumnEntity columnEntity) throws SQLException;
}

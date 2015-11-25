package ${packageName};

import java.util.List;
import java.lang.Integer;
 <#if pro?exists>
import ${packageName}.${pro.className};
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
public class ${pro.className}DaoImpl extends SqlSessionDaoSupport implements ${pro.className}Dao {
	@Override
	public void insert${pro.className}(${pro.className} ${pro.className?uncap_first}) throws SQLException{
		this.getSqlSession().insert("${pro.packageName?replace("/",".")}.${pro.className?uncap_first}.insert${pro.className}", ${pro.className?uncap_first});
	}
	
	@Override
	public void update${pro.className}(${pro.className} ${pro.className?uncap_first}) throws SQLException{
		this.getSqlSession().update("${pro.packageName?replace("/",".")}.${pro.className?uncap_first}.update${pro.className}", ${pro.className?uncap_first});
	}
	
	@Override
	public void delete${pro.className}(${pro.className} ${pro.className?uncap_first}) throws SQLException{
		this.getSqlSession().delete("${pro.packageName?replace("/",".")}.${pro.className?uncap_first}.delete${pro.className}", ${pro.className?uncap_first});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<${pro.className}> list${pro.className}(${pro.className} ${pro.className?uncap_first}) throws SQLException{
		return this.getSqlSession().selectList("${pro.packageName?replace("/",".")}.${pro.className?uncap_first}.list${pro.className}", ${pro.className?uncap_first});
	}

	@Override
	public Integer list${pro.className}Count(${pro.className} ${pro.className?uncap_first}) throws SQLException{
		return (Integer) this.getSqlSession().selectOne("${pro.packageName?replace("/",".")}.${pro.className?uncap_first}.list${pro.className}Count", ${pro.className?uncap_first});
	}

	@Override
	public ${pro.className} find${pro.className}ByID(${pro.className} ${pro.className?uncap_first}) throws SQLException{
		return (${pro.className})this.getSqlSession().selectOne("${pro.packageName?replace("/",".")}.${pro.className?uncap_first}.find${pro.className}ByID", ${pro.className?uncap_first});
	}
	
	@Override
	public ${pro.className} find${pro.className}ByCondition(${pro.className} ${pro.className?uncap_first}) throws SQLException{
		return (${pro.className})this.getSqlSession().selectOne("${pro.packageName?replace("/",".")}.${pro.className?uncap_first}.find${pro.className}ByCondition", ${pro.className?uncap_first});
	}
}
</#if>
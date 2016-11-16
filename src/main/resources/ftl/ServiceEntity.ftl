package ${packageName}.service;

import java.util.List;

import ${packageName}.domain.base.*;
import java.util.List;
import java.util.Map;
<#if pro?exists>
import ${packageName}.domain.${pro.className};

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
public interface ${pro.className}Service {
	/**新增对象 组装为空字段**/
	public int insert${pro.className}(${pro.className} ${pro.className?uncap_first});

	/**新增对象 不组装为空字段**/
	public int insert${pro.className}Selective(${pro.className} ${pro.className?uncap_first});

	/**删除对象 不组装为空字段**/
	public int delete${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first});

	<#if pro.priJavaType?exists>
	/**删除对象 根据主键删除**/
	public int delete${pro.className}ByPrimaryKey(<#if pro.priJavaType?exists>${pro.priJavaType}</#if> primaryId);
	</#if>

	/**修改对象 不组装为空字段 参数一:组装条件Object 参数二:修改Object**/
	public int update${pro.className}ByCriteriaSelective(${pro.className} ${pro.className?uncap_first}1, ${pro.className} ${pro.className?uncap_first}2);

	<#if pro.priJavaType?exists>
	/**修改对象 根据主键修改**/
	public int update${pro.className}ByPrimaryKeySelective(${pro.className} ${pro.className?uncap_first});
	</#if>
	
	/** 翻页查询 **/
	public DataGrid query${pro.className}ByPage(${pro.className} ${pro.className?uncap_first});
	
	<#if pro.priJavaType?exists>
	/**查询对象 根据主键查询**/
	public ${pro.className} select${pro.className}ByPrimaryKey(<#if pro.priJavaType?exists>${pro.priJavaType}</#if> primaryId);
	</#if>

	/**查询对象 根据对象查询**/
	public ${pro.className} select${pro.className}(${pro.className} ${pro.className?uncap_first});
	
	/**查询对象 根据对象查询**/
	public List<${pro.className}> select${pro.className}List(${pro.className} ${pro.className?uncap_first});
}
</#if>
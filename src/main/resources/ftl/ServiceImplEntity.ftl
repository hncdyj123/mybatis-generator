package ${packageName}.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
<#if pro?exists> 
import ${packageName}.domain.base.*;
import ${packageName}.domain.<#if pro.modelName?exists>${pro.modelName}.</#if>${pro.className};
import ${packageName}.inner.Inner${pro.className}Service;
import ${packageName}.service.${pro.className}Service;

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
 @Service
 @Transactional
public class ${pro.className}ServiceImpl implements ${pro.className}Service {
	@Resource
	private Inner${pro.className}Service inner${pro.className}Service;
	
	@Override
	public int insert${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.insert${pro.className}(${pro.className?uncap_first});
	}
	
	@Override
	public int insert${pro.className}Selective(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.insert${pro.className}Selective(${pro.className?uncap_first});
	}

	@Override
	public int delete${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.delete${pro.className}ByCriteria(${pro.className?uncap_first});
	}
	
	<#if pro.priJavaType?exists>
	@Override
	public int delete${pro.className}ByPrimaryKey(<#if pro.priJavaType?exists>${pro.priJavaType}</#if> primaryId) {
		return inner${pro.className}Service.delete${pro.className}ByPrimaryKey(primaryId);
	}
	</#if>

	@Override
	public int update${pro.className}ByCriteriaSelective(${pro.className} ${pro.className?uncap_first}1, ${pro.className} ${pro.className?uncap_first}2) {
		return inner${pro.className}Service.update${pro.className}ByCriteriaSelective(${pro.className?uncap_first}1,${pro.className?uncap_first}2);
	}

	@Override
	public int update${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first}1, ${pro.className} ${pro.className?uncap_first}2) {
		return inner${pro.className}Service.update${pro.className}ByCriteria(${pro.className?uncap_first}1,${pro.className?uncap_first}2);
	}
	
	<#if pro.priJavaType?exists>
	@Override
	public int update${pro.className}ByPrimaryKeySelective(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.update${pro.className}ByPrimaryKeySelective(${pro.className?uncap_first});
	}
	</#if>
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public DataGrid query${pro.className}ByPage(${pro.className} ${pro.className?uncap_first}) {
		int total = inner${pro.className}Service.count${pro.className}PageByCriteria(${pro.className?uncap_first});
		List<${pro.className}> ${pro.className?uncap_first}List = inner${pro.className}Service.select${pro.className}ListPage(${pro.className?uncap_first});
		return new DataGrid(total,${pro.className?uncap_first}List);
	}
	
	<#if pro.priJavaType?exists>
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public ${pro.className} select${pro.className}ByPrimaryKey(<#if pro.priJavaType?exists>${pro.priJavaType}</#if> primaryId) {
		return inner${pro.className}Service.select${pro.className}ByPrimaryKey(primaryId);
	}
	</#if>
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public ${pro.className} select${pro.className}(${pro.className} ${pro.className?uncap_first}){
		return inner${pro.className}Service.select${pro.className}(${pro.className?uncap_first});
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public List<${pro.className}> select${pro.className}List(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.select${pro.className}List(${pro.className?uncap_first});
	}
}
</#if>
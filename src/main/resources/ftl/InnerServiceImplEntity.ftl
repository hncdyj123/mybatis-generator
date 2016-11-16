package ${packageName}.inner.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import ${packageName}.domain.${pro.className?replace("Key","")}Criteria;
import ${packageName}.domain.${pro.className?replace("Key","")}Criteria.Criteria;

<#if pro?exists>
import ${packageName}.domain.${pro.className};
import ${packageName}.dao.${pro.className}Dao;
import ${packageName}.inner.Inner${pro.className}Service;

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
@Service
public class Inner${pro.className}ServiceImpl implements Inner${pro.className}Service {

	@Resource
	private ${pro.className}Dao ${pro.className?uncap_first}Dao;
	
	@Override
	public int insert${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.insert(${pro.className?uncap_first});
	}

	@Override
	public int insert${pro.className}Selective(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.insertSelective(${pro.className?uncap_first});
	}
	
	@Override
	public int delete${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?replace("Key","")}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		return ${pro.className?uncap_first}Dao.deleteByCriteria(criteria);
	}
	
	<#if pro.priJavaType?exists>
	@Override
	public int delete${pro.className}ByPrimaryKey(<#if pro.priJavaType?exists>${pro.priJavaType}</#if> primaryId) {
		return ${pro.className?uncap_first}Dao.deleteByPrimaryKey(primaryId);
	}
	</#if>

	@Override
	public int update${pro.className}ByCriteriaSelective(${pro.className} ${pro.className?uncap_first}1, ${pro.className} ${pro.className?uncap_first}2) {
		${pro.className?replace("Key","")}Criteria criteria = this.createCriteria(${pro.className?uncap_first}1);
		return ${pro.className?uncap_first}Dao.updateByCriteriaSelective(${pro.className?uncap_first}2,criteria);
	}
	
	<#if pro.priJavaType?exists>
	@Override
	public int update${pro.className}ByPrimaryKeySelective(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.updateByPrimaryKeySelective(${pro.className?uncap_first});
	}
	</#if>
	
	@Override
	public int count${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?replace("Key","")}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		return ${pro.className?uncap_first}Dao.countByCriteria(criteria);
	}

	<#if pro.priJavaType?exists>
	@Override
	public ${pro.className} select${pro.className}ByPrimaryKey(<#if pro.priJavaType?exists>${pro.priJavaType}</#if> primaryId) {
		return ${pro.className?uncap_first}Dao.selectByPrimaryKey(primaryId);
	}
	</#if>

	@Override
	public ${pro.className} select${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?replace("Key","")}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		if (CollectionUtils.isNotEmpty(${pro.className?uncap_first}List)) {
			return ${pro.className?uncap_first}List.get(0);
		}
		return null;
	}
	
	@Override
	public ${pro.className} select${pro.className}(Map<String,Object> paramMap) {
		${pro.className?replace("Key","")}Criteria criteria = this.createCriteria(paramMap);
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		if (CollectionUtils.isNotEmpty(${pro.className?uncap_first}List)) {
			return ${pro.className?uncap_first}List.get(0);
		}
		return null;
	}
	
	@Override
	public List<${pro.className}> select${pro.className}List(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?replace("Key","")}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		return ${pro.className?uncap_first}List;
	}
	
	@Override
	public List<${pro.className}> select${pro.className}List(Map<String,Object> paramMap) {
		${pro.className?replace("Key","")}Criteria criteria = this.createCriteria(paramMap);
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		return ${pro.className?uncap_first}List;
	}
	
	private ${pro.className?replace("Key","")}Criteria createCriteria(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?replace("Key","")}Criteria criteria = new ${pro.className?replace("Key","")}Criteria();
		Criteria c = criteria.createCriteria();
		if (${pro.className?uncap_first} != null) {
			<#list pro.columns as c>
			<#if c.jdkType == "java.lang.String">
			if (StringUtils.isNotEmpty(${pro.className?uncap_first}.get${c.fieldName?cap_first}())) {
				c.and${c.fieldName?cap_first}EqualTo(${pro.className?uncap_first}.get${c.fieldName?cap_first}());
			}
			</#if>
			<#if c.jdkType != "java.lang.String">
			if (${pro.className?uncap_first}.get${c.fieldName?cap_first}() != null) {
				c.and${c.fieldName?cap_first}EqualTo(${pro.className?uncap_first}.get${c.fieldName?cap_first}());
			}
			</#if>	
			</#list>
		}
		return criteria;
	}
	
	private ${pro.className?replace("Key","")}Criteria createCriteria(Map<String, Object> paramMap) {
		${pro.className?replace("Key","")}Criteria criteria = new ${pro.className?replace("Key","")}Criteria();
		Criteria c = criteria.createCriteria();
		if (paramMap != null) {
			<#list pro.columns as c>
			if (paramMap.get("${c.fieldName}") != null) {
				c.and${c.fieldName?cap_first}EqualTo((${c.jdkType}) paramMap.get("${c.fieldName}"));
			}
			</#list>
		}
		return criteria;
	}
}
</#if>
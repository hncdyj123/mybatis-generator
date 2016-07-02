package ${packageName}.inner.impl;

<#list importMap?keys as testKey>  
import ${testKey}
</#list>
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import ${packageName}.domain.${pro.className}Criteria;
import ${packageName}.domain.${pro.className}Criteria.Criteria;

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
		${pro.className}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		return ${pro.className?uncap_first}Dao.deleteByCriteria(criteria);
	}
	
	@Override
	public int delete${pro.className}ByPrimaryKey(int primaryId) {
		return ${pro.className?uncap_first}Dao.deleteByPrimaryKey(primaryId);
	}

	@Override
	public int update${pro.className}ByCriteriaSelective(${pro.className} ${pro.className?uncap_first}1, ${pro.className} ${pro.className?uncap_first}2) {
		${pro.className}Criteria criteria = this.createCriteria(${pro.className?uncap_first}1);
		return ${pro.className?uncap_first}Dao.updateByCriteriaSelective(${pro.className?uncap_first}2,criteria);
	}
	
	@Override
	public int update${pro.className}ByPrimaryKeySelective(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.updateByPrimaryKeySelective(${pro.className?uncap_first});
	}
	
	@Override
	public int count${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first}) {
		${pro.className}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		return ${pro.className?uncap_first}Dao.countByCriteria(criteria);
	}

	@Override
	public ${pro.className} select${pro.className}ByPrimaryKey(int primaryId) {
		return ${pro.className?uncap_first}Dao.selectByPrimaryKey(primaryId);
	}

	@Override
	public ${pro.className} select${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		if (CollectionUtils.isNotEmpty(${pro.className?uncap_first}List)) {
			return ${pro.className?uncap_first}List.get(0);
		}
		return null;
	}
	
	@Override
	public ${pro.className} select${pro.className}(Map<String,Object> paramMap) {
		${pro.className}Criteria criteria = this.createCriteria(paramMap);
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		if (CollectionUtils.isNotEmpty(${pro.className?uncap_first}List)) {
			return ${pro.className?uncap_first}List.get(0);
		}
		return null;
	}
	
	@Override
	public List<${pro.className}> select${pro.className}List(${pro.className} ${pro.className?uncap_first}) {
		${pro.className}Criteria criteria = this.createCriteria(${pro.className?uncap_first});
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		return ${pro.className?uncap_first}List;
	}
	
	@Override
	public List<${pro.className}> select${pro.className}List(Map<String,Object> paramMap) {
		${pro.className}Criteria criteria = this.createCriteria(paramMap);
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.selectByCriteria(criteria);
		return ${pro.className?uncap_first}List;
	}
	
	private ${pro.className}Criteria createCriteria(${pro.className} ${pro.className?uncap_first}) {
		${pro.className}Criteria criteria = new ${pro.className}Criteria();
		Criteria c = criteria.createCriteria();
		if (${pro.className?uncap_first} != null) {
			<#list pro.columns as c>
			if (${pro.className?uncap_first}.get${c.fieldName?cap_first}() != null) {
				c.and${c.fieldName?cap_first}EqualTo(${pro.className?uncap_first}.get${c.fieldName?cap_first}());
			}	
			</#list>
		}
		return criteria;
	}
	
	private ${pro.className}Criteria createCriteria(Map<String, Object> paramMap) {
		${pro.className}Criteria criteria = new ${pro.className}Criteria();
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
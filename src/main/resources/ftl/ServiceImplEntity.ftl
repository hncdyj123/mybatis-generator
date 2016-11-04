package ${packageName}.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
<#if pro?exists> 
import ${packageName}.domain.base.*;
import ${packageName}.domain.${pro.className};
import ${packageName}.inner.Inner${pro.className}Service;
import ${packageName}.service.${pro.className}Service;

/**
 * 妯℃澘寮曟搸鐢熸垚镄勫疄浣撶被
 * @email hncdyj123@163.com
 */
 @Service
 @Transactional
public class ${pro.className}ServiceImpl implements ${pro.className}Service {
	@Resource
	private Inner${pro.className}Service inner${pro.className}Service;
	
	@Override
	/**鏂板瀵硅薄 缁勮涓虹┖瀛楁**/
	public int insert${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.insert${pro.className}(${pro.className?uncap_first});
	}
	
	@Override
	/**鏂板瀵硅薄 涓岖粍瑁呬负绌哄瓧娈?*/
	public int insert${pro.className}Selective(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.insert${pro.className}Selective(${pro.className?uncap_first});
	}

	@Override
	/**鍒犻櫎瀵硅薄 涓岖粍瑁呬负绌哄瓧娈?*/
	public int delete${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.delete${pro.className}ByCriteria(${pro.className?uncap_first});
	}
	
	@Override
	/**鍒犻櫎瀵硅薄 镙规嵁涓婚敭鍒犻櫎**/
	public int delete${pro.className}ByPrimaryKey(<#if pro.priJava?exists>${pro.priJava}<#else>int</#if> primaryId) {
		return inner${pro.className}Service.delete${pro.className}ByPrimaryKey(primaryId);
	}

	@Override
	/**淇敼瀵硅薄 涓岖粍瑁呬负绌哄瓧娈?鍙傛暟涓€:缁勮鏉′欢Object 鍙傛暟浜?淇敼Object**/
	public int update${pro.className}ByCriteriaSelective(${pro.className} ${pro.className?uncap_first}1, ${pro.className} ${pro.className?uncap_first}2) {
		return inner${pro.className}Service.update${pro.className}ByCriteriaSelective(${pro.className?uncap_first}1,${pro.className?uncap_first}2);
	}
	
	@Override
	/**淇敼瀵硅薄 镙规嵁涓婚敭淇敼**/
	public int update${pro.className}ByPrimaryKeySelective(${pro.className} ${pro.className?uncap_first}) {
		return inner${pro.className}Service.update${pro.className}ByPrimaryKeySelective(${pro.className?uncap_first});
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public DataGrid query${pro.className}ByPage(${pro.className} ${pro.className?uncap_first}) {
		int total = inner${pro.className}Service.count${pro.className}ByCriteria(${pro.className?uncap_first});
		List<${pro.className}> ${pro.className?uncap_first}List = inner${pro.className}Service.select${pro.className}List(${pro.className?uncap_first});
		return new DataGrid(total,${pro.className?uncap_first}List);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public ${pro.className} select${pro.className}ByPrimaryKey(<#if pro.priJava?exists>${pro.priJava}<#else>int</#if> primaryId) {
		return inner${pro.className}Service.select${pro.className}ByPrimaryKey(primaryId);
	}

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
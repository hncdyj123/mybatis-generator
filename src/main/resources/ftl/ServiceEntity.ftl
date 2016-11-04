package ${packageName}.service;

import java.util.List;

import ${packageName}.domain.base.*;
import java.util.List;
import java.util.Map;
<#if pro?exists>
import ${packageName}.domain.${pro.className};

/**
 * 妯℃澘寮曟搸鐢熸垚镄勫疄浣撶被
 * @email hncdyj123@163.com
 */
public interface ${pro.className}Service {
	/**鏂板瀵硅薄 缁勮涓虹┖瀛楁**/
	public int insert${pro.className}(${pro.className} ${pro.className?uncap_first});

	/**鏂板瀵硅薄 涓岖粍瑁呬负绌哄瓧娈?*/
	public int insert${pro.className}Selective(${pro.className} ${pro.className?uncap_first});

	/**鍒犻櫎瀵硅薄 涓岖粍瑁呬负绌哄瓧娈?*/
	public int delete${pro.className}ByCriteria(${pro.className} ${pro.className?uncap_first});

	/**鍒犻櫎瀵硅薄 镙规嵁涓婚敭鍒犻櫎**/
	public int delete${pro.className}ByPrimaryKey(<#if pro.priJava?exists>${pro.priJava}<#else>int</#if> primaryId);

	/**淇敼瀵硅薄 涓岖粍瑁呬负绌哄瓧娈?鍙傛暟涓€:缁勮鏉′欢Object 鍙傛暟浜?淇敼Object**/
	public int update${pro.className}ByCriteriaSelective(${pro.className} ${pro.className?uncap_first}1, ${pro.className} ${pro.className?uncap_first}2);

	/**淇敼瀵硅薄 镙规嵁涓婚敭淇敼**/
	public int update${pro.className}ByPrimaryKeySelective(${pro.className} ${pro.className?uncap_first});
	
	/** 缈婚〉镆ヨ **/
	public DataGrid query${pro.className}ByPage(${pro.className} ${pro.className?uncap_first});
	
	/**镆ヨ瀵硅薄 镙规嵁涓婚敭镆ヨ**/
	public ${pro.className} select${pro.className}ByPrimaryKey(<#if pro.priJava?exists>${pro.priJava}<#else>int</#if> primaryId);

	/**镆ヨ瀵硅薄 镙规嵁瀵硅薄镆ヨ**/
	public ${pro.className} select${pro.className}(${pro.className} ${pro.className?uncap_first});
	
	/**镆ヨ瀵硅薄 镙规嵁瀵硅薄镆ヨ**/
	public List<${pro.className}> select${pro.className}List(${pro.className} ${pro.className?uncap_first});
}
</#if>
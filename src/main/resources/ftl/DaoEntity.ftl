package ${packageName}.dao;

<#if pro?exists>
import ${packageName}.dao.base.BaseDao;
import ${packageName}.domain.${pro.className};
import ${packageName}.domain.${pro.className}Criteria;
 
/**
 * 妯℃澘寮曟搸鐢熸垚镄勫疄浣撶被
 * @email hncdyj123@163.com
 */
public interface ${pro.className}Dao extends BaseDao<${pro.className}, ${pro.className}Criteria, <#if pro.priJava?exists><#if pro.priJava='int'>Integer<#else>String</#if><#else>Integer</#if>> {

}
</#if>

package ${packageName}.dao;

<#if pro?exists>
import ${packageName}.dao.base.BaseDao;
import ${packageName}.domain.${pro.className};
import ${packageName}.domain.${pro.className}Criteria;
 
/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
public interface ${pro.className}Dao extends BaseDao<${pro.className}, ${pro.className}Criteria, <#if pro.priJava?exists><#if pro.priJava='int'>Integer<#else>String</#if><#else>Integer</#if>> {

}
</#if>

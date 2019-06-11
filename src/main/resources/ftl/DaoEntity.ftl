package ${packageName}.dao;

<#if pro?exists>
import ${packageName}.dao.base.BaseDao;
import ${packageName}.domain.<#if pro.modelName?exists>${pro.modelName}.</#if>${pro.className};
import ${packageName}.domain.${pro.className?replace("Key","")}Criteria;
 
/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
public interface ${pro.className}Dao extends BaseDao<${pro.className}, ${pro.className?replace("Key","")}Criteria, <#if pro.priJavaType?exists>${pro.priJavaType}<#else>String</#if>> {

}
</#if>

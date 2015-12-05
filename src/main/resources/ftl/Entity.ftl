package ${packageName}.domain;

<#list importMap?keys as testKey>  
import ${testKey}
</#list>
import ${packageName}.domain.base.Page;

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
 <#if pro?exists>
public class ${pro.className} extends Page {
	<#list pro.columns as c>
	/** <#if (c.fieldDesc)??>${c.fieldDesc} </#if>**/
	private ${c.jdkType} ${c.fieldName};
	</#list>
	
	<#list pro.columns as c>
	public ${c.jdkType} get${c.fieldName?cap_first}() {
		return ${c.fieldName};
	}
	public void set${c.fieldName?cap_first}(${c.jdkType} ${c.fieldName}){
		this.${c.fieldName} = ${c.fieldName};
	}
	</#list>
}
</#if>


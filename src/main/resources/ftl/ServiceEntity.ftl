package ${packageName}.service;

import java.util.List;

import ${packageName}.domain.base.*;
 <#if pro?exists>
import ${packageName}.domain.${pro.className};

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
public interface ${pro.className}Service {
	/** 增加 **/
	public void insert${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 删除 **/
	public void delete${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 修改 **/
	public void update${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 查询所有 **/
	public List<${pro.className}> list${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 根据id获取**/
	public ${pro.className} query${pro.className}ById(${pro.className} ${pro.className?uncap_first});
	/** 根据条件获取**/
	public ${pro.className} query${pro.className}ByCondition(${pro.className} ${pro.className?uncap_first});
	/** 翻页查询 **/
	public DataGrid query${pro.className}ByPage(${pro.className} ${pro.className?uncap_first});
}
</#if>
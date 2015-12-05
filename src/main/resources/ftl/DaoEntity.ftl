package ${packageName}.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

 <#if pro?exists>
import ${packageName}.domain.${pro.className};

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
 @Repository
public interface ${pro.className}Dao {
	/** 增加 **/
	public void insert${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 删除 **/
	public void delete${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 修改 **/
	public void update${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 查询所有 **/
	public List<${pro.className}> list${pro.className}(${pro.className} ${pro.className?uncap_first});
	/** 查询记录总数 **/
	public Integer list${pro.className}Count(${pro.className} ${pro.className?uncap_first});
	/** 根据id获取**/
	public ${pro.className} query${pro.className}ById(${pro.className} ${pro.className?uncap_first});
	/** 根据条件获取**/
	public ${pro.className} query${pro.className}ByCondition(${pro.className} ${pro.className?uncap_first});
}
</#if>
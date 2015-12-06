package ${packageName}.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
<#if pro?exists> 
import ${packageName}.domain.base.*;
import ${packageName}.domain.${pro.className};
import ${packageName}.dao.${pro.className}Dao;
import ${packageName}.service.${pro.className}Service;

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
 @Service
 @Transactional
public class ${pro.className}ServiceImpl implements ${pro.className}Service {
	@Resource
	private ${pro.className}Dao ${pro.className?uncap_first}Dao;
	
	@Override
	public void insert${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?uncap_first}Dao.insert${pro.className}(${pro.className?uncap_first});
	}
	
	@Override
	public void delete${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?uncap_first}Dao.delete${pro.className}(${pro.className?uncap_first});
	}
	
	@Override
	public void update${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?uncap_first}Dao.update${pro.className}(${pro.className?uncap_first});
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public List<${pro.className}> list${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.list${pro.className}(${pro.className?uncap_first});
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public ${pro.className} query${pro.className}ById(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.query${pro.className}ById(${pro.className?uncap_first});
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public ${pro.className} query${pro.className}ByCondition(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.query${pro.className}ByCondition(${pro.className?uncap_first});
	}
	
	@Override
	public DataGrid query${pro.className}ByPage(${pro.className} ${pro.className?uncap_first}) {
		int total =  ${pro.className?uncap_first}Dao.list${pro.className}Count(${pro.className?uncap_first});
		List<${pro.className}> ${pro.className?uncap_first}List = ${pro.className?uncap_first}Dao.list${pro.className}(${pro.className?uncap_first});
		return new DataGrid(total,${pro.className?uncap_first}List);
	}
}
</#if>
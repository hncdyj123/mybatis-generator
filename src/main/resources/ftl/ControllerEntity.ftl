package ${packageName};

import java.util.List;
import java.lang.Integer;
 <#if pro?exists>
import ${packageName}.${pro.className};

/**
 * 模板引擎生成的实体类
 * @email hncdyj123@163.com
 */
public class ${pro.className}ServiceImpl implements ${pro.className}Service {
	
	private ${pro.className}Dao ${pro.className?uncap_first}Dao;
	
	@Override
	public void insert${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?uncap_first}Dao.insert${pro.className}(${pro.className?uncap_first});
	}
	
	@Override
	public void update${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?uncap_first}Dao.update${pro.className}(${pro.className?uncap_first});
	}
	
	@Override
	public void delete${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		${pro.className?uncap_first}Dao.delete${pro.className}(${pro.className?uncap_first});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<${pro.className}> list${pro.className}(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.list${pro.className}(${pro.className?uncap_first});
	}

	@Override
	public Integer list${pro.className}Count(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.list${pro.className}Count(${pro.className?uncap_first});
	}

	@Override
	public ${pro.className} find${pro.className}ByID(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.find${pro.className}ByID(${pro.className?uncap_first});
	}
	
	@Override
	public ${pro.className} find${pro.className}ByCondition(${pro.className} ${pro.className?uncap_first}) {
		return ${pro.className?uncap_first}Dao.find${pro.className}ByCondition(${pro.className?uncap_first});
	}
	
	public void set${pro.className?cap_first}Dao(${pro.className}Dao ${pro.className?uncap_first}Dao){
		this.${pro.className?uncap_first}Dao = ${pro.className?uncap_first}Dao;
	}
}
</#if>
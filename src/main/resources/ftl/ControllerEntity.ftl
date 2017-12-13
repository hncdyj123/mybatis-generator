package ${packageName}.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ${packageName}.domain.base.*;
import ${packageName}.domain.${pro.className};
import ${packageName}.service.${pro.className}Service;

@Controller
@RequestMapping("/${pro.className?uncap_first}")
public class ${pro.className}Controller {
	private static Logger LOGGER = LoggerFactory.getLogger(${pro.className}Controller.class);
	@Resource
	private ${pro.className}Service ${pro.className?uncap_first}Service;

	@RequestMapping(value = "init")
	public ModelAndView init(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		// model.setViewName("/${pro.className?uncap_first}");
		model.setViewName("/${pro.className}");
		return model;
	}

	@RequestMapping(value = "getDataGrid", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object getDataGrid(${pro.className} ${pro.className?uncap_first}) {
		DataGrid dataGrid = new DataGrid();
		try {
			dataGrid = ${pro.className?uncap_first}Service.query${pro.className}ByPage(${pro.className?uncap_first});
		} catch (Exception e) {
			LOGGER.error("getDataGrid method error : " + e);
			dataGrid.setCode(500);
			dataGrid.setMessage("getDataGrid error!");
		}
		return dataGrid;
	}

	@RequestMapping(value = "insert", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object insert(${pro.className} ${pro.className?uncap_first}) {
		Message message = new Message();
		try {
			${pro.className?uncap_first}Service.insert${pro.className}Selective(${pro.className?uncap_first});
		} catch (Exception e) {
			LOGGER.error("insert method error :", e);
			message.setCode(500);
			message.setMessage("insert error!");
		}
		return message;
	}
	
	<#if pro.priJavaType?exists>
	@RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object delete(${pro.className} ${pro.className?uncap_first}) {
		Message message = new Message();
		try {
			${pro.className?uncap_first}Service.delete${pro.className}ByPrimaryKey(<#list pro.columns as c><#if (c.columnKey)?? && c.columnKey == "PRI">${pro.className?uncap_first}.get${c.fieldName?cap_first}()<#break></#if></#list>);
		} catch (Exception e) {
			LOGGER.error("delete method error :", e);
			message.setCode(500);
			message.setMessage("delete error!");
		}
		return message;
	}
	</#if>

	<#if pro.priJavaType?exists>
	@RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object update(${pro.className} ${pro.className?uncap_first}) {
		Message message = new Message();
		try {
			${pro.className?uncap_first}Service.update${pro.className}ByPrimaryKeySelective(${pro.className?uncap_first});
		} catch (Exception e) {
			LOGGER.error("update method error :", e);
			message.setCode(500);
			message.setMessage("update error!");
		}
		return message;
	}
	</#if>

	@RequestMapping(value = "query", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object query(${pro.className} ${pro.className?uncap_first}) {
		Message message = new Message();
		try {
			message.setResult(${pro.className?uncap_first}Service.select${pro.className}List(${pro.className?uncap_first}));
		} catch (Exception e) {
			LOGGER.error("query method error :", e);
			message.setCode(500);
			message.setMessage("query error!");
		}
		return message;
	}
	
	<#if pro.priJavaType?exists>
	@RequestMapping(value = "queryById", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object queryById(${pro.className} ${pro.className?uncap_first}) {
		Message message = new Message();
		try {
			message.setResult(${pro.className?uncap_first}Service.select${pro.className}ByPrimaryKey(<#list pro.columns as c><#if (c.columnKey)?? && c.columnKey == "PRI">${pro.className?uncap_first}.get${c.fieldName?cap_first}()<#break></#if></#list>));
		} catch (Exception e) {
			LOGGER.error("queryById method error :", e);
			message.setCode(500);
			message.setMessage("queryById error!");
		}
		return message;
	}
	</#if>
	
	@RequestMapping(value = "queryByCondition", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object queryByCondition(${pro.className} ${pro.className?uncap_first}) {
		Message message = new Message();
		try {
			message.setResult(${pro.className?uncap_first}Service.select${pro.className}List(${pro.className?uncap_first}));
		} catch (Exception e) {
			LOGGER.error("queryByCondition method error :", e);
			message.setCode(500);
			message.setMessage("queryByCondition error!");
		}
		return message;
	}

}

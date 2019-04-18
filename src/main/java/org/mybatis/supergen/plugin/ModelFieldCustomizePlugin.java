package org.mybatis.supergen.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * DTO加上列描述注释
 * 
 * @author costin_law
 * 
 */
public class ModelFieldCustomizePlugin extends PluginAdapter {

	@Override
	public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType) {
		field.addJavaDocLine("//" + introspectedColumn.getRemarks());
		// System.out.println("field name = " + field.getName() + "field type =" + field.getType().getFullyQualifiedName());
		// if ("java.math.BigDecimal".equals(field.getType().getFullyQualifiedName())) {
		// field.setType(new FullyQualifiedJavaType("java.lang.double"));
		// }
		return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
	}

	/**
	 * This plugin is always valid - no properties are required
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}

	// @Override
	// public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
	// if ("LmtAccountInfo".equals(className) || "LmtItsAccountInfo".equals(className)) {
	// topLevelClass.setSuperClass(new FullyQualifiedJavaType("com.lz.cts.common.domain.base.BaseAccountInfo"));
	// }
	// return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	// }

}

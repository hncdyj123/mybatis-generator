package org.mybatis.supergen.plugin;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.supergen.util.PropertiesHelper;

/**
 * 
 * MySQL 分页生成插件。
 * 
 */
public final class MySQLPaginationPlugin extends PluginAdapter {
	private String daoPackag = PropertiesHelper.getString("system.project.packagename") + ".dao";
	private String suffixDao = "Dao";

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// add field, getter, setter for limit clause
		addLimit(topLevelClass, introspectedTable, "limitStart");
		addLimit(topLevelClass, introspectedTable, "pageSize");
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();

		// 自动生成namespace
		List<Attribute> list = parentElement.getAttributes();
		for (int i = 0; i < list.size(); i++) {
			Attribute old = list.get(i);
			if ("namespace".equals(old.getName())) {
				Attribute repace = new Attribute("namespace", old.getValue().replaceAll("mapper.", daoPackag + ".").replaceAll("Mapper", suffixDao));
				list.set(i, repace);
				break;
			}
		}

		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		// XmlElement isParameterPresenteElemen = (XmlElement)
		// element.getElements().get(element.getElements().size() - 1);

		/*
		 * XmlElement isNotNullElement = new XmlElement("isGreaterEqual");
		 * //$NON-NLS-1$ isNotNullElement.addAttribute(new Attribute("property",
		 * "limitStart")); //$NON-NLS-1$ //$NON-NLS-2$
		 * isNotNullElement.addAttribute(new Attribute("compareValue", "0"));
		 * //$NON-NLS-1$ //$NON-NLS-2$
		 */
		XmlElement isNotNullElement = new XmlElement("if");
		isNotNullElement.addAttribute(new Attribute("test", "limitStart >= 0"));

		isNotNullElement.addElement(new TextElement("limit ${limitStart},${pageSize}"));
		element.getElements().add(isNotNullElement);
		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(FullyQualifiedJavaType.getIntInstance());
		field.setName(name);
		field.setInitializationString("-1");
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);

		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);

		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	/**
	 * This plugin is always valid - no properties are required
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}
	/*
	 * public static void generate() { String config =
	 * PaginationPlugin.class.getClassLoader().getResource(
	 * "generatorConfig.xml").getFile(); String[] arg = { "-configfile", config,
	 * "-overwrite" }; ShellRunner.main(arg); } public static void main(String[]
	 * args) { generate(); }
	 */

}

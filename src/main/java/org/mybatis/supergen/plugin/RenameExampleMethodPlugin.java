package org.mybatis.supergen.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class RenameExampleMethodPlugin extends PluginAdapter {

	private String replaceString = "Criteria";

	@Override
	public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		method.setName(method.getName().replaceAll("Example", replaceString));
		return super.clientCountByExampleMethodGenerated(method, interfaze, introspectedTable);
	}

	@Override
	public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		method.setName(method.getName().replaceAll("Example", replaceString));
		return super.clientDeleteByExampleMethodGenerated(method, interfaze, introspectedTable);
	}

	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		method.setName(method.getName().replaceAll("Example", replaceString));
		return super.clientUpdateByExampleSelectiveMethodGenerated(method, interfaze, introspectedTable);
	}

	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		method.setName(method.getName().replaceAll("Example", replaceString));
		return super.clientSelectByExampleWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable);
	}

	public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		replaceIdAttribute(element);

		List<Element> list = element.getElements();
		for (int i = 0; i < list.size(); i++) {
			Element old = list.get(i);
			if (old instanceof TextElement) {
				TextElement repace = new TextElement(((TextElement) old).getContent().replace("*", "1"));
				list.set(i, repace);
				break;
			}
		}
		return super.sqlMapCountByExampleElementGenerated(element, introspectedTable);
	}

	public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		replaceIdAttribute(element);
		return super.sqlMapDeleteByExampleElementGenerated(element, introspectedTable);
	}

	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		replaceIdAttribute(element);
		return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		replaceIdAttribute(element);
		return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
	}

	public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		replaceIdAttribute(element);
		return super.sqlMapUpdateByExampleSelectiveElementGenerated(element, introspectedTable);
	}

	public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		replaceIdAttribute(element);
		return super.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable);
	}

	public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		replaceIdAttribute(element);
		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	private void replaceIdAttribute(XmlElement element) {
		List<Attribute> list = element.getAttributes();
		for (int i = 0; i < list.size(); i++) {
			Attribute old = list.get(i);
			if ("id".equals(old.getName())) {
				Attribute repace = new Attribute("id", old.getValue().replaceAll("Example", replaceString));
				list.set(i, repace);
				break;
			}
		}
	}

	public boolean validate(List<String> warnings) {
		return true;
	}

}

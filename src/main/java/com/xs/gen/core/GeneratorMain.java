package com.xs.gen.core;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xs.gen.domain.PropertyClass;
import com.xs.gen.domain.TemplateInfoDesc;
import com.xs.gen.util.ResManager;

/**
 * 程序主入口类
 * 
 * @author hncdyj123@163.com
 * @date 2015年11月26日 下午3:35:30
 *
 */
public class GeneratorMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(WriteClass.class);

	/**
	 * 主程序入口
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		LOGGER.info("-------------------开始生成文件-----------------------");
		OverCore core = new OverCore();
		// 获取数据库表所有的描述信息
		List<PropertyClass> propertyClassList = core.getAllFileInfo(ResManager.getString("system.db.name"));
		List<TemplateInfoDesc> templateInfoDescList = core.getTemplateInfo(propertyClassList);
		for (TemplateInfoDesc desc : templateInfoDescList) {

		}
		LOGGER.info("-------------------结束生成文件-----------------------");
	}
}

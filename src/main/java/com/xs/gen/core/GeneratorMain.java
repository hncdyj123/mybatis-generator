package com.xs.gen.core;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xs.gen.constants.Constant;
import com.xs.gen.domain.PropertyClass;
import com.xs.gen.util.ResManager;

/**
 * 
 * @ClassName: GeneratorMain
 * @Description: 程序主入口类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 上午11:38:23
 *
 */
public class GeneratorMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(WriteClass.class);

	/**
	 * 
	 * @Description: 主程序入口
	 * @param args
	 * @throws Exception
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) throws Exception {
		LOGGER.info("-------------------开始生成文件-----------------------");
		OverCore core = new OverCore();
		// 获取数据库表所有的描述信息
		List<PropertyClass> propertyClassList = core.getAllFileInfo(ResManager.getString("system.db.name"));
		// 生成基准文件地址
		core.createAllFolder(ResManager.getString("system.file.output"), propertyClassList);
		// 启动生成线程
		core.startThread(propertyClassList, Constant.ENTITY_TEMPLATE_FILENAME, Constant.DAOENTITY_TEMPLATE_FILENAME, Constant.DAOIMPLENTITY_TEMPLATE_FILENAME,
				Constant.SERVICEENTITY_TEMPLATE_FILENAME, Constant.SERVICEIMPLENTITY_TEMPLATE_FILENAME, Constant.XML_TEMPLATE_FILENAME);
		LOGGER.info("-------------------结束生成文件-----------------------");
	}
}

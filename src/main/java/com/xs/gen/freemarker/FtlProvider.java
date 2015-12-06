package com.xs.gen.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xs.gen.util.FileUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * @ClassName: FtlProvider
 * @Description: freemarker相关类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:25:45
 *
 */
public class FtlProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(FtlProvider.class);

	/**
	 * 
	 * @Description: 初始化freemarker引擎
	 * @param ftlName
	 *            模板文件名
	 * @param ftlPath
	 *            模板文件路径
	 * @param filePath
	 *            文件地址
	 * @param map
	 *            数据源
	 * @throws IOException
	 * @throws TemplateException
	 * @return void
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public void initFreemarker(String ftlName, String ftlPath, String filePath, Map map) throws IOException, TemplateException {
		LOGGER.info(" 模板文件路径 : " + ftlPath + " 模板文件名 : " + ftlName + " 输出文件位置  : " + filePath);
		Configuration freemarkerCfg = new Configuration();
		freemarkerCfg.setDirectoryForTemplateLoading(new File(ftlPath));
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");

		Template template = freemarkerCfg.getTemplate(ftlName);
		template.setEncoding("UTF-8");
		try {
			// 创建文件夹
			FileUtil.createFolder(filePath.substring(0, filePath.lastIndexOf(File.separator)));
		} catch (Exception e) {
			LOGGER.error("初始化FreeMarker模板错误:" + e);
		}
		// 创建新文件
		File createFile = FileUtil.createFile(filePath);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(createFile), "UTF-8"));
		template.process(map, out);
		out.flush();
		out.close();

		LOGGER.info(" 模板文件名为 - " + filePath + " 创建成功!");
	}
}

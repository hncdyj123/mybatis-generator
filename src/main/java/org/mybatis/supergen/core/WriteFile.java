package org.mybatis.supergen.core;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.supergen.constants.Constant;
import org.mybatis.supergen.domain.PropertyClass;
import org.mybatis.supergen.domain.TemplateInfoDesc;
import org.mybatis.supergen.freemarker.FtlProvider;
import org.mybatis.supergen.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: WriteClass
 * @Description: 写文件
 * @author hncdyj123@163.com
 * @date 2015年11月21日 上午11:39:30
 *
 */
public class WriteFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(WriteFile.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void run(TemplateInfoDesc desc) {
		try {
			PropertyClass pro = desc.getPropertyClass();
			Map currentMap = new HashMap();
			// currentMap.put("importMap", getImportPackage(pro));
			String fileName = ""; // 生成文件的文件名
			// innerService 自定义文件名
			if (StringUtil.equalsString(Constant.INNERSERVICE_FILE_PREFIX, desc.getFilePrefix())) {
				fileName = desc.getOutFilePath() + "Inner" + pro.getClassName() + "Service" + desc.getFileSuffixes();
			} else if (StringUtil.equalsString(Constant.INNERSERVICEIMPL_FILE_PREFIX, desc.getFilePrefix())) {
				fileName = desc.getOutFilePath() + "Inner" + pro.getClassName() + "ServiceImpl" + desc.getFileSuffixes();
			} else {
				fileName = desc.getOutFilePath() + pro.getClassName() + desc.getFilePrefix() + desc.getFileSuffixes();
			}

			// 当前文件包名
			currentMap.put("packageName", pro.getPackageName());
			currentMap.put("pro", pro);
			FtlProvider ftlProvider = new FtlProvider();
			ftlProvider.initFreemarker(desc.getTemplateName(), desc.getTemplatePath(), fileName, currentMap);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("生成文件文件异常", e);
		}
	}
}

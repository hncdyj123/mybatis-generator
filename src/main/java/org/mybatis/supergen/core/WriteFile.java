package org.mybatis.supergen.core;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mybatis.supergen.constants.Constant;
import org.mybatis.supergen.domain.Column;
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
	// 参数Map
	private FtlProvider ftlProvider = new FtlProvider();
	private TemplateInfoDesc desc;

	// java类型需要导包的类
	private static Map<String, String> importMapper = new LinkedHashMap<String, String>();
	static {
		importMapper.put("String", "java.lang.String;");
		importMapper.put("Date", "java.sql.Date;");
		importMapper.put("Timestamp", "java.sql.Timestamp;");
		importMapper.put("BigDecimal", "java.math.BigDecimal;");
		importMapper.put("Time", "java.sql.Time;");
		importMapper.put("Boolean", "java.lang.Boolean;");
		importMapper.put("Long", "java.lang.Long;");
		importMapper.put("Integer", "java.lang.Integer;");
		importMapper.put("Float", "java.lang.Float;");
		importMapper.put("Double", "java.lang.Double;");
	}

	public WriteFile() {

	}

	public WriteFile(TemplateInfoDesc templateInfoDesc) {
		this.desc = templateInfoDesc;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void run() {
		try {
			PropertyClass pro = desc.getPropertyClass();
			Map currentMap = new HashMap();
			currentMap.put("importMap", getImportPackage(pro));
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
			ftlProvider.initFreemarker(desc.getTemplateName(), desc.getTemplatePath(), fileName, currentMap);
		} catch (Exception e) {
			LOGGER.error("生成文件文件异常", e);
		}
	}

	/**
	 * 
	 * @Description: 获取当前需要导入的包
	 * @param propertyClass
	 *            当前表映射的类
	 * @return
	 * @return Map<String,String>
	 * @throws
	 */
	private Map<String, String> getImportPackage(PropertyClass propertyClass) {
		Map<String, String> importPackageMap = new HashMap<String, String>();
		for (Column column : propertyClass.getColumns()) {
			if (importMapper.containsKey(column.getJdkType())) {
				importPackageMap.put(importMapper.get(column.getJdkType()), importMapper.get(column.getJdkType()));
			}
		}
		return importPackageMap;
	}
}

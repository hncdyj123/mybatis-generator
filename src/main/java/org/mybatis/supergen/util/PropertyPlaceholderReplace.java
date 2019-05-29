package org.mybatis.supergen.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 额外文件替换
 * 
 * @author 杨杰
 * @date 2015年10月15日
 */
public class PropertyPlaceholderReplace {
	/** 日志对象 **/
	private static Logger LOGGER = LoggerFactory.getLogger(PropertyPlaceholderReplace.class);
	// this is filepath Examples /data/member/conf/
	private String filePath = "";
	// this is fileNames Example ec_mq.properties,redis.properties
	private String fileNames = "";
	// 正则表达式截取
	private String regex = "\\$\\{([\\w\\.]+)\\}";

	public PropertyPlaceholderReplace() {

	}

	public PropertyPlaceholderReplace(String fileNames) {
		this.filePath = Thread.currentThread().getContextClassLoader().getResource("").getFile() + "/prosource/";
		this.fileNames = fileNames;
		LOGGER.info("filePath = [ " + filePath + " ], fileNames = [ " + fileNames + " ]");
	}

	/**
	 * 替换文件
	 * 
	 * @throws IOException
	 */
	public void placeholderReplace() throws IOException {
		if (StringUtil.isEmpty(filePath) || StringUtil.isEmpty(fileNames)) {
			throw new RuntimeException("文件路径或文件名不能为空");
		}
		String[] fileNameAarry = fileNames.split(",");
		for (String fileName : fileNameAarry) {
			String file = filePath + fileName;
			// get file
			String fileStr = readFile(file);
			// get replace char ArrayList
			List<String> propertiesList = readline(file);
			for (String properties : propertiesList) {
				String newProKey = properties.replace("$", "").replace("{", "").replace("}", "");
				String newChar = PropertiesHelper.getString(newProKey);
				if (!StringUtil.isEmpty(newChar)) {
					fileStr = fileStr.replace(properties, newChar);
				}
				LOGGER.debug("key = [ " + properties + " ] , newchar = [" + newChar + " ]");
			}
			// 新文件路径
			String newFile = new FileHelper().getMavenProFramework().get("srcMainResources") + fileName;
			if (StringUtil.equalsString("pom.xml", fileName)) {
				newFile = new FileHelper().getMavenProFramework().get("pomPath") + fileName;
			}
			wirteFile(newFile, fileStr);
		}
	}

	/**
	 * 替换文件
	 * 
	 * @throws IOException
	 */
	public void placeholderReplace(String oldfilePath, String newfilePath) throws Exception {
		if (StringUtil.isEmpty(oldfilePath) || StringUtil.isEmpty(newfilePath)) {
			throw new RuntimeException("老文件或者新文件path为空");
		}
		Map<String, String> fileMap = FileUtil.listFile(oldfilePath);
		for (Map.Entry<String, String> entry : fileMap.entrySet()) {
			String file = entry.getValue() + File.separator + entry.getKey();
			// get file
			String fileStr = readFile(file);
			// get replace char ArrayList
			List<String> propertiesList = readline(file);
			for (String properties : propertiesList) {
				String newProKey = properties.replace("$", "").replace("{", "").replace("}", "");
				String newChar = PropertiesHelper.getString(newProKey);
				if (!StringUtil.isEmpty(newChar)) {
					fileStr = fileStr.replace(properties, newChar);
				}
				LOGGER.debug("key = [ " + properties + " ] , newchar = [" + newChar + " ]");
			}
			wirteFile(newfilePath + File.separator + entry.getKey(), fileStr);
		}
	}

	/**
	 * 读取文件字符
	 * 
	 * @param filePath 文件路径
	 * @return
	 * @throws IOException
	 */
	protected String readFile(String filePath) throws IOException {
		filePath = URLDecoder.decode(filePath, "UTF-8");
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
		String rtStr = "";
		String str = null;
		while ((str = bf.readLine()) != null) {
			rtStr += str + "\n";
		}
		bf.close();
		return rtStr;
	}

	/**
	 * 读取文件中的占位符
	 * 
	 * @param filePath 文件路径
	 * @return
	 * @throws IOException
	 */
	protected List<String> readline(String filePath) throws IOException {
		filePath = URLDecoder.decode(filePath, "UTF-8");
		List<String> propertyList = new ArrayList<String>();
		FileReader reader = new FileReader(filePath);
		BufferedReader bf = new BufferedReader(reader);
		String str = null;
		while ((str = bf.readLine()) != null) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			while (m.find()) {
				propertyList.add(m.group());
			}
		}
		return propertyList;
	}

	/**
	 * 重写配置文件
	 * 
	 * @param filePath 文件路径
	 * @param fileString 文件名称
	 */
	protected void wirteFile(String filePath, String fileString) {
		try {
			OutputStreamWriter pw = null;// 定义一个流
			pw = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
			// pw.write(new String(fileString.toString().getBytes("UTF-8")));// 将要写入文件的内容，可以多次write
			pw.write(fileString);
			pw.close();// 关闭流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}

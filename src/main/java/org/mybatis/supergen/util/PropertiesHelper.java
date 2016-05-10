package org.mybatis.supergen.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 属性文件帮助类
 * 
 * @author hncdyj123@163.com
 * @date 2015年11月25日 下午7:30:16
 *
 */
public class PropertiesHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesHelper.class);

	private static ResourceBundle EXIT_RESOURCE_BUNDLE = null;

	private static final String BUNDLE_NAME = "config";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static void initProperties(String filePath) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		EXIT_RESOURCE_BUNDLE = new PropertyResourceBundle(in);
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			LOGGER.error("不存在配置项: [ key =" + key + " ]");
			return "";
		}
	}

	public static String getByKey(String key) {
		try {
			if (EXIT_RESOURCE_BUNDLE == null) {
				return "";
			}
			return EXIT_RESOURCE_BUNDLE.getString(key);
		} catch (Exception e) {
			LOGGER.error("不存在配置项: [ key =" + key + " ]");
			return "";
		}
	}
}

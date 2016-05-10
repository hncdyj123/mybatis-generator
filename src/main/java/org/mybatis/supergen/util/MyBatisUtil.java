package org.mybatis.supergen.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @ClassName: MyBatisUtil
 * @Description: Mybatis SqlSessionFactory创建
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:34:40
 *
 */
public class MyBatisUtil {
	private final static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {

		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}

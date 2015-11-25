package com.xs.gen.constants;

import java.io.File;

/**
 * 
 * @ClassName: Constant
 * @Description: 系统常量类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 上午11:29:13
 *
 */
public class Constant {
	/** xml文件后缀 **/
	public final static String XML_FILE_SUFFIX = "Mapper.xml";
	/** java文件后缀 **/
	public final static String JAVA_FILE_SUFFIX = ".java";
	/** DAO前缀 **/
	public final static String DAO_FILE_PREFIX = "Dao";
	/** DAOIMPL前缀 **/
	public final static String DAOIMPL_FILE_PREFIX = "DaoImpl";
	/** SERVICE前缀 **/
	public final static String SERVICE_FILE_PREFIX = "Service";
	/** SERVICEIMPL前缀 **/
	public final static String SERVICEIMPL_FILE_PREFIX = "ServiceImpl";
	/** ENTITY模板文件名 **/
	public final static String ENTITY_TEMPLATE_FILENAME = "Entity.ftl";
	/** Dao模板文件名 **/
	public final static String DAOENTITY_TEMPLATE_FILENAME = "DaoEntity.ftl";
	/** DaoImpl模板文件名 **/
	public final static String DAOIMPLENTITY_TEMPLATE_FILENAME = "DaoImplEntity.ftl";
	/** Service模板文件名 **/
	public final static String SERVICEENTITY_TEMPLATE_FILENAME = "ServiceEntity.ftl";
	/** ServiceImpl模板文件名 **/
	public final static String SERVICEIMPLENTITY_TEMPLATE_FILENAME = "ServiceImplEntity.ftl";
	/** XML模板文件名 **/
	public final static String XML_TEMPLATE_FILENAME = "SqlMapper.ftl";
	/** Dao文件夹 **/
	public final static String DAO_FILE_PATH = "dao";
	/** Dao的实现文件夹 **/
	public final static String DAO_IMPL_FILE_PATH = DAO_FILE_PATH + File.separator + "impl";
	/** Service文件夹 **/
	public final static String SERVICE_FILE_PATH = "service";
	/** Service的实现文件夹 **/
	public final static String SERVICE_IMPL_FILE_PATH = SERVICE_FILE_PATH + File.separator + "impl";
	/** Entity文件夹 **/
	public final static String ENTITY_FILE_PATH = "entity";
}

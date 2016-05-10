package org.mybatis.supergen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: FileUtil
 * @Description: 文件操作帮助类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:34:19
 *
 */
public class FileUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 文件夹创建，指定路径文件的读取
	 * 
	 * @param path
	 *            要创建文件夹位置
	 * @param writeFileName
	 *            输出文件路径
	 * @param readFilePath
	 *            读入文件路径
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unused", "resource" })
	public static boolean saveFile(String path, String writeFileName, String readFilePath) throws Exception {
		// 创建文件夹
		boolean result = false;
		File dirFile = null;
		try {
			dirFile = new File(path);
			if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
				boolean creadok = dirFile.mkdirs();
				if (creadok) {
					LOGGER.info(" ok:创建文件夹成功！ ");
				} else {
					LOGGER.info(" err:创建文件夹失败！ ");
				}
			}
		} catch (Exception e) {
			LOGGER.error("创建文件发生错误！", e);
			return false;
		}

		// 字节数组
		byte[] tempbytes = new byte[100];

		int byteread = 0;
		// 读取文件流
		InputStream ins = new FileInputStream(new File(readFilePath));

		// 输出文件路径
		String tempPath = path + "\\" + writeFileName;

		// 输出文件流
		OutputStream out = new FileOutputStream(new File(tempPath));

		// 读入多个字节到字节数组中，BYTEREAD为一次读入的字节数
		while ((byteread = ins.read(tempbytes)) != -1) {
			// 将文件流写入文件
			out.write(tempbytes);
			result = true;
		}
		return result;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param path
	 *            要删除文件路径
	 * @return
	 * @throws Exception
	 */
	public static boolean delete(String path) throws Exception {
		boolean result = false;
		if (!StringUtil.isEmptyString(path)) {
			File file = new File(path);
			file.delete();
			result = true;
		}
		return result;
	}

	/**
	 * 删除文件夹
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteFolder(String path) throws Exception {
		File file = new File(path);
		boolean result = false;
		;
		try {
			String childs[] = file.list();
			if (childs == null || childs.length <= 0) {
				if (file.delete()) {
					result = true;
				}
			} else {
				for (int i = 0; i < childs.length; i++) {
					String childName = childs[i];
					String childPath = file.getPath() + File.separator + childName;
					File filePath = new File(childPath);
					if (filePath.exists() && filePath.isFile()) {
						if (filePath.delete()) {
							result = true;
						} else {
							result = false;
							break;
						}
					} else if (filePath.exists() && filePath.isDirectory()) {
						if (deleteFolder(childPath)) {
							result = true;
						} else {
							result = false;
							break;
						}
					}
				}
			}

			file.delete();
		} catch (Exception e) {
			LOGGER.info("删除文件夹失败！", e);
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * 获取文件名
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> listFile(String path) throws Exception {
		// 存放文件信息 key->文件名 value ->文件绝对地址(不包含文件名)
		Map<String, String> map = new HashMap<String, String>();
		File file = new File(path);
		// 获取文件夹中的文件
		File[] array = file.listFiles();
		if (array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].isFile()) {
					// 获取文件名
					String filePath = array[i].getPath();
					map.put(array[i].getName(), filePath.substring(0, filePath.lastIndexOf("\\")));
				} else if (array[i].isDirectory()) {
					LOGGER.error("模板文件夹未发现!");
				}
			}
		}
		return map;
	}

	/**
	 * 创建文件
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public synchronized static File createFile(String filePath) throws IOException {
		File f = new File(filePath);
		if (f.exists()) {
			f.delete();
		}
		f.createNewFile();
		return f;
	}

	public static void createFolder(String path) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static void copyFolder(File src, File dest) throws IOException {
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdirs();
			}
			String files[] = src.list();
			for (String file : files) {
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// 递归复制
				copyFolder(srcFile, destFile);
			}
		} else {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		}
	}

	/**
	 * 拷贝文件
	 * 
	 * @param oldfile
	 * @param newPath
	 */
	public static void CopyFile(File oldfile, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			// File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldfile);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

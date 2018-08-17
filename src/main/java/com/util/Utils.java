package com.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Utils {
	public static Object getBean(String key){
		return getBean(key, "/config.properties");
	}
	public static Object getBean(String key,String path){
		if(key == null || path == null){
			return null;
		}
		Object obj = null;
		try {
			String className = readProperties(path,key);
			Class<?> clazz = Class.forName(className);
			 obj = clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
		
	}
	/**
	 * 从 /config.properties 中读取 key的值
	 * @param key
	 * @return
	 */
	public static String readProperties(String key){
		return readProperties("/config.properties",key);
	}
	/**
	 * 从path指定的properties文件中读取key对应的值
	 * @param path
	 * @param key
	 * @return
	 */
	public static String readProperties(String path,String key){
		Properties pro = loadProperties(path == null || "".equals(path) ? "/config.properties" : path);
		return pro.getProperty(key);
	}
	/**
	 * properties转换为Map
	 * @param path
	 * @return
	 */
	public static Map<String,String> loadPropertiesToMap(String path){
		Map<String,String> reMap = new HashMap<>();
		Properties pro = loadProperties(path);
		Set<Entry<Object, Object>> set = pro.entrySet();
		Iterator<Map.Entry<Object, Object>> it = set.iterator(); 
		while(it.hasNext()){
			Entry<Object, Object> entry = it.next();
			String key = String.valueOf(entry.getKey());
			String value = String.valueOf(entry.getValue());
			reMap.put(key, value);
		}
		return reMap;
	}
	/**
	 * 加载properties
	 * @param path
	 * @return
	 */
	public static Properties loadProperties(String path){
		Properties pro = new Properties();
		try {
			InputStreamReader inr = new InputStreamReader(Utils.class.getResourceAsStream(path),"UTF-8");
			pro.load(inr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
}

package com.sky.blue.comm.json;


import java.lang.reflect.Field;
//import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sky.blue.business.beans.AjaxResponse;

/**
 * Json 操作 ***********************************
 * 
 * @author sandy
 * @project operating_cyb
 * @create_date 2013年8月23日 下午2:24:15 ***********************************
 */
public class JsonUtil {
	public static final String DATE_FOMART_FULL = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 最简单的转换为Json String 的方法 （如果你不需要日期转换什么的，就用这个把）
	 * ***********************************
	 * 
	 * @author sandy
	 * @create_date 2013年8月23日下午2:40:14
	 * @param t
	 * @return ***********************************
	 */
	public static <T> String tojson(T t) {
		//return new Gson().toJson(t);
		return new Gson().toJsonTree(t).toString();
	}

	/**
	 * 最简单的转换为 javabean 的方法 （如果你不需要日期转换什么的，就用这个把）
	 * ***********************************
	 * 
	 * @author sandy
	 * @create_date 2013年8月23日下午2:40:14
	 * @param t
	 * @return ***********************************
	 */
	public static <T> T toBean(String json, Class<T> clazz) {
		T t = new Gson().fromJson(json, clazz);
		return t;
	}

	/**
	 * 转换为Json字符串 ***********************************
	 * 
	 * @author sandy
	 * @create_date 2013年8月23日下午2:34:17
	 * @param bean
	 * @param type
	 * @return ***********************************
	 */
	public static String bean2json(Object bean) {
		Gson gson = new GsonBuilder().setDateFormat(DATE_FOMART_FULL).serializeNulls().create();
		return gson.toJson(bean);
	}

	/**
	 * 转换json字符串
	 * 
	 * @Title: bean2json
	 * @Description: 转换json字符串
	 * @author: 肖武胜
	 * @param bean
	 * @param fieldAliasMap
	 *            属性要替换的别名，bean中的字段名和返回出去的结果不一直可用别名
	 * @param excludeFieldSet
	 *            要过滤的属性字段，为空不过滤字段转换所有字段为json
	 * @param clazzSet
	 *            此类的字段不过滤,为空所有类多过滤
	 * @return
	 * @return String
	 * @throws
	 */
	public static String bean2json(final Object bean, final Map<String, String> fieldAliasMap, final Set<String> excludeFieldSet, final Set<Class<?>> clazzSet) {
		return new GsonBuilder().setFieldNamingStrategy(new FieldNamingStrategy() {

			@Override
			public String translateName(Field f) {
				if (fieldAliasMap != null)
					return fieldAliasMap.containsKey(f.getName()) ? fieldAliasMap.get(f.getName()) : f.getName();
				return f.getName();
			}
		}).setExclusionStrategies(new ExclusionStrategy() {

			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				if (excludeFieldSet != null)
					return excludeFieldSet.contains(f.getName());

				return false;
			}

			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				if (clazzSet != null)
					return clazzSet.contains(clazz);

				return false;
			}
		}).setDateFormat(DATE_FOMART_FULL).serializeNulls().create().toJson(bean);
	}

	/**
	 * 转换为对象 ***********************************
	 * 
	 * @author sandy
	 * @create_date 2013年8月23日下午2:34:35
	 * @param json
	 * @param type
	 * @return ***********************************
	 */
	/*public static <T> T json2bean(String json, Type type) {
		Gson gson = new GsonBuilder().setDateFormat(DATE_FOMART_FULL).create();
		return gson.fromJson(json, type);
	}*/

	/**
	 * 转换为对象 ***********************************
	 * 
	 * @author sandy
	 * @create_date 2013年8月23日下午2:34:35
	 * @param json
	 * @param type
	 * @return ***********************************
	 */
	public static <T> T json2bean(String json, Class<T> clazz) {
		Gson gson = new GsonBuilder().setDateFormat(DATE_FOMART_FULL).create();
		return gson.fromJson(json, clazz);
	}

	public static void main(String[] args) {
		AjaxResponse<Date> res = new AjaxResponse<Date>();
		res.setMsg("test is ok");
		res.setResult(new Date());
		System.out.println(bean2json(res));
	}

}

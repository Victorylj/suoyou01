package com.sky.blue.comm.page;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**

 */
public class ObjectUtils {
	static final  Pattern Number_PATTERN = Pattern.compile("([0-9]+\\.?[0-9]+|[0-9]+)");
	static final  Pattern INT_PATTERN = Pattern.compile("[0-9]+");
	static final  Pattern VALIDATE_GPS_X = Pattern.compile("([7-9]\\d|1[0-3]\\d|140)\\.\\d{1,6}");// 符合车友规范的gps x
	static final  Pattern VALIDATE_GPS_Y = Pattern.compile("[1-6]\\d\\.\\d{1,6}");//符合车友规范的gps y
	public static boolean isNullOrEmptyString(Object o) {
		if(o == null)
			return true;
		if(o instanceof String) {
			String str = (String)o;
			if(str.length() == 0)
				return true;
		}
		return false;
	}
	
	/**
	 * 可以用于判断 Map,Collection,String,Array是否为空
	 * @param o
	 * @return
	 */
	@SuppressWarnings("all")
    public static <T> boolean isEmpty(T t)  {
        if(t == null) return true;

        if(t instanceof String) {
            if(((String)t).length() == 0){
                return true;
            }
        } else if(t instanceof Collection) {
            if(((Collection)t).isEmpty()){
                return true;
            }
        } else if(t.getClass().isArray()) {
            if(Array.getLength(t) == 0){
                return true;
            }
        } else if(t instanceof Map) {
            if(((Map)t).isEmpty()){
                return true;
            }
        }else {
            return false;
        }

        return false;
    }

	/**
	 * 可以用于判断 Map,Collection,String,Array是否不为空
	 * @param c
	 * @return
	 */
	public static boolean isNotEmpty(Object c) throws IllegalArgumentException{
		return !isEmpty(c);
	}
	/**判断是否是数字型
	 * @param c
	 * @return
	 */
	public static boolean isNumber(String str) throws IllegalArgumentException{
		return Number_PATTERN.matcher(str).matches();
	}
	/**
	 * 判断是否是int数据
	 * @param c
	 * @return
	 */
	public static boolean isInteger(String str) throws IllegalArgumentException{
		return INT_PATTERN.matcher(str).matches();
	}
	/**
	 * 判断是否是车友规范的纬度
	 * @param str
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static boolean isValidateLat(String str) throws IllegalArgumentException{
		return VALIDATE_GPS_Y.matcher(str).matches();
	}
	/**
	 * 判断是否是车友规范的经度
	 * @param str
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static boolean isValidateLng(String str) throws IllegalArgumentException{
		return VALIDATE_GPS_X.matcher(str).matches();
	}
	public static void main(String[] args) {
		System.out.println(isValidateLat("69.333")+"  "+isValidateLng("69.333"));
	}
	
	/**
	 * 获取远程客户端IP
	 */
	public static String getIpAddr(HttpServletRequest request) throws Exception {
	    String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip;
	}
}

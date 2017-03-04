package com.sky.blue.comm;

/**
 * 
 */

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sky.blue.business.beans.AjaxResponse;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.comm.json.JsonUtil;



/**
 * ***********************************
 * 
 * @author sandy
 * @project operating_cyb
 * @create_date 2013年8月22日 下午3:02:50 ***********************************
 */
@Controller
public class BaseController  {

	protected Log logger = LogFactory.getLog(this.getClass());

	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * 获取保存在Session中的用户对象
	 * 
	 * @param request
	 * @return
	 */
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}
   
	/**
	 * 保存用户对象到Session中
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(HttpServletRequest request,User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
				user);
	}
	

	/**
	 * 获取基于应用程序的url绝对路径
	 * 
	 * @param request
	 * @param url
	 *            以"/"打头的URL地址
	 * @return 基于应用程序的url绝对路径
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}
	

	/**
	 * 获取request中参数值，如果request中有参数key就返回，如果没有参数key就返回null
	 * 
	 * @Title: getRequestParamValue
	 * @Description: 获取request中参数值，如果request中有参数key就返回，如果没有参数key就返回null
	 * @author: 肖武胜
	 * @param request
	 * @param paramKey
	 * @return
	 */
	protected String getRequestParamValue(HttpServletRequest request,
			String paramKey) {
		if (request != null && request.getParameterMap() != null) {
			if (request.getParameterMap().containsKey(paramKey)) {
				String[] paramValues = (String[]) request.getParameterMap()
						.get(paramKey);
				if (paramValues != null && paramValues.length > 0) {
					return paramValues[0];
				}
				return "";
			}
		}
		return null;
	}

	/**
	 * ajax 返回success ***********************************
	 * 
	 * @author sandy
	 * @param <E>
	 * @create_date 2013年8月22日下午3:06:26
	 * @param response
	 * @param t
	 * @throws IOException
	 *             ***********************************
	 */
	protected <T> void ajaxResponse(HttpServletResponse response, T t) {
		try {
			response.reset();
			response.setContentType("application/json;charset=UTF-8");

			String jsonStr = getJson(true, t);
			if (logger.isDebugEnabled()) {
				logger.debug("JSON【" + jsonStr + "】");
			}

			response.getWriter().write(jsonStr);

			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取验证错误
	 * 
	 * @Title: validError
	 * @Description: 获取验证错误
	 * @author: 肖武胜
	 * @param binding
	 * @param errors
	 * @return
	 */
	protected String validError(BindingResult binding, String... errors) {
		if (binding == null || errors == null || errors.length == 0) {
			return null;
		}
		for (String err : errors) {
			if (binding.hasFieldErrors(err))
				return binding.getFieldError(err).getDefaultMessage();
		}
		return null;
	}

	protected <T> void ajaxResponse(HttpServletRequest request,
			HttpServletResponse response, T t) {
		ajaxResponse(request, response, t, null, null, null);
	}

	/**
	 * 转换json格式
	 * 
	 * @Title: ajaxResponse
	 * @Description: 转换json格式
	 * @author: 肖武胜
	 * @param request
	 * @param response
	 * @param t
	 * @param fieldAliasMap
	 *            属性别名Map
	 * @param excludeFieldSet
	 *            排除属性Set
	 * @param clazzSet
	 *            不排除属性类Set
	 * @return void
	 * @throws
	 */
	protected <T> void ajaxResponse(HttpServletRequest request,
			HttpServletResponse response, T t,
			Map<String, String> fieldAliasMap, Set<String> excludeFieldSet,
			Set<Class<?>> clazzSet) {
		try {
			// 打印日志
			logger.info("远程服务器【" + request.getRemoteHost() + ":"
					+ request.getRemotePort() + "】访问资源【"
					+ request.getRequestURI() + "】请求参数：【");
			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				logger.info(paramName + "=" + request.getParameter(paramName));
			}
			logger.info("】");

			String jsonStr = JsonUtil.bean2json(t, fieldAliasMap,
					excludeFieldSet, clazzSet);
			logger.info("车云宝运营平台对外接口响应JSON【" + jsonStr + "】");

			response.reset();
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(jsonStr);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("车云宝运营平台对外接口响应数据异常：", e);
		}
	}

	/** 设置响应头 */
	public void setResponseHeader(HttpServletResponse response,
			String fileName, String type) {
		try {
			response.setContentType("application/octet-stream;");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("GBK"), "ISO-8859-1")
					+ type);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			logger.error("设置响应头出错：", e);
		}
	}

	/** 设置响应头 */
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			response.setContentType("application/octet-stream;");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			logger.error("设置响应头出错：", e);
		}
	}

	/**
	 * ajax 返回success ***********************************
	 * 
	 * @author sandy
	 * @param <E>
	 * @create_date 2013年8月22日下午3:06:26
	 * @param response
	 * @param t
	 * @throws IOException
	 *             ***********************************
	 */
	protected <T extends AjaxResponse<E>, E> void ajaxSuccess(
			HttpServletResponse response, T t) {
		this.ajaxSuccess(response, t, false);
	}

	/**
	 * ajax 返回success ***********************************
	 * 
	 * @author sandy
	 * @param <E>
	 * @create_date 2013年8月22日下午3:06:26
	 * @param response
	 * @param t
	 * @throws IOException
	 *             ***********************************
	 */
	protected <T extends AjaxResponse<E>, E> void ajaxSuccess(
			HttpServletResponse response, T t, boolean format) {
		t.setErrorCode(AjaxResponseStatus.SUCCESS.getStatus());
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(getJson(format, t));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ajax 返回success ***********************************
	 * 
	 * @author sandy
	 * @param <E>
	 * @create_date 2013年8月22日下午3:06:26
	 * @param response
	 * @param t
	 * @throws IOException
	 *             ***********************************
	 */
	protected void ajaxSuccess(HttpServletResponse response, String msg) {
		AjaxResponse<String> t = new AjaxResponse<String>();
		t.setMsg(msg);
		t.setErrorCode(AjaxResponseStatus.SUCCESS.getStatus());
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(JsonUtil.bean2json(t));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: ajaxFail
	 * @Description: 返回失败
	 * @author: 杨培弘
	 * @param response
	 * @param msg
	 */
	protected void ajaxFail(HttpServletResponse response, String msg) {
		AjaxResponse<String> t = new AjaxResponse<String>();
		t.setMsg(msg);
		t.setErrorCode(AjaxResponseStatus.FAIL.getStatus());
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(JsonUtil.bean2json(t));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ajax 返回失败 ***********************************
	 * 
	 * @author sandy
	 * @create_date 2013年8月22日下午3:21:12
	 * @param response
	 * @param t
	 * @throws IOException
	 *             ***********************************
	 */
	protected <T extends AjaxResponse<E>, E> void ajaxFail(
			HttpServletResponse response, T t, boolean format) {
		t.setErrorCode(AjaxResponseStatus.FAIL.getStatus());
		try {
			response.getWriter().write(getJson(format, t));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ajax 返回失败 ***********************************
	 * 
	 * @author sandy
	 * @create_date 2013年8月22日下午3:21:12
	 * @param response
	 * @param t
	 * @throws IOException
	 *             ***********************************
	 */
	protected <T extends AjaxResponse<E>, E> void ajaxFail(
			HttpServletResponse response, T t) {
		t.setErrorCode(AjaxResponseStatus.FAIL.getStatus());
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(getJson(false, t));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected <T extends AjaxResponse<E>, E> void ajaxFail(
			HttpServletResponse response, T t, Integer status) {
		t.setErrorCode(status);
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(getJson(false, t));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private <T> String getJson(boolean format, T t) {
		String res = null;
		if (format) {
			res = JsonUtil.bean2json(t);
		} else {
			res = JsonUtil.tojson(t);
		}
		return res;
	}

	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		// System.out.println(request);
		return request;
	}

	// 获取Response
	/*
	 * public static HttpServletResponse getResponse() { return
	 * ((ServletWebRequest)
	 * RequestContextHolder.getRequestAttributes()).getResponse(); }
	 */

	// 获取Session
	protected Object getSession(String name) {
		//return session.getAttribute(getRequest(), name);
		return getRequest().getSession().getAttribute(name);
	}

	// 设置Session
	protected void setSession(String name, Serializable value) {
		//session.setAttribute(getRequest(), response, name, value);
		 getRequest().getSession().setAttribute(name, value);
	}

	// 移除Session
	protected void removeSession(String name) {
		//session.removeAttribute(getRequest(), response, name);
		getRequest().getSession().removeAttribute(name);
	}
	protected String arrayToString(String arr[]){
		StringBuffer sb = new StringBuffer();
		if(arr!=null){
			for(int i=0;i<arr.length;i++){
				if(i<arr.length-1){
				sb.append(arr[i]).append(",");
				}else{
					sb.append(arr[i]);
				}
			}
		
		}
		return sb.toString();
	}
}
package com.sky.blue.business.logon;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.sky.blue.business.logon.entity.User;

import static com.sky.blue.comm.CommonConstant.*;
public class ForumFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";

	// ① 不需要登录即可访问的URI资源
	private static final String[] INHERENT_ESCAPE_URIS = { "/index.jsp",
			"/index.html", "/login.jsp", "/doLogin.do","/doLogout.do","/updateChannelName.do",
			"/register.jsp", "/register.do", "/board/listBoardTopics-",
			"/board/listTopicPosts-","/main.jsp" };

	// ② 执行过滤
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println(request+"  ===   "+ request.getAttribute(FILTERED_REQUEST));
		// ②-1 保证该过滤器在一次请求中只被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
	
		} else {

			// ②-2 设置过滤标识，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);

			User userContext = getSessionUser(httpRequest);

			// ②-3 用户未登录, 且当前URI资源需要登录才能访问
			if (userContext == null
					&& !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}
				// ②-4将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
				httpRequest.getSession().setAttribute(LOGIN_TO_URL, toUrl);

				// ②-5转发到登录页面
			
				//request.getRequestDispatcher("/login.jsp").forward(request,response);
				response.getWriter().print("<script>window.parent.parent.location.href='login.jsp';</script>");
				return;
			}
			/*String[] allowPaths= (String[])httpRequest.getSession().getAttribute("allowPaths");
			if(allowPaths!=null){
				System.out.println("requestURI:"+httpRequest.getRequestURI());
				if(!isURILogin(httpRequest.getRequestURI(),httpRequest)&&!isAllowedURI(httpRequest.getRequestURI(),allowPaths)){
			
					response.getWriter().print("<script>window.parent.location.href='login.jsp';</script>");
					return;
				}
			}*/
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	private boolean isAllowedURI(String requestURI,String[] paths){
		if(requestURI.indexOf(".do")>0){
			if(paths!=null&&requestURI!=null){
				for(String path:paths){
					if(requestURI.indexOf(path)>0){
						
						return true;
					}
				}
			}
		}else{
			return true;
		}
		return false;
	}
	
   /**
    * 当前URI资源是否需要登录才能访问
    * @param requestURI
    * @param request
    * @return
    */
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null ) {
				if( requestURI.indexOf(uri) >= 0)
				return true;
			}
		}
		return false;
	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(USER_CONTEXT);
	}

	@Override
	public void destroy() {

	}
}

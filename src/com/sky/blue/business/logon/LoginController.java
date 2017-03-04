package com.sky.blue.business.logon;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sky.blue.business.logon.comm.ToolUtil;
import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.logon.service.IModuleService;
import com.sky.blue.business.logon.service.IUserService;
import com.sky.blue.comm.BaseController;
import com.sky.blue.comm.CommonConstant;
import com.sky.blue.comm.page.ObjectUtils;

/**
 * 
 * 
 * </pre>
 * 
 * @see
 * @since
 */
@Controller
public class LoginController extends BaseController {
	/**
	 * 自动注入
	 */
	@Resource(name = "userServiceImpl")
	private IUserService userService;
	@Resource(name = "moduleServiceImpl")
	private IModuleService moduleService;

	/**
	 * 用户登陆
	 * 
	 * @param request
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, User user) {
		System.out.println(user.toString());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if (user != null) {
			user.setPassword(ToolUtil.getMD5(user.getPassword()));
		}
		User dbUser;
		try {
			dbUser = userService.getUser(user);
			System.out.println(dbUser.getPassword() + "===" + user.getPassword());
			if (dbUser == null) {
				mav.addObject("errorMsg", "用户名不存在");
			} else if (!dbUser.getPassword().equals(user.getPassword())) {
				mav.addObject("errorMsg", "用户密码不正确");
			} else if (dbUser.getLocked() == User.USER_LOCK) {
				mav.addObject("errorMsg", "用户已经被锁定，不能登录。");
			} else {
				dbUser.setLastIp(request.getRemoteAddr());
				dbUser.setLastVisit(new Date());
				// userService.loginSuccess(dbUser);
				setSessionUser(request, dbUser);
				String toUrl = (String) request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
				request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
				// 如果当前会话中没有保存登录之前的请求URL，则直接跳转到主页
				System.out.println("toUrl-----------:" + toUrl);
				if (StringUtils.isEmpty(toUrl)) {
					toUrl = "/main.jsp";
				}
				List<Module> mList = moduleService.getUserModuleList(dbUser);
				/*
				 * Collections.sort(mList, new Comparator<Module>() { public int
				 * compare(Module arg0, Module arg1) { int c =
				 * arg0.getP_id().compareTo(arg1.getP_id());
				 * 
				 * if(c==0){
				 * c=arg0.getDisplay_order().compareTo(arg1.getDisplay_order
				 * ()); }
				 * 
				 * return c; } });
				 */

				String menu = madeMenu(mList);
				String[] allowPaths = getAllowedUrl(mList);
				request.getSession().setAttribute("curUser", dbUser);
				request.getSession().setAttribute("allowPaths", allowPaths);
				request.getSession().setAttribute("leftMenu", menu);
				mav.setViewName("redirect:" + toUrl);

			}
			mav.setViewName("redirect:/main.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	class Sort implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
			Module t1 = (Module) o1;
			Module t2 = (Module) o2;
			if (t1.getP_id() > t2.getP_id()) {
				return 1;
			} else if (t1.getP_id() == t2.getP_id()) {
				if (t1.getDisplay_order() > t2.getDisplay_order()) {
					return 1;
				} else if (t1.getDisplay_order() == t2.getDisplay_order()) {
					return 0;
				} else if (t1.getDisplay_order() < t2.getDisplay_order()) {
					return -1;
				}
			} else if (t1.getP_id() < t2.getP_id()) {
				return -1;
			}
			return 0;
		}
	}

	/**
	 * 登录注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogout")
	public String logout(HttpSession session, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("curUser");

		try {
			user.setLastIp(ObjectUtils.getIpAddr(request));
			user.setLastVisit(new Date());
			userService.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		session.invalidate();
		return "redirect:/main.jsp";
	}

	public String[] getAllowedUrl(List<Module> mList) {
		StringBuffer sbuf = new StringBuffer();
		if (mList != null) {
			for (Module module : mList) {
				if (module.getModule_path() != null && !"".endsWith(module.getModule_path())) {
					sbuf.append(module.getModule_path());
				}
			}
		}
		String paths[] = null;
		String pathstr = sbuf.toString();
		System.out.println("allowPATHS----:" + pathstr);
		if (!"".equals(pathstr)) {
			pathstr = pathstr.replaceAll("；", ";");
			paths = pathstr.split(";");
		}
		return paths;
	}

	public String madeMenu(List<Module> mList) {
		StringBuffer sbuf = new StringBuffer();
		Module main = new Module();
		HashMap<Module, ArrayList<Module>> secondMenu = new HashMap<Module, ArrayList<Module>>();

		if (mList != null) {
			for (Module module : mList) {
				if (module.getIs_leaf() == 1) {
					main = module;
				}
				if (module.getIs_leaf() == 2) {
					secondMenu.put(module, new ArrayList<Module>());
					for (Module mod : mList) {
						if (module.getModule_id() == mod.getParent_id())
							secondMenu.get(module).add(mod);
					}
				}

			}
		}
		sbuf.append("<div class=\"lefttop\">");
		if (main.getModule_name() != null) {
			sbuf.append(main.getModule_name());
		}
		sbuf.append("</div>");
		sbuf.append("<dl class=\"leftmenu\"> ");

		List<Module> mainList = new ArrayList<Module>();

		Set<Module> subMenus = secondMenu.keySet();
		Iterator<Module> it = subMenus.iterator();
		while (it.hasNext()) {
			Module subModule = it.next();
			mainList.add(subModule);
		}

		Collections.sort(mainList, new Sort());

		for (Module msub : mainList) {
			Module subModule = msub;
			sbuf.append("<dd><div class=\"title\">");
			sbuf.append(subModule.getModule_name());
			sbuf.append("</div>");
			List<Module> subList = secondMenu.get(subModule);
			if (subList.size() > 0) {
				Collections.sort(subList, new Sort());
				sbuf.append("<ul class=\"menuson\">");
				for (Module m : secondMenu.get(subModule)) {
					sbuf.append("<li><span style='width:10px;'></span><a href=\"javaScript:gotourl('");
					sbuf.append(m.getModule_url());
					sbuf.append("')\"target=\"rightFrame\">");
					sbuf.append(m.getModule_name());
					sbuf.append("</a><i></i></li>");
				}
				sbuf.append(" </ul> ");
			}
		}

		/*
		 * while (it.hasNext()) { Module subModule = it.next(); sbuf.append(
		 * "<dd><div class=\"title\"><span><img src=\"images/leftico01.png\" /></span>"
		 * ); sbuf.append(subModule.getModule_name()); sbuf.append("</div>"); if
		 * (secondMenu.get(subModule).size() > 0) { sbuf.append(
		 * "<ul class=\"menuson\">"); for (Module m : secondMenu.get(subModule))
		 * { sbuf.append("<li><cite></cite><a href=\"");
		 * sbuf.append(m.getModule_url());
		 * sbuf.append("\"target=\"rightFrame\">");
		 * sbuf.append(m.getModule_name()); sbuf.append("</a><i></i></li>"); }
		 * sbuf.append(" </ul> "); } }
		 */
		sbuf.append(" </dl>");

		return sbuf.toString();
	}

}

package com.ulysses.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.util.UtilDate;

/**
 * 登录过滤器
 * @author Administrator
 *
 */
@Service
public class LoginFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);
	private static final String LOGOUT = "logout";
	private static final String ACTION_TYPE = "actionType";

	private static final String RESULT_NOT_LOGIN = "{\"codeType\":\"218\",\"success\":true }";  //请登录
	private static final String RESULT_CLEAR_LOGIN = "{\"codeType\":\"260\",\"success\":true }";//已注销
	
	
	
	private static final String filterArr[] = { ".css", ".js", ".html", ".jpg",
			".JPG", ".png", ".PNG", "/homeController/info",
			"/fsbaUserController/isLogin",
			"/fsbaUserController/regeditUser",
			"/temp/temp.html" };
	
	public void destroy() {
		log.warn(" login filter destroy ");
	}

	/**
	 * 如果  return;   直接return 不会继续运行Controller
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
            throw new ServletException("OncePerRequestFilter just supports HTTP requests");
        }
		
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(true);

        StringBuffer url = httpRequest.getRequestURL();
        
        //System.out.println(UtilDate.getNow() + " : "+url );
        
        /*
        String[] strs = ProsReader.getString("INDICATION_APP_NAME").split("\\|");
        if (strs != null && strs.length > 0) {
            for (String str : strs) {
                if (url.indexOf(str) >= 0) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
        }
        */
        
        
        Object object = session.getAttribute(session.getId());
        TbUser user = object == null ? null : (TbUser) object;
        if (user == null) {

            if(isPass(url.toString())){
        		//过滤包含登录请求的URL 
        		filterChain.doFilter(servletRequest, servletResponse);
        	} else {
        		//没有登录
        		writeMessageUtf8(httpResponse, RESULT_NOT_LOGIN);//请登录
        	}
        	//httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");  //401错误
            //httpResponse.sendRedirect("/page/login/user_login");
            
        } else if (StringUtils.endsWithIgnoreCase(url.toString(), LOGOUT)){
    		
    		if(LOGOUT.equals(httpRequest.getParameter(ACTION_TYPE))){
    			session.removeAttribute(session.getId());//移除保存的用户信息
        		session.invalidate();
        		writeMessageUtf8(httpResponse, RESULT_CLEAR_LOGIN);//已注销
    		}
    		
    	} else {
        	//已登录
        	filterChain.doFilter(servletRequest, servletResponse);
        }
        
	}
	
    private boolean isPass(String url) {
		for(String s : filterArr){
			if(StringUtils.endsWithIgnoreCase(url, s)){
				return true;
			}
		}
		return false;
	}

	private void writeMessageUtf8(HttpServletResponse response, String json) throws IOException
    {
		PrintWriter wt = response.getWriter();
        try
        {
//            response.setCharacterEncoding("UTF-8");
        	wt.write(json);
        }
        finally
        {
        	wt.flush();
        	wt.close();
        }
    }
	
    /**
     * 判断是否为Ajax请求
     *
     * @param request HttpServletRequest
     * @return 是true, 否false
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
//        return request.getRequestURI().startsWith("/api");
    	
        String requestType = request.getHeader("X-Requested-With");
        return requestType != null && requestType.equals("XMLHttpRequest");
    }

    /*如果需要注入，可取消注释*/
	public void init(FilterConfig filterConfig) throws ServletException {
		/*如果需要注入，请取消注释*/
//      ServletContext servletContext = filterConfig.getServletContext();
//       WebApplicationContext applicationContext = (WebApplicationContext) servletContext.
//               getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//       if (null == topConstantsImpl) {
//           //从Spring AC 中加载app configuration对象
//           topConstantsImpl = applicationContext.getBean(TopConstantsImpl.class);
//   }
		
		
	}

}

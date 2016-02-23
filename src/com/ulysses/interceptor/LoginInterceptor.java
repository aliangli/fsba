package com.ulysses.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录 拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 在DispatcherServlet完全处理完请求后被调用，可以在该方法中进行一些资源清理的操作。
	 * 
	 * afterCompletion()方法在DispatcherServlet完全处理完请求后被调用 
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}

	/**
	 * 在业务处理器处理完请求后，但是DispatcherServlet向客户端返回请求前被调用，在该方法中对用户请求request进行处理。
	 * postHandle()方法在业务处理器处理请求之后被调用
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView view) throws Exception {
		System.out.println("postHandle");
	}

	/**
	 * 在业务处理器处理请求之前被调用，在该方法中对用户请求request进行处理。如果程序员决定该拦截器对请求进行拦截处理后还要调用其他的拦截器，或者是业务处理器去进行处理，则返回true；如果程序员决定不需要再调用其他的组件去处理请求，则返回false。
	 * 
	 * preHandle()方法在业务处理器处理请求之前被调用
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		
		System.out.println("preHandle");  
		
		return false;
	}

}

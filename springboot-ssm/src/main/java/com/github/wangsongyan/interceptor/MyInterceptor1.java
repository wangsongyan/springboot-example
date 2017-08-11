/**
 * 
 */
package com.github.wangsongyan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * @author songy
 * @date 2017年8月10日 下午5:13:05 
 */
public class MyInterceptor1 extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("url:"+request.getRequestURI());
		
		return true;
	}

}

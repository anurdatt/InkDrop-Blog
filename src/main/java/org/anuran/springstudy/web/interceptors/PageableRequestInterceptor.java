package org.anuran.springstudy.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anuran.springstudy.annotations.PageableRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PageableRequestInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = LoggerFactory.getLogger(PageableRequestInterceptor.class);
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.debug("Inside PageableRequestInterceptor.postHandle() ");
		HandlerMethod method = (HandlerMethod) handler;
		PageableRequest pageableRequest = method.getMethodAnnotation(PageableRequest.class);
		if (null != pageableRequest) {
			String path = pageableRequest.path();
			String defaultPath = (String) PageableRequest.class.getMethod("path").getDefaultValue();
			int currentPage = 0;
			if (!StringUtils.isEmpty(path) && !defaultPath.equalsIgnoreCase(path)) {
				currentPage = parsePageNumber(path, request.getRequestURL());
			}
			else {
				currentPage = parsePageNumber(defaultPath, request.getRequestURL());
			}
			modelAndView.addObject("nextPage", currentPage+1);
			modelAndView.addObject("prevPage", currentPage-1);
			
			log.debug("current page is {}", currentPage);
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	private int parsePageNumber(String path, StringBuffer url) {
		String [] parts = url.toString().split("/");
		
		for (int i=0; i<parts.length; i++) {
			if (parts[i].equalsIgnoreCase(path) && NumberUtils.isNumber(parts[i+1])) {
				return Integer.parseInt(parts[i+1]);
			}
		}
		if("/".equals(path)) {
			String page = parts[parts.length - 1];
			if (NumberUtils.isNumber(page))
				return Integer.parseInt(page);
		}
		return 0;
	}
}

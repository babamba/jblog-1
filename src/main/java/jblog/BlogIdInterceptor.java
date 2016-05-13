package jblog;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BlogIdInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler )
		throws Exception {
		
		if( handler instanceof HandlerMethod == false ) {
			return true;
		}
		
		 Map<String, String> variables = (Map<String, String>)
				 request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		 
		 String blogId = variables.get( "blogId" );
		 if( blogId == null ) {
			 	//redirect "잘못된 경로 아내 페이지"
				return false;
		 }
		 
		 //service 에게 blogId 존재여부 확인
		 
		return true;
	}
	
}

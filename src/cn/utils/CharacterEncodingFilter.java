//package cn.utils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns= {"/*"})
//public class CharacterEncodingFilter implements Filter {
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//	}
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		//转换类型
//		HttpServletRequest req=(HttpServletRequest) request;
//		HttpServletResponse res=(HttpServletResponse) response;
//		//获取请求界面的路径
//		String a=req.getRequestURI();
//		if(a.contains(".css") || a.contains(".js") || a.contains(".png")|| a.contains(".jpg")){
//			//如果发现是css或者js文件，直接放行
//			chain.doFilter(request, response);
//		}
//		//在else中放对网页过滤的代码
//		else{
//			//登录拦截
//		}
//	}
//
//
//	@Override
//	public void destroy() {
//	}
//
//}

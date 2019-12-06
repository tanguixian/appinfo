package cn.sq.appinfo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class SessionInterceptor implements HandlerInterceptor  {


	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		 HttpSession session = req.getSession();
		 if(session.getAttribute("userSession")!=null || session.getAttribute("devUserSession")!=null) {
			 return true;
		 }
		 else {
			 res.sendRedirect("/appinfo/index.jsp");
			 return false;
		 }
		
	}
	/*
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("devUserSession") != null ||request.getSession().getAttribute("userSession") != null) {
			return true;
		}else {
			response.sendRedirect("index.jsp");
			return false;
		}
	}*/

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


}

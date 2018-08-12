package ua.com.oliinyk.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ua.com.oliinyk.entity.User;

public class CheckUserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler,
			ModelAndView modelAndView) {
		if (req.getRequestURI().contains("login")) {
			User user = (User) modelAndView.getModel().get("user");
			if (user != null) {
				try {
					resp.sendRedirect("logout");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		/*if (req.getRequestURI().contains("logout")) {
			User user = (User) modelAndView.getModel().get("user");
			if (user == null) {
				try {
					resp.sendRedirect("login");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
}

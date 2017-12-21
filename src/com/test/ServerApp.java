package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.UserBiz;
import com.vo.User;

@WebServlet({ "/ServerApp", "/sa" })
public class ServerApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBiz<User, String> biz = new UserBiz<>();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		User user = null;
		try {
			 user = biz.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = 
			response.getWriter();
		out.print("SUCCESS");
		out.close();
		System.out.println(id+" "+pwd);
	}

}






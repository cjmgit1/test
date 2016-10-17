package j31.java.web;

import j31.java.dao.UserDao;
import j31.java.entity.UserInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	private UserDao dao=new UserDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method.equals("Login")) {
			Login(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}
	public void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		
		UserInfo u = new UserInfo();
		u=dao.Login(name, pass);
		if(u!=null)
		{
			dao.Login(name, pass);
			request.getSession().setAttribute("u", u);
			
			
		
			request.getRequestDispatcher("Show?method=GetInfo").forward(request, response);
			
		}else 
		{
			request.setAttribute("err", "用户名或密码错误");
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		}
		
	}
	
	

}

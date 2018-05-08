package cn.javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import cn.javaweb.javabean.Admin;
import cn.javaweb.javabean.*;
import cn.javaweb.sql.*;
//import cn.javaweb.sql.adminDAO;

/**
 * Servlet implementation class Login_servlet
 */
@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
	  String a=(String)request.getParameter("gender");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user = request.getParameter("user");
		//request.getSession().setAttribute("u", mail);
		String pass = request.getParameter("pass");
	    User psw =new UserDAO().findUserByname(user);
		if(psw.getUser()==null){
			request.setAttribute("msg", "没有这个用户！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(psw.getUser()!=null&&!psw.getPassword().equals(pass))
		{
			request.setAttribute("msg", "密码错误请重新输入！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(psw.getPassword().equals(pass)){
			session.setAttribute("USER", psw.getUser());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
   }
}



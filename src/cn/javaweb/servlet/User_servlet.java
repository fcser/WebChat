package cn.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.javaweb.javabean.User;
import cn.javaweb.sql.UserDAO;

/**
 * Servlet implementation class User_servlet
 */
@WebServlet("/User_servlet")
public class User_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_servlet() {
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
		System.out.println("ajax连接成功");
		response.setCharacterEncoding("utf-8");
		String  name=request.getParameter("name");//获取查询名称
		User user=UserDAO.findUserByname(name);//根据用户名查询数据
		JSONObject jsb=new JSONObject();
		jsb.put("user", user.getUser());//生成json
		jsb.put("sex", user.getSex());
		jsb.put("age", user.getAge());
		jsb.put("home",user.getHome());
		jsb.put("intro", user.getIntro());
		String message=jsb.toString();
		System.out.println(message);
		PrintWriter out=response.getWriter();//发送到客户端
		//System.out.println("a");
		out.print(message);
		//System.out.println("b");
	}

}

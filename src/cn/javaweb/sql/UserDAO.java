package cn.javaweb.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.javaweb.javabean.User;

public class UserDAO {
	//添加用户
		public static void Add_User(String name,String password,String sex,int age,String home)
		{
			String query="insert into user(name,password,sex,age,home) values('"+name+"','"+password+"','"+sex+"','"+age+"','"+home+"')";
			try{
				dataprocess.ExeQuery(query);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//修改用户信息
		public static void Edit_User(int id,String name,String sex,int age,String home,String intro)
	    {

			String query="update user set name='"+name+"',sex='"+sex+"',age='"+age+"',home='"+home+"',intro='"+intro+"'where id="+id;
			
			try{
		           dataprocess.ExeQuery(query);
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
	    }
		//修改密码
		public static void Change_Password(int id,String password)
	    {

			String query="update user set password='"+password+"'where id="+id;
			
			try{
		           dataprocess.ExeQuery(query);
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
	    }
		//删除用户
		public static void Delete_User(int id)
		{
			String query="delete from user where id="+id;
			try{
				dataprocess.ExeQuery(query);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		//根据用户名查找用户信息
		public static User findUserByname(String name) {
			// TODO Auto-generated method stub
			Connection con=dataprocess.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			User user=new User();
			String sql="select * from user where name='"+name+"'";
			try {
				pstmt=(PreparedStatement) con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()){				
					user.setUser(rs.getString(2));
					user.setPassword(rs.getString(3));	
					user.setSex(rs.getString(4));
					user.setAge(rs.getInt(5));
					user.setHome(rs.getString(6));
					user.setIntro(rs.getString(7));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return user;	
		}
		//根据id查找用户信息
		public static User findUserByid(int id) {
			// TODO Auto-generated method stub
			Connection con=dataprocess.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			User user=new User();
			String sql="select * from user where id="+id;
			try {
				pstmt=(PreparedStatement) con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()){				
					user.setUser(rs.getString(2));
					user.setPassword(rs.getString(3));	
					user.setSex(rs.getString(4));
					user.setAge(rs.getInt(5));
					user.setHome(rs.getString(6));
					user.setIntro(rs.getString(7));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return user;	
		}
		//找出所有用户
		public static ArrayList<User> findALLUsers(){
			Connection con=(Connection) dataprocess.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			ArrayList<User> users=new ArrayList<User>();
			String sql="select * from user";
			try {
				pstmt=(PreparedStatement) con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					User user=new User();
					user.setId(rs.getInt(1));
					user.setUser(rs.getString(2));
					user.setPassword(rs.getString(3));	
					user.setSex(rs.getString(4));
					user.setAge(rs.getInt(5));
					user.setHome(rs.getString(6));
					user.setIntro(rs.getString(7));
					users.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return users;
			
		}
}

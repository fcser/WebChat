package cn.javaweb.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;



public class dataprocess {
public dataprocess(){}

	//创建链接，连接到mlxc2数据库
public static Connection getConnection()   
{
	String CLASSFORNAME="com.mysql.jdbc.Driver";
	String SERVANDDB="jdbc:mysql://localhost:3306/qqweb?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";

	Connection con;
	try{
		Class.forName(CLASSFORNAME);
		con=DriverManager.getConnection(SERVANDDB);
		System.out.print("数据库连接成功");
		return con;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	//下面是数据库连接池，缺少jar包
	/*Context context;
	try {
		context = new InitialContext();
		DataSource ds=(DataSource)context.lookup("java:/comp/env/web/webchat");
		con=ds.getConnection();
		return con;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	*/
}
	public static int nCount(String SQL)
	{
		Connection connection=getConnection();
		int count=0;
		try
		{
			Statement stm=connection.createStatement();
			ResultSet result=stm.executeQuery(SQL);
			if(result!=null){
			while(result.next())//改过了
			{
				count++;
			}
			result.close();
			stm.close();
			connection.close();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	//执行sql语句主要用于增删改
	public static void ExeQuery(String SQL)    
	{
		Connection con=getConnection();
		try
		{
			Statement stmt=con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void CloseConnection(Connection con)
	{
		try{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void CloseResultSet(ResultSet rs)
	{
		try{
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

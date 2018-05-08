package cn.javaweb.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.GregorianCalendar;
import java.util.Vector;

import cn.javaweb.javabean.Chatting;

import cn.javaweb.javabean.Page;


public class ChatDAO {
	//添加聊天记录
	public static void addChat(String sender,String receiver,String content){
		System.out.println(sender);
		GregorianCalendar gc=new GregorianCalendar();
		@SuppressWarnings("deprecation")
		String query="insert into chatting(sender,receiver,content,datatime) values('"+sender+"','"+receiver+"','"+content+"','"+gc.getTime().toLocaleString()+"')";
		try{
		dataprocess.ExeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//删除聊天记录
	public static void delChat(String sort){
		String query="delete from chatting where sort='"+sort+"'";
		try{
			dataprocess.ExeQuery(query);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	//查询聊天记录
	public static Vector<Chatting> search(String strSql,int page)throws Exception{
		Vector<Chatting> Items=new Vector<Chatting>();
		Connection con=(Connection) dataprocess.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			pstmt=(PreparedStatement) con.prepareStatement(strSql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			Page pgb=new Page();
			pgb.setp(rs,page,5);
			System.out.println("HHH"+rs.getRow());
			//pgb.gotoPage(page);
			rs.absolute(pgb.getRowsCount());//将光标移动到指定位置
			System.out.println("光标移动位置"+pgb.getRowsCount());
			int i=0;
			//System.out.println("page=="+page);
			if(rs!=null&&!rs.wasNull());
			{//System.out.println("进第一个if");
				do{
					System.out.println("当前页"+pgb.getCurrentPageRowsCount());
					if(pgb!=null&&pgb.getCurrentPageRowsCount()!=0){
						//System.out.println("进第二个if");
						Chatting chatting=new Chatting();
						chatting.setId(rs.getInt(1));
						chatting.setSender(rs.getString(2));
						chatting.setReceiver(rs.getString(3));
						chatting.setContent(rs.getString(4));
						chatting.setDatatime(rs.getString(5));
						Items.add(chatting);
						i++;
					}
				}while(rs.next()&&i<pgb.getCurrentPageRowsCount());
			}
			return Items;
		}
		finally{
			try{
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}

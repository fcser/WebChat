package cn.javaweb.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Page {
     public static int currentp;//当前页
     private int allp;//总页数
     private int pagesize;//每页内容数
     private int allr;//总记录数
     private int currentr;//当前页记录数
     
     public Page(){}
     public Page(int a,int allp,int pagesize,int allr,int currentr)
     {
    	 currentp=a;
    	 this.allp=allp;
    	 this.pagesize=pagesize;
    	 this.allr=allr;
    	 this.currentr=currentr;
     }
     
     public void setCurrentp(int a)
     {
    	 currentp=a;
     }
     public int getCurrentp()
     {
    	 return currentp;
     }
     public void setAllp(int allp)
     {
    	this.allp=allp; 
     }
     public int getAllp()
     {
    	 return this.allp;
     }
     public void setPagesize(int pagesize)
     {
    	 this.pagesize=pagesize;
     }
     public int getPagesize()
     {
    	 return this.pagesize;
     }
     public void setAllr(int allr)
     {
    	 
			this.allr=allr;
		
	}//设置总查询数
    
     public int getAllr()
     {
    	 return this.allr;
     }
     public void setCurrentr(int currentr)
     {
    	 this.currentr=currentr;
     }
     public int getCurrentr()
     {
    	 return this.currentr;
     }
     
    public void gotopage(int page)
    {
    	switch(page){
		case -1:
			CurrentPage.currentp=1;
			break;
		case -2:
			CurrentPage.currentp=CurrentPage.currentp-1;
			break;
		case -3:
			
			CurrentPage.currentp=CurrentPage.currentp+1;
			break;
		case -4:
			CurrentPage.currentp=this.getAllp();
			break;
		default:
			this.setCurrentp(page);	
		}
    }
    public void setp(ResultSet rs,int page,int pagesize)
    {
    	setPagesize(pagesize);
    	
    	try{
			rs.last();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try{
			this.setAllr(rs.getRow());
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		try{
			rs.beforeFirst();
		}
		catch(SQLException e2)
		{
			e2.printStackTrace();
		}
		//上面的代码是设置总查询数
    	 
    	 if(getAllr()%pagesize!=0){
    	 setAllp(getAllr()/pagesize+1);
    	 }
    	 else{
    		 setAllp(getAllr()/pagesize);
    	 }
    	 gotopage(page);
    }
    public int getRowsCount()
    {
    	System.out.println("当前页"+(CurrentPage.currentp-1));
    	System.out.println("页面数"+(this.getPagesize()+1));
    	//return (getCurrentp()-1)*this.getPagesize()+1;
    	if(CurrentPage.currentp>this.getAllp())
    	{
    		CurrentPage.currentp=CurrentPage.currentp-1;
    	}
    	if(CurrentPage.currentp==0)
    	{
    		CurrentPage.currentp=CurrentPage.currentp+1;
    	}
    	return (CurrentPage.currentp-1)*this.getPagesize()+1;
    }
    public int getCurrentPageRowsCount()
	{
		if(this.getPagesize()==0)
			return this.getAllr();
		if(this.getAllr()==0)
			return 0;
		if(CurrentPage.currentp!=this.getAllp())
			return this.getPagesize();
		
		return this.getAllr()-(this.getAllp()-1)*this.getPagesize();
	}
}

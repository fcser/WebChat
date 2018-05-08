package cn.javaweb.javabean;
/**
 * 
 * @version :v1.0.0
 * @description :
 * @author: zym
 * @date: 2017-11-12下午9:51:44
 */
public class User {
	private int id;
	private String user;
	private String password;
	private String sex;
	private int age;
	private String home;
	private String intro;

	
	public User(){}
	
	User(int id,String user,String password,int age,String sex,String home,String intro)
	{
		this.id=id;
		this.user=user;
		this.password=password;
		this.age=age;
		this.sex=sex;
		//this.mail=mail;
		this.home=home;
		this.intro=intro;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setUser(String user)
	{
		this.user=user;
	}
	
	public String getUser()
	{
		return this.user;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	
	public String getSex()
	{
		return this.sex;
	}
	
	public void setHome(String home)
	{
		this.home=home;
	}
	
	public String getHome()
	{
		return this.home;
	}
	public void setIntro(String intro)
	{
		this.intro=intro;	
	}
	public String getIntro()
	{
		return this.intro;
	}
}

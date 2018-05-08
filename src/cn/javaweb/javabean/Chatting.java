package cn.javaweb.javabean;
/**
 * 
 * @version :v1.0.0
 * @description :
 * @author: zym
 * @date: 2017-11-12下午9:50:28
 */
public class Chatting {
	private int id;
	private String sender;
	private String receiver;
	private String content;
	private String datatime;
	public Chatting(){}
	public Chatting(int id,String sender,String receiver,String content,String datatime)
	{
		this.id=id;
		this.sender=sender;
		this.receiver=receiver;
		this.content=content;
		this.datatime=datatime;
		
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setSender(String sender){
		this.sender=sender;
	}
	
	public String getSender(){
		return this.sender;
	}
	
	public void setReceiver( String receiver){
		this.receiver=receiver;
	}
	
	public String getReceiver(){
		return this.receiver;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setDatatime(String datatime){
		this.datatime=datatime;
	}
	public String getDatatime(){
	    return this.datatime;
	}
	
}

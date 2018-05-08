package cn.javaweb.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import cn.javaweb.sql.ChatDAO;
import net.sf.json.JSONObject;
/**
 * @version :v1.0.0
 * @description :
 * @author: zym
 * @date: 2017-11-19下午9:39:45
 */
@ServerEndpoint("/websockets/{sender}")
public class ChatServer {
	//线程安全，用来存放每个客户端对应的ChatServer对象
	private final static Set<ChatServer> connections = new CopyOnWriteArraySet<ChatServer>();
	
	private Session session;//自己的session，通过它来给客户端发送消息
	
	private String receiver;//自己的用户名
	
	@OnOpen
	public void open(Session session, @PathParam("sender") final String sender) {
		// 添加初始化操作
		System.out.println("打开成功");
		this.session = session;
        connections.add(this);
        session.getUserProperties().put("sender", sender); 
        //this.sender=sender;
        sendUser(session);//获取在线用户
        System.out.println(sender);
        broadcast(sender);//上线消息广播
	}
	
	@OnMessage
	public void getMessage(String message, Session session) {
		System.out.println(message);
		JSONObject jsonObject = JSONObject.fromObject(message);
		receiver = jsonObject.getString("receiver");
		String content=jsonObject.getString("content");
		try {
			// 把消息发送给所有连接的会话
			for (ChatServer client : connections) {
				if(receiver.equals(client.session.getUserProperties().get("sender"))) {
					// 添加本条消息是否为当前会话本身发的标志
					jsonObject.put("sender", session.getUserProperties().get("sender"));
					jsonObject.put("iswhat", "xinxi");
					// 发送JSON格式的消息
					String sendtxt=jsonObject.toString();
					System.out.println(sendtxt);
					ChatDAO.addChat((String)session.getUserProperties().get("sender"), receiver, content);
					client.session.getBasicRemote().sendText(sendtxt);
					//System.out.println("服务器广播消息"+jsonObject.toString());
				}
			}
		} catch (IOException e1) {
            // Ignore
        }
		
	}
	@OnClose
	public void close() {
		// 添加关闭会话时的操作
		connections.remove(this);
	}
	@OnError
	public void error(Throwable t) {
		// 添加处理错误的操作
		System.out.println("error");
	}
	//将在线的人发送给前台
	public static void sendUser(Session session){
		//ArrayList<User> users=UserDAO.findALLUsers();
		JSONObject jso=new JSONObject();
		//将集合中所有的用户，通过JSON发送给浏览器
		for(ChatServer client : connections){
			//jso.put("name", user.getUser());
			jso.put("name", client.session.getUserProperties().get("sender"));
			jso.put("iswhat", "user");
			System.out.println(jso.toString());
			try {
				session.getBasicRemote().sendText(jso.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//有人上线，则将此人广播给各个人
	public static void broadcast(String msg) {
    	JSONObject jso=new JSONObject();
    	jso.put("name", msg);
		jso.put("iswhat", "user");//确定类别，便于客户端接受到消息后做不同处理
        for (ChatServer client : connections) {
        	if(!msg.equals(client.session.getUserProperties().get("sender"))){
        	  try {
				client.session.getBasicRemote().sendText(jso.toString());
			     } catch (IOException e) {
				  // TODO Auto-generated catch block
				    e.printStackTrace();
			     }
        	}
        }
    }
}
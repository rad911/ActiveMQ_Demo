package cn.itcast.demo.point_to_ponit;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @author rad
 *
 */
public class QueueConsumer {
	public static void main(String[] args) throws JMSException, IOException {
		//1.创建连接工厂
		ConnectionFactory  connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
		//2.创建连接对象
		Connection connection = connectionFactory.createConnection();
		//3.启动连接
		connection.start();
		//4.创建会话对象
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		//5.创建队列
		Queue queue = session.createQueue("test-queue");
		//6.创建消费对象
		MessageConsumer  consumer = session.createConsumer(queue);
		//7.设置监听
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message msg) {
				TextMessage  textMessage = (TextMessage) msg;
				try {
					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		//8.等待键盘输入
		System.in.read();
		//9.关闭连接
		consumer.close();
		session.close();
		connection.close();
	}
}

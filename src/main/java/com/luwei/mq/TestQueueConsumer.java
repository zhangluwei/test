/*******************************************************************************
 * Created on 2017年6月21日 下午5:45:53
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.luwei.mq;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @since 1.0.0
 * @version $Id$
 */
public class TestQueueConsumer {

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://127.0.0.1:61616)");
        Connection conn = connectionFactory.createConnection();

        conn.start();

        Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // Destination destination = session.createTopic("VirtualTopic.investResultTopic");
        Destination destination = session.createQueue("test1234?consumer.prefetchSize=10");
        
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {

            public void onMessage(Message message) {
                try {
                    Enumeration<String> nameEnums = message.getPropertyNames();
                    while (nameEnums.hasMoreElements()) {
                        String name = nameEnums.nextElement();
                        System.out.print(message.getJMSMessageID()+"--------");
                        System.out.print(name+"---------");
                        System.out.println(message.getObjectProperty(name));
                    }
                    System.out.print(message.getJMSMessageID());
                    String c = ((TextMessage)message).getText();
                    System.out.println("---------"+c);
                    
                } catch (JMSException e) {
                    System.out.println(e);
                }
                
//                throw new RuntimeException("123");
                
                
            }
        }

        );

//        try {
//            Thread.currentThread().sleep(50000);
//
//        } catch (Exception e) {
//            //TODO: handle exception
//        }
//
//        session.close();
//
//        conn.close();

    }
}

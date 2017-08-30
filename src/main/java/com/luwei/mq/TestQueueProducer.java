/*******************************************************************************
 * Created on 2017年6月21日 下午5:45:53
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.luwei.mq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory; 
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @since 1.0.0
 * @version $Id$
 */
public class TestQueueProducer {

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://127.0.0.1:61616)");
        Connection conn = connectionFactory.createConnection();

        conn.start();

        Session session = conn.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        // Destination destination = session.createTopic("VirtualTopic.investResultTopic");
        Destination destination = session.createQueue("test1234");

        
        MessageProducer producer = session.createProducer(destination);
 
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                
                TextMessage msg = session.createTextMessage(i+"----"+j);
                producer.send(msg);
                
            }
        }
        

//        session.commit();

        session.close();

        conn.close();

    }
}

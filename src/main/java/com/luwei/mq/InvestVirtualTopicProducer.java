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
public class InvestVirtualTopicProducer {

    public static void main(String[] args) throws Exception {

        // ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://10.17.5.51:61616)");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://172.20.20.86:61616)");
        Connection conn = connectionFactory.createConnection();

        conn.start();

        Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // Destination destination = session.createTopic("VirtualTopic.investResultTopic");
        Destination destination = session.createTopic("VirtualTopic.investResultTopic");

        
        MessageProducer producer = session.createProducer(destination);

         InvestResult p = new InvestResult();
         p.setProductName("test");
//            p.setUserId(3616154l);
//            p.setAmount(new BigDecimal(100));
//            p.setInvestTime(new Date());
//            p.setInvestStatus(1);
//            p.setInvestId(RandomUtils.nextLong(9999l, 999999l));
//            p.setInvestSequence(10);
//            
////            p.setProductType(0);
////            p.setProductId(539076l);
////            p.setProductType(11);
////            p.setProductId(110028l);
//            p.setProductType(3);
//            p.setProductId(504632l);
//            p.getExtendParamMap().put("isFirstInvest", "false"); 
            
            
            
            p.setProductName("test");
            p.setUserId(4908506l);
            p.setAmount(new BigDecimal(100));
            p.setInvestTime(new Date());
            p.setInvestStatus(1);
//            p.setInvestId(RandomUtils.nextLong(9999l, 999999l));
            p.setInvestSequence(10);
            p.setProductType(3);
            p.setProductId(542502l);
            p.getExtendParamMap().put("isFirstInvest", "false"); 

//        TextMessage msg = session.createTextMessage(JSON.toJSONString(p));
        
//        producer.send(msg);

        session.commit();

        session.close();

        conn.close();

    }
}

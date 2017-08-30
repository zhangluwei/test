package com.luwei.redis;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisPublish {
	
	public static void main(String[] args) throws Exception {
		
		new Thread(){
			
			public void run() {
				
				Jedis c = RedisUtil.getInstance();
				c.subscribe(new JedisPubSub() {
					public void onMessage(String channel, String message) {
				        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
				    }

				    public void onSubscribe(String channel, int subscribedChannels) {
				        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d", 
				                channel, subscribedChannels));
				    }

				    public void onUnsubscribe(String channel, int subscribedChannels) {
				        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d", 
				                channel, subscribedChannels));

				    }
				}, "AAA");
				
			};
			
		}.start();
		

		new Thread(){
			
			public void run() {
				
				try {
					while (true) {
						Jedis c = RedisUtil.getInstance();

						for (int i = 0; i < 1000; i++) {
							c.publish("AAA",DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(Calendar.getInstance()));
						}
						
						Thread.sleep(1000l);
						
						c.close();
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			};
			
			
		}.start();
		
		
	}
	
}

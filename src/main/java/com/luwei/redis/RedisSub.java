package com.luwei.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisSub {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("start");
		
//		while (true) {
//			Jedis c = RedisUtil.getInstance();
//
//			List<String> contents = c.pubsubChannels("AAA");
//			if(null != contents && contents.size() > 0){
//				for (String s : contents) {
//					System.out.println(s);
//				}
//			}else{
//				Thread.sleep(1000l);
//			}
//			c.close();
//		}
		
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
		
		
		
	}
	
}

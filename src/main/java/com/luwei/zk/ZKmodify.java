package com.luwei.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
 

public class ZKmodify {

    public static CuratorFramework  createWithOptions()
    {
        return CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000, 2))
            .connectionTimeoutMs(10000)
            .sessionTimeoutMs(10000)
            .build();
    }
    
    public static void main(String[] args) throws Exception {
        
        new ZKmodify().run();
        
        System.out.println("end");
    }

    private void run() throws Exception {
        CuratorFramework client = createWithOptions();
        client.start();
         
//        String content = RandomStringGenerator.randomString(10);
//        
//        client.create().orSetData().forPath("/config/A", RandomStringGenerator.randomString(10).getBytes());
//        client.create().orSetData().forPath("/config/B", RandomStringGenerator.randomString(10).getBytes());
//        client.create().orSetData().forPath("/config/C", RandomStringGenerator.randomString(10).getBytes());
//        
//        client.create().orSetData().forPath("/config/A", RandomStringGenerator.randomString(10).getBytes());
//        client.create().orSetData().forPath("/config/B", RandomStringGenerator.randomString(10).getBytes());
//        client.create().orSetData().forPath("/config/C", RandomStringGenerator.randomString(10).getBytes());
//        
//        
        client.close();
       
        
        
        
    }
    
    
    
}

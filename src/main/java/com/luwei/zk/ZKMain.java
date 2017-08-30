package com.luwei.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;

public class ZKMain {

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
        
        new ZKMain().run();
        
        System.out.println("end");
    }

    private void run() throws Exception {
        CuratorFramework client = createWithOptions();
        client.start();
        
        
//        client.create().forPath("/config");
        
        client.getData().usingWatcher(new CuratorWatcher() {
            
            public void process(WatchedEvent event) throws Exception {
                System.out.println("**************************");
                System.out.println(event.getPath());
//                System.out.println(JSON.toJSONString(event));
                System.out.println("**************************");
                
            }
        }).forPath("/config/A");
        
        client.getChildren().usingWatcher(new CuratorWatcher() {
            
            public void process(WatchedEvent event) throws Exception {
                System.out.println("**************************");
                System.out.println(event.getPath());
//                System.out.println(JSON.toJSONString(event));
                System.out.println("**************************");
                
            }
        }).forPath("/config");
        
//String content = RandomStringGenerator.randomString(10);
        
        client.create().orSetData().forPath("/config/A", "".getBytes());
//        client.create().orSetData().forPath("/config/A", RandomStringGenerator.randomString(10).getBytes());
        client.create().forPath("/config/B");
        client.delete().forPath("/config/B");
//        client.create().orSetData().forPath("/config/B", RandomStringGenerator.randomString(10).getBytes());
        
        Thread.sleep(10000);
//        new BufferedReader(new InputStreamReader(System.in)).readLine();  
        
    }
    
    
    
}

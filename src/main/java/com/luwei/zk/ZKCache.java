package com.luwei.zk;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
 

public class ZKCache {

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
        
        new ZKCache().run();
        
        System.out.println("end");
    }

    private void run() throws Exception {
        CuratorFramework client = createWithOptions();
        client.start();
        
        PathChildrenCache   cache = new PathChildrenCache(client, "/config", true);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                
                
                try {
//                    System.out.println(event);
                    
                    String node = ZKPaths.getNodeFromPath(event.getData().getPath());
                    String data = String.valueOf(event.getData().getData());
                    
                    System.out.println(node +"========== " +data);
                    
                    APPENV e = new APPENV();
                    Field[] fields = APPENV.class.getDeclaredFields();
                    for (Field field : fields) {
                        System.out.println("field :" + field.getName());
                        Annotation[] as =  field.getAnnotations();
                        for (Annotation annotation : as) {
                            System.out.println("field :" + field.getName()+ "----------  anno : "+annotation.toString());
                            if(annotation instanceof ZKConfig){
                                ZKConfig zkAnno =        (ZKConfig) annotation;                         
                                System.out.println("field :" + field.getName()+ "----------  value : "+zkAnno.value());
                                
                                if(node.equalsIgnoreCase(zkAnno.value())){
                                    field.setAccessible(true);
                                    field.set(e, data);
                                    
                                }
                                
                            }
                        }
                        
                    }
                    
                    System.out.println("eeeeeeeeeee    :  "+e);
                    
                    
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                
            }
        });
        
        cache.start();
        
        client.setData().forPath("/config/A", "".getBytes());
//        client.delete().forPath("/config/B");
//      client.create().forPath("/config/B");
//      client.delete().forPath("/config/B");
//      client.create().forPath("/config/B");
        
        Thread.sleep(1000000);
//        new BufferedReader(new InputStreamReader(System.in)).readLine();  
        
    }
    
    
    
}

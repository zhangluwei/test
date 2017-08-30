package com.luwei.zk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ZKConfig {

    public String value();
    
 
    
}

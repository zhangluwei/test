package com.luwei.disruptor;

import org.apache.log4j.Logger;

import com.lmax.disruptor.EventHandler;

public class LogEventHander   implements EventHandler<LogEvent> {
    /**
    * Logger for this class
    */
    private static final Logger logger = Logger.getLogger(LogEventHander.class);

    public void onEvent(LogEvent event, long sequence, boolean endOfBatch) throws Exception {
            
               
        Thread.currentThread().sleep(1000);
        
            logger.info("onEvent(LogEvent, long, boolean) - event=" + event + ", sequence=" + sequence + ", endOfBatch="
                    + endOfBatch);
            
            
    }

}

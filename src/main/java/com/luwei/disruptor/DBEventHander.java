package com.luwei.disruptor;

import org.apache.log4j.Logger;

import com.lmax.disruptor.EventHandler;

public class DBEventHander   implements EventHandler<LogEvent> {
    /**
    * Logger for this class
    */
    private static final Logger logger = Logger.getLogger(DBEventHander.class);

    public void onEvent(LogEvent event, long sequence, boolean endOfBatch) throws Exception {
            
               
            logger.info("onEvent(LogEvent, long, boolean) - event=" + event + ", sequence=" + sequence + ", endOfBatch="
                    + endOfBatch);
            
//            Thread.currentThread().sleep(1000);
            
    }

}

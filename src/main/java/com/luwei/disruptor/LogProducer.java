package com.luwei.disruptor;

import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class LogProducer {

    Disruptor<LogEvent> disruptor;

    public void init() {
        LogEventFactory eventFactory = new LogEventFactory();
        int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；
        // WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
        // WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
        // WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
        disruptor = new Disruptor<LogEvent>(eventFactory, ringBufferSize, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }, ProducerType.SINGLE, new YieldingWaitStrategy());

        disruptor.handleEventsWith(new LogEventHander()).handleEventsWith(new DBEventHander());
        disruptor.start();

    }

    public void sendEvent(String log) {

        // 发布事件；
        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();// 请求下一个事件序号；

        try {
            LogEvent event = ringBuffer.get(sequence);// 获取该序号对应的事件对象；

            event.setLog(log);

        } finally {
            ringBuffer.publish(sequence);// 发布事件；
        }
    }

    public static void main(String[] args) throws Exception {
        LogProducer logProducer = new LogProducer();
        logProducer.init();
        for (int i = 0; i < 5; i++) {
            logProducer.sendEvent("log " + i);
        }

        // Thread.currentThread().sleep(10000);

    }

}

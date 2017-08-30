package com.luwei.disruptor;

import com.lmax.disruptor.EventFactory;

public class LogEventFactory  implements EventFactory<LogEvent> {

    public LogEvent newInstance() {
        return new LogEvent();
    }

}

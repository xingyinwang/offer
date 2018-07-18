package com.wxy.JCU;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cser_W on 2018/4/8.
 */
public class CheckNoticeDelay implements Delayed {
    private Integer recordId;

    public long getDelayTime() {
        return delayTime;
    }

    private long delayTime;

    public CheckNoticeDelay(Integer recordId, long delayTime) {
        this.recordId = recordId;
        this.delayTime = delayTime;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) {
            return 1;
        }
        if (o == this) {
            return 0;
        }
        long diff = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
        return diff > 0 ? 1 : diff == 0 ? 0 : -1;
    }

    public Integer getRecordId() {
        return recordId;
    }
}

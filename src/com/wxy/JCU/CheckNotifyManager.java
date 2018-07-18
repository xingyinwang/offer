package com.wxy.JCU;

import org.junit.Assert;

import java.util.concurrent.DelayQueue;

/**
 * Created by Cser_W on 2018/4/8.
 */
public class CheckNotifyManager {
    private DelayQueue<CheckNoticeDelay> pushQueue = new DelayQueue<>();
    public boolean addNotice(CheckNoticeDelay checkNoticeDelay) {
        Assert.assertNotNull(checkNoticeDelay);
        return pushQueue.offer(checkNoticeDelay);
    }

    public CheckNoticeDelay takeNotice() throws InterruptedException {
        return  pushQueue.take();
    }
}

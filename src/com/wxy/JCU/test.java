package com.wxy.JCU;

import org.junit.Test;

/**
 * Created by Cser_W on 2018/4/8.
 */
public class test {
    @Test
    public void testPushNotice() {
        CheckNotifyManager manager = new CheckNotifyManager();
        manager.addNotice(new CheckNoticeDelay(1, System.currentTimeMillis() + 1 * 1000));//1s
        manager.addNotice(new CheckNoticeDelay(2, System.currentTimeMillis() + 6 * 1000));//6s
        manager.addNotice(new CheckNoticeDelay(3, System.currentTimeMillis() + 3 * 1000));//3s
        CheckRecordPushTask task = new CheckRecordPushTask(manager);
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

package com.wxy.JCU;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Cser_W on 2018/4/8.
 */
public class CheckRecordPushTask implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(CheckRecordPushTask.class);

    private CheckNotifyManager checkNotifyManager;

    public CheckRecordPushTask(CheckNotifyManager checkNotifyManager) {
        this.checkNotifyManager = checkNotifyManager;
    }


    @Override
    public void run() {
        while (true) {
            try {
                CheckNoticeDelay delay = checkNotifyManager.takeNotice();
                if (delay != null) {
                    logger.info("push msg, recordId;{}", delay.getRecordId());
                }
                System.out.println("this is a test!");
            } catch (InterruptedException e) {
                logger.error("Thread is Interrupted!");
            }
        }
    }
}

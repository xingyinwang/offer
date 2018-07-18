package com.wxy.BlockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cser_W on 2018/4/11.
 */

class DelayTask implements Delayed{

    public String name;
    public Long delayTime;
    public TimeUnit delayTimeUnit;
    public Long executeTime;// ms

    public DelayTask(String name, Long delayTime, TimeUnit delayTimeUnit) {
        this.name = name;
        this.delayTime = delayTime;
        this.delayTimeUnit = delayTimeUnit;
        this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis()
                ,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }
}
public class DelayQueueTest {
    public static void main(String[] args){
        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();
        delayQueue.add(new DelayTask("1",1L,TimeUnit.SECONDS));
        delayQueue.add(new DelayTask("2",2L,TimeUnit.SECONDS));
        delayQueue.add(new DelayTask("3",3L,TimeUnit.SECONDS));
        System.out.println("delayQueue put done");
        while (!delayQueue.isEmpty()) {
            try {
                DelayTask task = delayQueue.take();
                System.out.println(task.name + ": "+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

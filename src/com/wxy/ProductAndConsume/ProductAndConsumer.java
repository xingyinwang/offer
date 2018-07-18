package com.wxy.ProductAndConsume;

import java.util.LinkedList;

/**
 * Created by Cser_W on 2018/3/30.
 */

class Consumer extends Thread {
    private String consumer;
    private Storage storage;

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public Consumer(String consumer, Storage storage){
        this.consumer = consumer;
        this.storage = storage;
    }
    @Override
    public void run() {
        consume(consumer);
    }
    public void consume(String consumer) {
        storage.consume(consumer);
    }
}

class Producer extends Thread{
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    private String producer;
    private Storage storage;
    public Producer(String producer, Storage storage) {
        this.producer = producer;
        this.storage = storage;
    }
    @Override
    public void run() {
        produce(producer);
    }
    public void produce(String producer){
        storage.produce(producer);
    }
}
 class Storage {

    private  final int MAX_SIZE = 10;

    private  LinkedList<Object> list = new LinkedList<>();

    public void produce(String producer) {
        synchronized (list) {
            while (list.size() == MAX_SIZE) {
                System.out.println("仓库已满，【"+producer+"】:暂时不能执行生成任务");
                try{
                    list.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【"+producer+"】:生产了一个产品\t 【现存储量为】:"+list.size());
            list.notifyAll();
        }
    }

    //消费产品
    public void consume(String consumer) {
        synchronized(list) {
            while (list.size() == 0) {
                System.out.println("仓库已空，【"+consumer+"】:暂时不能执行消费任务");
                try {
                    list.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【"+consumer+"】:消费了一个产品\t 【现存储量为】:"+list.size());
            list.notifyAll();
        }
    }
    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMAX_SIZE(){
        return MAX_SIZE;
    }

}

public class ProductAndConsumer {
    public static void main(String[] args){
        Storage storage=new Storage();
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer("第"+i+"消费", storage)).start();
        }

        for (int i = 0; i < 4; i++) {
            new Thread(new Producer("第"+i+"个生产者",storage)).start();
        }

    }
}

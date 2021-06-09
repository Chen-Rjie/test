package JUC;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private Lock lock;

    private LinkedList<String> buffer;

    private int maxSize;

    private Condition notfullCondition;

    private Condition fullCondition;

    public ConditionTest(int maxSize) {
        this.maxSize = maxSize;
        lock = new ReentrantLock();
        buffer = new LinkedList<>();
        this.maxSize = maxSize;
        notfullCondition = lock.newCondition();
        fullCondition = lock.newCondition();
    }

    public void produce(String goods) throws InterruptedException {

        lock.lock();

        try {

            while (maxSize == buffer.size()) {
                notfullCondition.await();
                System.out.println("工厂产能达到极限，不能继续进行生产了,停工一段时间");
            }

            //队列没有满，可以生产
            buffer.add(goods);

            System.out.println("哈哈，我生产了" + goods + "，通知消费者进行消费...");
            //通知消费者线程进行消费
            fullCondition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public String consume() throws InterruptedException {

        String goods = null;
        lock.lock();

        try {

            while (buffer.size() == 0) {
                System.out.println("工厂的产品已经消费完了，暂时不能剁手了");
                fullCondition.await();
            }

            //开始消费
            goods = buffer.poll();
            System.out.println("哈哈，我消费" + goods + "，通知工厂进行生产...");
            //通知生成者
            notfullCondition.signalAll();

        } finally {
            lock.unlock();
        }

        return goods;
    }


    public static void main(String[] args) {

        ConditionTest conditionTest = new ConditionTest(100);

        new Thread(() -> {

            for (int i = 0; i < 1000000; i++) {
                try {
                    conditionTest.produce("笔记本电脑" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "produce").start();


        new Thread(() -> {

            while (true) {
                try {
                    conditionTest.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "consume").start();

    }

}
package JUC;

/**
 * DATE: 2021/6/8
 * Author: (Chen)
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class ShareResource{
    private int number = 1;
    //1:A 2:B 3:C
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(int totalLoopNumber){
        lock.lock();
        try {
            //1 判断
            while(number != 1){
                //A 就要停止
                c1.await();//sychonize 释放锁的时候会刷回共享内存 此时别的缓存行就会失效  会重新从驻主存里面读取 因此保证了原子性
            }
            //2 干活
            for (int i = 1; i <=5; i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
            }
            //3 通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁的时候会刷回共享内存 此时别的缓存行就会失效  会重新从驻主存里面读取 因此保证了原子性
        }
    }
    public void print10(int totalLoopNumber){
        lock.lock();
        try{
            //1 判断
            while(number != 2){
                //A 就要停止
                c2.await();
            }
            //2 干活
            for (int i = 1; i <=10; i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
            }
            //3 通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15(int totalLoopNumber)  {
        lock.lock();
        try{
            //1 判断
            while(number != 3){
                //A 就要停止
                c3.await();
            }
            //2 干活
            for (int i = 1; i <=15; i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
            }
            //3 通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


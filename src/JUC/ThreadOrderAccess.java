package JUC;

/**
 * DATE: 2021/6/8
 * Author: (Chen)
 */
/**
 *
 * @Description:
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 *
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮
 *
 */
public class ThreadOrderAccess{
    public static void main(String[] args){
        ShareResource sr = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <=10; i++)
            {
                sr.print15(i);
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 1; i <=10; i++){
                sr.print10(i);
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <=10; i++){
                sr.print5(i);
            }
        }, "AA").start();


    }
}


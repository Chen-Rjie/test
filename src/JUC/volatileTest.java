package JUC;

/**
 * DATE: 2021/6/8
 * Author: (Chen)
 */
public class volatileTest {
    public static void main(String[] args) {

        UseThread u1 = new UseThread();
        u1.start();
        System.out.println("main:"+System.currentTimeMillis());//这里两个线程没有加锁与释放锁的过程  因此需要volatile关键字的支持
        try {
            Thread.sleep(1000);//sleep是Thread方法 不需要synchronized支持  而wait是object方法 需要synchronized
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        u1.setFlag(false);

    }
}

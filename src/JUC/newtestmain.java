package JUC;

/**
 * DATE: 2021/6/8
 * Author: (Chen)
 */
public class newtestmain {
    public static void main(String[] args) throws InterruptedException {
        testVolatile2 ts = new testVolatile2();

//        ts.thread2.start();
        ts.thread1.start();
//        try {
//            Thread.sleep(1000);//sleep是Thread方法 不需要synchronized支持  而wait是object方法 需要synchronized
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ts.setNumber(2);

    }
}

package JUC;

/**
 * DATE: 2021/6/8
 * Author: (Chen)
 */
public class testVolatile2 {
    private int number = 1;
    private int flag = 1;
    public void setNumber(int num){
        this.number = num;
    }
    Thread thread1 = new Thread(()->{
        synchronized (this){
//            setNumber(1);
            int count =0;
            while (number==1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                try {
//                    flag = 2;
//                    wait();
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            System.out.println(number);
        }

    });
    Thread thread2 = new Thread(()->{
        synchronized (this){

            if (flag!=1){
                try {
                    wait(2000);
                    setNumber(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                number = 2;
//                try {
//                    wait(6000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println("number2");
                System.out.println(number);
                notify();

//                try {
//                    wait(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//                System.out.println("这里是"+number);
            }
        }
    });
    Thread thread3 = new Thread(()->{
        synchronized (this){
            while (number==3){
                System.out.println("number3");
                number = 1;
            }
        }
    });
    public static void main(String[] args) throws InterruptedException {
        testVolatile2 ts = new testVolatile2();
        ts.thread1.start();
        ts.thread2.start();

//        ts.thread2.start();
//        ts.thread1.start();
//        try {
//            Thread.sleep(1000);//sleep是Thread方法 不需要synchronized支持  而wait是object方法 需要synchronized
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ts.setNumber(2);



//        Thread.sleep(3000);

    }
}

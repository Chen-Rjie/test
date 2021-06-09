package JUC;

/**
 * DATE: 2021/6/8
 * Author: (Chen)
 */
public class ABThread {

    private static  int num=0;
    public static void main(String[] args) throws InterruptedException {

        Thread A=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (num==0){        //读取num过程记作1
                        System.out.println("A");
                        num=1;          //写入num记位2
                    }
                }
            }
        },"A");
        Thread B=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (num==1){        //读取num过程记作3
                        System.out.println("B");
                        num=0;          ////写入num记位4
                    }
                }
            }
        },"B");
        A.start();
        B.start();
    }
}

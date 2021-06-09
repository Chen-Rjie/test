package JUC;

/**
 * DATE: 2021/6/8
 * Author: (Chen)
 */
public class UseThread extends Thread{
    private   boolean flag = true;
    public boolean isFlag(){
        return flag;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("888:"+System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName()+"线程正在执行");
            while (flag){

        }
        System.out.println(Thread.currentThread().getName()+"线程执行完毕");
    }
}

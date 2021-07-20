package 笔试题;

import java.util.Scanner;

/**
 * Created by Chen
 * 2021/6/26 19:12
 */
public class moni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
//            System.out.println(s.length());
            sc.nextLine();
            if(s.equals("1")){
                int count = 0;
                while (sc.hasNextLine()){
                    String str = sc.nextLine();
                    if(str.length()!=0)
                        count++;
                }
                System.out.println(count);
            }
            else if(s.equals('Q')){
                System.out.println("Quit");
            }
            else {
                System.out.println("Wrong input, Please re-choose");
                System.out.println("Menu Function Test");
                System.out.println("1: Count Lines");
                System.out.println("Q: Quit");}
        }
    }
}

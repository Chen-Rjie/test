package 笔试题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Chen
 * 2021/6/27 21:16
 */
public class compute {
    public static void main(String[] args) {
        String ts = "100+200-1+2-3";
        System.out.println(computeString(ts));
    }
    public static int computeString(String s){

        StringBuilder str = new StringBuilder();
        Queue<Integer> list = new LinkedList<>();
        Queue<Character> chList = new LinkedList<>();
        chList.add('+');
        int tmp = 0;
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            if(Character.isDigit(now)){
                tmp = tmp*10 + now-'0';
            }
            else {
                list.offer(tmp);
                chList.offer(now);
                tmp = 0;
            }
        }
        list.add(tmp);
        int res = 0;
        while (!list.isEmpty()){
            int num1 = list.poll();
            char option = chList.poll();
            switch (option){
                case '+':res += num1;break;
                case '-':res -= num1;break;
            }
        }
        return res;
    }
}

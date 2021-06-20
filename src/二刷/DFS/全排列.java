package 二刷.DFS;

import javax.swing.text.Segment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chen
 * 2021/6/14 14:28
 */
public class 全排列 {
    public void perm(char[] ch){

    }
    public  void Swap(char chs[],int i,int j) throws Exception {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
        Integer[] ar = {1,2};
        List<Integer> s = Arrays.asList(ar);
        ar = s.toArray(new Integer[0]);
        new ArrayList<>().size();
//        Segment

        Lock lock = new ReentrantLock();
        ThreadLocal<Integer> ss = new ThreadLocal();
        ss.set(3);
        int[] mm = new int[2];
//        Arrays.sort(mm,new Comparator<Integer>{});
//        Arrays.stream()
    }

    }

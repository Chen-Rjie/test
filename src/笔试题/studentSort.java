package 笔试题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Chen
 * 2021/6/26 18:28
 */
public class studentSort {
    static class Student{
        String name;
        int chinese;
        int math;
        int english;

        public Student(String name, int chinese, int math, int english) {
            this.name = name;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
        }


        @Override
        public String toString(){
            return "name:"+this.name+" total:"+(this.chinese+this.math+this.english)+" chinese:"+this.chinese+" math:"
                    +this.math+" english:"+this.english;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int num = in.nextInt();
            Student[] sList = new Student[num];
            for(int i=0;i<num;i++){
                String name = in.next();
                int chinese = in.nextInt();
                int math = in.nextInt();
                int english = in.nextInt();
                sList[i] = new Student(name,chinese,math,english);
            }
            Arrays.sort(sList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int totalA = o1.math+o1.chinese+o1.english;
                    int totalB = o2.math+o2.chinese+o2.english;
                    if(totalA!=totalB)
                        return totalB-totalA;
                    if(o2.chinese!=o1.chinese)
                        return o2.chinese-o1.chinese;
                    if(o2.chinese==o1.chinese&&o2.math!=o1.math){
                        return o2.math-o1.math;
                    }
                    if(o2.math==o1.math&&o2.english!=o1.english)
                        return o2.english-o1.english;
//                    else if(o2.chinese!=o1.chinese)
//                        return o2.chinese-o1.chinese;
//                    else if()
//                    else if(o2.math!=o1.math){
//                        return o2.math-o1.math;
//                    }
                    else if(!o1.name.equals(o2.name)){
                        if(o1.name.compareTo(o2.name)<0){
                            return -1;
                        }
                        else
                            return 1;
                    }
                    return 1;

                }
            });
            for(int i=0;i<num;i++){
                if(i!=num-1)
                    System.out.println("rank:"+(i+1)+" "+sList[i].toString());
                else
                    System.out.print("rank:"+(i+1)+" "+sList[i].toString());
            }
        }

    }
}

package 双指针;
//给定两个数组，编写一个函数来计算它们的交集。
//        示例 1：
//        输入：nums1 = [1,2,2,1], nums2 = [2,2]
//        输出：[2]

//java8的 Stream方法 对集合操作的优化
//java的retainAll方法s1.retainAll(s2)方法 删除所有s1有但是s2没有的
//Arrays.copyOfRange
import java.util.*;
public class leetcode349 {
    //第一想法 哈希
    public int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length,length2= nums2.length;
        int[] intersections = new int[length1 + length2];
        int index = 0;
        Map<Integer,Integer> map1 = new HashMap<>(),map2 = new HashMap<>();
        for(int i=0;i< length1;i++)
        {
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for(int j=0;j< length2;j++)
        {
            map2.put(nums2[j],map2.getOrDefault(nums2[j],0)+1);
        }
        for(int key : map2.keySet()){
            if(map1.containsKey(key))
                intersections[index++] = key;
        }
        return Arrays.copyOfRange(intersections,0,index);

    }
}

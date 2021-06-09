package 二刷.位运算;

import java.util.ArrayList;
import java.util.List;

/**
 * DATE: 2021/5/31
 * Author: (Chen)
 */
/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class leetcode78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return res;
    }
    public void dfs(int[] nums,int level){
        if(level== nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[level]);
        dfs(nums,level+1);
        tmp.remove(tmp.size()-1);
        dfs(nums,level+1);//一定是先取再是不去  保证回退的状态后面是没有取的
    }
    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        for(int mask=0;mask<1<<n;mask++){
            for(int i=0;i<n;i++){
                tmp.clear();
                if((mask&(1<<i))!=0){//注意运算符优先级
                    tmp.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

}

package 二刷.树;

/**
 * DATE: 2021/6/1
 * Author: (Chen)
 */
/*
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
输入：n = 3
输出：5
 */
public class leetcode96 {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                G[i] += G[i-j]*G[j-1];
            }
        }
        return G[n];
    }
}

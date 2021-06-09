package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode207 {
    //dfs做法
    /*
    List<List<Integer>> edges = new LinkedList<>();
    boolean res = true;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];

        for (int[] tmp : prerequisites)
        {
            edges.get(tmp[1]).add(tmp[0]);
        }
         for(int i=0;i<numCourses&&res;i++)
        {
            if(visited[i]==0)
                dfs(i);
        }
        return res;
    }
    public void dfs(int index)
    {
        visited[index]=1;
        //获取每一条出边
        for(int i : edges.get(index))
        {
            if(visited[i]==0)
            {
                dfs(i);
                if(!res)
                    return;
            }
            else if(visited[i]==1)//只有当前节点visited才为1，若等于1则表示dfs到了当前节点，表示有环路
            {
                res = false;
                return;
            }

        }
        visited[index]=2;//已经寻找完成的节点：该节点开始的节点后面都没有环路
        return;
    }*/
    //广度优先遍历
    List<List<Integer>> edges = new LinkedList<>();
    int[] incount;
    int count=0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        incount = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            edges.add(new LinkedList<>());
        }
        for (int[] tmp : prerequisites)
        {
            edges.get(tmp[1]).add(tmp[0]);
            incount[tmp[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(incount[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty())
        {
            ++count;
            int now = queue.poll();
            for(int i : edges.get(now))
            {
                incount[i]--;
                if(incount[i]==0)
                    queue.offer(i);
            }
        }
        return count==numCourses;
    }
}

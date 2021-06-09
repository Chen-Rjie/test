import java.util.*;
public class leetcode77 {
    public List<Integer> line = new LinkedList<>();
    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        boolean visited[] = new boolean[n+1];
        dfs(n,k,1,visited);
        return res;
    }
    public void dfs(int n,int k,int now,boolean[] visited)
    {
        if(line.size()+(n-now+1)<k)
            return;
        if(line.size()==k)
        {
            res.add(new ArrayList<>(line));
            return;
        }
        for(int i=now;i<=n;i++)
        {
            if(visited[i]==false)
            {
                visited[i] = true;
                line.add(i);
                dfs(n,k,i+1,visited);
                line.remove(line.size()-1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args)
    {
        int n=4,k=2;
        List<List<Integer>> res = new leetcode77().combine(n,k);

    }
}

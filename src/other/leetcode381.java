package other;
//设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
//
//注意: 允许出现重复元素。
//
//insert(val)：向集合中插入元素 val。
//remove(val)：当 val 存在时，从集合中移除一个 val。
//getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
//示例:
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
import java.util.*;
public class leetcode381 {
    Map<Integer,List<Integer>> numforcount;
    int count = 0;

    /** Initialize your data structure here. */
    public leetcode381() {
        numforcount = new TreeMap<>();//treemap的key是有顺序的
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        count++;
        if(!numforcount.containsKey(val))
        {
            List<Integer> tmp  = new ArrayList<>();
            tmp.add(val);
            numforcount.put(val,tmp);
            return true;
        }
        else {
            List<Integer> tmp = numforcount.get(val);
            tmp.add(val);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!numforcount.containsKey(val))
            return false;
        List<Integer> tmp = numforcount.get(val);
        if(tmp.size()==0)
            return false;
        tmp.remove(tmp.size()-1);
        count--;
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();

        int index = random.nextInt(count);
        Iterator<Integer> iterator = numforcount.keySet().iterator();
        while (iterator.hasNext()&&index>=0)
        {
            Integer key = iterator.next();
            List<Integer> ls = numforcount.get(key);
            int len = ls.size();
            if(index<len)
                return ls.get(index);
            index -= len;
        }
        return 0;
    }

}

package 设计;
/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
/*
输入
        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        输出
        [null, null, null, 1, null, -1, null, -1, 3, 4]
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
 */
import java.util.*;
public class leetcode146 {
    int cap;
    Node head,tail;
    Map<Integer,Node> map;
    class Node{
        int key;
        int val;
        Node pre=null;
        Node next=null;
        public Node(){};
        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }
    public leetcode146(int capacity) {
        this.cap = capacity;
        this.map = new HashMap();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node now = map.get(key);
        Node pre = now.pre;
        Node next = now.next;
        pre.next = next;
        next.pre = pre;
        Node hnext = head.next;
        head.next = now;
        now.pre = head;
        now.next = hnext;
        hnext.pre = now;
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size()==cap){
                Node last = tail.pre;
                map.remove(last.key);
                Node lastpre = last.pre;
                lastpre.next = tail;
                tail.pre = lastpre;

            }
            Node now = new Node(key,value);
            Node hnext = head.next;
            head.next = now;
            now.pre = head;
            now.next = hnext;
            hnext.pre = now;
            map.put(key,now);
        }
        else {
            Node now = map.get(key);
            now.val = value;
            Node pre = now.pre;
            Node next = now.next;
            pre.next = next;
            next.pre = pre;
            Node hnext = head.next;
            head.next = now;
            now.pre = head;
            now.next = hnext;
            hnext.pre = now;
//            Node hnext = head.next;
//            head.next = now;
//            now.pre = head;
//            now.next = hnext;
//            hnext.pre = now;
            map.put(key,now);
        }
    }
}

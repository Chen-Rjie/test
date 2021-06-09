package 二刷.堆;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
23. 合并K个升序链表
 */
public class leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int lenl = lists.length;
        if(lenl==0)
            return null;//没写这个就需要下面写start>end的判断
        return merge(lists,0,lenl-1);
    }
    //使用归并排序的思想
    public static ListNode merge(ListNode[] list,int start,int end){
        if(start==end)
            return list[start];
        if(start>end)
            return null;//注意这个边界条件
        int mid = (start+end)>>1;
//        return mergeTwo(merge(list,start,mid-1),merge(list, mid,end));
        return mergeTwo(merge(list,start,mid),merge(list, mid+1,end));//只能这样写
    }
    public static ListNode mergeTwo(ListNode A,ListNode B){
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (A!=null&&B!=null){
            if(A.val<B.val){
                tail.next = A;
                A = A.next;
            }
            else {
                tail.next = B;
                B = B.next;
            }
            tail =tail.next;
        }
        tail.next = (A==null)?B:A;
        return head.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        int lenl = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b)->a.val- b.val);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            ListNode now = queue.poll();
            tail.next = now;
            if(now.next!=null)
                queue.add(now.next);
            tail = tail.next;
        }
        return head.next;
    }
}

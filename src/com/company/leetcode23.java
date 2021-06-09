package com.company;
import java.util.*;
class ListNode {
     int val;
     ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2)->o2.val-o1.val);
        ListNode head = new ListNode(0);
        ListNode rhead = head;
        for(ListNode node : lists)
        {
            if(node!=null)
                queue.add(node);
        }
        while(!queue.isEmpty())
        {
            head.next = queue.poll();
            head = head.next;
            if(head.next!=null)
                queue.add(head.next);

        }
        return rhead.next;
    }

}

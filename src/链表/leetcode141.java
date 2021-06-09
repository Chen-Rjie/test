package 链表;
//判断链表是否存在环
public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow = head,fast = head.next;
        while(fast!=null&&fast.next!=null)
        {
            if(slow==fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

package 链表;

public class reverselist {
    //迭代法
//    public ListNode reverseList(ListNode head) {
//        if(head==null)
//            return null;
//        ListNode pre=null,now=head;
//        while (now.next!=null)
//        {
//            ListNode tmp = now.next;
//            now.next = pre;
//            pre = now;
//            now = tmp;
//        }
//        now.next = pre;
//        return now;
//    }

    //递归法
    ListNode rhead;
    public ListNode reverseList(ListNode head){
        if(head==null)
            return null;
        reverse(head);
        head.next=null;
        return rhead;
    }
    public ListNode reverse(ListNode head) {
        if(head.next==null)
        {
            rhead = head;
            return head;
        }
        ListNode now = reverse(head.next);
        now.next = head;
        return head;
    }
}

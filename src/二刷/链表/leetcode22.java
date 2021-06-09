package 二刷.链表;
public class leetcode22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode slow = head;
//        ListNode tmp = head;
        ListNode pre = new ListNode();
        pre.next = head;
//        ListNode fast = head.next;
        while (k-->0&&slow!=null){
            slow = slow.next;
        }
        if(k>0)
            return null;
        while (slow!=null){
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        if(head==slow)
            return head.next;
        return head;
    }
}

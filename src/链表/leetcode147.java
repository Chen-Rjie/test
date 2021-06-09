package 链表;
/*
 对链表进行插入排序
 */
public class leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode newhead = head;
        ListNode sechead = head.next,pre = newhead;
        ListNode lastsorted = head;
        newhead.next=null;
        while (sechead!=null){
            ListNode node = newhead;
            ListNode secnext = sechead.next;
            if(sechead.val>= lastsorted.val){
                lastsorted.next = sechead;
                lastsorted = sechead;
            }
            else {
                while (node!=null){
                    if(node.val<sechead.val){
                        pre = node;
                        node = node.next;
                    }
                    else {
                        if(node==newhead){
                            sechead.next = node;
                            newhead = sechead;
                        }
                        else {
                            pre.next = sechead;
                            sechead.next = node;
                        }
                        break;

                    }
                }
                if(node==null){
                    pre.next = sechead;
                    sechead.next = null;
                }

            }
            sechead = secnext;
            }

        return newhead;
    }

    public static void main(String[] args) {
        int[] ts = {4,2,1,3};
        ListNode head = new leetcode147().createlist(ts);
        new leetcode147().insertionSortList(head);
    }
    public ListNode createlist(int[] a){
        ListNode head = null,tail=null;
        for(int num:a){
            if(head==null){
                head = new ListNode(num);
                tail = head;
            }
            else {
                ListNode now = new ListNode(num);
                tail.next = now;
                tail = now;
            }
        }
        return head;
    }
}

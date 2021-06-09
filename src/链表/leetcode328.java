package 链表;

public class leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode odd = head,even = head.next,pre=new ListNode(1);
        while (head!=null&&head.next!=null){
            ListNode now = head.next;
            ListNode sec = now.next;
            head.next = sec;
            head = sec;
            pre = head;
            if(sec!=null){
                pre = sec;
                now.next = sec.next;
                now = now.next;
            }
        }
        if(head==null){
            pre.next = even;
        }
        else {
            head.next =even;
        };
        return odd;
    }


    public ListNode create(int[] a){
        ListNode head = null,r=null;
        for(int num:a){
            if(head==null){
                head = new ListNode(num);
                r = head;
            }
            else {
                ListNode now = new ListNode(num);
                r.next = now;
                r = now;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] ts = {1,2,3,4,5};
        ListNode head = new leetcode328().create(ts);
        ListNode res = new leetcode328().oddEvenList(head);
    }
}

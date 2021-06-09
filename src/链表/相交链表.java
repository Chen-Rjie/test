package 链表;

public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA,B=headB;
        if(A==null||B==null)
            return null;
        while (A!=B)
        {
            if(A.next==null&&B.next==null)
                return null;
            if(A.next==null)
                A = headB;
            else
                A = A.next;
            if(B.next==null)
                B = headA;
            else
                B = B.next;
        }
        return A;
    }
}

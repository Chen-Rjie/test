package 链表;

/**
 * Created by Chen
 * 2021/6/10 0:01
 */
public class leetcode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while(l1!=null&&l2!=null){
            int nowVal = l1.val+l2.val+pre;
            pre = nowVal/10;
            l1.val = nowVal%10;
            l2.val = nowVal%10;
            if(l1.next==null||l2.next==null)
                break;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1.next==null&&l2.next==null){
            if(pre!=0)
                l2.next = new ListNode(pre);
            return head2;
        }
        ListNode newhead = l1.next==null?l2.next:l1.next;
        ListNode realHead = l1.next==null?head2:head1;
        while(newhead!=null){
            int nowVal = newhead.val+pre;
            pre = nowVal/10;
            newhead.val = nowVal%10;
            if(newhead.next==null){
                if(pre!=0){
                    newhead.next = new ListNode(pre);
                }
                return realHead;
            }
            newhead = newhead.next;
        }
        // if(l1!=null){
        //     l1 = l1.next;
        //     while(l1!=null){
        //         int nowVal = l1.val+pre;
        //         pre = nowVal/10;
        //         l1.val = nowVal%10;
        //         if(l1.next==null){
        //             l1.next = new ListNode(pre);
        //             return head;
        //         }
        //         l1 = l1.next;
        //     }
        // }
        // else{

        // }
        // while(l1.next!=null){
        //     int nowVal = l1.val+pre;
        //     pre = nowVal/10;
        //     l1.val = nowVal%10;
        //     l1 = l1.next;
        // }
        // ListNode end = l2==null?l1;
        // if(end==nul)


        // while(l1!=null){
        //     int nowVal = l1.val+pre;
        //     pre = nowVal/10;
        //     l1.val = nowVal%10;
        //     l1 = l1.next;
        // }


        // while(l2!=null){
        //     int nowVal = l2.val+pre;
        //     pre = nowVal/10;
        //     l2.val = nowVal%10;
        //     if(l2.next==null){
        //         break;
        //     }
        //     l2 = l2.next;
        // }
        // while(l1!=null){
        //     int nowVal = l1.val+pre;
        //     pre = nowVal/10;
        //     l1.val = nowVal%10;
        //     if(l1.next==null){
        //         break;
        //     }
        //     l1 = l1.next;
        // }

        return realHead;
    }

    public static void main(String[] args) {
        int[] ts1 = new int[]{5};
        int[] ts2 = new int[]{5};
       ListNode h1 = createList(ts1);
       ListNode h2 = createList(ts2);
       ListNode res = addTwoNumbers(h1,h2);
       while (res!=null){
           System.out.println(res.val);
           res = res.next;
       }

    }
    public static ListNode createList(int[] ts){
        ListNode res = null;
        ListNode tail = null;
        for(int num:ts){
            if(tail == null){
                res = new ListNode(num);
                tail = res;
            }
            else {
                tail.next = new ListNode(num);
                tail = tail.next;
            }
        }
        return res;
    }
}

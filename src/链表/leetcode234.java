package 链表;

public class leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,fast = head,pre=null,tmp1,tmp2;
        //快慢指针可以找到链表的中点
        int flag = 0;
        boolean is_single = true;//判断奇数偶数
        while(fast!=null&&fast.next!=null)
        {
            tmp1 = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp1;
            if(flag==0)
            {
                fast = tmp1.next;
                flag = 1;
            }
            else {
                fast = fast.next.next;
            }
            if(fast==null)
                is_single = false;
        }
        //这样完了之后中点靠后 slow就是中点
        if(is_single)
        {
            if(pre!=null&&slow.next==null)
            {
                return pre.val==slow.val;
            }
            while (pre!=null&&slow.next!=null)
            {
                if(pre.val!=slow.next.val)
                    return false;
                pre = pre.next;
                slow = slow.next;
            }
            return true;
        }
        else {
            while (pre!=null&&slow!=null)
            {
                if(pre.val!=slow.val)
                    return false;
                pre = pre.next;
                slow = slow.next;
            }
            return true;
        }


    }
    public static void main(String[] args)
    {
        int[] ts = new int[]{1,2};
        ListNode head = new leetcode234().create(ts);
        boolean res = new leetcode234().isPalindrome(head);

    }
    public ListNode create(int[] ls)
    {
        ListNode head = null,tail=null;
        for(int num : ls)
        {
            if(head==null)
            {
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

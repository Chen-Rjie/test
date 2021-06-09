package com.company;

public class leetcode_148 {
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    /*public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        //链表找到中间节点
        //若把slow和fast都置于开始节点，偶数时slow最后结束在前一个节点
        ListNode slow = head,fast = head.next;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;//断开
        //上面的操作在数组里面直接就是求数组的中间位置
        //接下来要做的就是合并两个有序链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left!=null&&right!=null)
        {
            if(left.val< right.val)
            {
                res.next = left;
                left = left.next;
                res = left;
            }
            else {
                res.next = right;
                right = right.next;
                res = right;
            }
        }
        res.next = left!=null?left:right;
        return h.next;
    }*/
    //非递归方法
    public ListNode sortList(ListNode head) {
        ListNode h = head,pre;
        //第一步:计算链表长度
        int len = 0;
        while(h!=null)
        {
            ++len;
            h = h.next;
        }
        //建立一个头结点往上挂
        ListNode res = new ListNode(0);
        res.next = head;
        int sublen = 1;
        while(sublen<len)
        {
            pre = res;//维护一个pre指针用来指向合并的链表
            h = pre.next;
            //每次找两个区间合并 如果第一个区间还没找完的话就不用何合并了
            while(h!=null)
            {
                ListNode h1 = h;//保存需要合并的节点的开始节点，之后用来合并
                int i = sublen;
                while(h!=null&&i>0)
                {
                    i--;
                    h = h.next;
                }//退出循环指向第二段的第一个节点
                if(i>0)//说明第一个子区间都不够直接break
                {
                    break;
                }
                //找第二个区间
                i = sublen;
                ListNode h2 = h;
                while(h!=null&&i>0)
                {
                    i--;
                    h = h.next;
                }
                int c1 = sublen,c2 = sublen-i;
                //老操作 合并有序链表
                while(c1>0&&c2>0)
                {
                    if(h1.val< h2.val)
                    {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;

                    }
                    else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1>0?h1:h2;
                //还要把pre移到最后一个节点
                while (c1>0||c2>0)
                {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                //因为排序了 不能保证pre.next就是原数组对应位置的下一个节点
                pre.next = h;//和pre = res;//维护一个pre指针用来指向合并的链表对应 next指向原来第二段最后一个节点的下一个节点
                //主要是为了防止最后一个节点指向前一个节点而没有指向null
            }
            sublen *=2;
        }
        return res.next;
    }
}

package com.company;

public class linkedlist {
    public static void main(String[] args)
    {
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class Solution5 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode tmp = new RandomListNode(node.label);
            tmp.next = node.next;
            node.next = tmp;
            node = tmp.next;
        }
        node = pHead;
        while (node != null) {
            RandomListNode randomnode = node.random;
            RandomListNode copynode = node.next;
            if (randomnode != null) {
                copynode.random = randomnode.next;
            }
            node = copynode.next;
        }
        node = pHead;
        RandomListNode copyhead = node.next;
        RandomListNode end = copyhead;
        node = end.next;
        while (node != null) {
            end.next = node.next;
            end = end.next;
            node = end.next;
        }
        /*node.next = end.next;
        node = node.next;
        while(node!=null)
        {
            end.next = node.next;
            end = end.next;
            node.next = end.next;
            node = node.next;
        }*/
        return copyhead;
    }
}}
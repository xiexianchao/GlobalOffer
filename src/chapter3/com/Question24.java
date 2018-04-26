package chapter3.com;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/4/24
 * @Time:8:38
 * @description：
 */
public class Question24 {
    private static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            next=null;
        }
    }

    public ListNode ReverseList(ListNode pHead)
    {
       // return getListNode(pHead);
        // return getListNode2(pHead);
        if(pHead == null || pHead.next ==null)
            return pHead;
        ListNode nextNode = pHead.next;
        pHead.next = null;
        ListNode reversetRest = ReverseList(nextNode);
        nextNode.next = pHead;
        return reversetRest;

    }

    /*翻转，逆序使用栈的思想*/
    private ListNode getListNode2(ListNode pHead) {
        if(pHead ==null)
            return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode node = pHead;
        while(node !=null)
        {
            stack.push(node);
            node = node.next;
        }
        ListNode pReverseHead = stack.pop();
        ListNode cur = pReverseHead;
        while(!stack.empty())
        {
            ListNode node1=stack.pop();
            node1.next=null;  /*不然会形成环*/
            cur.next=node1;
            cur=cur.next;
        }
        return pReverseHead;
    }


    /*剑指Offer上的方法*/
    private ListNode getListNode(ListNode pHead) {
        if(pHead == null)
            return null;


        ListNode pNode = pHead;
        ListNode pPre = null;
        ListNode pReverseHead = null;
        while(pNode !=null)
        {
            if(pNode.next == null)
                pReverseHead =  pNode;
            ListNode pNext = pNode.next;
            pNode.next = pPre;
            pPre =pNode;
            pNode = pNext;

        }
        return pReverseHead;
    }

    @Test
    public void test()
    {
        ListNode root = new ListNode(1);
        ListNode secodn = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        root.next=secodn;
        secodn.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=null;

        ReverseList(root);


    }

}

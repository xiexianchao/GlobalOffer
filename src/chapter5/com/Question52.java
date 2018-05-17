package chapter5.com;


import leetcode.Question2;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/5/17
 * @Time:17:13
 * @description：
 */
public class Question52 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 借助栈
     * @param pHead1
     * @param pHead2
     * @return 第一个公共结点
     */
   ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2)
   {
       if(pHead1 == null || pHead2 == null)
            return null;
       Stack<ListNode> stack1 = new Stack<>();
       Stack<ListNode> stack2 = new Stack<>();

       while(pHead1 != null) {
           stack1.push(pHead1);
           pHead1 = pHead1.next;
       }
       while(pHead2 != null)
       {
           stack2.push(pHead2);
           pHead2 = pHead2.next;
       }
       ListNode node = null;
       while((!stack1.isEmpty())&&(!stack2.isEmpty())&&(stack1.peek() == stack2.peek()))
       {
           stack1.pop();
          node= stack2.pop();
       }

       return node;


   }

   ListNode findFirstCommonNode2(ListNode pHead1,ListNode pHead2)
   {
       if(pHead1 == null || pHead2 == null)
           return null;
       int length1 = 0;
       int length2 = 0;
       ListNode node1 = pHead1;
       ListNode node2 = pHead2;
       while(node1!=null)
       {
           length1++;
           node1 = node1.next;
       }
       while(node2 != null)
       {
           length2++;
           node2 = node2.next;
       }

       if(length1>length2) {
           for (int i = 1; i <= length1 - length2; i++) {
                pHead1 = pHead1.next;
           }
       }else if(length2 > length1)
       {
           for (int i = 0; i <= length2 - length1 ; i++) {
               pHead2 = pHead2.next;
           }
       }
       while((pHead1 != null)&&(pHead2 != null)&&(pHead1 != pHead2))
       {
           pHead1 = pHead1.next;
           pHead2 = pHead2.next;
       }
       if(pHead1 == null || pHead2 == null)
           return null;
       else
           return pHead1;
   }

}

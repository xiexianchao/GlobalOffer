package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/5/14
 * @Time:9:58
 * @description：
 */
public class Question2 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null && l2 == null)
                return null;
            int digits = 0;
            long num1 =  0;
            long num2 = 0;
            ListNode node = l1;
            while(node != null)
            {
                num1 = (int) (num1 + node.val*Math.pow(10,digits));
                digits++;
                node = node.next;
            }
            digits = 0;
            node = l2;
            while(node != null)
            {
                num2 = (int) (num2 + node.val*Math.pow(10,digits));
                digits++;
                node = node.next;
            }
            //digits = 0;
            long num = num1 + num2;
            ListNode root = null;
            ListNode cur = null;
            if(num != 0)
            {
                while(num !=0)
                {
                    ListNode listNode = new ListNode((int) (num%10));
                    if(root == null)
                    {
                       root = listNode;
                       cur =root;
                      // digits = 1;
                    }else {
                        cur.next = listNode;
                        cur = listNode;
                    }
                    num = num/10;
                }
            }
            else{
                root = new ListNode(0);
            }

            return root;
        }


        public ListNode addTwoNumbers2(ListNode l1,ListNode l2) {
            if (l1 == null && l2 == null)
                return null;
            ListNode node1 = l1;
            ListNode node2 = l2;
            int carry = 0;
           // int precarry = 0;
            ListNode pre = new ListNode(0);
            ListNode root = pre;
            while (node1 != null || node2 != null) {
                int temp = (node1 == null?0:node1.val) + (node2 == null?0:node2.val) + carry;
               /* if (temp >= 10) {
                    carry = temp / 10;
                    temp = temp % 10;
                }else
                    carry = 0;*/
                ListNode node = new ListNode(temp % 10);
                carry  = temp / 10;
               // precarry = carry;
                    pre.next = node;
                    pre = pre.next;

                node1 = node1== null?null:node1.next;
                node2 = node2==null?null:node2.next;
            }
            if(carry >0)
                pre.next = new ListNode(carry);

            return root.next;
        }


    @Test
    public void test1()
    {
        ListNode L1 = new ListNode(9);
      //  L1.next = new ListNode(4);
       // L1.next.next = new ListNode(3);

        ListNode L2 = new ListNode(1);
        L2.next = new ListNode(9);
        ListNode node =L2.next.next = new ListNode(9);
        node.next = new ListNode(9);
        node.next = new ListNode(9);
        node.next.next = new ListNode(9);
        node.next.next.next = new ListNode(9);
        ListNode node2 = node.next.next.next.next = new ListNode(9);
        node2.next = new ListNode(9);
        node2.next = new ListNode(9);

        addTwoNumbers2(L1,L2);


        addTwoNumbers2(new ListNode(5),new ListNode(5));
    }

}

package chapter4.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/4
 * @Time:8:57
 * @description：
 */
public class Question35 {
    private static  class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead)
    {
        cloneNodes(pHead);
        ConnectSiblingNodes(pHead);
        return reconnnetNodes(pHead);
    }

    private void cloneNodes(RandomListNode pHead)
    {
        RandomListNode node = pHead;
        while(node != null)
        {
            RandomListNode nodeClone = new RandomListNode(node.label);
            nodeClone.next = node.next;
            node.next = nodeClone;
            node = nodeClone.next;
        }
    }

    private void ConnectSiblingNodes(RandomListNode pHead)
    {
        RandomListNode node = pHead;
        while(node != null)
        {
            if(node.random != null)
            {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

    }

    private RandomListNode reconnnetNodes(RandomListNode pHead)
    {
       if(pHead == null ||pHead.next == null)
           return null;
       //RandomListNode root = pHead;
       RandomListNode node = pHead;
       RandomListNode rootClone = pHead.next;
       RandomListNode nodeClone = rootClone;
       node.next = nodeClone.next;
       node = node.next;
       while(node != null)
       {
           /*node = nodeClone.next;
           nodeClone = node.next;
           node.next = node;
           nodeClone.next = nodeClone;*/
           nodeClone.next = node.next;
           nodeClone = nodeClone.next;
           node.next = nodeClone.next;
           node = node.next;
       }
       return rootClone;
    }



    @Test
    public void test1()
    {
        RandomListNode root = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        RandomListNode third = new RandomListNode(3);
        RandomListNode fourth = new RandomListNode(4);
        root.next = second;
        second.next = third;
        third.next = fourth;
        root.random = fourth;
        second.random = root;

        cloneNodes(root);
        ConnectSiblingNodes(root);
        reconnnetNodes(root);
//        assert(root.next.label ==1);


    }




}

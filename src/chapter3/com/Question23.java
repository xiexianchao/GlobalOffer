package chapter3.com;

/**
 * @author:xiehcao
 * @Date:2018/4/23
 * @Time:21:15
 * @description：
 */
public class Question23 {
    private static class ListNode{
        int data;
        ListNode next;
    }
    ListNode enteryNodeOfLoop(ListNode root)
    {

        if(root==null)
            return null;
        ListNode sNode = root.next;
        ListNode fNode = null;
        if(sNode != null)
            fNode = sNode.next;
        else
            return null;

        while(sNode != fNode)
        {
            if(sNode != null && fNode != null)
            {
                sNode = sNode.next;
                fNode = fNode.next;
                if(fNode !=null)
                    fNode = fNode.next;
            }else
                return null;

        }
        int count =1;
        ListNode meetnode = sNode;
        while(sNode.next != meetnode)
        {
            count++;
            sNode = sNode.next;
        }

        sNode = root;
        fNode = root;
        for (int i = 0; i <count ; i++) {
            fNode = fNode.next;
        }
        while(sNode != fNode)
        {
            sNode = sNode.next;
            fNode = fNode.next;
        }
        return sNode;



       // return getListNode1(root);
    }

    private ListNode getListNode1(ListNode root) {
        if(root==null)
            return null;
        ListNode sNode = root.next;
        ListNode fNode = null;
        if(sNode != null) {
             fNode = sNode.next;
        }else{
            return null;               /*一个节结点不存在环返回null*/
        }
        while(sNode != fNode)
        {
           if(sNode != null && fNode !=null)
           {
               sNode = sNode.next;
               fNode = fNode.next;
               if(fNode != null)
                   fNode = fNode.next;
               else
                   return null;
           }else
               return null;
        }

        sNode = root;
        while(sNode != fNode)
        {
            sNode = sNode.next;
            fNode = fNode.next;
        }
        return sNode;
    }


}

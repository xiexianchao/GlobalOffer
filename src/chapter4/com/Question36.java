package chapter4.com;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/5/4
 * @Time:11:24
 * @description：
 */
public class Question36 {


     static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

    /*递归---剑指Offer*/
    public TreeNode Convert(TreeNode pRootOfTree) {
            if(pRootOfTree == null )
                return null;

           // TreeNode lastNodeInList = null;
            ConvertCore(pRootOfTree);
            TreeNode node = lastNodeInList;
            while(node !=null && node.left != null)
            {
                node = node.left;
            }
            return node;


        }

    private  TreeNode lastNodeInList = null;
    private void ConvertCore(TreeNode pNode) {
            if(pNode == null) return;
            TreeNode pCurrent = pNode;
            if(pCurrent.left != null)
                ConvertCore(pCurrent.left);
            pCurrent.left = lastNodeInList;
            if(lastNodeInList != null)
                lastNodeInList.right = pCurrent;
            lastNodeInList = pCurrent;
            if(pCurrent.right != null)
                ConvertCore(pCurrent.right);
    }

    /*递归-----牛客高分*/
    public TreeNode Convert1(TreeNode pRootOfTree)
    {
        if(pRootOfTree == null)
            return null;
        TreeNode root = pRootOfTree;
        if(root.left != null)
        {
            TreeNode left = Convert1(root.left);
            while(left != null && left.right != null)
                left = left.right;

            root.left = left;
            left.right = root;
        }

        if(root.right != null)
        {
            TreeNode right = Convert1(root.right);


            root.right = right;
            right.left = root;
        }
        /*返回头结点*/
        while(root != null && root.left != null)
            root = root.left;

        return root;


    }

    /*非递归--栈---牛客高分*/
    public TreeNode Convert2(TreeNode pRootOfTree)
    {
        if(pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRootOfTree;
        TreeNode preNode = null;
        TreeNode head = null;
        while(node != null || !stack.isEmpty())
        {
            while(node != null)
            {
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty())
            {
                 node = stack.pop();
                 if(preNode == null)
                 {
                     preNode = node;
                     head = node;
                 }else{
                     preNode.right = node;
                     node.left = preNode;
                     preNode = node;
                 }
                 node = node.right;

            }
        }
        return head;
    }


    /*Morris法---牛客高分*/
    public TreeNode Convert3(TreeNode pRootOfTree)
    {
        if(pRootOfTree == null)
            return null;

        TreeNode cur = pRootOfTree;
        TreeNode temp = null;
        TreeNode pre = null;
        TreeNode head = null;
        while(cur != null)
        {
            if(cur.left == null)
            {
                if(pre == null)
                {
                    pre = cur;
                    head = cur;
                }else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }else{
                temp = cur.left;
                while(temp.right != null && temp.right != cur)
                    temp = temp.right;
                if(temp.right == null)
                {

                  temp.right = cur;
                  cur = cur.left;

                }else{
                   temp.right = null;
                    if(pre == null)
                    {
                        pre = cur;
                        head = cur;
                    }else {
                        pre.right = cur;
                        cur.left = pre;
                        pre = cur;
                    }
                   cur = cur.right;
                }
            }
        }
        return head;
    }



    @Test
    public void test1()
    {
        TreeNode root = new TreeNode(8);
        TreeNode left1 = new TreeNode(6);
        TreeNode right1 = new TreeNode(10);
        TreeNode left11 = new TreeNode(5);
        TreeNode right11 = new TreeNode(7);
        TreeNode left21 = new TreeNode(9);
        TreeNode right21 = new TreeNode(11);


        root.left = left1;
        root.right = right1;
        left1.left = left11;
        left1.right = right11;
        right1.left = left21;
        right1.right = right21;
        //TreeNode pHead=Convert(root);

        TreeNode pHead1=Convert3(root);
    }

}


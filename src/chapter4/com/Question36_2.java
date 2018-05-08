package chapter4.com;
import org.junit.Test;

import java.util.Stack;

import static chapter4.com.Question36.*;
/**
 * @author:xiehcao
 * @Date:2018/5/4
 * @Time:16:10
 * @description：二叉树的Morris遍历法：时间复杂度：0(n) 空间复杂度：O(1) 非递归
 *
 * 传统遍历无论是递归还是借助栈时间复杂度都为O(n)，空间复杂度都为:O（n）
 */
public class Question36_2 {
    public void morrisInOrder(TreeNode root)
    {
        if(root == null)
            return;
        TreeNode cur = root;
        TreeNode temp = null;
        while(cur != null)
        {
            if(cur.left == null)
            {
                System.out.print(cur.val+" ");
                cur = cur.right;
            }else{
                temp = cur.left;
                while( temp.right != null && temp.right != cur)
                {
                    temp = temp.right;
                }
                if(temp.right == null)
                {
                    temp.right = cur;
                    cur = cur.left;
                }else {
                    temp.right = null;
                    System.out.print(cur.val + " ");
                    cur = cur.right;
                   // cur.right = null;
                }
            }
        }
    }

    public void morrisPreOrder(TreeNode root)
    {
        if(root == null)
            return;
        TreeNode cur = root;
        TreeNode temp = null;
        while(cur != null)
        {
            if(cur.left == null)
            {
                System.out.print(cur.val+"*");
                cur = cur.right;
            }else{
                temp = cur.left;
                while(temp.right != null && temp.right != cur)
                    temp = temp.right;
                if(temp.right == null)
                {
                    System.out.print(cur.val+"-");
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    temp.right = null;
                    cur = cur.right;
                }

            }
        }
    }


    public void morrisPostOrder(TreeNode root)
    {
        if(root == null)
            return;
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        dump.right = null;
        TreeNode cur = dump;
        TreeNode temp = null;

        while(cur != null)
        {
            if(cur.left == null)
            {
                cur = cur.right;
            }else{
                temp = cur.left;
                while(temp.right != null && temp.right != cur)
                {
                    temp = temp.right;
                }
                if(temp.right == null)
                {
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    reversePrint(cur,temp);
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }

    }

    private void reversePrint(TreeNode cur, TreeNode preInOrder) {
        TreeNode temp = cur.left;
        Stack<TreeNode> stack = new Stack<>();
        while(temp != preInOrder)
        {
            stack.push(temp);
            temp=temp.right;
        }
        stack.push(preInOrder);
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop().val+"  ");
        }

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
        morrisInOrder(root);

        System.out.println();
        morrisPreOrder(root);
        System.out.println();
        morrisPostOrder(root);

    }

}

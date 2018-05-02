package chapter4.com;
import org.junit.Test;

import java.util.Stack;

import static chapter4.com.Question32.*;
/**
 * @author:xiehcao
 * @Date:2018/5/2
 * @Time:11:58
 * @description：
 */
public class Question32_3 {
    public void Print(BinaryTreeNode root)
    {
        if(root == null)
            return;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
       // int current = 0;
       // int  next = 1;
        boolean leftToRight = true;

        while(!stack1.empty())
        {
            BinaryTreeNode node = stack1.pop();
            System.out.print(node.data+" ");
            //leftToRight = false;
            if(leftToRight)
            {
                if(node.left != null)
                    stack2.push(node.left);
                if(node.right != null)
                    stack2.push(node.right);
            }else{
                if(node.right != null)
                    stack2.push(node.right);
                if(node.left != null)
                    stack2.push(node.left);
            }
            leftToRight = false;
            if(stack1.isEmpty())
            {
                System.out.println();
                stack1 = stack2;
                stack2 = new Stack<>();
            }
        }
    }

    @Test
    public void test1()
    {

        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode left1 = new BinaryTreeNode(6);
        BinaryTreeNode right1 = new BinaryTreeNode(10);
        BinaryTreeNode left11 = new BinaryTreeNode(5);
        BinaryTreeNode right11 = new BinaryTreeNode(7);
        BinaryTreeNode left21 = new BinaryTreeNode(9);
        BinaryTreeNode right21 = new BinaryTreeNode(11);

        root.left = left1;
        root.right = right1;
        left1.left = left11;
        left1.right = right11;
        right1.left = left21;
        right1.right = right21;

        BinaryTreeNode right112 = new BinaryTreeNode(1);
        BinaryTreeNode right211 = new BinaryTreeNode(2);
        BinaryTreeNode left111 = new BinaryTreeNode(3);
        BinaryTreeNode left211 = new BinaryTreeNode(4);

        left11.left = left111;
        left11.right = right112;

        left21.right=right211;
        left21.left=left211;

        Print(root);
    }



}

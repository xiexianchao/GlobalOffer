package chapter4.com;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/4/26
 * @Time:20:48
 * @description：
 */
public class Question28 {
    private static class TreeNode {
        int val = 0;
         TreeNode left = null;
         TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetrical(TreeNode root)
    {


        /*非递归，用栈实现，注意null的处理*/
        if(root == null)
            return true;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        stack2.push(root);

        while((!stack1.empty()) && (!stack2.empty()))
        {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();

            while(node1 == null)
            {
                if(node2 !=null)
                    return false;
                node1 = stack1.pop();
                node2 = stack2.pop();

                if(stack1.empty()&&stack2.empty())
                    return true;
            }
           if(node2 == null)
               return false;
            if(node1.val != node2.val)
                return false;

            stack1.push(node1.right);
            stack1.push(node1.left);

            stack2.push(node2.left);
            stack2.push(node2.right);
        }

        return true;

      //  return isSymmetrical(root,root);
    }

    /*递归*/
    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;

        return isSymmetrical(root1.left,root2.right)&&
                isSymmetrical(root1.right,root2.left);
    }
    @Test
    public void test1() {
        TreeNode root = new TreeNode(8);
        TreeNode left1 = new TreeNode(6);
        TreeNode right1 = new TreeNode(6);
        TreeNode left11 = new TreeNode(5);
        TreeNode right11 = new TreeNode(7);
        TreeNode left21 = new TreeNode(7);
        TreeNode right21 = new TreeNode(5);

        root.left = left1;
        root.right = right1;
        left1.left = left11;
        left1.right = right11;
        right1.left = left21;
        right1.right = right21;
        System.out.println(isSymmetrical(root));
    }



}

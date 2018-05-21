package chapter6.com;

import chapter4.com.Question32;
import org.junit.Test;

import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/5/21
 * @Time : 9:49
 * @description :二叉搜索树中的第k大节点
 */
public class Question54 {
    private static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
            right = null;
            left = null;
        }
    }

    public TreeNode getKthNode(TreeNode root,int k)
    {
        if(root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
      //  stack.push(node);
        int count = 0;
        while(!stack.isEmpty() || node != null)
        {
            while(node != null)
            {
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty())
            {
                count++;
                node = stack.pop();
                if(count == k)
                    return node;
                node = node.right;
            }
        }
        return null;
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
        getKthNode(root,8);
    }


}

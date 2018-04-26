package chapter4.com;


import org.junit.Test;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/4/26
 * @Time:20:02
 * @description：
 */
public class Question27 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

         TreeNode(int val) {
            this.val = val;
        }
    }
        public void Mirror(TreeNode root) {
           /* if(root==null)
                return;
            if(root.left==null && root.right==null)
                return;

            TreeNode node=root.left;
            root.left=root.right;
            root.right=node;

            if(root.left!=null)
                Mirror(root.left);
            if(root.right!=null)
                Mirror(root.right);
            */
           /*非递归*/

           if(root == null)
               return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.empty())
            {
                TreeNode node = stack.pop();
                if(node.left !=null || node.right !=null)
                {
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
                if(node.left != null)
                    stack.push(node.left);
                if(node.right != null)
                    stack.push(node.right);
            }

        }

        private TreeNode MirrorRecursiverly(TreeNode root)
        {
            if(root == null)
                return null;
            if(root.left == null && root.right == null)
                return root;
            TreeNode node = root.left;
            root.left = MirrorRecursiverly(node.right);
            root.right = MirrorRecursiverly(node);
            return root;
        }

    @Test
    public void test1() {
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
        Mirror(root);
    }


}

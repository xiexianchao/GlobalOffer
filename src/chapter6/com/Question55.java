package chapter6.com;

import Chapter2.com.tree.TreeNode;
import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/5/21
 * @Time : 10:39
 * @description :求二叉树的深度
 */
public class Question55 {
    //int depth = 0;
    public int getTreeDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int depth = 1;
      /*  if(root.right == null && root.left == null)
            return depth;
       else*/
           return depth +=Math.max(getTreeDepth(root.left),getTreeDepth(root.right));
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
        System.out.println(getTreeDepth(root));
    }
}

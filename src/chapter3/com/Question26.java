package chapter3.com;

/**
 * @author:xiehcao
 * @Date:2018/4/26
 * @Time:11:07
 * @description：
 */
public class Question26 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    boolean HasSubtree(TreeNode root1,TreeNode root2)
    {
        if(root1 == null || root2 == null)
            return false;

        boolean result = false;
        if(root1.val == root2.val)
            result = DoesTreeHaveTree2(root1,root2);
        if(!result)
            result = HasSubtree(root1.left,root2);
        if(!result)
            result = HasSubtree(root1.right,root2);

        return result;
    }

    private boolean DoesTreeHaveTree2(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return  true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;

        return DoesTreeHaveTree2(root1.left,root2.left)&&
                DoesTreeHaveTree2(root1.right,root2.right);
    }

}

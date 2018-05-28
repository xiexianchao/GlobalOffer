package chapter6.com;

import Chapter2.com.tree.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiehcao
 * @Date : 2018/5/22
 * @Time : 20:47
 * @description : 给一个二叉树判断是否是平衡二叉树
 */
public class Question55_2 {
    private Map<TreeNode,Integer> map = new HashMap<>();

    /**
     *
     * @param root
     * @return 使用记事簿方法求二叉树的深度
     */
    private int getTreeDepth(TreeNode root)
    {
        if(map.containsKey(root))
        {
            return map.get(root);
        }else{
        if(root == null)
            return 0;
        int depth = 1;
        depth +=Math.max(getTreeDepth(root.left),getTreeDepth(root.right));
        map.putIfAbsent(root,depth);
        return depth;
        }
    }

    /**
     *
     * @param root
     * @return
     * @description： 从根节点到子节点依次判断所有节点，在求子节点的深度时包含重复计算
     */
    public boolean isBalance(TreeNode root){
        if(root == null) return true;
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) >1)
            return false;
        return isBalance(root.left) && isBalance(root.right);
    }


    /**
     * 封装返回结果
     */
    class Result{
        boolean isBalance;
        int depth;

        public Result(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }

    /**
     *
     * @param root
     * @return 返回root节点是否满足平衡二叉树条件，以及root节点的深度
     *          从子节点到父节点，后序遍历算法的变种，不包含重复计算
     */
    Result isBalanceCore(TreeNode root)
    {
        if(root == null)
        {
            return new Result(true,0);
        }else{
            Result left = isBalanceCore(root.left);
            Result right = isBalanceCore(root.right);
            int depth = 1 + Math.max(left.depth,right.depth);
            if(left.isBalance && right.isBalance) {
                if (Math.abs(left.depth - right.depth) <= 1) {
                    return new Result(true, depth);
                }
            }
            return new Result(false,depth);
        }
    }
    
    boolean isBalance2(TreeNode root)
    {
        return isBalanceCore(root).isBalance;
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


        System.out.println(isBalance(root));
        System.out.println(isBalance2(root));


    }


}

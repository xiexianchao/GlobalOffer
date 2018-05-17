package inspiration.com;

import Chapter2.com.tree.TreeNode;
import chapter4.com.Question32;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/5/17
 * @Time:17:34
 * @description：
 */
public class FindPathInTreeTest {

    LinkedList<TreeNode> path = new LinkedList<>();
    public boolean findPath(TreeNode root,TreeNode target)
    {
        if(root == target)
        {   path.addLast(root);
            return true;
        }
        path.addLast(root);
        boolean found = false;
        if( !found )
        {
            if(root.left != null)
                found =findPath(root.left,target);
            if(root.right != null)
                found = findPath(root.right,target);
        }
        if(!found) {
            path.removeLast();
        }
        return found;
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
        findPath(root,right21);
     //   System.out.println(Arrays.toString(path.toArray()));
        
    }



}

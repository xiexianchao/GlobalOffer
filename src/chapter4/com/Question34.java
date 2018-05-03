package chapter4.com;
import org.junit.Test;

import java.util.LinkedList;

import static chapter4.com.Question32.*;
/**
 * @author:xiehcao
 * @Date:2018/5/3
 * @Time:11:38
 * @description：
 */
public class Question34 {
    public void findPath(BinaryTreeNode root,int target)
    {
        if(root == null)
            return;
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<LinkedList<Integer>> paths = new LinkedList<>();

        findPathCore(root,target,path,paths);
        assert(paths.size()>0);

    }

    private void findPathCore(BinaryTreeNode root, int target, LinkedList<Integer> path, LinkedList<LinkedList<Integer>> paths) {
        if(root == null)
            return;
        path.add(root.data);
        int targetNext = target-root.data;
        if((root.left == null) && (root.right == null) && targetNext == 0)
        {
            paths.add((LinkedList<Integer>) path.clone());
           // path = new LinkedList<>(path);
        }

        findPathCore(root.left,targetNext,path,paths);
        findPathCore(root.right,targetNext,path,paths);

       // System.out.print(root.data+" ");
        path.removeLast();

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

        findPath(root,29);


    }
}

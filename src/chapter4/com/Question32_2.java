package chapter4.com;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static chapter4.com.Question32.BinaryTreeNode;
/**
 * @author:xiehcao
 * @Date:2018/5/2
 * @Time:11:46
 * @description：
 */
public class Question32_2 {
    public void Print(BinaryTreeNode root)
    {
        if(root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        int toBePrint = 1;
        int nextLevel = 0;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.data+" ");
            toBePrint--;

            if(node.left != null)
            {
                queue.offer(node.left);
                nextLevel++;
            }
            if(node.right != null)
            {
                queue.offer(node.right);
                nextLevel++;
            }
            if(toBePrint == 0)
            {
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
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
        Print(root);
    }

}

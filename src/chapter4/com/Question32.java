package chapter4.com;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:xiehcao
 * @Date:2018/5/2
 * @Time:11:36
 * @description：
 */
public class Question32 {
     static class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

         public BinaryTreeNode(int data) {
             this.data = data;
         }
     }

    public void printFromTopToBottom(BinaryTreeNode root)
    {
        if(root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.data+" ");

            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }

    }


}

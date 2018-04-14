package Chapter2.com.tree;

import Chapter2.com.exception.InvaliPutException;
import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/13
 * @Time:19:49
 * @description：
 */
public class findNextNodeInOrderTraverse {

    private static class TreeNode{
        private String value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        TreeNode(String value)
        {
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    public  String findNextNodeInOrder(TreeNode root) throws InvaliPutException {
        if(root == null)
           return null;
            // throw new InvaliPutException("输入无效");

        if(root.right != null)
        {
            TreeNode node = root.right;
           // TreeNode preNode = null;
           while(node.left !=null)
           {
               node = node.left;
           }
            return node.value;

        }else{
            if(root.parent == null)
                return null;
            else if(root.parent.left == root)
                return root.parent.value;
            else{
              TreeNode pCureentNode = root;
              TreeNode pPareant = root.parent;
              while(pPareant !=null && pCureentNode == pPareant.right)
              {
                  pCureentNode = pPareant;
                  pPareant = pPareant.parent;
              }
                return pPareant.value;
            }
        }
    }

    @Test
    public void test1()
    {
        TreeNode aNode = new TreeNode("a");
        TreeNode bNode = new TreeNode("b");
        TreeNode cNode = new TreeNode("c");
        TreeNode dNode = new TreeNode("d");
        TreeNode eNode = new TreeNode("e");
        TreeNode fNode = new TreeNode("f");
        TreeNode gNode = new TreeNode("g");
        TreeNode hNode = new TreeNode("h");
        TreeNode iNode = new TreeNode("i");




    }

}

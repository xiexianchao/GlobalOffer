package Chapter2.com.tree;

import Chapter2.com.exception.InvaliPutException;
import Chapter2.com.tree.TreeNode;

/**
 * @author:xiehcao
 * @Date:2018/4/13
 * @Time:18:06
 * @description：
 */
public class ReBuildBinTree {

    public static TreeNode reBuildBinTree(int[] postOrder,int startPost,int endPOst,
                                          int[] InOrder,int startIn,int endIn) throws InvaliPutException {

        if(postOrder == null || InOrder == null || postOrder.length != InOrder.length)
            throw new InvaliPutException("输入无效");

        System.out.println(endPOst);
        TreeNode root = new TreeNode(postOrder[endPOst]);


        if(startPost == endPOst)
        {
            if(startIn == endIn && postOrder[startPost] == InOrder[startIn])
                return  root;
            else
                throw new InvaliPutException("输入无效");
        }

        int rootIndex = startIn;
        while(rootIndex <= endIn && InOrder[rootIndex] != root.value)
            rootIndex++;


       // int leftLength = rootIndex - startIn;
       // int leftPostStartIndex = endPOst + leftLength;
        int rightLength = endIn - rootIndex;
        int rightPostStartIndex = endPOst -rightLength;

        if(rightLength >0 )
            root.right = reBuildBinTree(postOrder,rightPostStartIndex,endPOst-1,InOrder,rootIndex+1,endIn);
        if( endPOst-1- rightLength >0)
            root.left = reBuildBinTree(postOrder,startPost,rightPostStartIndex-1,InOrder,startIn,rootIndex-1);

        return  root;

    }

}

package chapter4.com;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static chapter4.com.Question36.*;
/**
 * @author:xiehcao
 * @Date:2018/5/7
 * @Time:9:42
 * @description：
 */
public class Question37 {
    List<String> list = new ArrayList<>();

    /*递归*/
    List<String> Serialize(TreeNode pRoot)
    {
        if(pRoot == null)
        {
            list.add("$");
            return list;
        }
        list.add(pRoot.val+"");
        Serialize(pRoot.left);
        Serialize(pRoot.right);
        return list;
    }

    /*Morris 前序遍历*/
    List<String> SerializeByMorris(TreeNode pRoot)
    {
        if(pRoot == null)
        {
            list.add("$");
            return list;
        }
        TreeNode cur = pRoot;
        TreeNode temp = null;
        while(cur != null)
        {
            if(cur.left == null)
            {
                list.add(cur.val+"");
                if(cur.left == null)
                    list.add("$");
                if(cur.right == null)
                    list.add("$");
                cur = cur.right;
            }else{
                temp = cur.left;
                while(temp.right != null && temp.right != cur)
                    temp = temp.right;
                if(temp.right == null)
                {
                    list.add(cur.val+"");
                    if(cur.left == null)
                        list.add("$");
                    if(cur.right == null)
                        list.add("$");
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    temp.right = null;
                    cur = cur.right;
                }

            }
        }
        return  list;
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

        List<String> list = SerializeByMorris(root);
        System.out.println(list);

    }

}

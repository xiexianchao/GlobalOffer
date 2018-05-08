package chapter4.com;

import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/5/7
 * @Time:10:05
 * @description：
 */
import chapter4.com.Question36.*;
import org.junit.Test;

public class Question37_2 {
    TreeNode root;


    int index = 0;
    TreeNode Deserialize(String str)
    {
        String[] sequence = str.split(",");
        TreeNode  node = null;
        if(!"$".equals(sequence[index]))
        {
            node = new TreeNode(Integer.parseInt(sequence[index]));
            index++;
            node.left = Deserialize(str);
            index++;
            node.right = Deserialize(str);
        }
        return node;
    }


    @Test
    public void test1()
    {
        TreeNode root = Deserialize("8,6,5,$,$,7,$,$,10,9,$,$,11,$,$");
        assert(root.val == 8);


    }
}

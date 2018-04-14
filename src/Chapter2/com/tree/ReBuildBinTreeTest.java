package Chapter2.com.tree;

import Chapter2.com.exception.InvaliPutException;
import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/13
 * @Time:19:29
 * @description：
 */
public class ReBuildBinTreeTest {
    @Test
    public void test1() throws InvaliPutException {
        int[] post = new int[]{7,4,2,5,8,6,3,1};
        int[] In = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root=ReBuildBinTree.reBuildBinTree(post,0,post.length-1,
                In,0,In.length-1);
        System.out.println();
    }
}

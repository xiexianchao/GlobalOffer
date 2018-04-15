package Chapter2.com.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/4/15
 * @Time:9:15
 * @description：面试题12 矩阵中的路径
 */
public class BackTrack {
    public boolean hasPath(char[][] nums,String str)
    {
        if(null == nums || nums.length <= 0 || str.length()<=0)
            return false;

        Boolean[][] visited = new Boolean[nums.length][nums[0].length];
        for (int i = 0; i < visited.length ; i++) {
            Arrays.fill(visited[i],false);
        }
        int[] length = {0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if(hasPathCore(nums,i,j,length,str,visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathCore(char[][] nums, int row, int clomun,int[] stringLength, String str, Boolean[][] visited) {
       if(stringLength[0]>=str.length())
           return true;

        int rows = nums.length;
        int cols = nums[0].length;

        boolean hasPath = false;

        if(row>=0&&row<rows &&clomun>= 0&& clomun<cols && str.charAt(stringLength[0])==nums[row][clomun] &&
                !visited[row][clomun])
        {
            ++stringLength[0];
            visited[row][clomun] = true;

            hasPath = hasPathCore(nums,row,clomun-1,stringLength,str,visited)
                    ||hasPathCore(nums,row-1,clomun,stringLength,str,visited)||
                      hasPathCore(nums,row,clomun+1,stringLength,str,visited)
                    ||hasPathCore(nums,row+1,clomun,stringLength,str,visited);

            if(!hasPath)
            {
                stringLength[0]--;     /**/
                visited[row][clomun] = false;
            }
        }
        return hasPath;
    }

    @Test
    public void test()
    {
        char[][] nums = new char[3][4];
        nums[0] = new char[]{'a','b','t','g'};
        nums[1] = new char[]{'c','f','c','s'};
        nums[2] = new char[]{'j','d','e','h'};
        System.out.println(hasPath(nums,"bfce")); /*true*/
        System.out.println(hasPath(nums,"acfctgsh"));/*true*/
        System.out.println(hasPath(nums,"afeh")); /*false*/
        System.out.println(hasPath(nums,""));   /*false*/
        System.out.println(hasPath(nums,"abfcs")); /*true*/
        System.out.println(hasPath(nums,"abg")); /*false*/
    }


}

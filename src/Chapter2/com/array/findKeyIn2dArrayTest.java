package Chapter2.com.array;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/9
 * @Time:21:57
 * @description：面试题4：二维数组中的查找
 */
public class findKeyIn2dArrayTest {
    public boolean findKeyIn2Array(int[][] nums,int key)
    {
        //return method1(nums, key);
        if(null == nums||nums.length<=0)
            return false;
        if(key<nums[0][0]||key>nums[nums.length-1][nums[0].length-1])
            return false;

        int row=0;
        int column=nums[0].length-1;
        int rows=nums.length;
        int cols=nums[0].length;
        while(row<rows&&column>=0)
        {
            if(nums[row][column]>key)
                column--;
            else if(nums[row][column]<key)
                row++;
            else
                return true;
        }
        return false;


    }

    /*自己写的代码自己都不想看，太乱了*/
    private boolean method1(int[][] nums, int key) {
        if(null == nums||nums.length<=0)
            return false;
        if(key<nums[0][0]||key>nums[nums.length-1][nums[0].length-1])
            return false;
        int j=nums[0].length-1;
        for (int i = 0; i <nums.length&j>=0;) {
            for ( ;j>=0;)
            {
                if(nums[i][j]>key)
                    j--;
                else if(nums[i][j]<key)
                {
                    i++;
                    break;
                }
                else
                    return true;
            }
        }
        return false;
    }

    @Test
    public void test()
    {
        int[][] arr=new int[4][];
        arr[0] = new int[]{1,2,8,9};
        arr[1] = new int[]{2,4,9,12};
        arr[2] = new int[]{4,7,10,13};
        arr[3] = new int[]{6,8,11,15};
        System.out.println(findKeyIn2Array(arr,11));
        System.out.println(findKeyIn2Array(arr,3));

    }


}

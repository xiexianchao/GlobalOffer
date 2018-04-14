package Chapter2.com.algorithm;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:15:30
 * @description：
 */
public class FillRectang {

    public int getNums(int target)
    {
        if(target<=0)
            return 0;
        else if(target==1)
            return 1;
        else if(target==2)
            return 2;
        else{
            int[] nums = new int[target+1];
            nums[1] = 1;
            nums[2] = 2;
            for (int i = 3; i < nums.length ; i++) {
                nums[i] = nums[i-1] + nums[i-2];
            }
            return nums[target];
        }
    }
    @Test
    public void test()
    {
        System.out.println(getNums(3));
    }

}

package Chapter2.com.algorithm;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:14:57
 * @description：
 */
public class Fibonacci {

    public long  getFibonacci(int n)
    {
        if(n<=0)
            return 0;
        else if(n==1)
            return 1;

        long[] nums = new long[n+1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i-2];
            System.out.println(nums[i]);
        }
        return nums[n];

    }

    @Test
    public void test1()
    {
        System.out.println(getFibonacci(5000));
    }


}

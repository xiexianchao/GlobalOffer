package chapter5.com;

import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.io.InvalidClassException;

/**
 * @author:xiehcao
 * @Date:2018/5/11
 * @Time:15:57
 * @description：
 */
public class Question42 {
    public int findMaxSumOfSubArray(int[] nums) throws InvalidClassException {
        if(nums == null || nums.length <=0)
            throw new InvalidClassException("输入无效");
        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = sum>0?sum+nums[i]:nums[i];
            if(sum >= maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
    @Test
    public void test1() throws InvalidClassException {
        int[] arr = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(findMaxSumOfSubArray(arr));
    }




}

package chapter6.com;

import org.junit.Test;

import java.io.InvalidClassException;

/**
 * @author: xiehcao
 * @Date : 2018/5/21
 * @Time:  9:42
 * @description： 数组中数值和下标相等的元素
 */
public class Question53_3 {
    /**
     *
     * @param numbers 递增数组
     * @return 返回数组中索引等于数值的元素
     */

    public int getNumberSameAsIndex(int[] numbers) {
        if(numbers == null || numbers.length <= 0)
           return -1;

        int start = 0;
        int end = numbers.length-1;
        while( start <= end)
        {
            int mid = (start + end) >>>1;
            if(numbers[mid] < mid)
            {
                start = mid + 1;
            }else if(numbers[mid] > mid)
            {
                end = mid -1;
            }else
                return mid;
        }

        return -1;
    }
    @Test
    public void test1()
    {
        System.out.println(getNumberSameAsIndex(new int[]{-3,-1,1,3,5}));
        System.out.println(getNumberSameAsIndex(new int[]{-2,0,1,2,3,5}));
    }
}

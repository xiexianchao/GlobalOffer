package chapter6.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date: 2018/5/21
 * @Time: 9:21
 * @description： 查找0-n-1中缺失的数字
 */
public class Question53_2 {


    /***
     *
     * @param numbers 长度为n-1的排序数组所有数字都是唯一的，
     *                并且每个数字都在0-n-1范围内
     * @return 返回缺失的那个数字
     */
    private int getMissingNumber(int[] numbers)
    {
        if(numbers == null || numbers.length ==0)
            return -1;
        int start = 0;
        int end = numbers.length-1;

        while(start <= end)
        {
            int mid = (start + end) >>> 1;
          if(numbers[mid] != mid)
          {
              if(mid == 0 || numbers[mid-1] == mid-1)
                  return mid;
              else
                  end = mid -1;
          }else{
              start = mid + 1;
          }
        }
        if(start == numbers.length)
            return start;
        return -1;
    }

    @Test
    public void test1()
    {
        System.out.println(getMissingNumber(new int[]{1,2,3,4,5,6}));
        System.out.println(getMissingNumber(new int[]{0,1,2,3,4}));
        System.out.println(getMissingNumber(new int[]{0,1,3,4,5}));
    }

}

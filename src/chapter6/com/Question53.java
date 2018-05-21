package chapter6.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/21
 * @Time:8:49
 * @description：
 */
public class Question53 {

    /***
     *
     * @param numbers 排序数组
     * @param key 目标
     * @return 目标在排序数组中出现的次数
     */
    public int getCounts(int[] numbers, int key)
    {
        if(numbers == null || numbers.length <= 0)
            return 0;

        int firstIndex = getFirstKey(numbers,key);
        int lastIndex = getLastKey(numbers,key);
            if(firstIndex >=0 && lastIndex >=0)
                return lastIndex-firstIndex+1;
        return 0;
    }

    private int getFirstKey(int[] numbers,int key)
    {
        int start = 0;
        int end = numbers.length-1;

        while(start <= end)
        {
            int mid = (start+end) >>> 1;
            if(numbers[mid] > key)
            {
                end = mid -1;
            }else if(numbers[mid] < key)
            {
                start = mid + 1;
            }else{
               if(mid == 0 || numbers[mid-1] != key)
                   return mid;
               else
                   end = mid-1;
            }
        }
        return -(start+1);
    }
    private int getLastKey(int[] numbers,int key)
    {
        int start = 0;
        int end = numbers.length-1;

        while(start <= end)
        {
            int mid = (start+end) >>> 1;
            if(numbers[mid] > key)
            {
                end = mid -1;
            }else if(numbers[mid] < key)
            {
                start = mid + 1;
            }else{
                if(mid == numbers.length-1 || numbers[mid+1] != key)
                    return mid;
                else
                    start = mid+1;
            }
        }
        return -(start+1);
    }

    @Test
    public void test1()
    {

        int[] numbers = new int[]{1,2,3,3,3,4,5};
        System.out.println(getFirstKey(numbers,3));
        System.out.println(getLastKey(numbers,3));



    }
}

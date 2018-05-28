package chapter6.com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiehcao
 * @Date : 2018/5/23
 * @Time : 16:32
 * @description :输入一递增数组，求和为sum的两个数字
 */
public class Question57 {

    /**
     *
     * @param data
     * @param key
     * @return 不存在这样的两个数字，返回空的list，存在，返回任意一组
     */
    public List<Integer> findNumbersWithSum(int[] data,int key)
    {
        List<Integer> list = new ArrayList<>();
        if(data == null || data.length <= 1)
            return list;
        int left = 0;
        int right = data.length-1;
        while(left < right)
        {
            int sum = data[left] + data[right];
            if(sum > key)
                right--;
            else if(sum < key)
                left++;
            else
            {
                list.add(data[left]);
                list.add(data[right]);
                break;
            }
        }
        return list;
    }




    @Test
    public void test1()
    {
        long start1 = System.nanoTime();
       findNumbersWithSum(new int[]{1,2,3,4,4,5,6},5);
       long count1 = System.nanoTime() - start1;
       System.out.println("方法一花费："+count1);




    }

}

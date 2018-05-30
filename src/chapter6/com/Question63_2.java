package chapter6.com;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/5/30
 * @Time : 15:09
 * @description :可以交易多次，每天都可以买卖
 */
public class Question63_2 {
    public int getMaxProfit(int[] numbers)
    {
        int max = 0;
        if(numbers  == null || numbers.length <2)
            return max;
        //max += numbers[1] - numbers[0];
        for (int i = 0; i <numbers.length-1 ; i++) {
            if(numbers[i+1] > numbers[i])
                max += numbers[i+1] - numbers[i];
        }
        return max;
    }
    @Test
    public void test1()
    {
        System.out.println(getMaxProfit(new int[]{10, 3, 5, 10, 3, 5, 6, 5, 6, 4, 7, 1}));
    }
}

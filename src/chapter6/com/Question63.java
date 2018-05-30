package chapter6.com;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/5/30
 * @Time : 14:52
 * @description :只可交易一次，求股票的最大利润。
 */
public class Question63 {

    /**
     *
     * @param price 为每天股票的价格，只可买卖一次
     * @return
     */
    public int getMaxProfit(int[] price)
    {
        int maxProfit = 0;
        if(price == null || price.length <2)
                return maxProfit;
        int minPrice = price[0];
        int profit = price[1] - price[0];
        for (int i = 2; i < price.length ; i++) {
            if(price[i-1] < minPrice)
                minPrice = price[i-1];
            profit = price[i] - minPrice;
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
    @Test
    public void test1()
    {
        System.out.println(getMaxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(getMaxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}

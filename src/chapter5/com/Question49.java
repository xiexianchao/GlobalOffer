package chapter5.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/17
 * @Time:15:14
 * @description：
 */
public class Question49 {

    public int getUglyNumber2(int index)
    {
        if(index <=0)
            return 0;
        int[] uglyNumbers = new int[index+1];
        uglyNumbers[0] = 1;

        int min2Ugly = uglyNumbers[0];
        int min3Ugly = uglyNumbers[0];
        int min5Ugly = uglyNumbers[0];

        int count  =1;
        while(count < uglyNumbers.length)
        {
            uglyNumbers[count] = Math.min(Math.min(min2Ugly,min3Ugly),min5Ugly);
           // count ++ ;

            while(min2Ugly * 2 <=uglyNumbers[count])
                    min2Ugly++;
            while(min3Ugly * 3 <= uglyNumbers[count])
                   min3Ugly++;
            while(min5Ugly*5 <= uglyNumbers[count])
                min5Ugly++;

            count++;
        }

        return uglyNumbers[index];
    }




    /*暴力解法：不推荐*/
    public int getUglyNumber(int index)
    {
        if(index == 0)
            return 0;
        int number = 0;
        int uglyFound  = 0;
        while(uglyFound <index)
        {
            ++ number;
            if(isUgly(number))
            {
                uglyFound++;
            }

        }

        return number;

    }
    private boolean isUgly(int number) {
        while(number % 2 ==0)
            number = number /2;
        while(number % 3 == 0)
            number = number /3;
        while(number %5 == 0)
            number = number /5;

        return number == 1;
    }

    @Test
    public void test1()
    {
        System.out.println(getUglyNumber(1500));

        System.out.println(getUglyNumber(1500));

    }


}

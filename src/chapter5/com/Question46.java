package chapter5.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/13
 * @Time:11:18
 * @description：
 */
public class Question46 {
    int count = 0;


    /*递归*/
    public int getTranslationCount(int number)
    {
        if(number <=0)
            return 0;
        if(number == 1)
            return  1;
        core((number+"").toCharArray(),0);
        return count;

    }

    private void core(char[] numbers, int begin) {
            if(numbers == null || numbers.length<=0)
                return;
            if(begin >= numbers.length-1)
            {
                count++;
                return;
            }
            int temp = (numbers[begin]-'0')*10+numbers[begin+1]-'0';
            if(temp <= 25 && temp >= 10)
            {
                core(numbers,begin+2);
                core(numbers,begin+1);
            }
            else
                core(numbers,begin+1);
    }

    /*递归简化*/
    public int getTranslationCount2(int number)
    {
        if(number <0 )
            return  0;
        return core2((number+"").toCharArray(),0);
    }

    private int core2(char[] numbers, int begin) {
        if(begin >= numbers.length-1)
            return 1;
        int temp = (numbers[begin]-'0')*10+numbers[begin+1]-'0';
        if(temp<=25 && temp >=10)
            return core2(numbers,begin+1)+core2(numbers,begin+2);
        else
            return core2(numbers,begin+1);
    }


    /*迭代*/
    public int getTranslationCount3(int number)
    {
        if(number <0)
            return 0;
        if(number == 0)
            return 1;
        String str = number + "";
        char[] arr = str.toCharArray();
        int[] counts = new int[arr.length];
        int count = 0;
        for (int i = arr.length-1; i >=0 ; i--)
        {
            count = 0;
            if(i<arr.length-1)
                count = counts[i+1];
            else
                count = 1;
            if(i<arr.length-1)
            {
                int temp = (arr[i]-'0')*10+(arr[i+1]-'0');
                if(temp >= 10 && temp <=25)
                {
                    if(i < arr.length-2)
                        count = count + counts[i+2];
                    else
                        count = count + 1;
                }
            }
            counts[i] = count;
        }
        return counts[0];

    }




    @Test
    public void test1()
    {
        System.out.println(getTranslationCount(12558));
        System.out.println(getTranslationCount2(12558));
        System.out.println(getTranslationCount3(12558));
        System.out.println(getTranslationCount3(12258));
    }


}

package chapter5.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/13
 * @Time:10:08
 * @description：
 */
public class Question44 {
    public int digitAtIndex(int index)
    {
        int digits = 1;
        if(index < 0)
            return -1;
        while(true)
        {
            int numbers = countOfIntegers(digits);
            if(index < numbers*digits)
            {
                return digitAtIndex(index,digits);
            }
            index = index - numbers*digits;
            digits ++;
        }
    }

    private int countOfIntegers(int digits) {
        if(digits==1)
            return 10;
        else{
            return (int) (Math.pow(10,digits-1)*9);
        }
    }

    private int digitAtIndex(int index ,int digits)
    {
        int count = index / digits;
        int temp = (int) (Math.pow(10,digits-1)+count);
        int indexFromRight = digits - index%digits;
        for (int i = 0; i <indexFromRight ; i++) {
            temp = temp /10;
        }
        return temp%10;

    }

    @Test
    public void test1(){
       System.out.println(digitAtIndex(1001));
    }






}

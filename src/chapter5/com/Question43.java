package chapter5.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/11
 * @Time:16:03
 * @description：
 *
 *
 *
 */
public class Question43 {
    /*暴力解法*/
    public int numberOf1Between1AndN(int n)
    {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numberOf1(i);
        }
        return result;
    }
    private int numberOf1(int number)
    {
        int count = 0;
        while(number != 0)
        {
           if((number %10) == 1)
                count ++;
           number =number/10;
        }
        return count;
    }

    /*剑指Offer：基于数字规律*/
    public int numberOf1Between1AndN2(int n)
    {
        if(n<=0)
            return 0;
        return numberOf1((n+"").toCharArray());





    }

    private int numberOf1(char[] strN) {
        if(strN == null || strN.length == 0)
            return 0;
        char top = strN[0];
        int first = top - '0';
        if(strN.length == 1 && first == 0)
            return 0;
        if(strN.length == 1 && first > 0) /*0---first*/
            return 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < strN.length; i++) {
            stringBuilder.append(strN[i]);
        }
        String nextString = stringBuilder.toString();

        int numFirstDigit = 0;
        if(first > 1)
            numFirstDigit = (int) Math.pow(10,strN.length-1);
        else if(first == 1)
           // numFirstDigit = 1 + Integer.parseInt(new String((strN)))-(int) Math.pow(10,strN.length-1);
            numFirstDigit = 1 +Integer.parseInt(nextString);

        int numOthersDigits = (int) (first*(strN.length-1)*Math.pow(10,strN.length-2));
        int numRecursive = numberOf1(nextString.toCharArray());

        return numFirstDigit+numOthersDigits+numRecursive;
    }


    @Test
    public void test1()
    {
        System.out.println(numberOf1Between1AndN2(21345));

        System.out.println(numberOf1Between1AndN2(12));
    }


}

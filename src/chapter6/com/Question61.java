package chapter6.com;

import org.junit.Test;

import java.util.Arrays;

public class Question61
{
    private static final int arrSize = 5;

    /***
     * @function 求任意的5张扑克是否为顺子，大小王为赖子
     * @param number 输入数组要求长度为arrSize
     *               并且所有元素都在0-13范围内
     * @return
     */
    public boolean isContinous(int[] number)
    {
        boolean result = false;

        if(number != null && number.length == arrSize)
        {

            int[] counts = new int[14];
            Arrays.fill(counts,0);
            for (int i = 0; i <number.length ; i++) {
                if(number[i] <0 || number[0] >13)
                    break;
                else
                    counts[number[i]]++;
                if( number[i] !=0 && counts[number[i]] >1)
                    return false;
            }
            int zeroSize = counts[0];
            Arrays.sort(number);  //nlogn
            for (int i = zeroSize; i <number.length-1 ; i++) {
                zeroSize -= number[i+1] - number[i]-1;
            }
            if (zeroSize >=0)
                result = true;
        }
        return result;
    }
    @Test
    public void test1()
    {
        System.out.println(isContinous(new int[]{0,5,8,4,0}));
        System.out.println(isContinous(new int[]{1,0,0,1,0}));   /*除了0之外有重复的数字不能为顺子*/
    }

}

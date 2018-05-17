package chapter5.com;

import Chapter2.com.exception.InvaliPutException;
import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/8
 * @Time:17:29
 * @description：
 */
public class Question39 {
    int MoreThanHalfNum(int[] numbers) throws InvaliPutException {
        if(numbers == null || numbers.length == 0)
            throw new InvaliPutException("输入无效");
        int middle = numbers.length>>>1;
        int start = 0;
        int end = numbers.length - 1;
        int index = partition(numbers,start,end);
        while(index != middle)
        {
            if(index > middle)
            {
                 index = partition(numbers,start,index-1);
            }
            else{
                index = partition(numbers,index+1,end);
            }

        }
        int result = numbers[index];
        if(!check(numbers,result))
            throw new InvaliPutException("输入无效");
        return result;

    }

    private boolean check(int[] numbers, int result) {
        int  count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(result == numbers[i])
                count++;
        }
        if(count > (numbers.length>>>1))
            return true;
        return false;
    }

    int partition(int[] numbers,int start,int end)
    {
        int value = numbers[start];
        while(start<end)
        {
            while(start<end && numbers[end] > value)
                end--;
            swap(numbers,start,end);
            while(start<end && numbers[start] <=value)
                start++;
            swap(numbers,start,end);
        }
        numbers[start] = value;
        return start;


    }

    private void swap(int[] numbers, int start, int end) {
        int temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
    }


    /*剑指Offer上的Moore's voting Algorithm*/
    int MoreThanHalfNum2(int[] numbers) throws InvaliPutException
    {
        if(numbers == null || numbers.length <=0)
            throw new InvaliPutException("无效输入");
        int count = 1;
        int reslut = numbers[0];

        for (int i = 1; i < numbers.length ; i++) {
            if(count == 0)
            {
                reslut = numbers[i];
                count = 1;
            }
            if(reslut != numbers[i])
            {
                count--;
            }
            else
                count++;
        }
        return  reslut;

    }


    @Test
    public void test1() throws InvaliPutException {
        int[] num = new int[]{2,1,1,4,3,2,2,2,2};
        System.out.println(MoreThanHalfNum(num));
        System.out.println(MoreThanHalfNum2(num));
    }
}

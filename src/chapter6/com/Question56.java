package chapter6.com;

import org.junit.Test;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiehcao
 * @Date : 2018/5/22
 * @Time : 21:08
 * @description :求数组中出现一次的两个数字
 */
public class Question56 {


    /**
     * @param data 输入数组出了一个数组出现一次，其他数字都出现两次
     * @return 返回数组中只出现一次的数字
     * @throws InvalidClassException
     */
    private int getAppearOnce(int[] data) throws InvalidClassException {
        if(data == null || data.length <= 0)
            throw new InvalidClassException("输入无效");
        int temp = 0;
        for (int e:data) {
            temp ^= e;
        }
        return temp;
    }


    /**
     *
     * @param data
     * @return
     * @description： 输入一个数组，返回数组中出现次数为一次的两个数字
     */
    List<Integer> findNumbersAppearOnce(int[] data)
    {
        List<Integer> list = new ArrayList<>();
        if(data == null || data.length <=0)
            return list;
        int temp = 0;
        for (int e: data) {
            temp ^= e;
        }
        int n = findFirstBitIs1(temp);
        int num1 = 0;
        int num2 = 0;
        for (int e:data) {
            if(isBit1(e,n))
                num1 ^=e;
            else
                num2 ^=e;
        }
        list.add(num1);
        list.add(num2);
        return list;
    }

    private boolean isBit1(int e, int n) {
        e = e>>>n;
        return (e&1)!=0;
    }

    private int findFirstBitIs1(int temp) {
        int count = 0;
        while((temp&1)==0)
        {
            count++;
            temp = temp>>>1;
        }
        return count;
    }


    @Test
    public void test1() throws InvalidClassException {
        System.out.println(getAppearOnce(new int[]{2,4,3,3,2,5,5}));
        System.out.println(findNumbersAppearOnce(new int[]{2,4,3,3,2,5,5,6}));
    }


}

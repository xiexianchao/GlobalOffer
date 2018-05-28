package chapter6.com;

import org.junit.Test;

import java.io.InvalidClassException;

/**
 * @author: xiehcao
 * @Date : 2018/5/22
 * @Time : 21:33
 * @description :数组中其他数字都出现三次，找出数组中唯一出现一次的数字
 */
public class Question56_2 {

    /**
     *
     * @param number
     * @return 返回数组中唯一出现一次的数字
     * @throws InvalidClassException
     */
    public int findNumberAppearOnce(int[] number) throws InvalidClassException {
        if(number == null && number.length <=0)
            throw new InvalidClassException("输入无效");

        int[] bitSum = new int[32];

        for (int i = 0; i < number.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >=0 ; j--) {
                int bit = number[i] & bitMask;
                if(bit !=0)
                    bitSum[j] +=1;
                bitMask = bitMask<<1;
            }
        }
        int result = 0;
        for (int i = 0; i <32 ; i++) {
            result = result <<1;
            result += bitSum[i]%3;
        }
        return result;
    }
    @Test
    public void test1() throws InvalidClassException {
        System.out.println(findNumberAppearOnce(new int[]{2,3,3,3,2,2,111}));
    }

}

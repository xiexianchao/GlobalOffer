package chapter4.com;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/5/8
 * @Time:15:53
 * @description：回溯法请看Question38_5
 */
public class Question38_4 {
    public int eightQueen(int n)
    {
        int[] positionColunm = new int[n];
        for (int i = 0; i < positionColunm.length ; i++) {
            positionColunm[i] = i;
        }
        return eightQueenCore(positionColunm,0);
    }

    /*全排列方式*/
    private int eightQueenCore(int[] positionColunm, int begin) {
            int count = 0;
            if(begin == positionColunm.length)
            {
                for (int i = 0; i < positionColunm.length ; i++) {
                    for (int j = i+1; j < positionColunm.length ; j++) {  /*要从i+1开始检测，不能从i开始检测*/
                        if(j-i == Math.abs(positionColunm[j]-positionColunm[i]))
                                return count;
                    }
                }
                System.out.println(Arrays.toString(positionColunm));
                count++;

            }else{
                for (int i = begin; i < positionColunm.length; i++) {
                    int temp = positionColunm[i];
                    positionColunm[i] = positionColunm[begin];
                    positionColunm[begin] = temp;

                    count += eightQueenCore(positionColunm, begin+1);

                    temp = positionColunm[i];
                    positionColunm[i] = positionColunm[begin];
                    positionColunm[begin] = temp;
                }
            }
            return count;
    }


    @Test
    public void tets1()
    {
        System.out.println(eightQueen(11));
    }

}

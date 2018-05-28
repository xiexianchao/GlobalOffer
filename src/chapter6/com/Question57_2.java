package chapter6.com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiehcao
 * @Date : 2018/5/23
 * @Time : 16:42
 * @description :和为s的连续序列
 */
public class Question57_2 {

    /**
     *
     * @param sum
     * @return： 返回所有和为sum的连续正数序列
     *      不存在返回空的List
     */
    public List<List<Integer>> findContinousSequence(int sum)
    {
        List<List<Integer>> list = new ArrayList<>();
        if(sum <= 0)
            return list;
        int small = 1;
        int big = 2;
        int bound = (sum>>>1) + (sum&1);
        int temp = small + big;

        while(small < bound)
        {
            if(temp == sum)
            {
                List<Integer> pairs = new ArrayList<>();
                for (int i = small; i <= big ; i++) {
                    pairs.add(i);
                }
                list.add(pairs);
            }
            while(temp > sum && small <bound)
            {

                temp -=small;
                small++;
                if(temp == sum)
                {
                    List<Integer> pairs = new ArrayList<>();
                    for (int i = small; i <= big ; i++) {
                        pairs.add(i);
                    }
                    list.add(pairs);
                }
            }
            big++;
            temp +=big;
        }
        return list;
    }

    @Test
    public void test1()
    {
        System.out.println(findContinousSequence(15));
    }
}

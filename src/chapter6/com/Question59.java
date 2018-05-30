package chapter6.com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiehcao
 * @Date : 2018/5/28
 * @Time : 10:05
 * @description : 队列的最大值
 */
public class Question59 {

    /**
     *
     * @param nums
     * @param size
     * @return
     * @function 输入一个数组和一个size,求出以size为窗口大小，每个窗口的最大值
     */
    List<Integer> getMaxInWindows(int[] nums ,int size)
    {
        List<Integer> list = new ArrayList<>();

        if(nums !=null && nums.length > size && size >=1)
        {
            Deque<Integer> index = new LinkedList<>();
            for (int i = 0; i <size ; i++) {
                while(!index.isEmpty() && nums[i] > nums[index.peekLast()])
                {
                    index.pollLast();
                }
                index.offerLast(i);
            }
            for (int i = size; i < nums.length; i++) {
                list.add(nums[index.getFirst()]);
                while(! index.isEmpty() && nums[i] > nums[index.peekLast()])
                        index.pollLast();
                while(! index.isEmpty() && i >= index.peekFirst() + size)
                    index.pollFirst();
                index.offerLast(i);
            }
            list.add(nums[index.peekFirst()]);
        }
        return list;
    }
    @Test
    public void test1()
    {
        System.out.println(getMaxInWindows(new int[]{2,3,4,2,6,2,5,1},3));


    }




}

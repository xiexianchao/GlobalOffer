package chapter5.com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author:xiehcao
 * @Date:2018/5/8
 * @Time:20:56
 * @description：
 */
public class Question40 {
    /*O(n)  可以修改数组*/
    List<Integer> getLeastKthNumber(int[] numbers, int k)  {

        List<Integer> list = new ArrayList<>();

        if(numbers == null || numbers.length <=0 || k<=0 ||k >numbers.length)
        {
            return list;
        }
       // if(k>numbers.length) k = numbers.length;

        int index = partition(numbers,0,numbers.length-1);
        int start = 0;
        int end = numbers.length-1;
        while(index !=k-1)
        {
            if(index > k-1)
                index=partition(numbers,start,index-1);
            if(index <k-1 )
                index=partition(numbers,index+1,end);

        }

        for (int i = 0; i <k ; i++) {
            list.add(numbers[i]);
        }
        return list;

    }

    int partition(int[] numbers,int start,int end)
    {
        int value = numbers[start];
        while(start<end)
        {
            while(start<end && numbers[end] >= value)
                end--;
            swap(numbers,start,end);
            while(start<end && numbers[start] < value)
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

    List<Integer> getLeastKthNumber2(int[] numbers,int k)
    {
        List<Integer> list = new ArrayList<>();

        if(numbers == null || numbers.length <=0 || k<=0 || k >numbers.length)
        {
            return list;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            set.add(numbers[i]);
        }
        for (int i = 0; i < k ; i++) {
            list.add(set.pollFirst());
        }
        return list;

    }


    @Test
    public void test1() {
        int[] numbers = new int[]{9,8,7,6,5,4,3,2,1};
        System.out.println(getLeastKthNumber(numbers,4));
        System.out.println(getLeastKthNumber(numbers,0));
        System.out.println(getLeastKthNumber(numbers,10));

        System.out.println(getLeastKthNumber2(numbers,4));


    }

}

package sort.com;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/5/17
 * @Time:16:01
 * @description：
 */
public class Sort {
    public static void mergerSort(int [] num)
    {
        if (num == null || num.length<=0)
            return;

        sort(num,0,num.length-1);


    }
    private static void sort(int[] num,int start,int end)
    {
        if(start >= end)
            return;
        int mid = start+((end - start)>>>1);
        sort(num,start,mid);
        sort(num,mid+1,end);
        merger(num,start,mid,end);
    }
    private static void merger(int[] num, int start, int mid, int end)
    {
        int[] copy = new int[end -  start +1];
        int indexCpoy = copy.length-1;
        int i = mid;
        int j = end;
        while(i>= start && j>=mid+1)
        {
            if(num[i] > num[j])
                copy[indexCpoy--] = num[i--];
            else
                copy[indexCpoy--] = num[j--];
        }

        for(;i >=start;i--)
            copy[indexCpoy--] = num[i];
        for(;j >= mid+1;j--)
            copy[indexCpoy--] = num[j];
        for (int k = 0; k <copy.length; k++) {
            num[start+k] = copy[k];
        }
    }

    @Test
    public void test1()
    {
        int[] arr = new int[]{9,8,7,5,8,4,3,1,2};
        mergerSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}

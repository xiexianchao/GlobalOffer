package chapter5.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/17
 * @Time:16:28
 * @description：
 */
public class Question51 {
    public int getInversePairs(int[] nums)
    {
        if(nums == null || nums.length <=0)
            return 0;
        //int[] copy = new int[nums.length];
       // int count = inversePairsCore(nums,copy,0,nums.length-1);
       // return count;
        int count = inversePairsCore(nums,0,nums.length-1);
        return count;

    }

    private int inversePairsCore(int[] nums, int start, int end) {
        if(start >= end)
            return 0;
        int mid = (end+start)/2;

        int left = inversePairsCore(nums,start,mid);
        int right = inversePairsCore(nums,mid+1,end);
        int count = merger(nums,start,mid,end);

        return left+right+count;

    }

    private int merger(int[] nums, int start, int mid, int end) {
        int i = mid;
        int j = end;
        int count = 0;
        int[] copy = new int[end-start+1];
        int indexCopy = copy.length-1;

        while(i >= start && j>= mid+1)
        {
            if(nums[i] > nums[j])
            {
                copy[indexCopy--] = nums[i--];
                count += j - mid;
                //i--;
            }else{
                copy[indexCopy--] = nums[j--];
               // j--;
            }
        }
        for (; i >= start ; i--) {
            copy[indexCopy--] = nums[i];
        }
        for (; j >= mid+1 ; j--) {
            copy[indexCopy--] = nums[j];
        }
        for (int k = 0; k < copy.length; k++) {
            nums[start+k] = copy[k];
        }

        return count;
    }


    @Test
    public void test1()
    {
        System.out.println(getInversePairs(new int[]{7,5,6,4}));

    }


}

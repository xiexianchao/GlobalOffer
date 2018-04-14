package Chapter2.com.array;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/9
 * @Time:20:02
 * @description：面试题3 题目二 同leetcode287
 * 二分法思想：时间复杂度为O(nlogn) ，空间复杂度为O(1)
 *
 * 还有时间复杂度为O(n)，空间复杂度为O(1)的方法
 */
public class findDuplicateInArray {
    public int findDuplicate(int[] nums)
    {
       /* if(null == nums || nums.length<=0)
            return -1;
        int n=nums.length;
        int slow=n;
        int fast=n;
        do{
            slow=nums[slow-1];
            fast=nums[nums[fast-1]-1];
        }while(nums[slow] !=nums[fast]);

        slow=n;
        while(slow !=fast){
            slow=nums[slow-1];
            fast=nums[fast-1];
        }
        return slow;*/
       if(null == nums || nums.length<=0)
           return -1;
       int slow=0;
       int fast=0;
       do {
           slow=nums[slow];
           fast=nums[nums[fast]];
       }while(nums[slow] != nums[fast]);

       slow=0;
       while(slow!=fast)
       {
           slow=nums[slow];
           fast=nums[fast];
       }
       return slow;


    }

    private int method1(int[] nums) {
        if(null == nums || nums.length<=0)
            return -1;
        int low=1;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int count=getCount(nums,low,mid);
            if(low==high)
            {
                if(count>1)
                    return low;
                else
                    break;
            }
            if(count>(mid-low+1))
                high=mid;
            else
                low=mid+1;
        }
        return -1;
    }

    private int getCount(int[] nums,int start,int end)
    {
        int count=0;
        for (int e:nums) {
            if(e>=start&&e<=end)
                count++;
        }
        return count;

    }
    @Test
    public void test1()
    {
        System.out.println(findDuplicate(new int[]{2,3,5,4,3,2,6,7}));


    }
}

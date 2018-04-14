package Chapter2.com.algorithm;

import Chapter2.com.exception.InvaliPutException;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:16:12
 * @description：
 */
public class FindMin {

    private int findMinInRotateArrays(int[] nums) throws InvaliPutException {
        if(null == nums)
            throw new InvaliPutException("输入无效");
        else if(nums.length==0) {
            return nums[0];
        } else{
            int low = 0;
            int high = nums.length-1;
            int mid = low;
            while(nums[low]>=nums[high])
            {
                if(high - low ==1)
                    return nums[high];
                mid =(high+low)>>>1;
                if(nums[mid] == nums[low] && nums[low] == nums[high])
                {
                    int min = Integer.MAX_VALUE;
                    for (int num : nums) {
                        min = Math.min(min, num);
                    }
                    return min;
                }

                if(nums[mid] >= nums[low])
                    low = mid;
                else if(nums[mid]<=nums[high])
                    high = mid;
            }
            return nums[mid];
        }
    }

    @Test
    public void tets1() throws InvaliPutException {
        System.out.println(findMinInRotateArrays(new int[]{3,4,5,1,2}));
        System.out.println(findMinInRotateArrays(new int[]{1,1,1,0,1}));
        System.out.println(findMinInRotateArrays(new int[]{1,2,3,3,4,5}));
        System.out.println(findMinInRotateArrays(new int[]{1,0,1,1,1}));
        System.out.println(findMinInRotateArrays(new int[]{}));

    }





}

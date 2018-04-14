package Chapter2.com.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/4/8
 * @Time:20:46
 * @description：面试题3：数组中的重复数字 注意和leetcode442的区别
 * 时间复杂度O(n),空间复杂度O(1)
 */
public class findAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums)
    {
        return  leetcode442(nums);


    }

    /*leetcode442 改写 数组长度为n，数据在0-n-1之间*/
    private List<Integer> leetcode442(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(null == nums || nums.length<=0)
            return list;
        for (int i = 0; i <nums.length ; i++) {
            int index = nums[i] >=nums.length?nums[i]-nums.length:nums[i];
            if(nums[index]>=nums.length)
                list.add(index);
            else nums[index] = nums[index]+nums.length;
        }
        return list;
    }

    //面试题3
    private List<Integer> method1(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    list.add(nums[i]);
                    break;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;

                }
            }
        }
        return list;
    }

    @Test
    public void test1()
    {
        int[] arr =new int[]{2,3,1,0,2,5,3};
        List list=findDuplicates(arr);
        System.out.println(list);

        System.out.println(findDuplicates(new int[]{3,2,1,6,7,1,2,0}));
    }




}

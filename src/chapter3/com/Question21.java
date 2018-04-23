package chapter3.com;

import org.junit.Test;

import java.util.*;

/**
 * @author:xiehcao
 * @Date:2018/4/23
 * @Time:10:24
 * @description：
 */
public class Question21 {
    public void Solution(int[] nums)
    {
        method1(nums);
        //method2(nums);
        //method1_1(nums);

    }

    /*method1的另一个版本*/
    private void method1_1(int[] nums) {
        if(nums==null||nums.length<=0)
            return;
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            while (left < right && (nums[left] & 0x1) == 1)
                left++;
            while (left < right && (nums[right] & 0x1) == 0)
                right--;
            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
    }


    /*O(n),O(n)，可以保持原始顺序*/
    private void method2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer e:nums) {
            if((e&0x1)==1)
                list.add(e);
        }
        for (Integer e:nums) {
            if((e&0x1)==0)
                list.add(e);
        }
        for (int i = 0; i <list.size() ; i++) {
            nums[i]=list.get(i);
        }
    }

    /*O(n),O(1)，但不能保持原始顺序*/
    private void method1(int[] nums) {
        if(nums==null||nums.length<=0)
            return;
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            if(((nums[left]&0x1)==0)&&((nums[right]&0x1)==1))
            {
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                right--;
                left++;
            }else if(((nums[left]&0x1)==0)&&((nums[right]&0x1)==0)){
                right--;
            }else{
                left++;
            }
        }
    }

    @Test
    public void test1()
    {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        Solution(arr);
        System.out.println(Arrays.toString(arr));
    }



    public void Solution2(int[] nums,int threshold,Comparator<Integer> comparator)
    {
        if(nums==null||nums.length<=0)
            return;
        int left = 0;
        int right = nums.length-1;
        while(left<right)
        {
            while(left<right && comparator.compare(nums[left],threshold)>0)  /*>0 为奇数*/
                left++;
            while(left<right && comparator.compare(nums[right],threshold)<0) /*<0，为偶数*/
                right--;

            if(left<right)
            {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }

        }
    }

    @Test
    public void test2()
    {
        int[] arr=new int[]{1,2,3,4,5,6,7};
        Solution2(arr,0,(a,b)->{
            if((a&0x1)!=b)
                return 1;
            else
                return -1;
        });

        System.out.println(Arrays.toString(arr));
    }



}

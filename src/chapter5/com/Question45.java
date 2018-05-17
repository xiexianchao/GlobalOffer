package chapter5.com;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/5/13
 * @Time:10:37
 * @description：
 */
public class Question45 {

    /*j剑指Offer*/
    String getMinNumber(Integer[] nums)
    {
        if(nums == null || nums.length <= 0)
            return "";
        if(nums.length == 1)
            return nums[0]+"";
/*
        ArrayList<Integer> list = new ArrayList();
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        Collections.sort(list,(obj1,obj2)->{
            String str1 = obj1+""+obj2;
            String str2 = obj2+""+obj1;
            return str1.compareTo(str2);


        });*/



        Arrays.sort(nums,(obj1,obj2)->{
            String str1 = obj1+""+obj2;
            String str2 = obj2+""+obj1;
            if(str1.compareTo(str2)>0)
                return 1;
            else if(str1.compareTo(str2)<0)
                return -1;
            else
                return 0;
        });




        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(nums[i]);
        }
/*
        for (int i = 0; i <list.size() ; i++) {
                stringBuilder.append(list.get(i));
        }*/

        return stringBuilder.toString();
    }
    @Test
    public void test1()
    {
        Integer[] arr = new Integer[]{3,32,321};
        System.out.println(getMinNumber(arr));
    }





}

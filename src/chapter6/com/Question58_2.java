package chapter6.com;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/5/23
 * @Time : 17:49
 * @description :左旋转字符串
 */
public class Question58_2 {

    private void reverseArr(char[] arr,int start,int end)
    {
        while(start < end)
        {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public String leftReverseString(String str,int key)
    {
        if(str == null)
            return null;
        if(str.length() == 0)
            return "";
        if(key > str.length() || key<0)
            return "";


        char[] arr = str.toCharArray();
        reverseArr(arr,0,key-1);
        reverseArr(arr,key,arr.length-1);
        reverseArr(arr,0,arr.length-1);
        return new String(arr);
    }
    @Test
    public void test1()
    {
        long start = System.nanoTime();
        String result=leftReverseString("I am a student.",3);
        long count1 = System.nanoTime()-start;
        System.out.println("方法一花费:"+count1+" 获得结果"+result);

        long start2 = System.nanoTime();
        String result2=leftReverseString("abcdefg",2);
        long count2 = System.nanoTime()-start2;
        System.out.println("方法一花费:"+count2+" 获得结果"+result2);
    }


}

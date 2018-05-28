package chapter6.com;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/5/23
 * @Time : 16:42
 * @description :翻转字符串中单词的顺序，单词内的字母顺序不变
 */
public class Question58 {
    String reverseSetence(String str)
    {
        if(str == null)
            return null;
        if(str.length() == 0)
            return "";

        //StringBuilder sb = new StringBuilder(str);
       // sb=sb.reverse();
        //char[] arr = sb.toString().toCharArray();
        char[] arr = str.toCharArray();
        reverse2(arr,0,arr.length-1);
        int start = 0,end =0;
        while(start < arr.length)
        {
            if(arr[start] ==' ')
            {
                start++;
                end++;
            }
            else if(arr[end] ==' '|| end == arr.length-1)
            {
                reverse2(arr,start,end-1);
                start = ++end;
            }else{
                end++;
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        Stack<Character> stack = new Stack<>();
        for (int i = start; i <= end ; i++) {
            stack.push(arr[i]);
        }
        for (int i = start; i <=end ; i++) {
            arr[i] = stack.pop();
        }
    }

    private void reverse2(char[] arr,int start,int end)
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

    String reverseSetence2(String str)
    {
        if(str == null)
            return null;
        if(str.length() == 0)
            return "";
        char[] arr= str.toCharArray();
        reverse2(arr,0,arr.length-1);
        int start = 0,end = 0;

        while(end <= arr.length-1){
            if(arr[start] ==' ')
            {
                start++;
                end++;
            }
            else if(arr[end] ==' '||end==arr.length-1)
            {
                reverse2(arr,start,end-1);
                start = ++end;
            }else
                end++;
        }
        return new String(arr);
    }



    @Test
    public void tets1()
    {
        long start = System.nanoTime();
        String result=reverseSetence("I am a student.");
        long count1 = System.nanoTime()-start;
        System.out.println("方法一花费:"+count1+" 获得结果"+result);

        long start2 = System.nanoTime();
        String result2=reverseSetence2("I am a student.");
        long count2 = System.nanoTime()-start2;
        System.out.println("方法二花费:"+count2+" 获得结果"+result2);
    }
}

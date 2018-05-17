package chapter5.com;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/5/17
 * @Time:15:36
 * @description：
 */
public class Question50 {
    private char firstNotRepeatingChar(String str)
    {
        if(str == null || str.length() <=0)
            return '\0';
        int[] arr = new int[256];
        char[] chars=str.toCharArray();
        Arrays.fill(arr,0);
        for (char ch:chars) {
            arr[ch]++;
        }
        for (int i = 0;i < arr.length;i++) {
            if(arr[i] == 1)
                return (char) i;
        }
        return '\0';
    }
    @Test
    public void test1()
    {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
    }


    private boolean isAnagram(String str1,String str2)
    {
        boolean result = true;

        if(str1 == null && str2 == null)
            return result = true;
        else if(str1 == null || str2 == null)
            return result = false;
        if(str1.length() != str2.length())
            return result =false;
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map,0);
        for (char c:str1Arr) {
            map[c]++;
        }
        for (char c:str2Arr) {
            map[c]--;
        }
        for (int i:map) {
            if(i !=0)
            {
                result = false;
                break;
            }
        }
        return result;
    }
    @Test
    public void test2()
    {
        System.out.println(isAnagram("evil","live"));
        System.out.println(isAnagram("evil",""));
        System.out.println(isAnagram("silent","listen"));
        System.out.println(isAnagram("12233","32321"));

    }



}

package chapter5.com;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:xiehcao
 * @Date:2018/5/13
 * @Time:12:16
 * @description：
 */
public class Question48 {
    public int longestSubStringWithOutDuplication(String str)
    {
        if(str == null || str.length() <= 0)
            return 0;
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        String sub = sb.append(arr[0]).toString();
        int subLength = 1;
        String maxSub = sub.intern();
        int maxLength = 1;

        for (int i = 1; i < arr.length ; i++) {
            if(!sub.contains(arr[i]+""))
            {
                sub = sb.append(arr[i]).toString();
                subLength = subLength+1;
            }
            else{
                int d = sub.indexOf(arr[i]);
                subLength =subLength-d;
                //sub = sub.substring(d,sub.length())+arr[i];
                sb.delete(0,d+1);
               /* while(d>=0)
                {
                    sb.deleteCharAt(d);
                    d--;
                }*/
                sb.append(arr[i]);
                sub = sb.toString();
            }
            if(subLength >= maxLength)
            {
                maxLength = subLength;
                maxSub = sub.intern();
            }
        }
        return maxLength;
    }

    public int longestSubStringWithOutDuplication2(String str)
    {
        if(str == null || str.length() <=0)
            return 0;

        char[] arr = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;

        int subLength = 0;
        int subMaxLength = 0;

        for (int i = 0; i <arr.length ; i++) {

            if(!map.containsKey(arr[i]))
            {
                subLength++;
                map.put(arr[i],i);
            }else{
                int d = map.get(arr[i]);
               if(d>start)
               {
                   subLength = i-d;
                   start = d;
               }
               else
               {
                   subLength = i - start;
               }
                map.put(arr[i],i);
            }
            if(subLength > subMaxLength)
                subMaxLength = subLength;
        }
        return  subMaxLength;
    }


    @Test
    public void test1()
    {
        System.out.println(longestSubStringWithOutDuplication("arabcacfre"));
        System.out.println(longestSubStringWithOutDuplication("arabcacfr"));

        System.out.println(longestSubStringWithOutDuplication2("arabcacfre"));
        System.out.println(longestSubStringWithOutDuplication2("arabcacfr"));
    }

}

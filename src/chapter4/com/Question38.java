package chapter4.com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:xiehcao
 * @Date:2018/5/7
 * @Time:10:41
 * @description：
 */
public class Question38 {
    List<List<String>> Permutation(String str)
    {
        if(str == null || str.length() <=0)
            return null;
        List<List<String>> lists = new ArrayList<>();
        List<String> list = null;
        PermutationCore(lists,list,str.toCharArray(),0);
        return lists;
    }

    private void PermutationCore(List<List<String>> lists, List<String> list,char[] str, int begin) {
        if(begin==str.length)
        {
            list = new ArrayList<>();
            list.add(new String(str));
            lists.add(list);
        }else{
            for (int i = begin; i < str.length; i++) {
                char temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
                PermutationCore(lists,list,str,begin+1);
                temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
            }
        }
    }

    @Test
    public void test1()
    {
        List<List<String>> lists = Permutation("abcd");
        System.out.println(lists);
        System.out.println(lists.size());
    }



}

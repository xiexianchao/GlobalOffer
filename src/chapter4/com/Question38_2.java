package chapter4.com;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/5/7
 * @Time:11:03
 * @description：组合问题
 */
public class Question38_2 {
    public int GetCounts(String str)
    {
        if(str == null || str.length()<=0)
            return 0;
        int count = 0;
        String[] arr= str.split(",");
        for (int i = 0; i < arr.length; i++) {
            count += getCountsCore2(arr,0,i+1);
        }
        return count;

    }

    /*
    *递归
    求从索引begin开始的数组中m个字符的组合有多少种*/
    public int getCountsCore(String[] str,int begin,int m)
    {
        if(m+begin > str.length)
            return 0;
        if(m+begin == str.length || m==0)
            return 1;
        return getCountsCore(str,begin+1,m-1)+getCountsCore(str,begin+1,m);
    }

    /*动态规划*/
    public int getCountsCore2(String[] str,int begin,int m)
    {
        int n = str.length - begin;
        if( n < m )
            return 0;

        int[][] nm = new int[n+1][m+1];
        for (int i = 0; i <n+1 ; i++) {
            nm[i] = new int[m+1];
          //  nm[i][0] = 1;  /*每一列第一个元素都为1*/
        }
        Arrays.fill(nm[0],0);  /*第一行所有元素都为0，第一行第一列元素为0*/
        for (int i = 0; i <n+1 ; i++) {
            nm[i][0] = 1;  /*每一列第一个元素都为1*/
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                nm[i][j] = nm[i-1][j]+nm[i-1][j-1];
            }
        }
        return nm[n][m];
    }




    @Test
    public void test1()
    {
        System.out.println(GetCounts("a,b,c,d"));

    }

}

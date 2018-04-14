package Chapter2.com.BitOperation;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:15:39
 * @description：
 */
public class findCodeWegiht {

    public int getWeightCode(int n)
    {
        int count = 0;
        while(n !=0) {
          count++;
          n=n&(n-1);
        }
        return  count;

    }

    @Test
    public void test1()
    {
        System.out.println(getWeightCode(-10));
    }


}

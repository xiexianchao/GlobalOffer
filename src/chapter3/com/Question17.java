package chapter3.com;

import com.sun.xml.internal.fastinfoset.tools.PrintTable;
import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/16
 * @Time:20:48
 * @description：
 */
public class Question17 {
    void Print1ToMaxOfNDigits(int n)
    {
        if(n <= 0)
            System.out.println(1);
         else {
            String str = "";
            for (int i = 0; i < n; i++) {
                str += "9";
            }
            System.out.println(str);
        }
    }

    @Test
    public void test1()
    {
        /*功能测试*/
        Print1ToMaxOfNDigits(2);
        Print1ToMaxOfNDigits(-1);
        Print1ToMaxOfNDigits(1);
        Print1ToMaxOfNDigits(1000);

    }



}

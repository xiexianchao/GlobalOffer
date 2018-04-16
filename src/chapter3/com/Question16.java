package chapter3.com;

import Chapter2.com.exception.InvaliPutException;
import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/16
 * @Time:20:00
 * @description：
 */
public class Question16 {

    double Power(double base,int exponent) throws InvaliPutException
    {
        if(base ==0 && exponent < 0)  /*此处错误，看Power2*/
            throw new InvaliPutException("输入无效");
        double temp = 1.0;
        int count = exponent >=0? exponent:-exponent;
        for (int i = 1; i <= count; i++) {
            temp = temp*base;
        }
        return exponent>=0?temp:1.0/temp;
    }


    double Power2(double base,int exponent) throws InvaliPutException {
       // if(Double.toString(base).equals("0.0") && exponent <0)
         if(Double.doubleToLongBits(base) == 0 && exponent < 0)
            throw new InvaliPutException("输入无效");
        if(exponent == 1)
            return base;
        if(exponent == 0)
            return 1;
        int count = exponent>=0?exponent:-exponent;
        double result = Power(base,count>>1);
        result *= result;
        if((count & 0x01) == 1)
            result = result*base;
        return exponent>=0?result:1.0/result;
    }


    @Test
    public void test() throws InvaliPutException
    {
        /*功能测试*/
        System.out.println(Power2(2.0,2)); /*4.0*/
        System.out.println(Power2(2.0,-1)); //0.5
        System.out.println(Power2(3.0,-2)); //0.111111111
        System.out.println(Power2(1.0,-1)); //1.0
        /*边界测试*/
        System.out.println(Power2(0,0)); //1.0
        System.out.println(Power2(0,10)); //0.0
        /*异常测试*/
        System.out.println(Power2(0,-2)); //Exception

    }

}

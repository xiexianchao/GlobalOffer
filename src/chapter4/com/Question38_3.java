package chapter4.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/8
 * @Time:15:33
 * @description：
 */
public class Question38_3 {
    public boolean isSymmertic(int[] number)
    {
        if(number == null || number.length !=8)
            return false;
        return isSymmerticCore(number,0);


    }

    private boolean isSymmerticCore(int[] number, int begin) {
        boolean possible = false;
        if(begin == number.length)
        {
            if(((number[0]+number[1]+number[2]+number[3]) == (number[4]+number[5]+number[6]+number[7]))
                &&((number[0]+number[2]+number[4]+number[6])==(number[1]+number[3]+number[5]+number[7]))
                    &&((number[0]+number[1]+number[4]+number[5])==(number[2]+number[3]+number[6]+number[7])))
               possible = true;

        }else{
            for (int i = begin; i < number.length ; i++) {
                int temp = number[i];
                number[i] = number[begin];
                number[begin] = temp;
                if(possible=isSymmerticCore(number,begin+1))  /*false要继续寻找下一组排列， true就直接返回*/
                    return possible;
                temp = number[i];
                number[i] = number[begin];
                number[begin] = temp;
            }
        }
        return possible;
    }

    @Test
    public void test1()
    {
        int[] num =new  int[]{1,1,1,1,1,1,1,1};
        System.out.println(isSymmertic(num));
        System.out.println(isSymmertic(new int[]{1,0,0,0,0,0,0,1}));
    }

}

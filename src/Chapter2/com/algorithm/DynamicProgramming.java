package Chapter2.com.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/4/15
 * @Time:11:41
 * @description：
 */
public class DynamicProgramming {
    public int maxProductAfterCutting_solution1(int length)
    {
        if(length < 2)
            return 0;
        else if(length == 3)
            return 2;
        int[] products = new int[length+1];
        Arrays.fill(products,0);

        for (int i = 4; i < length+1; i++) {
            for (int j = 0; j <= i/2; j++) {
                products[i] = Math.max(Math.max(j,products[j])*Math.max(i-j,products[i-j]),products[i]);
            }
        }

        return products[length];
    }
    @Test
    public void test1()
    {

        System.out.println(maxProductAfterCutting_solution1(5)); /*6*/
        System.out.println(maxProductAfterCutting_solution1(8)); /*18*/
        System.out.println(maxProductAfterCutting_solution1(4)); /*4*/
    }





}

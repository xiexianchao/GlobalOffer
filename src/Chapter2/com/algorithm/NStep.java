package Chapter2.com.algorithm;
import org.junit.Test;
import java.lang.Math.*;
/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:15:09
 * @description：
 */
public class NStep {

    public long getSteps(int n)
    {

        if(n<=0)
            return 0;
        else if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else {
            int[] nums = new int[n + 1];
            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 2;
            for (int i = 3; i < nums.length; i++) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        return nums[n];
        }
    }

    @Test
    public void test1()
    {
        System.out.println(getSteps(10));
    }

}

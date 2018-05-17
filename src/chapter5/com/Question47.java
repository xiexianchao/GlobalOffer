package chapter5.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/13
 * @Time:12:00
 * @description：
 */
public class Question47 {

    /*递归*/
    public int getMaxValueOfGifts(int[][] numbers)
    {
        if(numbers == null || numbers.length <=0 || numbers[0] == null || numbers[0].length <=0)
            return 0;
        return core(numbers,numbers.length-1,numbers[0].length-1);
    }

    private int core(int[][] numbers, int i, int j) {
        if(i<0 || j<0)
            return 0;
        int result = 0;
        if(i == 0&& j!=0)
        {
            for (int k = 0; k <=j ; k++) {
                result += numbers[0][k];
            }
        }
        else if(j==0)
        {
            for (int k = 0; k <=i ; k++) {
                result +=numbers[k][0];
            }
        }
        else{
            result = numbers[i][j]+Math.max(core(numbers,i-1,j),core(numbers,i,j-1));
        }
        return result;
    }

    /*非递归---动态规划*/
    int getMaxValueOfGifts2(int[][] numbers)
    {
        if(numbers == null || numbers.length <=0 || numbers[0] == null || numbers[0].length <=0)
            return 0;
        int m = numbers.length;
        int n = numbers[0].length;
        int[][] results = new int[m][n];
        for (int i = 0; i <m ; i++) {
            results[0] = new int[n];
        }
        results[0][0] = numbers[0][0];
        for (int i = 1; i < m; i++) {
            results[i][0] = results[i-1][0]+numbers[i][0];
        }
        for (int i = 1; i < n; i++) {
            results[0][i] = results[0][i-1]+numbers[0][i];
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                results[i][j] = numbers[i][j] + Math.max(results[i-1][j],results[i][j-1]);
            }
        }
        return results[m-1][n-1];


    }



    @Test
    public void test1()
    {
        int[][] arr = new int[4][4];
        arr[0] = new int[]{1,10,3,8};
        arr[1] = new int[]{12,2,9,6};
        arr[2] = new int[]{5,7,4,11};
        arr[3] = new int[]{3,7,16,5};
        System.out.println(getMaxValueOfGifts(arr));
        System.out.println(getMaxValueOfGifts2(arr));

    }


}

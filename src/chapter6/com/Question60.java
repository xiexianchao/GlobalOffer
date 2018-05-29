package chapter6.com;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Question60 {
    private static class Result{
        Integer sum = 0;
        Double probability = 0d;

        public Result(Integer sum, Double probability) {
            this.sum = sum;
            this.probability = probability;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "sum=" + sum +
                    ", probability=" + probability +
                    '}';
        }
    }

    List<Result> getProbability(int number)
    {
        List<Result> results = new ArrayList<>();

        if(number <= 0)
            return results;
        int[] sum = getSum(number);
        int totals = (int) Math.pow(6,number);
        for (int i = number; i <= 6*number ; i++) {
            Result result = new Result(i, ((double)sum[i] / totals));
            results.add(result);
        }
        return results;
    }

    private int[] getSum(int number) {
        int[][] sum = new int[number][6*number+1];  /*存放1到n个骰子 所有的和*/

        for (int i = 0; i <sum.length ; i++) {
            sum[i] = new int[6*number+1];
            Arrays.fill(sum[i],0);
        }
        for (int i = 1; i <=6 ; i++) {
            sum[0][i] = 1;
        }
        for (int i = 1; i <sum.length ; i++) {
            for (int j = (i+1); j <= 6*(i+1) ; j++) {
                sum[i][j] = 0;
                for (int k = 1; k <=6 && j>k; k++) {
                    sum[i][j] += sum[i-1][j-k];
                }
            }
        }
        return sum[sum.length-1];
    }

    @Test
    public void test1()
    {

        //getSum(1);
        System.out.println(getProbability(1));
        System.out.println(getProbability(3));
        //getSum(2);
        //getSum(3);
       // getSum(6);


    }


}

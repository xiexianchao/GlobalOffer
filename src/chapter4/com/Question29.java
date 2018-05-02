package chapter4.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/2
 * @Time:9:38
 * @description：
 */
public class Question29 {
    void PrintMatrixClockwisely(int[][] numbers)
    {
        if(numbers == null|| numbers.length<=0 || numbers[0] == null ||numbers[0].length<=0)
            return;

        int start = 0;
        int rows = numbers.length;
        int columns = numbers[0].length;


        while(rows > 2*start && columns > 2*start)
        {
            PrintMatrixCore(numbers,rows,columns,start);
            start++;
        }


    }

    private void PrintMatrixCore(int[][] numbers, int rows, int columns, int start) {
        int endY = rows-1-start;
        int endX = columns-1-start;


        for (int i = start; i <=endX ; i++) {
            System.out.print(numbers[start][i]+" ");
        }

        if(endY > start) {
            for (int i = start+1; i <=endY; i++) {
                System.out.print(numbers[i][endX]+" ");
            }
        }

        if(endY > start && endX > start)
        {
            for (int i = endX-1; i >= start ; i--) {
                System.out.print(numbers[endY][i]+" ");
            }
        }

        if(endY-1 > start && endX > start)
        {
            for (int i = endY -1; i >= start+1 ; i--) {
                System.out.print(numbers[i][start]+" ");
            }
        }

        System.out.println();
    }

    @Test
    public void test1()
    {
        int[][] numbers = new int[4][];
        numbers[0] = new int[]{1,2,3,4};
        numbers[1] = new int[]{5,6,7,8};
        numbers[2] = new int[]{9,10,11,12};
        numbers[3] = new int[]{13,14,15,16};
        PrintMatrixClockwisely(numbers);
        System.out.println("********");

        int[][] numbers1 = new int[1][];
        numbers1[0] = new int[]{1,2,3,4};
        PrintMatrixClockwisely(numbers1);
        System.out.println("********");

        int[][] numbers2 = new int[4][1];
        numbers2[0] = new int[]{1};
        numbers2[1] = new int[]{2};
        numbers2[2] = new int[]{3};
        numbers2[3] = new int[]{4};
        PrintMatrixClockwisely(numbers2);
        System.out.print("*********");


    }
}

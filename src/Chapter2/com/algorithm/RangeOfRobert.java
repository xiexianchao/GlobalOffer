package Chapter2.com.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:xiehcao
 * @Date:2018/4/15
 * @Time:10:58
 * @description：
 */
public class RangeOfRobert {

    public int movingCount(int rows, int cols, int threshold) {
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;

        Boolean[][] visited = new Boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(visited[i], false);
        }

        int count = movingCountCore(rows, cols, 0, 0, visited, threshold);

        return count;

    }

    private int movingCountCore(int rows, int cols, int row, int col, Boolean[][] visited, int threshold) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return 0;

        int count = 0;
        if (check(threshold, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(rows, cols, row - 1, col, visited, threshold) +
                    movingCountCore(rows, cols, row, col - 1, visited, threshold) +
                    movingCountCore(rows, cols, row + 1, col, visited, threshold) +
                    movingCountCore(rows, cols, row, col + 1, visited, threshold);

        }
        return count;
    }



    private boolean check(int threshold, int row, int col, Boolean[][] visited) {

            if(threshold >= getDigitSum(row)+getDigitSum(col)&&!visited[row][col]) {
                return true;
            }
            return false;
    }




    private int getDigitSum(int number)
    {
        int sum = 0;
        while(number !=0)
        {
            sum = sum + number%10;
            number = number /10;

        }
        return sum;
    }


    @Test
    public void test()
    {
        System.out.println(movingCount(3,4,3));/*3*/
        System.out.println(movingCount(3,4,0));/*1*/
    }
}

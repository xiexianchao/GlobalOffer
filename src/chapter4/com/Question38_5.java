package chapter4.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/8
 * @Time:16:50
 * @description：
 */
public class Question38_5 {

    class EightQueen{
       // private static final int K = 15;
       // private static int count = 0;
        private static final int N = 11;
        private int count = 0;
        private int[] chess = new int[N];

        public int getCounts()
        {

            long start = System.currentTimeMillis();
            eightQueenCore(0);
            long end = System.currentTimeMillis();
            System.out.println(N+"皇后问题耗时"+(end-start)+"ms,得到"+count+"种解法");
            return count;
        }

       /* private void eightQueenCore(int begin) {
            if(begin == N)
                count++;
            else{
                for (int i = 0; i < N; i++) {
                    chess[begin] = i;
                    if(check(begin))
                        eightQueenCore(begin+1);
                }
            }
        }*/
       private void eightQueenCore(int n)
       {
           if(n == N )
               count++;
           else{
               for (int i = 0; i < N; i++) {
                    chess[n] = i;
                    if(check(n))
                        eightQueenCore(n+1);
               }
           }
       }

        private boolean check(int i) {
            for (int j = 0; j < i; j++) {
                if(chess[j] == chess[i] || i-j == Math.abs(chess[i]-chess[j]))
                    return false;
            }
            return true;
        }
    }

    @Test
    public void test1()
    {
        EightQueen eightQueen = new EightQueen();
        eightQueen.getCounts();
    }
}

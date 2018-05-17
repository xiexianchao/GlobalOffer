package leetcode;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/16
 * @Time:11:14
 * @description：
 */
public class Question5 {
        public String longestPalindrome(String s) {
            if(s == null || s.length() <= 0)
                return "";
            int maxLength = 0;
            // String sub = "";
            int start = 0;
            int end = 0;
            boolean[][] tf = new boolean[s.length()][s.length()];
            char[] arr = s.toCharArray();

            for(int i = 0;i<tf.length;i++)
            {
                tf[i] = new boolean[s.length()];

                tf[i][i] = true;

                if(1 > maxLength)
                {
                    start = i;
                    end = i;
                    maxLength =1;
                }

                if(i+1 < tf.length && arr[i] == arr[i+1])
                {
                    start = i;
                    end = i+1;
                    maxLength = 2;
                    tf[i][i+1] = true;
                }
            }

            for(int i =tf.length-3;i>=0;i--) {
                for (int j = i + 2; j < tf.length; j++) {
                    if (tf[i + 1][j - 1] && arr[i] == arr[j]) {
                        tf[i][j] = true;
                        if ((j - i + 1) > maxLength) {
                            maxLength = j - i + 1;
                            start = i;
                            end = j;
                        }
                    } else {
                        tf[i][j] = false;
                    }
                }
            }
            return s.substring(start,end+1);
        }
        @Test
    public void test1()
        {

            System.out.println(longestPalindrome("abcba"));
            System.out.println("PAYPALISHIRING".length());
        }

}

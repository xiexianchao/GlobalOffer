package chapter5.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/5/17
 * @Time:15:51
 * @description：
 */
public class Question50_2 {
    class CharStatics{
        private int[] occurrence = new int[256];

        void insert(char ch)
        {
            occurrence[ch] ++;
        }
        void remove()
        {

        }
        char firstApperaingOnce()
        {
            //char c = '\0';
            for (int i = 0; i < occurrence.length; i++) {
                if(occurrence[i] == 1)
                    return (char) i;
            }
            return '\0';
        }

    }
    @Test
    public void test1()
    {
        CharStatics cs = new CharStatics();
        cs.insert('a');
        cs.insert('b');
        cs.insert('c');
        cs.insert('b');
        cs.insert('a');
        cs.insert('d');
        System.out.println(cs.firstApperaingOnce());

    }


}

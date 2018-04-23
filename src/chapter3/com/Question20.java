package chapter3.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/23
 * @Time:9:21
 * @description：
 */
public class Question20 {
    public boolean isNumeric(char[] str)
    {
        //return method1(str);
        if(str==null||str.length<=0)
            return false;
        int[] s=new int[]{0};
        boolean numerice=scanInteger(str,s);

        if(s[0]<str.length&&str[s[0]]=='.')
        {
            s[0]++;
            //numerice=numerice|scanUnInteger(str,s);/*防止短路*/
            numerice=scanInteger(str,s)||numerice;

        }
        if(s[0]<str.length&&(str[s[0]]=='e'||str[s[0]]=='E'))
        {
            s[0]++;
            numerice=numerice&&scanInteger(str,s);
        }
        return numerice&&s[0]==str.length;
    }

    private boolean scanInteger(char[] str, int[] s) {
        if((s[0]<str.length)&&(str[s[0]]=='+'||str[s[0]]=='-'))
            s[0]++;
        return scanUnInteger(str,s);

    }

    private boolean scanUnInteger(char[] str, int[] s) {
       int start=s[0];
       while((s[0]<str.length)&&str[s[0]]>='0'&&str[s[0]]<='9')
            s[0]++;
       return s[0]>start;
    }

    @Test
    public void test1()
    {
        System.out.println(isNumeric("123.45e+6".toCharArray()));
        System.out.println(isNumeric("123.45a".toCharArray()));
    }



    private boolean method1(char[] str) {
        try{
            Double d = Double.parseDouble(new String(str));

        }catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }

}

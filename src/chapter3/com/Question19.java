package chapter3.com;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/21
 * @Time:15:21
 * @description：
 */
public class Question19 {
   public boolean match(char[] str,char[] pattern)
   {
       if(str==null||pattern==null)
            return false;
       return matchCore(str,0,pattern,0);

   }
   private boolean matchCore(char[] str,int s,char[] pattern,int p)
   {
       if(s>=str.length&&p>=pattern.length)
           return true;
       if(s<str.length&&p>=pattern.length)
           return false;

       if((p+1<pattern.length)&&pattern[p+1]=='*')
       {

           if(s<str.length&&(pattern[p]==str[s]||pattern[p]=='.'))
               return matchCore(str,s+1,pattern,p+2)||
                       matchCore(str,s,pattern,p+2)||
                       matchCore(str,s+1,pattern,p);
           else
               return matchCore(str,s,pattern,p+2);


       }
       if(s<str.length&&(str[s]==pattern[p]||(pattern[p]=='.')))
           return matchCore(str,s+1,pattern,p+1);

       return false;
   }

    @Test
    public void test1()
    {
        System.out.println(match("".toCharArray(),".*".toCharArray()));
        System.out.println(match("a".toCharArray(),".".toCharArray()));
    }

}

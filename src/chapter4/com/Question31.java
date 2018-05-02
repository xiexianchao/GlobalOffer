package chapter4.com;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/5/2
 * @Time:10:15
 * @description：
 */
public class Question31 {
    public boolean IsPopOrder(int[] pPush,int[] pPop)
    {
        //return method1(pPush, pPop);

      //  return method2(pPush, pPop);
        return method4(pPush, pPop);
    }

    /*do--while改写*/
    private boolean method4(int[] pPush, int[] pPop) {
        boolean bPosssilbe = false;
        if(pPush != null || pPop != null || pPush.length == pPop.length)
        {
             int i = 0,j=0;
             Stack<Integer> stack = new Stack<>();
            for (i = 0; i <  pPop.length; i++) {
                  do{
                      if(j<pPush.length) {
                          stack.push(pPush[j]);
                      }
                      j++;
                  }while (j<pPush.length&&stack.peek()!=pPop[i]);
                if(stack.peek() != pPop[i])
                    break;
                stack.pop();
            }
            if(stack.empty() && i == pPop.length)
                return true;
        }
        return bPosssilbe;
    }

    /*剑指Offer*/
    private boolean method3(int[] pPush, int[] pPop) {
        boolean bPossible = false;
        if(pPush != null || pPop != null || pPush.length == pPop.length)
        {
            int i = 0,j = 0;
            Stack<Integer> stack = new Stack<>();
            while(i<pPop.length)
            {
                while(stack.empty() || stack.peek() != pPop[i])
                {
                    if(j == pPush.length)
                        break;
                    stack.push(pPush[j]);
                    j++;
                }
                if(stack.peek()!=pPop[i])
                    break;
                stack.pop();
                i++;
            }
            if(stack.empty() && i == pPush.length)
                return true;
        }
        return bPossible;
    }

    /*根据剑指Offer的改编*/
    private boolean method2(int[] pPush, int[] pPop) {
        if(pPush == null || pPop == null || pPop.length!= pPush.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        for (i = 0; i < pPop.length; i++) {
            for (;j < pPush.length &&(stack.empty()|| stack.peek() != pPop[i]); j++) {
                stack.push(pPush[j]);
            }
            if(stack.peek()!=pPop[i])
                break;
            if(!stack.empty())
                stack.pop();
        }
        if(stack.empty() && i == pPop.length)
            return true;
        return false;
    }


    /*遍历弹出序列，把没有当前元素之前没有入栈的元素全部入栈*/
    private boolean method1(int[] pPush, int[] pPop) {
        if(pPush == null || pPop == null || pPush.length != pPop.length)
            return false;

        boolean[] visit = new boolean[pPop.length];
        Arrays.fill(visit,false);
        Stack<Integer> stack  = new Stack<>();


        for (int i = 0; i < pPop.length ; i++) {
            int j = 0 ;
            for (j = 0; j <pPush.length && pPush[j] != pPop[i] ; j++) {
                if(!visit[j]) {
                    visit[j] = true;
                    stack.push(pPush[j]);
                }
            }
            if(stack.size() == pPush.length)
                return false;
            //stack.push(pPop[i]);
            if(!visit[j]) {
                stack.push(pPush[j]);
                visit[j] = true;
            }
            if(! stack.empty() && stack.pop() != pPop[i])
                return false;
        }
        return true;
    }




    @Test
    public void test1()
    {
        int[] pPush = new int[]{1,2,3,4,5};
        int[] pPop = new int[]{4,3,5,1,2};
        int[] pPop1 = new int[]{4,5,3,2,1};
        int[] pPop2 = new int[]{0,4,5,3,2};
        System.out.print(IsPopOrder(pPush,pPop1));
    }


}

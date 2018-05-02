package chapter4.com;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/5/2
 * @Time:10:02
 * @description：
 */
public class Question30 {
    private static class StackWithMin{
        Stack<Integer> mData = new Stack<>();
        Stack<Integer> mMin = new Stack<>();

        public void push(Integer data)
        {
            //int min = Integer.MAX_VALUE;
            mData.push(data);
            if(mMin.empty() || mMin.peek() > data)
                mMin.push(data);
           // else if(mMin.peek() > data)
            //    mMin.push(data);
            else
                mMin.push(mMin.peek());
        }

        public Integer min()
        {
            if(mMin.empty())
                return null;
            return mMin.peek();
        }

        public Integer pop()
        {
            if(mData.empty())
                return null;
            else {
                mMin.pop();
                return mData.pop();
            }
        }
    }

}

package util.datastructure;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/5/8
 * @Time:21:58
 * @description：
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();


    void push(int number)
    {
        stack.push(number);
        if(min.isEmpty())
            min.push(number);
        else{
            int minValue = min.peek();
            if(number<minValue)
                min.push(number);
            else
                min.push(minValue);
        }
    }

    int pop()
    {
        min.pop();
        return stack.pop();
    }

    int min()
    {
        return min.peek();
    }
    
    
}

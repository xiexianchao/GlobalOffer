package util.datastructure;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/5/8
 * @Time:21:58
 * @description：
 */
public class MaxStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> max = new Stack<>();

    void push(int number)
    {
        stack.push(number);
        if(max.isEmpty())
            max.push(number);
        else{
            int maxValue = max.peek();
            if(number>maxValue)
                max.push(number);
            else
                max.push(maxValue);
        }
    }

    int pop()
    {
        max.pop();
        return stack.pop();
    }

    int max()
    {
        return max.peek();
    }

    @Test
    public void test1()
    {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(5);
        maxStack.push(4);
        System.out.println(maxStack.max());
        maxStack.pop();
        System.out.println(maxStack.max());
    }


}

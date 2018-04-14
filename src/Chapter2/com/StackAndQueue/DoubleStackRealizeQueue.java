package Chapter2.com.StackAndQueue;

import java.util.Stack;

/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:10:31
 * @description：
 */
public class DoubleStackRealizeQueue<E> {
    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    public boolean offer(E data)
    {
        stack1.push(data);
        return true;
    }

    public E poll()
    {
        if(stack1.empty() && stack2.empty())
            return null;
        if(stack2.empty())
        {
            while(!stack1.empty())
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}

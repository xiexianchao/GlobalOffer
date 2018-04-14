package Chapter2.com.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:10:58
 * @description：
 */
public class DoubleQueueRealizeStack<E> {
    private Queue<E> queue1 = new ArrayDeque<>();
    private Queue<E> queue2 = new ArrayDeque<>();

    boolean push(E data)
    {
        if (queue2.isEmpty())
            return queue1.offer(data);
        else
            return queue1.isEmpty() && queue2.offer(data);
    }
    public E pop()
    {
        if(queue1.isEmpty() && queue2.isEmpty())
            return null;
        if(queue1.size()>1&&queue2.size()>1)
            return null;
        if(queue1.isEmpty())
        {
            while(queue2.size()>1)
            {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else if(queue2.isEmpty())
        {
            while(queue1.size()>1)
                queue2.offer(queue1.poll());

            return queue1.poll();
        }
        return null;

    }

}

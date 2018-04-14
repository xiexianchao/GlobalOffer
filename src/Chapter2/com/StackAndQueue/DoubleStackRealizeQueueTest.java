package Chapter2.com.StackAndQueue;

import org.junit.Test;

/**
 * @author:xiehcao
 * @Date:2018/4/14
 * @Time:10:47
 * @description：
 */
public class DoubleStackRealizeQueueTest {
    @Test
    public void test1()
    {
        DoubleStackRealizeQueue<String> queue = new
                DoubleStackRealizeQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer("d");
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

}

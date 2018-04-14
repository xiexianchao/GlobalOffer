package Chapter2.com.StackAndQueue;

import org.junit.Test;

/**
 * @author: xie,chao
 * @Date: 2018/4/14
 * @Time: 11:19
 * @description：
 */
public class DoubleQueueRealizeStackTest {

    @Test
    public void test1()
    {
        DoubleQueueRealizeStack<String> stack = new
                DoubleQueueRealizeStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        /*功能测试*/
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

      /*边界测试*/
        System.out.println(stack.pop());

    }
}

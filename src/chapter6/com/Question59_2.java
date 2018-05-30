package chapter6.com;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: xiehcao
 * @Date : 2018/5/28
 * @Time : 10:27
 * @description :
 */
public class Question59_2 {
    private static class QueueWithMax{
        private static class Element{
            Integer data;
            Long id;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Element)) return false;

                Element element = (Element) o;

                if (data != null ? !data.equals(element.data) : element.data != null) return false;
                return id != null ? id.equals(element.id) : element.id == null;
            }

            @Override
            public int hashCode() {
                int result = data != null ? data.hashCode() : 0;
                result = 31 * result + (id != null ? id.hashCode() : 0);
                return result;
            }

            public Element(Integer data, Long id) {
                this.data = data;
                this.id = id;
            }
        }
        private Deque<Element> dataDeque = new LinkedList<>();
        private Deque<Element> maxDeque = new LinkedList<>();
        private Long currentId = 0L;

        public  boolean offer(Integer element)
        {
            while(!maxDeque.isEmpty() && element > maxDeque.peekLast().data)
            {
                maxDeque.pollLast();
            }
            Element element1 = new Element(element,currentId);
            currentId++;
            return dataDeque.offerLast(element1)&&maxDeque.offerLast(element1);

        }

        public Integer poll()
        {
            Element e = dataDeque.pollFirst();
            if(e == maxDeque.peekFirst())
            {
                maxDeque.pollFirst();
            }
            return e.data;
        }
        public Integer max()
        {
            return maxDeque.peekFirst().data;
        }
    }

    @Test
    public void test1()
    {
        QueueWithMax queue = new QueueWithMax();
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(2);
        queue.offer(6);
        queue.offer(5);
        queue.offer(1);

        System.out.println(queue.max());

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue.max());
        queue.poll();
        System.out.println(queue.max());
        queue.poll();
        System.out.println(queue.max());

    }


}

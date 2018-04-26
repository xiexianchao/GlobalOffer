package chapter3.com;

/**
 * @author:xiehcao
 * @Date:2018/4/23
 * @Time:18:54
 * @description：
 */
public class Question22<E> {
    static class LinkNode<T>{
        T data;
        LinkNode<T> next;

        public LinkNode(T data) {
            this.data = data;
        }

        public LinkNode(T data, LinkNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    LinkNode<E> findkthToTail(LinkNode<E> root,int k)
    {
        if(root == null || k<=0)
            return null;
        else{

            LinkNode<E> node1 = root;
            while(node1.next!=null && k>1)
            {
                node1 = node1.next;
                k--;
            }
            if(k>1)
                return null;
            else{
                LinkNode<E> node2= root;
                while(node1.next!=null)
                {
                    node1=node1.next;
                    node2=node2.next;
                }
                return node2;
            }
        }
    }


    LinkNode<E> findMidNode(LinkNode<E> root) {
        if (root == null)
            return null;
        LinkNode<E> node1 = root.next;
        LinkNode<E> node2 = root.next;
        while (node1 != null) {
            node1 = node1.next;
            if (node1 != null)
                node1 = node1.next;
            else
                break;
            node2 = node2.next;
        }
        return node2;
    }




}

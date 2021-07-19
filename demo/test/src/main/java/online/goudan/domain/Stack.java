package online.goudan.domain;

/**
 * @author 刘成龙
 * @date 2021/7/13 10:06
 * @desc MyStack
 */
public class Stack<E> {

    private Node<E> stackTop;


    public synchronized void add(E e) {
        stackTop = new Node<>(e, stackTop);
    }

    public boolean hasNext() {
        return stackTop != null;
    }

    public synchronized E pop() {
        if (stackTop == null) {
            return null;
        }
        E e = stackTop.e;
        stackTop = stackTop.next;
        return e;
    }

    private static class Node<E> {
        Node<E> next;
        E e;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

}

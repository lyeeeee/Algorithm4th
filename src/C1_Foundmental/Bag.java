package C1_Foundmental;

import StdLib.StdIn;
import StdLib.StdOut;

import java.util.Iterator;

/**
 * @program: Algorithm4th
 * @description:
 * @author: liyi
 * @create: 2020-03-01 14:43
 */
public class Bag<T> implements Iterable<T>{
    private int n;
    private Node<T> first;

    private static class Node<T> {
        T item;
        Node<T> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node<T> origin = first;
        first = new Node<>();
        first.item = item;
        first.next = origin;
        n++;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> cur;
        public ListIterator(Node<T> first) {
            cur = first;
        }
        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            Node<T> ret = cur;
            cur = cur.next;
            return ret.item;
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }
}

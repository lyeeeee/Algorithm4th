package C3_Find;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2019-11-22 15:58
 * 1 节点是红色或黑色。
 * 2 根是黑色。
 * 3 所有叶子都是黑色（叶子是NIL节点）。
 * 4 每个红色节点必须有两个黑色的子节点。（从每个叶子到根的所有路径上不能有两个连续的红色节点。）
 * 5 从任一节点到其每个叶子的所有简单路径都包含相同数目的黑色节点（简称黑高）。黑高都相同
 *
 * 因为不能出现连续的红色结点，并且叶子节点是黑色，所以红色结点必须有两个黑色孩子
 *
 * 有了上面的几个性质作为限制，即可避免二叉查找树退化成单链表的情况。但是，仅仅避免这种情况还不够，这里还要考虑某个节点到其每个叶子节点路径长度的问题。
 * 如果某些路径长度过长，那么，在对这些路径上的结点进行增删查操作时，效率也会大大降低。这个时候性质4和性质5用途就凸显了，有了这两个性质作为约束，
 * 即可保证任意节点到其每个叶子节点路径最长不会超过最短路径的2倍。原因如下：
 *
 * 当某条路径最短时，这条路径必然都是由黑色节点构成。当某条路径长度最长时，这条路径必然是由红色和黑色节点相间构成（性质4限定了不能出现两个连续的红色节点）。
 * 而性质5又限定了从任一节点到其每个叶子节点的所有路径必须包含相同数量的黑色节点。此时，在路径最长的情况下，路径上红色节点数量 = 黑色节点数量。
 * 该路径长度为两倍黑色节点数量，也就是最短路径长度的2倍。
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> {

    private static boolean RED = true;
    private static boolean BLACK = false;

    private Node root;

    private class Node{
        private Key k;
        private Value v;
        private Node left;
        private Node right;
        private boolean color;
        private int size;

        public Node(Key k, Value v, boolean color, int size) {
            this.k = k;
            this.v = v;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackTree() {
    }

    private boolean isRed(Node node){
        if(node == null) return false;
        return node.color == RED;
    }

    private int size(Node node){
        if(node == null) return 0;
        return node.size;
    }

    public int size(){
        return size(root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key can not be null");
        return get(root,key);
    }

    private Value get(Node node, Key key){
        while(node != null){
            int compare = key.compareTo(node.k);
            if(compare == 0){
                return node.v;
            }else if(compare < 0){
                return get(node.left,key);
            }else{
                return get(node.right,key);
            }
        }
        return null;
    }

    public void put(Key key,Value value){
        if(key == null)
            throw new IllegalArgumentException("key can not be null");
        if(value == null){
            delete(key);
        }
        root = put(root,key,value);
        root.color = BLACK;
    }


    // insert the key-value pair in the subtree rooted at h
    private Node put(Node node, Key key, Value value){
        if(node == null)
            return new Node(key,value,RED,1);
        int compare = key.compareTo(node.k);
        if(compare == 0){
            node.v = value;
        }else if(compare < 0){
            node.left = put(node.left,key,value);
        }else{
            node.right = put(node.right,key,value);
        }
        //在插入之后，需要进行树结构和颜色的调整
        //1.插入到了2结点左边，即黑结点左边
        //2.插入到了2结点右边，即黑结点右边
        //3.插入到了3结点左边，即红结点左边
        //2.插入到了3结点右边，即红结点右边
        if(!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left)) node = retateRight(node);
        if(isRed(node.left) && isRed(node.right)) flipColors(node);

        node.size = size(node.right) + size(node.left) + 1;
        return node;
    }

    public void deleteMin(){
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        if(!isRed(root.left) && !isRed(root.right)){
            root.color = RED;//为把结点提升到root做准备，即将root变为3及以上类型
        }
        root = deleteMin(root);
        if(!isEmpty()) root.color = BLACK;
    }

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        return null;
    }


    /**
     * Removes the largest key and associated value from the symbol table.
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {

        // assert check();
    }

    // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) {
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {

        // assert check();
    }

    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key) {
        // assert get(h, key) != null;

        return null;
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);
        return null;

    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        return null;
    }

    // restore red-black tree invariant
    private Node balance(Node h) {//将右斜红边，调整。还有连续的红色，最后反转颜色
        // assert (h != null);
        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = retateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;

    }

    public Value max(){
        if(isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root);
    }

    public Value max(Node node){
        if(node.right != null) return max(node.right);
        else return node.v;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).k;
    }

    public int height(){
        return height(root);
    }

    public int height(Node node){
        if(node == null) return 0;
        return Math.max(height(node.left),height(node.right)) +1;
    }

    // the smallest key in subtree rooted at x; null if no such key
    private Node min(Node x) {
        // assert x != null;
        if (x.left == null) return x;
        else                return min(x.left);
    }

    private Node rotateLeft(Node p){
        Node x = p.right;
        p.right = x.left;
        x.left = p;

        x.color = x.left.color;
        x.left.color = RED;

        x.size = p.size;
        p.size = size(p.left) + size(p.right) + 1;
        return x;
    }

    private Node retateRight(Node p){
        Node x = p.left;
        p.left = x.right;
        x.right = p;

        x.color = x.right.color;
        x.right.color = RED;

        x.size = p.size;
        p.size = size(p.left) + size(p.right) + 1;
        return x;
    }

    private void flipColors(Node node){
        if(node == null) return;
        else {
            node.color = !node.color;
            node.left.color = !node.left.color;
            node.right.color = !node.right.color;
        }
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the sybol table between {@code lo}
     *    (inclusive) and {@code hi} (inclusive) as an {@code Iterable}
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *    is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new LinkedList<>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }

    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.k);
        int cmphi = hi.compareTo(x.k);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.offer(x.k);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}

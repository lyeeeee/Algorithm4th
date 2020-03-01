package C2_Sort;

import StdLib.StdOut;

import java.util.Comparator;

/**
 * @program: Algorithm4th
 * @description: 插入排序所需时间，取决于输入中元素的初始顺序，接近有序的数组排序会比较快
 * 最好情况需要n-1次比较和0次交换
 *
 * 最坏n^2/2次比较和n^2/2次交换
 *
 * 平均需要n^2/4次比较 n^2/4次交换  时间复杂度是O(n^2) 空间复杂度是O(1)
 *
 * @author: liyi
 * @create: 2019-10-22 16:45
 */
public class Insertion {
    // This class should not be instantiated.
    private Insertion() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int lengh = a.length;
        for(int i = 0;i < a.length-1;++i){
            for(int j = i + 1;less(a[j],a[j-1]);--j){
                exch(a,j,j-1);
            }
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        int lengh = a.length;
        for(int i = 1;i < lengh;++i){
            for(int j = i; j > 0 && less(comparator, a[j],a[j-1]);--j){
                exch(a, j, j-1);
            }
        }
        assert isSorted( a, comparator);
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }



    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = new String[]{"a","g","y","z","b","c","c","d"};
        Insertion.sort(a);
        show(a);
    }
}

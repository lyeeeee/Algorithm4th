package C2_Sort;

import StdLib.StdOut;

import java.util.Comparator;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2019-10-22 16:28
 */
public class Selection {
    // This class should not be instantiated.
    private Selection() { }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
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

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int length = a.length;
        for(int i = 0;i < length-1;++i){
            int minIndex = i;
            for(int j = i + 1;j < length;++j){
                if(less(a[j], a[i]))
                    exch(a, i, j);
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
        int length = a.length;
        for(int i = 0;i < length-1;++i){
            int minIndex = i;
            for(int j = i + 1;i < length;++j){
                if(less(comparator, a[j], a[i]))
                    exch(a, i, j);
            }
        }
        assert isSorted(a, comparator);
    }

    public static void main(String[] args) {
        String[] a = new String[]{"a","g","y","z","b","c","c","d"};
        sort(a);
        show(a);
    }
}

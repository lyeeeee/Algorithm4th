package C2_Sort;

import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * The {@code InsertionX} class provides static methods for sorting
 * an array using an optimized version of insertion sort (with half exchanges
 * and a sentinel).
 * @author: liyi
 * @create: 2019-10-30 10:34
 */
public class InsertionX {
    // This class should not be instantiated.
    private InsertionX() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        int compare = 0;
        for(int i = n-1;i > 0;--i){
            if(less(a[i],a[i-1])) {
                exch(a, i, i - 1);
                compare++;
            }
        }
        if(compare == 0) return;

        for(int i = 1;i < n;++i){
            for(int j = i; less(a[j],a[j-1]);--j){
                exch(a, j, j-1);
            }
        }
        assert isSorted(a);
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
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

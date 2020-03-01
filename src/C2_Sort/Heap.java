package C2_Sort;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2019-12-12 22:20
 */

import StdLib.StdOut;

/**
 *  The {@code Heap} class provides a static methods for heapsorting
 *  an array.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Heap {

    // This class should not be instantiated.
    private Heap() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param arr the array to be sorted
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int k = n/2;k >=1;--k){
            sink(arr, k, n);
        }
        while(n > 1){
            exch(arr, 1,n--);
            sink(arr, 1, n);
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/
    private static void sink(Comparable[] arr, int k, int n){
        while(k*2 <= n){
            int j = k*2;
            if(j < n && less(arr,j,j+1)) j++;
            if(!less(arr, k,j)) break;
            exch(arr, j,k);
            k = j;
        }
    }


    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0 ;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = new String[]{"z","a","g","y","z","b","c","c","d"};
        Heap.sort(a);
        show(a);
    }
}

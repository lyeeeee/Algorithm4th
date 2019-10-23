package C2_Sort;

import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * @description: 归并排序，能够保证任意的长度为N的数组的排序时间跟nlog(n) 成正比
 * 主要缺点是所需空间和n成正比
 *
 * @author: liyi
 * @create: 2019-10-22 17:40
 */
public class Merge {
    // This class should not be instantiated.
    private Merge() { }

    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high){
        for(int i = low; i <= high; ++i){
            aux[i] = a[i];
        }
        int i = low, j = mid + 1;
        int k = low;
        while(i <= mid || j <= high){
            if(i == mid + 1) a[k++] = aux[j++];
            else if(j == high + 1) a[k++] = aux[i++];
            else if(less(aux[i], aux[j])) a[k++] = aux[i++];
            else a[k++] = aux[j++];
        }
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int low,int high){
        if(high <= low) return;
        int mid = low + (high - low)/2;
        sort(a, aux, low, mid);
        assert isSorted(a, low, mid);
        sort(a, aux, mid + 1, high);
        assert isSorted(a, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    /***************************************************************************
     *  Helper sorting function.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    /***************************************************************************
     *  Index mergesort.
     ***************************************************************************/


    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param a the array
     * @return a permutation {@code p[]} such that {@code a[p[0]]}, {@code a[p[1]]},
     *    ..., {@code a[p[N-1]]} are in ascending order
     */


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = new String[]{"a","g","y","z","b","c","c","d"};
        sort(a);
        show(a);
    }
}

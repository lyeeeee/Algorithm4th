package C2_Sort;

import StdLib.StdOut;

import java.util.Comparator;

/**
 * @program: Algorithm4th
 * @description: using an optimized version of mergesort.
 * @author: liyi
 * @create: 2019-10-25 16:23
 */
public class MergeX {
    private static final int CUTOFF = 7;  // cutoff to insertion sort

    // This class should not be instantiated.
    private MergeX() { }

    public static void sort(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux,  0, arr.length - 1);
        assert isSorted(arr);
    }

    public static void merge(Comparable[] arr,Comparable[] aux, int low, int mid, int high){
        for(int i = low;i <= high; ++i){
            aux[i] = arr[i];
        }
        int i = low,j = mid + 1;
        int k = low;
        while(k <= high){
            if(i == mid + 1) arr[k++] = aux[j++];
            else if(j == high + 1) arr[k++] = aux[i++];
            else if(less(aux[i] ,aux[j])) arr[k++] = aux[i++];
            else arr[k++] = aux[j++];
        }
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param arr the array to be sorted
     */
    public static void sort(Comparable[] arr,Comparable[] aux, int low, int high){
        if(high <= low + CUTOFF){
            insertion(arr, low, high);
            return;
        }
        int mid = low + (high - low)/2;
        sort(arr, aux, low, mid);
        assert isSorted(arr, low, mid);
        sort(arr, aux , mid + 1, high);
        assert isSorted(arr, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    // sort from a[lo] to a[hi] using insertion sort
    public static void insertion(Comparable[] arr, int low, int high){
        for(int i = low; i < high; ++i){
            int j = i + 1;
            while(j > low && less(arr[j], arr[j-1])) {
                exch(arr,j , j-1);
                j--;
            }
        }
    }


    /*******************************************************************
     *  Utility methods.
     *******************************************************************/

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is a[i] < a[j]?
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // is a[i] < a[j]?
    private static boolean less(Object a, Object b, Comparator comparator) {
        return comparator.compare(a, b) < 0;
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

    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length - 1, comparator);
    }

    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1], comparator)) return false;
        return true;
    }

    // print array to standard output
    private static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them
     * (using an optimized version of mergesort);
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = new String[]{"a","g","y","z","b","c","c","d","e","r","y","p","i","o","k","n","m"};
        sort(a);
        show(a);
    }
}

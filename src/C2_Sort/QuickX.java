package C2_Sort;

import StdLib.StdOut;
import StdLib.StdRandom;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2019-10-25 16:51
 */
public class QuickX {
    private static final int CUT_OFF = 7;
    // This class should not be instantiated.
    private QuickX() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param arr the array to be sorted
     */
    public static void sort(Comparable[] arr){
        StdRandom.shuffle(arr);
        sort(arr, 0 , arr.length-1);
        assert isSorted(arr);
    }

    // quicksort the subarray from a[lo] to a[hi]
    public static void sort(Comparable[] arr, int low, int high){
        if(high <= low + CUT_OFF){
            insertion(arr, low, high);
            return;
        }
        int k = partition(arr, low , high);
        sort(arr, low, k -1);
        sort(arr, k + 1, high);
        assert isSorted(arr, low, high);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    public static int partition(Comparable[] arr, int low, int high){
        int i = low, j = high+1;
        Comparable k = arr[i];
        while(true){
            while(less(arr[++i], k)){
                if(i == high)
                    break;
            }
            while(less(k, arr[--j])){
                if(j == low)
                    break;
            }
            if(i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, j, low);
        return j;
    }

    /**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  arr the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public static Comparable select(Comparable[] arr, int k){
        if(k > arr.length-1 || k < 0){
            throw new IllegalArgumentException("index is not between 0 and " + arr.length + ": " + k);
        }
        int low = 0, high = arr.length - 1;
        while(low < high){
            int m = partition(arr, low ,high);
            if(m < k) high = m -1;
            else if(m > k) low = m + 1;
            else return arr[k];
        }
        return arr[low];
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

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
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
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
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
     * Reads in a sequence of strings from standard input; quicksorts them;
     * and prints them to standard output in ascending order.
     * Shuffles the array and then prints the strings again to
     * standard output, but this time, using the select method.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = new String[]{"a","g","y","z","b","c","c","d","e","r","y","p","i","o","k","n","m"};
        sort(a);
        show(a);
        assert isSorted(a);
//
//        // shuffle
//        StdRandom.shuffle(a);
//
//        // display results again using select
//        StdOut.println();
//        for (int i = 0; i < a.length; i++) {
//            String ith = (String) Quick.select(a, i);
//            StdOut.println(ith);
//        }
    }
}

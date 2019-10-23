package C2_Sort;

import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2019-10-23 10:57
 */
public class MergeBU {
    // This class should not be instantiated.
    private MergeBU() { }

    // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]
    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
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
        int length = a.length;
        Comparable[] aux = new Comparable[length];
        //len表示归并子数组的长度，1表示，一个一个的归并，归并后的长度为2,2表示两个两个的归并，归并后的长度为4,以此类推
        for(int len = 1;len < length; len *= 2){
            for(int i = 0;i <= length - len; i += len + len){
                //对于数组长度不满足2的x次幂的数组，mid可能会大于high
                int low = i, mid = low + len-1, high = Math.min(low + len + len -1,length - 1);
                merge(a, aux, low, mid, high);
            }
        }
        assert isSorted(a);
    }

    /***********************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
     * Reads in a sequence of strings from standard input; bottom-up
     * mergesorts them; and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = new Integer[]{4,2,1,5,7,6,3};
        sort(a);
        show(a);
    }
}

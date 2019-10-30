package C2_Sort;

import StdLib.StdOut;
import StdLib.StdRandom;

/**
 * @program: Algorithm4th
 * @description: sorting an array with 3-way partition  三取样
 * 使用子数组的一小部分元素的中位数来切分数组（取样大小为 3 并用大小居中的元素效果最好）
 * || 将取样元素放在数组末尾作为去掉 partition() 中的数组边界测试。
 * @author: liyi
 * @create: 2019-10-25 16:54
 */
public class Quick3way {

    private static final int CUT_OFF = 7;
    // This class should not be instantiated.
    private Quick3way() { }

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
        Comparable v = arr[low];
        int l = low, r = high;
        int i = l + 1;
        while(i <= r){
            if(less(arr[i] , v)) exch(arr, l++, i++);
            else if(less(v, arr[i])) exch(arr, r--, i);
            else i++;
        }
        sort(arr, low, l - 1);
        sort(arr, r + 1, high);
        assert isSorted(arr, low, high);
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
        String[] a = new String[]{"a","g","y","z","b","c","c","d"};
        sort(a);
        show(a);
        assert isSorted(a);
    }
}

package C2_Sort;

import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * @description: 希尔排序，交换不相邻的元素以对数组进行局部排序，并最终用插入排序的方法将局部有序数组排序
 * 基于插入排序，是对插入排序的改进。
 *思想是使数组中任意间隔为h的元素都是有序的。换句话说，一个h有序的数组是h个互相独立的有序数组组合在一起的
 * 代码量小，不需要任何的辅助空间
 *
 * 时间复杂度，无法推测  空间复杂度为O(1)
 * @author: liyi
 * @create: 2019-10-22 17:05
 */
public class Shell {
    // This class should not be instantiated.
    private Shell() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int length = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        //注意需要让增量能够递减到1，这里的 3x + 1保证了能够在除3过程中，增量最终为1，为1即为做一次插入排序
        int inc = 1;
        while(inc < a.length/3) inc = inc*3 + 1;
        while(inc >= 1){
            for(int  i = inc;i < a.length; ++i){
                for(int j = i;j >= inc && less(a[j], a[j-inc]);--j)
                    exch(a, j, j-inc);
            }
            inc/=3;
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

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; Shellsorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        assert 1+2 == 3;
        String[] a = new String[]{"a","g","y","z","b","c","c","d"};
        sort(a);
        show(a);
    }
}

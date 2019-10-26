package C2_Sort;

import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * @description: The {@code Quick3string} class provides static methods for sorting an
 * array of strings using 3-way radix quicksort.
 * @author: liyi
 * @create: 2019-10-26 11:47
 */
public class Quick3string {
    private static final int CUTOFF =  7;   // cutoff to insertion sort

    // do not instantiate
    private Quick3string() { }

    /**
     * Rearranges the array of strings in ascending order.
     *
     * @param arr the array to be sorted
     */
    public static void sort(String[] arr){
        sort(arr, 0, arr.length - 1, 0);
        assert isSorted(arr);
    }

    // return the dth character of s, -1 if d = length of s
    public static int charAt(String s, int d){
        if(d < 0 || d >= s.length()){
            return -1;
        }
        return (int)s.charAt(d);
    }


    // 3-way string quicksort a[lo..hi] starting at dth character
    public static void sort(String[] arr, int low, int high, int d){
        if(high <= low + CUTOFF){
            insertion(arr, low, high, d);
            return;
        }
        int l = low, r = high;
        int i = l + 1;
        int v = charAt(arr[low], d);
        while(i <= r){
            if(charAt(arr[i], d) < v) exch(arr, i++, l++);
            else if(charAt(arr[i],d ) > v) exch(arr, i, r--);
            else i++;
        }
        sort(arr, low, l-1, d);
        if(v >= 0) sort(arr, l, r, d+1);
        sort(arr, r+1, high, d);
    }

    // sort from a[lo] to a[hi], starting at the dth character
    public static void insertion(String[] arr, int low, int high, int d){
        for(int i = 1;i <= high; ++i){
            for(int j = i; i > low && less(arr[j], arr[j-1],d);--j)
                exch(arr, j, j-1);
        }
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    // DEPRECATED BECAUSE OF SLOW SUBSTRING EXTRACTION IN JAVA 7
    // private static boolean less(String v, String w, int d) {
    //    assert v.substring(0, d).equals(w.substring(0, d));
    //    return v.substring(d).compareTo(w.substring(d)) < 0;
    // }

    // is v less than w, starting at character d
    private static boolean less(String s, String ss, int d){
        assert s.substring(0, d).equals(ss.substring(0, d));
        for(int i = d;i < Math.min(s.length(),ss.length()); ++i){
            if(s.charAt(i)  < ss.charAt(i)) return true;
            else if(s.charAt(i) > ss.charAt(i)) return false;
            else return less(s,ss,d+1);
        }
        return s.length() < ss.length();
    }

    // is the array sorted
    private static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        // read in the strings from standard input
        String[] a = new String[]{"nihao","apple","benana","dfs","afsd","oi","amn"
        ,"asdf","eri","gdkjs","lkje","vcl","aslkd","apple","benana","dfs","eri","gdkjs","lkje","vcl",
                "nihao","apple","benana","dfs","afsd","oi","amn"
                ,"asdf","eri","gdkjs","lkje","vcl","aslkd","apple","benana","dfs","eri","gdkjs","lkje","vcl"};
        int n = a.length;

        // sort the strings
        sort(a);

        // print the results
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }
}

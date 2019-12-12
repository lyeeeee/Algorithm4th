package C2_Sort;

import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * @description: Reads in four integers and prints them out in sorted order without
 * using a loop. Uses 5 compare-exchanges.
 *
 * 对于bubbo 排序，则需要多一次
 *
 * 可以画图理解下
 * @author: liyi
 * @create: 2019-10-31 10:25
 */
public class Sort4 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        if (a > b) { int t = b; b = a; a = t; }
        if (c > d) { int t = d; d = c; c = t; }
        if (a > c) { int t = c; c = a; a = t; }
        if (b > d) { int t = d; d = b; b = t; }
        if (b > c) { int t = c; c = b; b = t; }

        StdOut.println(a + " " + b + " " + c + " " + d);
    }
}

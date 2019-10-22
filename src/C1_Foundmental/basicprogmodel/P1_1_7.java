package C1_Foundmental.basicprogmodel;

import StdLib.StdOut;

public class P1_1_7 {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .00001)
        {
            t = (9.0/t + t) / 2.0;
            StdOut.printf("%.5f\n", t);
        }

        System.out.println('b' + 'c');

        int sum = 0;
        for(int i = 1;i < 1000; i *= 2){
            for(int j = 0;j < 1000; j++)
                sum++;
        }
        StdOut.println(sum);
    }
}

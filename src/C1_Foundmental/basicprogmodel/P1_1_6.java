package C1_Foundmental.basicprogmodel;

import StdLib.StdOut;

public class P1_1_6 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for(int i = 0;i <= 15;++i){
            StdOut.print(f);
            f = f + g;
            g = f - g;
        }
    }
}

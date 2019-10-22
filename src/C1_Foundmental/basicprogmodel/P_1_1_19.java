package C1_Foundmental.basicprogmodel;

import StdLib.StdOut;

public class P_1_1_19 {
    public static long F(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }

    public static long Fi(int N){

        long[] buffer = new long[N+1];
        return Fib(N,buffer);
    }

    public static long Fib(int N,long[] buffer){
        if(buffer[N] == 0){
            if(N == 1){
                buffer[N] = 1;
            }else if(N > 1){
                buffer[N] = Fib(N-1,buffer) + Fib(N-2,buffer);
            }
        }
        return buffer[N];
    }
    public static void main(String[] args)
    {
//        for (int N = 0; N < 100; N++)
//            StdOut.println(N + " " + F(N));
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + Fi(N));
    }
}

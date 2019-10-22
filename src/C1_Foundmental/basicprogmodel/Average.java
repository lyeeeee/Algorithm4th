package C1_Foundmental.basicprogmodel;

import StdLib.StdIn;
import StdLib.StdOut;

public class Average {
    public static void main(String[] args) {
        int count = 0;
        double sum = 0.0;
        while(!StdIn.isEmpty()){
            count++;
            sum += StdIn.readDouble();
        }

        double avg = sum/count;

        StdOut.print(avg);
    }
}

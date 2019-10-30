package C1_Foundmental.basicprogmodel;

import StdLib.In;
import StdLib.StdIn;
import StdLib.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key,int[] a){
        int low = 0,high = a.length-1;

        while(low <= high){
            int mid = low+(high-low)/2;

            if(a[mid] == key)        return mid;

            else if(a[mid] > key)    high = mid-1;

            else if(a[mid] < key)    low = mid+1;

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] ints = In.readInts("data/tinyW.txt");
        Arrays.sort(ints);
        while(!StdIn.isEmpty()){
            int key =StdIn.readInt();
            if(rank(key,ints) != -1)
                StdOut.print(key);
        }
    }
}

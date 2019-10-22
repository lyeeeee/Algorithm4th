package C1_Foundmental.basicprogmodel;

import StdLib.In;
import StdLib.StdIn;
import StdLib.StdOut;

import java.util.Arrays;

public class P_1_1_22a {
    public static int rank(int key,int[] a){
        return rankk(key,a,0,a.length-1,1);
    }
    private static int rankk(int key,int[] a,int low,int high,int depth){
            if(low > high) return -1;
            printStack(depth,low,high);
            int mid = low+(high-low)/2;

            if(a[mid] == key)        return mid;

            else if(a[mid] > key)    return rankk(key,a,low,mid-1,depth+1);

            else    return rankk(key,a,mid +1 ,high,depth+1);

    }
    private static void printStack(int depth,int low,int high){
        for(int i = 0;i < depth;++i){
            System.out.print("\t");
        }
        System.out.println("low: " + low + "  " + "high: "+high);
    }
    public static void main(String[] args) {
        int[] ints = In.readInts("D:\\develop\\IdeaProject\\Algorithm4th\\src\\C1_Foundmental\\tinyW.txt");
        Arrays.sort(ints);
        while(!StdIn.isEmpty()){
            int key =StdIn.readInt();
            if(rank(key,ints) != -1)
                StdOut.print(key);
        }
    }
}

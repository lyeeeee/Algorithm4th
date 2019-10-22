package C1_Foundmental.basicprogmodel;

public class P_1_1_15 {
    public static int[] histogrem(int[] a,int M){
        if(a == null || a.length == 0) return null;
        int[] ret = new int[M];
        for(int i = 0;i < a.length;++i){
            if(a[i] < M)
                ret[a[i]]++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,3,5,5,6,8,9,22};
        int[] ret = histogrem(arr,10);
        for(int i = 0;i < ret.length;++i){
            System.out.print(ret[i] + " ");
        }
    }
}

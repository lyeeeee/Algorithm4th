package C1_Foundmental;

public class P1_1_27b {
    public static long count = 0;
    public static double binomial(int n,int k,double p){
        double[][] buffer = new double[n+1][k+1];
        for(int i = 0;i < buffer.length;++i){
            for(int j = 0;j < buffer[i].length;++j)
                buffer[i][j] = -1;
        }
        buffer[0][0] = 1.0;
        return binomiall(n,k,p,buffer);
    }
    public static double binomiall(int n, int k, double p,double[][] buffer)
    {


            if(n == 0 && k == 0)
                buffer[0][0] = 1.0;
            if(n < 0 || k < 0) return 0.0;
            if(buffer[n][k] == -1){
                count++;
                buffer[n][k] = p*binomiall(n-1,k-1,p,buffer) + (1-p)*binomiall(n-1,k,p,buffer);
            }
        return buffer[n][k];
    }
    public static void main(String[] args) {
        System.out.println(binomial(100,50,0.5));
        System.out.println(count);
    }
}

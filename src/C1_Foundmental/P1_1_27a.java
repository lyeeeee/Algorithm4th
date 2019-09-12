package C1_Foundmental;

public class P1_1_27a {
    public static long count = 0;
    public static double binomial(int n, int k, double p)
    {
        count++;
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;

        return (1.0 - p) * binomial(n-1, k, p) + p * binomial(n-1, k-1, p);
    }
    public static void main(String[] args) {
        System.out.println(binomial(50,25,0.5));
        System.out.println(count);
    }
}

package C1_Foundmental.basicprogmodel;

public class GCD {
    public static int gcd(int p, int q){
        if(q == 0) return p;
        int tail = p % q;
        return gcd(q,tail);
    }

    public static void main(String[] args) {
        System.out.println(GCD.gcd(37,9));
        System.out.println(GCD.gcd(2,4));
    }
}

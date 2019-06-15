package C1_Foundmental;

public class P_1_1_9 {
    public static void main(String[] args) {
        String s = "";
        int x = 10;
        while(x !=0){
            s = x%2 + s;
            x >>= 1;
        }
        System.out.println(s);
    }
}

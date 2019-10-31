package C2_Sort;

/**
 * @program: Algorithm4th
 * @description: web exercises 1
 * @author: liyi
 * @create: 2019-10-31 09:38
 */
public class Sort3 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if(a > b) {a = a ^ b; b = a ^ b; a = a ^ b;}
        if(a > c) {a = a ^ c; c = a ^ c; a = a ^ c;}
        if(b > c) {b = b ^ c; c = b ^ c; b = b ^ c;}
        System.out.println(a + " " + b + " " + c);
    }
}
